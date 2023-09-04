


import java.util.*;


public class Main {
	
	
	
	int solve() {
		
		
		System.out.println("Test go");
		
		
		int a[] = {3,5,9,1,9,4};
		
		int max = 0;
		for (int i : a) {
			System.out.println("i : "+i);
			if (i > max) max = i;
		}
		System.out.println("max : "+max);
		
		int result[] = new int[a.length];
		
		int count = 0;
		for (int i=0; i < a.length ; i++) {
		   if (	max == a[i]) result[count++] = i;
		}
		for (int i=0; i < count;i++) {
			System.out.println("result : "+result[i]);
		}		
		
		return 0;
	}
	
		
	public static void main(String[] args)  {
	
		Main m = new Main();
		
		m.solve();
	
	}
		
		
	
	

}