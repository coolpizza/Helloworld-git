

import java.util.*;

public class DivisorProgram {
    public static void main(String[] args) {
   
		List<Integer> ans = new ArrayList<>();
		ans = findDivisors(2200);
		System.out.println("Size : "+ans.size());
		System.out.println("elements are as follows : ");
		for (int a : ans) {
			System.out.println(" "+a);
		}
	
    }

    public static List<Integer> findDivisors(int N) {
        List<Integer> divisors = new ArrayList<>();

		for (int i=1; i <= N; i++) {
			if ( (N % i)==0) {
				divisors.add(i);
			}
		}			
		
		return  divisors;
    }
}
