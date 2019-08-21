package hdfsexam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class TomcatLogHDFS_Save {
	public static void main(String[] args) {
		String logPath = "C:/H/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/logs";
		File dir = new File(logPath);
		File[] fileList = dir.listFiles();
		String NewFileName = "tomcat_access_log.txt";
		File file = new File("C:/iotest/" + NewFileName);
		try {
			FileWriter writer = new FileWriter(file, true);
			BufferedReader br = null;
			for (File fl : fileList) {
				long size = fl.length();
				System.out.println(size + " 크기의 데이터 출력 완료!!");
				br = new BufferedReader(new FileReader(fl));
				String line = null;
				while ((line = br.readLine()) != null) {
					writer.write(line);
				}
			}
			writer.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
		try {
			FileSystem hdfs = FileSystem.get(conf);
			Path filePath = new Path("/edudata/" + NewFileName);
			FSDataOutputStream out = hdfs.create(filePath, false);
			BufferedReader br = new BufferedReader(new FileReader("C:/iotest/" + NewFileName));
			String line = null;
			while ((line = br.readLine()) != null) {
				out.write(line.getBytes("utf-8"));
			}
			out.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
