/*

6
5
2
4
2
6
1

--> 5 


*/

import java.util.Scanner;

public class Main {

	int N;	
	int []H = new int[10000];

	void inputData() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i=0; i < N; i++) {	
			H[i]= sc.nextInt();
		}		
		
	}
	
	int solve() {
		int count = 0;
		for (int i=0; i < N; i++) {
			for (int j=i+1; j < N; j++) {
				if (H[i] > H[j]) {
					count++;
					System.out.printf("H[%d]=%d, H[%d]=%d\n",i,H[i],j,H[j]); 
				} else break;
				//if (H[i] <= H[j]) break;
				//count++;	
				//System.out.printf("H[%d]=%d, H[%d]=%d\n",i,H[i],j,H[j]);
			}
			
		}				
		
		System.out.println("count: "+count);
		
		return count;
	}
	
	
	
	public static void main(String[] args) {
		Main m = new Main();
		
		// 입력 받는 부분
		m.inputData();
		
		// 코드를 작성하세요
		m.solve();
	}
}