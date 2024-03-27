
/*

7
2 4 3 2 2 5 1 
-->
8

100
10000 9990 9980 9970 9960 9950 9940 9930 9920 9910 9900 9890 9880 9870 9860 9850 9840 9830 9820 9810 9800 9790 9780 9770 9760 9750 9740 9730 9720 9710 9700 9690 9680 9670 9660 9650 9640 9630 9620 9610 9600 9590 9580 9570 9560 9550 9540 9530 9520 9510 9510 9520 9530 9540 9550 9560 9570 9580 9590 9600 9610 9620 9630 9640 9650 9660 9670 9680 9690 9700 9710 9720 9730 9740 9750 9760 9770 9780 9790 9800 9810 9820 9830 9840 9850 9860 9870 9880 9890 9900 9910 9920 9930 9940 9950 9960 9970 9980 9990 10000 
--> 148


*/

import java.util.Scanner;

public class Main {
	int N;//송수신 안테나 수
	int H[] = new int[100000 + 10];//송수신 안테나 높이
	
	int stack[] = new int[100000 + 10];
	int sp = 0;

	
	void InputData(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			H[i] = sc.nextInt();
		}
		sc.close();
	}

	int Solve(){
		int cnt = 0;
		int i;
		for (i = 0; i < N; i++){
			System.out.println("-----------------------------------------------\n");
			for ( ;(sp>0) && (stack[sp] < H[i]);sp--,cnt++){
				//cnt++;
				//sp--;
				System.out.printf("(1) H[%d]=%d, cnt=%d sp=%d\n", i, H[i], cnt, sp);
				
			}
			
			if (sp>0) {
				cnt++;
				if (stack[sp] == H[i]) { 
					sp--;
					System.out.printf("(4) H[%d]=%d \n",i, H[i]);
				}
				System.out.printf("(2) H[%d]=%d, cnt=%d sp=%d\n", i, H[i], cnt, sp);
			}
			
			
			stack[++sp] = H[i];
			System.out.printf("(3) push H[%d]=%d, cnt=%d sp=%d\n", i, H[i], cnt, sp);
			//System.out.println("-----------------------------------------------\n");
		}
		return cnt;
	}

	public static void main(String[] args){
		int ans = -1;
		Main m = new Main();

		m.InputData();				//	입력 함수

		ans = m.Solve();//	코드를 작성하세요

		System.out.println(ans);//출력
	}
}