
/*

5 2 4
1 2 20
2 3 50
3 5 30
4 4 40
->
90


<internal test> // 종료가 동일할 때 시작점의 차이로 구분하기 위한 TC
5 2 4
1 2 20
3 5 30
2 5 50
4 4 40



------

4 1 4
3 4 20
3 3 10
1 2 10
2 3 40
->
40 
 
 
 */

import java.util.*;


public class Main {

	public class planning implements Comparable <planning>  {
		int start;
		int end;
		int cost;
		planning(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override  
		/*
		public int compareTo(planning obj) {
			return this.end - obj.end;
		}
*/		
		// 종료가 동일할 때는 시작점의 순서로 구분
		public int compareTo(planning obj) {
			if (this.end == obj.end) {
				return this.start-obj.start;
			} else
				return this.end-obj.end;
		}
		
		
		
	}


	int N;
	int M;
	int K;
	int s;
	int e;
	int c;

	planning pl[] = new planning[100];

	void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		for (int i = 0; i < K; i++) {
			
			s = sc.nextInt();
			e = sc.nextInt();
			c = sc.nextInt();
			pl[i] = new planning(s, e, c);
		}		
		
	}
	
	void solve() {
		System.out.printf("------> \n");
		for (int i=0; i < K; i++) {
			System.out.printf("%d %d %d \n", pl[i].start, pl[i].end, pl[i].cost);
		}
		Arrays.sort(pl,0,K);
		System.out.printf("after sorting------> \n");
		for (int i=0; i < K; i++) {
			System.out.printf("%d %d %d \n", pl[i].start, pl[i].end, pl[i].cost);
		}
		
		
	}
	
	
	public static void main(String[] args) {

		Main m = new Main();
		System.out.println("Test go \n");
		m.input();
		m.solve();
	
	}

	
}