/*

https://m.blog.naver.com/soohan530/221029295310
https://53perc.tistory.com/entry/%EC%99%84%EC%A0%84%EC%88%98%EC%99%80-%EC%B4%88%EA%B3%BC%EC%88%98

220 225
-->
284 31 234 1 280 178

*/

import java.util.Scanner;

public class Main {

	int A, B;

	void inputData() {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		
	}
	
	int solve() {
		
		
		int n ; //= 224;
		int i;
		
		for (n = A; n <= B; n++) {
			int sum = 0;
			for (i=1; i*i < n; i++) {
				if (n%i==0) {
					//System.out.printf("%d %d \n",i,n/i);
					sum += i;
					sum += n/i;
				}
			}
			if (i*i==n) {
				//System.out.println("i:"+i);
				sum += i;
				
			}
			sum -= n;
			System.out.printf("%d ",sum);
		}
		
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		Main m = new Main();
		
		// 입력 받는 부분
		m.inputData();
		
		// 코드를 작성하세요
		m.solve();
	}
}