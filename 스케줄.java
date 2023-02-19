
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
	 
		calc();	
		
	}
	
	/*
	   - K개의 대여 일정에서 맞는 조합을 고른다.
	   - 조합의 갯수는 1개~K개 까지 있다
	   - 이중 스케줄에 가능한 일정만 선별하여 cost의 합을 구한다
	   - max 값을 갱신
	   - 조합이 끝날 때까지 반복
	
	*/
	
	// 모르면 손이 가지 않을테니 생각을 많이 하고 패턴은 외워놔야 한다. 
	
	boolean visit[] = new boolean[10];  // K
	
	void dfs(int begin) {
		visit[begin] = true;
		if (visit[begin] == false) return;
	
		
	
		
		
	}
	
	void calc() {
	   int max = 0;
	// 1개 일정
	   
	   for (int i=0; i < K; i++) { 
	     if (pl[i].cost > max) max = pl[i].cost;
	   }
	   System.out.printf("Max in 1 item : %d \n", max);

    // 2개 일정    4C2, (kC2)
	  dfs(0);	
	

    // 3개 일정

    // 4개 일정  (K개 일정)   	
		
	}
	
	
	
	public static void main(String[] args) {

		Main m = new Main();
		System.out.println("Test go \n");
		m.input();
		m.solve();
	
	}

	
}