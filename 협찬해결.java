/*

5
5 0 4 -4 9
-->
14


*/

import java.util.Scanner;

public class Main {
	int N;
	int D[] = new int[100000 + 10];
	int sol;

	void InputData() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) D[i] = sc.nextInt();
		sc.close();
	}


	void Solve() {
		int sum = 0;
		sol = -10001;

		for (int i = 0; i < N; i++) {
			if (sum > 0) sum += D[i];
			else sum = D[i];
			if (sol < sum) sol = sum;
		}
	}
	
	public static void main(String[] args) {
		Main m = new Main();

		m.InputData();				//	입력 함수

		//	코드를 작성하세요
		m.Solve();

		System.out.println(m.sol);//출력
	}
}