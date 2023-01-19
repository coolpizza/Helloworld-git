
/*

https://www.acmicpc.net/problem/1931
https://st-lab.tistory.com/145
https://latte-is-horse.tistory.com/204

한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 
단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
->
4
(1,4), (5,7), (8,11), (12,14) 를 이용할 수 있다

3
8 8
4 8
1 3
->
3




*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		
		/*
		  time[][0] 은 시작시점을 의미 
		  time[][1] 은 종료시점을 의미 
		*/
		int[][] time = new int[N][2];
		
		
		for(int i = 0; i < N; i++) {
			time[i][0] = in.nextInt();	// 시작시간 
			time[i][1] = in.nextInt();	// 종료시간 
		}
		
		
		// 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의 
		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.  
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
 
		});
		
		int count = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
			if(prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
 
}