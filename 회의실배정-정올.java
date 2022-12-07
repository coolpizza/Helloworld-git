
/*

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








*/


import java.util.*;


public class jungol_1370 {
	static class meet implements Comparable<meet>{
		int num;
		int start;
		int end;
		public meet(int num, int start, int end) {
			//super();
			this.num = num;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(meet o) {
			// TODO Auto-generated method stub
			return this.end - o.end;
		}
		
	}
	
	static ArrayList<meet> meeting = new ArrayList<>();
		
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			
			int num = sc.nextInt();
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			meeting.add(new meet(num, start, end));
		}
		Collections.sort(meeting);
		
		ArrayList<meet> avail = new ArrayList<>();
		
		meet temp = meeting.get(0);
		//avail.add(meeting.get(0));
		System.out.println("meeting.get(0):"+ temp.num);
		avail.add(temp);
		
		for (int i = 1; i < N; i++) {
			System.out.println("avail.size():"+avail.size());
			if(meeting.get(i).start>=avail.get(avail.size()-1).end) {
				avail.add(meeting.get(i));
			}
		}
		System.out.println(avail.size());
		for (int i = 0; i < avail.size(); i++) {
			System.out.print(avail.get(i).num+" ");
		}
	}
	

}