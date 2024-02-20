// 계산기
/*
10
12 B06A71411465957A5 334A0B
15 -4933CE64B47E2B9 9CABE379ECC71757BD4
21 KG708KA3B3A6AKG0J7 986I8I63FB08
13 -A4464895325C1187B 68B74C6817
25 5942MML63G02KCLOAJ4 -3
2 1001 -110
18 13FB7F1E4 7GG94695333
21 H8KE3CE1AEA4I049454 -GB9G
10 6858 5052
31 -51SL46D3TSHIRT NTCHB98EMKUGS8

-->
3033A060B994594635B6467
-3069B2A09CDC2443030A916B0414CCD5D6
9650FGDIA1DK82360I5AA66A04507E
-540C31C9882617C88B95B2A600C
-G2C8IIDIAN08BDFN77C
-110110
9BB76238HHBB9C1560C
-DF7BFI7EED028E9J32ACBE1
34646616
-3S742RP2N3J8QSU6CP9ISTFO32CF



*/

import java.util.Scanner;

public class Main {

	int N;//테스트 케이스 수
	int B;//진법
	char S[];//첫 번째 정수
	char D[];//두 번째 정수
	Scanner sc;
	char d2c[] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	int c2d(char ch){
		if(ch <= '9') return ch - '0';
		return ch - 'A' + 10;
	}
	void mul(int s, int d){
		int alen = S.length - s, blen = D.length - d, len = alen + blen - 1, i, j;
		int AA[] = new int[alen], BB[] = new int[blen], sol[] =  new int[len];
		
		for(i = 0, j = s; i < alen; i++, j++) AA[i] = c2d(S[j]);
		for(i = 0, j = d; i < blen; i++, j++) BB[i] = c2d(D[j]);
		
		for(i = 0; i < alen; i++){
			for(j = 0; j < blen; j++){
				sol[i + j] += AA[i] * BB[j];
			}
		}
		for(i = len - 1; i > 0; i--){
			if(sol[i] >= B){
				sol[i - 1] += sol[i] / B; sol[i] %= B;
			}
		}
		if(sol[0] >= B){
			System.out.print(d2c[sol[0] / B]); sol[0] %= B;
		}
		for(i = 0; i < len; i++) System.out.print(d2c[sol[i]]);
		System.out.println();
	}
	void solve(){
		if((S[0] == '0') || (D[0] == '0')) {
			System.out.println("0"); return;
		}
		int sign = 1; int s = 0, d = 0;
		if(S[0] == '-'){ sign *= -1; s++; }
		if(D[0] == '-'){ sign *= -1; d++; }
		if(sign < 0) System.out.print("-");
		mul(s, d);
	}

	void InputData(){
	    B = sc.nextInt();
		S = sc.next().toCharArray();
		D = sc.next().toCharArray();
	}

	public static void main(String[] args){
		Main m = new Main();
		m.sc = new Scanner(System.in);
		m.N = m.sc.nextInt();
		for(int i = 0; i < m.N; i++){
			m.InputData();				//	입력 함수

			//	코드를 작성하세요
			m.solve();
		}
	}
}