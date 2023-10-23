/*
 * http://comganet.github.io/dfs/2016/06/03/dfs-1006
 * 문제
 * 소들은 농부 존의 농장을 탈출하는 대담한 계획을 세웠다. 그들은 작은 고무 보트를 구했고 한 밤중에 농장 경계에 흐르는 강을 보트를 타고 건너려는 계획이다. 그 계획은 완벽해 보였다.
작은 고무 보트가 소들의 무게를 견디지 못한다는 사실을 알기 전까지는…
N마리의 소(1≤N≤20)들의 무게는 각각 W_1, …, W_N이다. 보트가 침몰하지 않을 만큼 가벼운 소들을 선별해야 한다. 불행하게도, 소들은 산수를 못하기로 유명하다. 10진법을 사용하는
소들은 소들의 무게를 더하다가 자리올림이 발생하는 경우 그 소는 보트를 사용하기에는 너무 무거운 소라고 판단한다. 자리올림이 발생하지 않고 더할 수 있는 무게가 보트를 사용할 수 있는 가벼운 무게이다.
당신이 할 일은 소들을 도와서 보트를 탈 수 있는 소들의 최대 수를 구하는 것이다. 즉, 소들의 무게들을 모두 더했을 때 자리올림이 발생하지 않게 하는 소들의 최대 수를 구하는 것이다.

입력형식
첫 줄에 소들의 수 N(1≤N≤20)이 주어진다.

두 번째 줄부터 N 줄에 걸쳐 각 소의 무게(W_i)가 입력된다. (정수, 1≤W_i≤100,000,000)

출력형식
무게를 모두 더했을 때 어떤 자리에서도 자리올림이 발생하지 않는 소들의 최대 수를 출력하라.

 입력
 5
522
6
84
7311
19

출력
3
 */

package Day4;

import java.util.Scanner;

public class Main_D4_2145_farm_escape {
	
	private static int N;
	private static int[] a;
	static int[] list; // 자리 올림이 발생하지 않는 소를 답을 배열
	
	static int max; // 모든 자리에서 반올림되지 않고 보트에 탈 수 있는 소의 수	
	static int cnt; // 디버깅을 위한 print
	
	static void printList(int L, int C, int S) {
		System.out.printf("%2d (%2d:%2d) %4d = ", ++cnt, C, max, S);
		for(int i=1; i<L; i++)
			System.out.printf("%4d ", list[i]);
		System.out.println();
	}

	static void input(Scanner sc) {
		N = sc.nextInt();
		a = new int[N+2];
		list = new int[N+2];
		for(int i=1; i<=N; i++)
			a[i] = sc.nextInt();
	}
	
	static void output() {
		System.out.println(max);
	}
	
	// return : 0(가벼운소), 1(무거운소)
	static int check(int A, int B) {
		while(A > 0 && B > 0) {
			if(A%10 + B%10 > 9) return 1;
			A /= 10; B /= 10;
		}
		return 0;
	}
	
	// 1. 프로토타입 작성
	//   1.1 리턴형 : 찾고자 하는 값을 반환하지 않음. 찾는 값을 넣는 변수는 전역변수 사용
	//            int 성공(1), 실패(0)
	//            void : 모든 경우의 수를 해봐야 하는 경우
	//   1.2 인수리스트 작성
	//      - 반드시 종료를 위한 인수가 있어야 함(int L)
	//      - 이전 Level의 어떤 상태 정보를 사용해야 할 경우 인수로 넘겨줌
	
	// L:소의 번호, C:보트에 탄 소의 수, S:보트에 탄 소의 무게 합
	static void DFS(int L, int C, int S) {
		// 5. 가지치기
		// if(max > C + (남아 있는 소의 수)) return;
		if(max >= C+N-L+1) return;
		// 3. Depth 까지만 수행되도록 최소한의 종료조건 기술
		if(L > N) {
			if(max < C) max = C;
			printList(L, C, S);
			return;
		}
		
		// 4. 재귀함수 호출문 및 결과값을 찾기 위한 검색 조건 작성
		if(check(S, a[L]) == 0) {
			list[L] = a[L];
			DFS(L+1, C+1, S+a[L]);
		}
		list[L] = 0;
		DFS(L+1, C, S);
		
		// 2. 리턴형이 int 인 경우 return 0 삽입 (실패)
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		DFS(1, 0, 0);
		output();
		sc.close();
	}

}
