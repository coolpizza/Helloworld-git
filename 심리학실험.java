
/*
5
-102 -58 59 78 101

-->
0 4

*/

import java.util.Scanner;

public class Main {
	int N;//후보자 수
	int []A = new int[100000 + 10];//기질 값
	Scanner sc;
	
	void InputData(){
		sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();
	}

	void solve() {
		int i=0;
		int j = N-1;
		int minsum = (int)(2e9+10);
		int sum;
		int minans = (int)(2e9+10);;
		int maxans = 0;
		
		while (i<j) {
			sum = A[i]+A[j];
			if (minsum > Math.abs(sum)) {
				minsum = Math.abs(sum);
				minans = i;
				maxans = j;				
			}
			if (sum>0) j--;
			else if (sum <0) i++;
			else break;		
			
		}
		System.out.printf("%d %d",minans, maxans);
				
	}
	
	public static void main(String[] args){
		Main m = new Main();

		m.InputData();				//	입력 함수

		//	코드를 작성하세요

		m.solve();		
	}
}