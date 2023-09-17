

import java.util.*;



class Main {


	public static void main(String[] args) {
		int []arr = {1,1,3,3,0,1,1};  // --> 1,3,0,1
		int []result = new int[arr.length];
		
		List<Integer> list = new LinkedList<>();
		
		//for (int i=0; i < arr.length ; i++) {
		//	list.add(arr[i]);
		//}
		
		int last = -1;
		//int index=0;
		for (int i=0 ; i < arr.length; i++) {
			if (last != arr[i]) {
				list.add(arr[i]);
			}
			last = arr[i];
		}		
		
		for (Integer l : list) {
			System.out.println(" list : "+l);
		}
		
		result = list.stream().mapToInt(Integer::intValue).toArray();
		
		for (int i=0; i < result.length; i++) {
		  System.out.println("index : "+result[i]);
		}
	}
	
}