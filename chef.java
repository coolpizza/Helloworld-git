
/*
4
10 3
7 5
8 1
2 1

-->

25

i=0, price=10
reserve at rev[3]=10
i=1, price=7
reserve at rev[5]=7
i=2, price=8
reserve at rev[1]=8
i=3, price=2
25


------------------------
5
8 1
7 2
8 3
10 4
9 4

-->

35

i=0, price=8
reserve at rev[1]=8
i=1, price=7
reserve at rev[2]=7
i=2, price=8
reserve at rev[3]=8
i=3, price=10
reserve at rev[4]=10
i=4, price=9
reserve swap : rev[3]=9
reserve swap : rev[2]=8
35


*/

import java.util.Scanner;

public class Main {
	int N;//손님 수
	int P[] = new int[10000 + 10];//음식 값
	int T[] = new int[10000 + 10];//예약 희망 시간
	int rev[] = new int[10000 + 10];//예약 확정, rev[시간] = 가격

	public void inputData()  {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
			T[i] = sc.nextInt();
		}
	}
	
	public int solve(){
		int i, j, price, temp, sum = 0;
		for(i = 0; i < N; i++){
			price = P[i];
			System.out.printf("i=%d, price=%d \n",i, price);
			
			for(j = T[i]; j > 0; j--){
				if(rev[j] == 0){//예약 없음
					rev[j] = price;
					System.out.printf("reserve at rev[%d]=%d\n",j, price);
					break;
				}
				else if(rev[j] < price){
					temp = price; price = rev[j]; rev[j] = temp;
					System.out.printf("reserve swap : rev[%d]=%d\n", j, rev[j]);
				}
			}
		}
		for(i = 1; i <= 10000 ; i++){
			sum += rev[i];
		}
		return sum;
	}

	public static void main(String[] args){
		Main m = new Main();
		int ans = -1;

		m.inputData();				//	입력 함수

		//	코드를 작성하세요
		ans = m.solve();
	
		System.out.println(ans);	//	정답 출력
	}
}