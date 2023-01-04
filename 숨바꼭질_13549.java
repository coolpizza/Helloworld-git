
/*

https://www.acmicpc.net/problem/13549

https://jdselectron.tistory.com/58
https://velog.io/@wonjwi/%EB%B0%B1%EC%A4%80-13549%EB%B2%88-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%883
https://luv-n-interest.tistory.com/1286

수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.


5 17
-->
2

*/

import java.util.*;

public class Main {    

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		boolean[] visited = new boolean[100001];
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {N, 0});
		
		int X, time = 0;
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			X = tmp[0];
			time = tmp[1];
			visited[X] = true;
			
			// 수빈이가 동생을 찾음
			if (X == K) break;
			
			// 걷거나 순간이동
			if (X*2 <= 100000 && !visited[X*2]) {
				queue.addFirst(new int[] {X*2, time});
			}
			if (X < K && X < 100000 && !visited[X+1]) {
				queue.add(new int[] {X+1, time+1});
			}
			if (X > 0 && !visited[X-1]) {
				queue.add(new int[] {X-1, time+1});
			}
		}
		System.out.println(time);
		
		
       
    }
}