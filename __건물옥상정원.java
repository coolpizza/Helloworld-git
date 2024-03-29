
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
	int N;//건물 수
	int H[] = new int [80010];//건물 높이

	public void inputData()  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			H[i] = sc.nextInt();
		}
	}
	
	int stack[] = new int[80010];
	public long solve(){
		int sp = 0;
		long sum = 0;
		for(int i=0; i<N ; i++){
			while(sp > 0){
				if(H[i] < stack[sp]) {					
					System.out.printf("H[%d]:%d, stack[%d]:%d\n",i,H[i],sp, stack[sp]);	
					break;
				}
				sp--;
			}			
			sum += sp;
			stack[++sp] = H[i];
			System.out.printf("i:%d, sum : %d\n", i,sum);
			System.out.printf("------------\n");
			

		}
		return sum;
	}

	public static void main(String[] args){
		long ans = -1;
		Main m = new Main();
		m.inputData();
		ans = m.solve();
		System.out.println(ans);
	}
}