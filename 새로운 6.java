
import java.util.*;

class Main {


	static int b[][] = {
		{1,3,7},
		{2,5,9},
		{4,7,1},
		{2,5,3}
		
		
	};


    static void printAry(int[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.printf("%2d ", a[i][j]);
			}
			System.out.println();			
		}
		System.out.println(" \n");
		System.out.println("a.length : " + a.length);
		for (int i = 0; i < a.length ; i++) {
			System.out.println("a[i].length : " + a[i].length);
		}
	}

	public static void main(String[] args) {
	
		printAry(b);
	
	
	}
	
	
	
}


/*

a.length : 4
a[i].length : 3
a[i].length : 3
a[i].length : 3
a[i].length : 3


*/


