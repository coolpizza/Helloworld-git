

import java.util.*;



class Main {


	public static void main(String[] args) {
		int []arr = {1,1,3,3,0,1,1};  // --> 1,3,0,1
		int []result = new int[arr.length];
				
		int index = 0;
		int last=-1;
		
		for (int i=0; i < arr.length; i++) {
			
			if (last != arr[i]) {
				result[index++] = arr[i];
			}
			last = arr[i];			
			
		}
	
		for (int i=0; i < index; i++) {
			System.out.println("result : "+result[i]);
		}
		System.out.println("index : "+index);
	}
	
}