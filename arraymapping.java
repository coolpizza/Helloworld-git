
/*

 
 
 */

import java.util.*;


public class Main {

	static int []M = new int[20];
	
	
	int check(int pos, int range) {
		int sum = 0;
		int low = pos-range;
		int high = pos+range;
		
		if (low<0) low = 0;
		if (high > 19) high = 19;
		
		System.out.printf("pos:%d, low:%d, high:%d \n", pos, low, high);
		
		for (int i=low; i <= high; i++) {
			System.out.printf("internal M[%d]:%d\n", i, M[i]);
			sum += M[i];		
		
		}
		return sum;		
	}
	
	
	
	public static void main(String[] args) {

		
		Main m = new Main();
		System.out.println("Test go \n");
			
		
		M[2]=3; M[3]=6; M[8]=5; M[15]=10;	
		
		for (int i=0; i < 20;i++) {
			System.out.printf("M[%d]:%d\n", i, M[i]);
		}
		
		System.out.printf("check(%d,%d)=%d \n", 3, 2, m.check(3,2));
		System.out.printf("check(%d,%d)=%d \n", 5, 3, m.check(5,3));
        System.out.printf("check(%d,%d)=%d \n", 11, 4, m.check(11,4));
		System.out.printf("check(%d,%d)=%d \n", 15, 6, m.check(15,6));		
		System.out.printf("check(%d,%d)=%d \n", 1, 6, m.check(1,6));


		
		
	}

	
}