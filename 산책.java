
/*
5 3
0 1
1 2
2 3
3 2
6 1

-->

3

5 3
0 2
1 2
2 3
3 1
6 1

-->

2

5 3
0 5
1 4
2 3
3 2
4 1

-->

1



-------------------------
20 278
23 11
44 191
72 238
83 104
143 346
174 248
178 293
225 73
227 12
236 223
238 33
240 96
271 77
281 241
304 59
333 221
363 384
366 80
379 399
395 157

-->

6

------------
5 3
0 1
2 3
3 2
5 2
6 1

-->

2 (?)



*/


import java.util.Scanner;

public class Main {
	int N;//직원 수
	int T;//산책 시간(분단위)
	int P[] = new int[100000 + 10];//직원 출발 위치
	int S[] = new int[100000 + 10];//직원 산책 속도(분당)
	
	long stack[] = new long[100000 + 10];

	public void inputData()  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = sc.nextInt();
		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
			S[i] = sc.nextInt();
		}
	}
	
	public int solve(){
		int i, sp = 0;
		long pos;
		for(i = 0; i < N; i++){
			pos = P[i] + (long)T * S[i];
			/*
			for( ; (sp > 0) && (stack[sp] >= pos) ; sp--);
			stack[++sp] = pos;
			*/
			for( ; (sp > 0) && (stack[sp] >= pos) ; sp--) {
				System.out.printf("sp:%d, pos:%d, stack[%d]:%d \n", sp, pos, sp,stack[sp]); 
			}
			stack[++sp] = pos;
		}
		return sp;
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