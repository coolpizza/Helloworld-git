
/*

 ArraryList 와 Array의 sorting 비교


6
1 1 10
2 5 6
3 13 15
4 14 17
5 8 14
6 3 12

-->
3
2 5 4

https://www.comcbt.com/xe/ctest/2795478


5
1 1 3
2 2 6
3 6 4
4 11 5
5 13 3

-->
4
1 5 3 4


*/


import java.util.*;


public class jungol_1370 {
	static class meet implements Comparable <meet> {
		int num;
		int start;
		int end;
		meet(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;	
			
		}	
		
		@Override 
		public int compareTo(meet o) {
			return this.end - o.end;
			
		}
	}
	
	static ArrayList <meet> meeting = new ArrayList<>();
	static meet [] mt = new meet[100];
	
	
		
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			
			int num = sc.nextInt();
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			meeting.add(new meet(num, start, end));
			//mt[i].num = num;
			//mt[i].start = start;
			//mt[i].end = end;
			
			mt[i] = new meet(num, start, end);
			
		}
		
		
		for (int i=0; i < meeting.size(); i++) {
			System.out.println(meeting.get(i).end);
		}			
		
		Collections.sort(meeting);
		
		System.out.println("After sorting arrayist");
		for (int i=0; i < meeting.size(); i++) {
			System.out.println(meeting.get(i).end);
		}
	
	
		for (int i=0; i <N; i++) {
			System.out.printf("mt[%d].num=%d, start=%d, end=%d \n", i,mt[i].num, mt[i].start, mt[i].end);
		}
		Arrays.sort(mt,0,N);
		
		System.out.println("After sorting array");
		for (int i=0; i <N; i++) {
			System.out.printf("mt[%d].num=%d, start=%d, end=%d \n", i,mt[i].num, mt[i].start, mt[i].end);
		}
		
		
	}
	

}