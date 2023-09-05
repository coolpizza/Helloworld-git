
/*

   

*/

import java.util.*;


public class Main {
		
	int []a;
	int []s;
	int N; 
	int total;

	
	int []solve() {
		
		total = -1;	
		
		int []lotto = {3,5,50,7,7,7,8,8,8,9,30,70,-5};
		
		Set<Integer> set = new HashSet<>();
		for (int l : lotto) {
			if (l < 1 || l >45) continue;;
			set.add(l);
			
		}
		System.out.println("set : "+set);
		
		return set.stream().mapToInt(Integer::intValue).toArray();
		
	}

	public static void main(String[] args) {
	
		Main m = new Main();
	
		int [] result = new int[100];
		System.out.println("Start proto \n");
		result = m.solve();

		for (int rr : result) {
			System.out.println("answer :"+rr);
		}

		//System.out.println("Reault: "+m.solve());

	 
	 

	}
}