/*
<2A<3B>CE>
-->

ABBBCEABBBCE


<2A<3BC><1D<2EF>><5G>>
-->
ABCBCBCDEFEFGGGGGABCBCBCDEFEFGGGGG



*/

import java.util.Scanner;

public class Main {
	char[] loop;
	
	void inputData() {
		Scanner sc = new Scanner(System.in);
		loop = sc.next().toCharArray();
		sc.close();
	}
	
	int analysisLoop(char[] loop, int s) {
		int p = s;
		int cnt_loop = loop[s+1] - '0';
		while(cnt_loop-->0) {
			p = s+2;
			while(loop[p] != '>') {
				if(loop[p] == '<') 
					p = analysisLoop(loop, p);
				else
					System.out.print(loop[p]);
				p++;
			}
		}
		return p;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		
		// 입력 받는 부분
		m.inputData();
		
		// 코드를 작성하세요
		m.analysisLoop(m.loop, 0);
	}
}