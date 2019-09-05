package rjava;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class JavaRLab2 {
	
	public static void returnHotelReview2() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("imsi<-source('c:/RStudy/lab.R'); imsi$value");
		RList list = x.asList();
		for(int i = 0 ; i < 10; i++) {
			String[] undata2 = list.at("undata2").asStrings();
			System.out.print(undata2[i]);
			String[] Freq = list.at("Freq").asStrings();
			System.out.println("\t"+Freq[i]);
		}
		rc.close();
	}


	public static void main(String[] args) throws RserveException, REXPMismatchException {
		JavaRLab2.returnHotelReview2();

	}

}
