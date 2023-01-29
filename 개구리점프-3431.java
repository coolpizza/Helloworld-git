
/*

정올 3431 : 개구리점프

https://m.blog.naver.com/doso5/221760638712

*/

/*

4 2
1 5 2
3 7 4
7 9 1
10 13 4
1 3
1 4

-->

1
0


*/



import java.util.*;

public class Main {


	static class Jump implements Comparable<Jump> {

		private int x1;
		private int x2;		
		private int y;
		private int num;
		

		public Jump(int x1, int x2, int y, int num) {
			this.x1 = x1;
			this.x2 = x2;
			this.y = y;
			this.num = num;
		}	

		@Override
		public int compareTo(Jump other) {
			if (this.x1 < other.x1) {
				return -1;
			}
			return 1;
		}
	}
	
	

    public static void main(String[] args) {	
		
		int Q1;
		int Q2;		
		
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
		int Q = sc.nextInt();
		
		/*
		Temp[] t=new Temp[n];
		for (int i = 0; i < n; i++) {
			t[i]=new Temp(sc.nextInt(),sc.nextInt());
		}
		*/
		
/*
4 2
1 5 2
3 7 4
7 9 1
10 13 4
1 3
1 4
		
*/
		
		Jump [] arr = new Jump[N];
		int [] group = new int[N+1];		
		
		for (int i=0; i < N;i++) {
			
			/*  아래와 같은 방법은 없음.   다른 배열로 받아서 class를 매핑해야 함.
			arr[i].x1 = sc.nextInt();
			arr[i].x2 = sc.nextInt();
			arr[i].y = sc.nextInt();
			arr[i].num = i;
			*/
			
			// 아니면 이렇게 입력을 해주어야 함
			arr[i] = new Jump(sc.nextInt(),sc.nextInt(),sc.nextInt(), i+1); // 그룹은 1부터 시작하므로 i+1			
		}
		
		Arrays.sort(arr);
		for (Jump j : arr) {
			System.out.printf("x1:%d  x2:%d y:%d num:%d \n",j.x1, j.x2, j.y, j.num);
		} 
		
		int lx = 0;
		int cnt = 0;
		
		 // 같은 그룹이면 놔두고 다르면 갱신함. 
		for (int i=0; i < N; i++){
			if (lx < arr[i].x1) {
				System.out.printf(" ==> update another group : %d \n", lx);
				group[arr[i].num] = ++cnt;
				lx = arr[i].x2;
				
			} else {
				System.out.printf(" ==> keep previous group : %d \n", lx);
				group[arr[i].num] = cnt;
				lx = Math.max(lx, arr[i].x2);				
			}
		
		}
		
		System.out.println("---------------------");
		
		for (int i = 0; i < N; i++) {
			System.out.printf(" group[%d]: %d \n", i+1, group[i+1]);
		}		
		
		for (int i=0; i < Q; i ++) {
			Q1 = sc.nextInt();
			Q2 = sc.nextInt();			
			
			if (group[Q1] == group[Q2]) {
				System.out.println("--> 1");
				
			} else {
			    System.out.println("--> 0");
			}
			
		}
		
      

    }
}