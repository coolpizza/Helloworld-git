
/*

5
5 16
8 2
1 5
3 20
9 10

--> 8

플레이어가 출발했을 때 탈출이 불가능한 공간 크기의 총 합



*/

import java.util.Scanner;
import java.util.*;

public class Main {
	int N;//물방울 수
	int []S; // 크기
	int []P; // 위치

	class bubble implements Comparable <bubble> {
		int size;
		int pos;
		bubble(int size, int pos) {
			this.size = size;
			this.pos = pos;
		}
		
		@Override 
		public int compareTo(bubble other) {
			return this.pos-other.pos;
		}		
		
		
	}

	bubble []bb;


	public void inputData()  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N];
		P = new int[N];
		
		bb = new bubble[N];
		
		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
			P[i] = sc.nextInt();
			
		}
		
	}
	
	int solve(){
		
		int []space = new int[N-1];
		int spc = 0;
		int imp_area = 0;
				
		for (int i=0; i<N;i++) {
			bb[i] = new bubble(S[i], P[i]);			
		}
		
		Arrays.sort(bb);
		for (int i=0; i<N; i++) {
			System.out.println("S:"+bb[i].size+" P:"+bb[i].pos);
		}
		
		for (int i=0; i<N-1; i++) {
			space[i]=bb[i+1].pos-bb[i].pos;
		}		
		spc = space[0];
		
		if (spc > bb[0].size) { // 1
			// exit success. do not calcate
		}
		if (spc < bb[0].size && spc < bb[1].size) { // 1
			//imp_area += spc;
			imp_area = space[0]
		}				
		if (spc > bb[1].size) {  // 2
			//spc += space[1];
			spc = space[0]+space[1];
			if (spc < bb[0].size && spc < bb[2].size) {  // 2
			//imp_area += spc;
				imp_area = space[0]+space[1];
			}
			if (spc > bb[2].size) {
				spc = space[0]+space[1]+space[2];
				if (spc < bb[0].size && spc < bb[3].size) { // 3
					imp_area = space[0]+space[1]+space[2];
				}
				if (spc > bb[3].size) {
					spc = space[0]+space[1]+space[2]+space[3];
					if (spc < bb[0].size && spc < bb[4].size) {  // 4
						imp_area = space[0]+space[1]+space[2]+space[3];
					}
					if (spc > bb[4].size) {
						imp_area = 0;
					}
						
				} else {
					imp_area = spc;
				}
				
			} else {
				imp_area = spc; // space[0]+space[1]
			}				
		}
		spc = space[1]; //5  
		if (spc > bb[1].size) {  // left direction.
			spc = space[0]+space[1];
			if (spc> bb[0].size) {
				// exit success. do not calculate.
			}	
		} 
		
		
		
		
	/*		
		if (space[N-2]> bb[N-1].size) {
			
		}
	*/	
		for (int i=0; i < N-1; i++) {
			System.out.printf("space[%d]=%d\n",i, space[i]);
		}
				
		return 0;
	}

	public static void main(String[] args){
		long ans = -1;
		Main m = new Main();
		m.inputData();
		ans = m.solve();
		System.out.println(ans);
	}
}