/*
12 3
2 4 8 5 8 4 8 5 9 6 3 2 4 8 5
-->
5


32 5
26 63 36 44 68 42 33 47 31 55 34 29 51 41 27 62 38 64 55 31 34 63 39 42 28 37 28 39 37 63 42 19
42 28 39 37 63

-->

3




*/

import java.util.Scanner;

public class Main {
	int N; // 실행 코드의 데이터 개수
	int M; // 바이러스의 데이터 개수
	int A[] = new int [20000 + 10]; // 실행 코드의 데이터
	int B[] = new int [10 + 10]; // 바이러스의 데이터

	int sol; // 정답

	void InputData(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();
		for (int i = 0; i < M; i++) B[i] = sc.nextInt();
		sc.close();
	}
	
	void OutputData(){
		System.out.println(sol);
	}

	void Sort(int a[], int s, int e){
		int i, j;

		for (i = s; i < e; i++) {
			for (j = i + 1; j <= e; j++) {
				if (a[i] > a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
	}

	int P[] = new int [10 + 10];
	int first = 1;

	int Find(int start){
		int i;
		int min;

		if (first == 1) {
			first = 0;

			Sort(B, 0, M - 1);

			min = B[0];
			for (i = 0; i < M; i++) {
				B[i] = B[i] - min;
			}
		}

		for (i = 0; i < M; i++) {
			P[i] = A[start + i];
		}

		Sort(P, 0, M - 1);

		min = P[0];
		for (i = 0; i < M; i++) {
			P[i] = P[i] - min;
		}

		for (i = 0; i < M; i++) {
			if (B[i] != P[i]) return 0;
		}
		return 1;
	}
	
	void Solve(){
		int i;

		for (i = 0; i <= N - M; i++) {
			sol += Find(i);
		}
	}

	public static void main(String[] args){
		Main m = new Main();

		m.InputData(); // 입력

		m.Solve(); // 문제 해결

		m.OutputData(); //출력
	}
}