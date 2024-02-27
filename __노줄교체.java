
/*
4
3 3 1 2 
1 1 3 1 
3 3 1 1 
1 1 3 3 

-->

22


*/

import java.util.Scanner;

public class Main {
	int N;	// 장비에 장착된 노즐의 가로, 세로 개수
	int A[][] = new int[1000][1000]; // 각 노즐의 오염도 정보
	long sol; // 정답
	
	void InputData(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i=0; i<N; i++){
			for (int j=0; j<N; j++){
				A[i][j] = sc.nextInt();
			}
        }
	}
	
	void OutputData(){
		System.out.println(sol);
	}

	void Solve() {
		long h = 0;
		for (int y = 0; y < N; y++) {
			long sum[] = new long [2];
			sum[0] = sum[1] = 0;
			for (int x = 0; x < N; x++) {
				sum[x % 2] += A[y][x];
			}
			h += Math.max(sum[0], sum[1]);
		}
		long v = 0;
		for (int x = 0; x < N; x++) {
			long sum[] = new long [2];
			sum[0] = sum[1] = 0;
			for (int y = 0; y < N; y++) {
				sum[y % 2] += A[y][x];
			}
			v += Math.max(sum[0], sum[1]);
		}
		sol = Math.max(h, v);
	}

	public static void main(String[] args){
		Main m = new Main();
		
		m.InputData(); // 입력

		// 코드를 작성하세요
		m.Solve();

		m.OutputData(); //출력
	}
}