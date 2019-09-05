package rjava;

import org.rosuda.REngine.Rserve.RConnection;

public class JavaRLab1 {
	
	public static void returnHotelReview() {
		RConnection r = null;
		try {
			r = new RConnection();			
			r.eval("library(KoNLP)");
			r.eval("library(dplyr)");
			r.eval("useNIADic()");
			r.eval("word_data<-readLines(\"hotel2.txt\")"); 
			r.eval("word_data2<-sapply(word_data, extractNoun,USE.NAMES = F)");
			r.eval("undata<-unlist(word_data2)");
			r.eval("word_table<-table(undata)");
			r.eval("undata2<-Filter(function(x){nchar(x)>=2},undata)");
			r.eval("word_table2<-table(undata2)");
			r.eval("tmp<-data.frame(word_table2)");
			r.eval("result<-arrange(tmp,desc(tmp$Freq)) %>% head(10)");
			String[] list = r.eval("result$undata2").asStrings();
			for(int i = 0 ; i < 10 ; i++) {
				System.out.println(list[i]);
			}
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			r.close();
		}
	}

	public static void main(String[] args) {
		JavaRLab1.returnHotelReview();

	}

}
