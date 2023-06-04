
/*

 
 
 */

import java.util.*;


public class Main {


	//static int a[][] = new int[4][4];
	static int a[][] = {{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}	
		
	};
	
	// java에서 call by value는 지원안해서 따로 만들어야 함.
	void swap(int e, int f, int g, int h) {
		int temp;
		temp = a[e][f];
		a[e][f] = a[g][h];
		a[g][h] = temp;
		
	}
	
	public static void main(String[] args) {

		Main m = new Main();
		System.out.println("Matrix Test go \n");
		
		for (int i=0; i < 4; i++) {
			for (int j=0; j < 4;j++) {
				System.out.printf("a[%d][%d]=%d ", i,j, a[i][j]);
				//System.out.printf("%d ", a[i][j]);
			}
			System.out.printf("\n");
		}			
		
		// a[0][1], a[3][2]
		// a[0][2], a[3][1]
		// a[1][0], a[2][3]
		// a[2][0], a[1][3]
		
		m.swap(0,1,3,2);
		m.swap(0,2,3,1);
		m.swap(1,0,2,3);
		m.swap(2,0,1,3);

		//a[0][1] = a[3][2];

		System.out.printf("After----->\n");
			
		for (int i=0; i < 4; i++) {
			for (int j=0; j < 4;j++) {
				System.out.printf("a[%d][%d]=%d ", i,j, a[i][j]);
				//System.out.printf("%d ", a[i][j]);
			}
			System.out.printf("\n");
		}
		
	}

	
}