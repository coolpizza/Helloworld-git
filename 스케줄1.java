
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


	static int N;
	static int M;
	static int K;
	int s;
	int e;
	int c;

	static planning pl[] = new planning[100];
	//static int arr[] = {20,30,50,40};

	void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		int i;
		for (i = 0; i < K; i++) {
			
			s = sc.nextInt();
			e = sc.nextInt();
			c = sc.nextInt();
			pl[i] = new planning(s, e, c);
		}		
		pl[i+1]= new planning(0, 0, 0); // 끝부분의 NPE를 막기위해.
		
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
	/*
		5 2 4
		1 2 20
		2 3 50
		3 5 30
		4 4 40
		->
		90
	
	*/
	
	static boolean visited[] = new boolean[10];  // K	
	static int max = 0;
	
    public static void dfs(int start, int depth, int r){
		if(depth == r){
			int sum = 0;			
            //for(int i=0; i<arr.length; i++){
			for(int i=0; i<K; i++){
                //if(visited[i]) System.out.print(arr[i]+" ");
				if (visited[i]) {
					// 여기에서 이전일정의 끝보다 다음 일정의 시작이 앞에오는 것은 제외.
					if (r>=2) {
						if (pl[i].end <= pl[i+1].start) {
							System.out.print(pl[i].cost+" ");
							sum +=pl[i].cost;
						}
					} else {
						System.out.print(pl[i].cost+" ");
						sum +=pl[i].cost;						
					}

				}		
			}
			if (sum>max) max=sum;
			System.out.printf("local sum :%d, max:%d \n", sum, max);
            System.out.println();
			
			
            return;
        }
        //for(int i=start; i<arr.length; i++){
		for(int i=start; i<K; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }
	
	void calc() {	   
	// 1개 일정
	   
	   for (int i=0; i < K; i++) { 
	     if (pl[i].cost > max) max = pl[i].cost;
	   }
	   System.out.printf("Max in 1 item : %d \n", max);

    // 2개 일정    4C2, (kC2)
	   //dfs(0,0,2);  // start, depth, r	
	   
	   //System.out.printf("arr.length:%d\n", arr.length);
	   // 2개 이상의 일정부터는 다음일정의 시작이 먼저 일정보다 앞에 오면 안된다. 
	   
	   for (int i=2; i <=K; i++) {
	      dfs(0, 0, i);
       }  

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