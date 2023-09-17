
import java.util.*;
// 최고값만 제거


class Main {

	static int []solution(int []arr) {
		int []result = new int[arr.length];
		
		int min = 0xfffffff;
		int index = 0;
		
		if (arr.length == 1) return new int[] {-1};
		for (int re : arr) {
			if (re < min) min = re;
		}
		//System.out.println("min : "+min);
		for (int i=0; i <arr.length; i++) {
			if (arr[i] != min) {
				result[index++] = arr[i];
			}		
		}
		int []result2 = new int[index+1];
		//System.out.println("index : "+index);
		for (int i=0; i < index; i++) {
			result2[i]=result[i];
		}
		for (int re : result2) {
			System.out.println("be : "+re);
		}
		
		return result2;
	}


	public static void main(String[] args) {
		int []arr = {3,4,2,1,1};
		// int []arr = {10};
		int []answer = new int[arr.length];
		
		answer = solution(arr);
		
		for (int re : answer) {
			System.out.println("re : "+re);
		}
		
	}
	
	
	
}