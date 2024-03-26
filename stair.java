
//package D0;

/*
https://velog.io/@hyuntall/%EB%B0%B1%EC%A4%80-2579%EB%B2%88-%EA%B3%84%EB%8B%A8-%EC%98%A4%EB%A5%B4%EA%B8%B0-%EB%AC%B8%EC%A0%9C-%ED%92%80%EC%9D%B4-%ED%8C%8C%EC%9D%B4%EC%8D%AC
https://www.acmicpc.net/problem/2579
계단 오르는 데는 다음과 같은 규칙이 있다.

계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.
따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.  
  __
               __|20|
            __|10|도 |
         __|25|  |착 |
      __|15|  |  |  |
  ___|20|  |  |  |  |
  |10|  |  |  |  |  |
---------------------
시작

  입력형식
입력의 첫째 줄에 계단의 개수가 주어진다. 
둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 
계단의 개수는 300 이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000 이하의 자연수이다.

출력형식
첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최대값을 출력한다.

입력
6
10
20
15
25
10
20

출력
75
 */

import java.util.Scanner;

// DP(Dynamic Programming)
public class stair {
	
	private static int N;
	private static int[] S; // 계단 별 점수

	static void input(Scanner sc) {
		N = sc.nextInt();
		S = new int[N+2];
		for(int i=1; i<=N; i++)  {
			S[i] = sc.nextInt();
			System.out.println("S["+i+"]="+S[i]);
		}
	}
	
	static int solve1() {
		// dynamic table
		int[] D = new int[N+2];
		// 점화식
		// D[i] = max(D[i-2]+S[i], D[i-3]+S[i-1]+S[i]) // 두 계단 올라간 것과 연속 한 계단씩 두 번 올라간 점수 비교
		
		D[0] = 0;
		D[1] = S[1];
		D[2] = S[1] + S[2];
		
		for(int i=3; i<=N; i++) {
			D[i] = D[i-2] + S[i]; // 연속 세 계단 불가하여 두 계단 이전과 합께 저장
			System.out.println(D[i-2] + " + " + S[i] + " = " + D[i]);
			if(D[i] < D[i-3] + S[i-1] + S[i]) // 연속 1계단인 경우
				D[i] = D[i-3] + S[i-1] + S[i];
			print(D);
			
		}
		
		return D[N];
	}
	static int solve2() {
		// dynamic table
		int[] D1 = new int[N+2]; // by 1 step
		int[] D2 = new int[N+2]; // by 1 step or 2 step
		// 점화식
		// D1 += max(D1[s-1], D2[s-1]
				
		// 첫 계단은 무조건 밟아야 함(?)
		D1[1] = D2[1] = S[1];
		for(int i=2; i<=N; i++) {
			D1[i] = D2[i-1] + S[i];
			D2[i] = Integer.max(D1[i-2], D2[i-2]) + S[i];
			
			print(D1);
			print(D2);
		}
		
		return Integer.max(D1[N], D2[N]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		System.out.println(solve1());
		System.out.println(solve2());
		sc.close();
	}
	
	static void print(int[] b) {
		for(int i=1; i<=N; i++)
			System.out.print(b[i] + " ");
		System.out.println();
	}

}