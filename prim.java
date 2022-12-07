/*
 * 마을에 도로 설치
         1
(1)--------------(2)
|               / |
|            /    |
| 3       3/      |6
|        /        |
|     /           |
|  /              |
(3)--------------(4)
 \       4       /
   \          /
     2\    /5
        \/
       (5)
 입력 예
5
0
1 0
3 3 0
0 6 4 0
0 0 2 5 0

 출력 예
 10
 */


package Day5;

import java.util.Scanner;

// Prime : 임의의 시작 노드에서 간선을 추가하는 방식 (현 노드에서 가장 최선의 방식 선택)
public class Main_D5_Prim_2067 {
	
	private static int N;
	private static int[][] a;
	private static int[] cost;
	private static int[] visit;

	static void input(Scanner sc) {
		N = sc.nextInt();
		a = new int[N+2][N+2];
		cost = new int[N+2];
		visit = new int[N+2];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				a[i][j] = sc.nextInt();
				a[j][i] = a[i][j];
			}
			cost[i] = Integer.MAX_VALUE;
		}
	}
	
	static void print(int[][] temp) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				System.out.print(temp[i][j] + " ");
			System.out.println();
		}
	}
	
	// cost or visit
	static void print(int[] temp) {
		for(int i=1; i<=N; i++) {
			if(temp[i] == Integer.MAX_VALUE)
				System.out.print("* ");
			else
				System.out.print(temp[i] + " ");
		}
		System.out.println();
	}
	
	static int solve(int v) { // v : 마을번호
		int sol = 0;
		visit[v] = 1;
		
		for(int i=1; i<=N-1; i++) { // 간선은 N-1개 연결
			// 1. 선택 노드에서 간선들의 비용 확인 ==> 간선 추가하기 위함
			for(int j=1; j<=N; j++) {
				if(visit[j] == 1 || a[v][j] == 0) continue;
				if(cost[j] > a[v][j]) cost[j] = a[v][j];
			}
			// 2. 추가된 간선에 연결된 노드를 선택 집합체에 추가 (다음 노드 선택), 최소 비용 구함
			int min = Integer.MAX_VALUE;
			for(int j=1; j<=N; j++) {
				if(visit[j] == 1) continue;
				if(min > cost[j]) {
					min = cost[j];
					v = j;
				}
			}
			visit[v] = 1;
			sol += min;
			print(cost);
			print(visit);
		}
		
		return sol;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
//		print(a);
//		print(cost);
//		print(visit);
		System.out.println(solve(1)); // 첫(1) 마을 부터 노드 검사
		sc.close();
	}

}
