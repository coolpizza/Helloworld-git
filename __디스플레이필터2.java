
/*
4
2 10
2 8
3 4
4 12

-->

1


4
1 7
2 6
3 8
4 9

-->
1

3
19 855276
14 853141
14 75897

-->
2

*/

import java.util.Scanner;

public class Main {
	int N;//필터의 수
	int R[]=new int [11]; //반사의 정도
	int P[]=new int [11]; //투과의 정도
	static int sol = 0x7FFFFFFF;
	static int diff = 0x7FFFFFFF;
	
	long mindiff = (long)1e6;;
	int mincnt;
	
	void InputData(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			R[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		sc.close();
	}

	
/****	
	void Dfs(int n, int r, int p, int cnt){
		int val = Math.abs(r - p);
		if (n > N) {
			if (cnt == 0) return;
			if (val < diff)
			{
				diff = val;
				sol = cnt;
			}
			else if (diff == val)
			{
				if (sol>cnt) sol = cnt;
			}
			return;
		}
		Dfs(n+1, r*R[n], p+P[n], cnt+1);
		Dfs(n+1, r, p, cnt);
	}
****/


	void Dfs(int s, int cnt, long mul, long sum) {
		if (cnt !=0) {
			long diff = Math.abs(mul - sum);
			if ((mindiff > diff) ||
				((mindiff == diff) && (mincnt > cnt))) {
					mindiff = diff;
					mincnt = cnt;
			}
		}
		for (int i = s; i <= N; i++) {
			Dfs(i+1, cnt+1, mul*R[i], sum+P[i]);
		}
	}
	
	int Solve() {
		mindiff = (long)1e6;
		Dfs(1,0,1,0);
		return N - mincnt;
	}				
	
	
	public static void main(String[] args){
		int ans = -1;
		Main m = new Main();

		m.InputData();	 //	입력 함수

		//	코드를 작성하세요
		ans = m.Solve();
		System.out.println(ans);//출력
	}
}