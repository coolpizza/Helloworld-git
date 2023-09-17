

import java.util.*;

class Main {

    
	static char b[] = new char[10];

	public static void main(String[] args) {
		String str = "sangseon";
		
		int N = 3;
		//int M = 20;
		char a[][] = new char[N][str.length()];
	
        Main m = new Main();
		
		//for (int i=0; i < N; i++) {
		  //for (int j=0; j < 3; j++) {
		    a[0] = str.toCharArray();
          //} 			
		//}
		//for (int i=0; i < N; i++) {
			for (int j=0; j < str.length(); j++) {
				System.out.println("a : "+a[0][j]+"   "+str.length());
			}

		//}

	}
}
