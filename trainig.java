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
	 
    String SS;
    String DD;	
	char S[];  //첫 번째 정수
	char D[];  //두 번째 정수
	Scanner sc;
	char d2c[] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	//int c2d(char ch){
	//	if(ch <= '9') return ch - '0';
	//	return ch - 'A' + 10;
	//}
	
	void InputData() {
	    SS = "B06A71411465957A5";
        DD = "334A0B";	
	}
	
	void solve() {
	    S = SS.toCharArray();
		D = DD.toCharArray();
		
		for (char c : S) {
			System.out.printf("%c ", c);
		}
		System.out.println();
		for (char c : D) {
			System.out.printf("%c ", c);
		}
		System.out.println();
	}
	
	int c2d(char c) {
		 int res;
		 res = c - '0';
		 if (c < '9') {res = c - '0'; return res;}
		 res = c - 'A'+10; return res;
    }    
	public static void main(String[] args){
		Main m = new Main();
		//m.sc = new Scanner(System.in);
		//m.N = m.sc.nextInt();
		//for(int i = 0; i < m.N; i++){
			m.InputData();				//	입력 함수

			//	코드를 작성하세요
			m.solve();
		//}
	}
}



    
		 