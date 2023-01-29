
/*

   a[] : story of building
   a[1] = 7;  // building #1 : 5 story
   a[2] = 8;
   a[3] = 4;
   a[4] = 3;
   a[5] = 5;

<data>
 
5 7 8 4 3 5 

*/

import java.util.Arrays;
import java.util.Scanner;


public class proto {
		
	static int []a;
	static int []s;
	static int N; 
	static long total;

	static void input(Scanner sc) {
		N = sc.nextInt();
		a = new int[N+2];
		s = new int[N+2];
		
		for(int i=1; i<=N; i++) {
			 a[i] =sc.nextInt();			
		}
		System.out.println("Input list .....\n");
		
		/*
		for(int i=1; i<=N; i++) {
			 System.out.println("a["+i+"]="+a[i]);			
		}
		*/
		
	}

	static long solve() {
		
		
		a = new int[10];
		s = new int[10];
			
		a[1] = 7;
		a[2] = 8;
		a[3] = 4;
		a[4] = 3;
		a[5] = 5;
		total = 0;
		
		for (int i=0; i<3; i++) {
			for (int j=1; j<=10; j++) {
				
				if (j==2) {
					System.out.printf("continue...at %d\n",j);
					continue;
					//System.out.printf("do not display here\n");
				}
				System.out.printf("loop J :%d \n", j);
				if (j==6) break;
				
			}
			System.out.printf("-->loop i :%d \n", i);
		}
		return total;
		
	}

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//input(sc);
		
		System.out.println("Start proto \n");

		System.out.println("Total : "+solve());

	 
	 

	}
}