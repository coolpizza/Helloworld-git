/*
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=532&sca=99&sfl=wr_subject&stx=%EA%B1%B4%EB%AC%BC
문제
(주)정올에서는 여러 개의 빌딩을 새로 지을 계획이다. 그래서 빌딩을 세울 장소를 선정하였다. 그리고 각 빌딩을 각 장소에 세울 경우에 드는 비용을 추정하였다. 예를 들어서 아래의 표를 보자
  1 2 3
A 4 7 3
B 2 6 1
C 3 9 4
A, B, C 는 건물을 나타내고, 1, 2, 3은 장소를 나타낸다. 예를 들어서 건물 B를 장소 1에 세우면 비용이 2가 들고, 장소 2에 세우면 비용이 6, 장소 3에 세우면 비용이 1만큼 든다.
 물론 한 장소에는 한 건물밖에 세울 수 없다. 만일 A를 장소 2에, B를 장소 3에, C를 1에 세우면 전체 비용이 7+1+3 = 11이 필요하다. 
 그런데 A를 3, B를 1, C를 2에 세우면 3+2+9 = 14 가 필요하다.
각 빌딩을 어느 장소에 세우면 비용의 합이 최소가 되는지 구하는 프로그램을 작성하시오.

입력형식
입력 파일의 첫 줄은 빌딩의 개수 n(1≤n≤20)이 들어있다. 그 다음 n 줄에는 각 건물을 각 장소에 세울 경우에 드는 비용이 입력된다. 
물론 각 줄 에는 n개의 수가 입력된다. 비용을 나타내는 수의 범위는 1이상 100미만이다.

출력형식
첫 줄에는 최소비용을 출력한다. 둘째 줄에는 건물을 세울 장소들을 알파벳 순서에 따라 빈칸을 하나씩 두고 출력한다.

앱력 예
4
11 12 18 40
14 15 13 22
11 17 19 23
17 14 20 28

출력 예
61
1 3 4 2
 */

 /*
 
 4
11 12 18 40
14 15 13 22
11 17 19 23
17 14 20 28

After.. i:1, S:0, S+a[1][1]=11 , min = 2147418112
After.. i:2, S:11, S+a[2][2]=26 , min = 2147418112
After.. i:3, S:26, S+a[3][3]=45 , min = 2147418112
After.. i:4, S:45, S+a[4][4]=73 , min = 2147418112
 1 ( 73:  73) :  1 2 3 4
After.. i:4, S:26, S+a[3][4]=49 , min = 73
After.. i:3, S:49, S+a[4][3]=69 , min = 73
 2 ( 69:  69) :  1 2 4 3
After.. i:3, S:11, S+a[2][3]=24 , min = 69
After.. i:2, S:24, S+a[3][2]=41 , min = 69
After.. i:4, S:24, S+a[3][4]=47 , min = 69
After.. i:2, S:47, S+a[4][2]=61 , min = 69
 3 ( 61:  61) :  1 3 4 2
After.. i:4, S:11, S+a[2][4]=33 , min = 61
After.. i:2, S:33, S+a[3][2]=50 , min = 61
After.. i:3, S:33, S+a[3][3]=52 , min = 61
After.. i:2, S:0, S+a[1][2]=12 , min = 61
After.. i:1, S:12, S+a[2][1]=26 , min = 61
After.. i:3, S:26, S+a[3][3]=45 , min = 61
After.. i:4, S:26, S+a[3][4]=49 , min = 61
After.. i:3, S:12, S+a[2][3]=25 , min = 61
After.. i:1, S:25, S+a[3][1]=36 , min = 61
After.. i:4, S:25, S+a[3][4]=48 , min = 61
After.. i:4, S:12, S+a[2][4]=34 , min = 61
After.. i:1, S:34, S+a[3][1]=45 , min = 61
After.. i:3, S:34, S+a[3][3]=53 , min = 61
After.. i:3, S:0, S+a[1][3]=18 , min = 61
After.. i:1, S:18, S+a[2][1]=32 , min = 61
After.. i:2, S:32, S+a[3][2]=49 , min = 61
After.. i:4, S:32, S+a[3][4]=55 , min = 61
After.. i:2, S:18, S+a[2][2]=33 , min = 61
After.. i:1, S:33, S+a[3][1]=44 , min = 61
After.. i:4, S:33, S+a[3][4]=56 , min = 61
After.. i:4, S:18, S+a[2][4]=40 , min = 61
After.. i:1, S:40, S+a[3][1]=51 , min = 61
After.. i:2, S:40, S+a[3][2]=57 , min = 61
After.. i:4, S:0, S+a[1][4]=40 , min = 61
After.. i:1, S:40, S+a[2][1]=54 , min = 61
After.. i:2, S:40, S+a[2][2]=55 , min = 61
After.. i:3, S:40, S+a[2][3]=53 , min = 61
61
1 3 4 2
 
 */
 
package Day3;

import java.util.Scanner;

public class Main_D3_2612_building_BASIC {
	
	private static int N; // 건물 수
	private static int[][] a; // 입력 데이타
	private static int[] chk; // 장소 선정 여부
	private static int min = 0x7fff0000;
	private static int[] best;
	
	private static int[] list; // 건물을 지을 장소 리스트
	private static int cnt;

	private static void input(Scanner sc) {
		N = sc.nextInt();
		a = new int[N+2][N+2];
		chk = new int[N+2];
		list = new int[N+2];
		best = new int[N+2];
		
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
				a[i][j] = sc.nextInt();
	}
	
	private static void output() {
		System.out.println(min);
		for(int i=1; i<=N; i++)
			System.out.print(best[i] + " ");
		System.out.println();
	}
	
	private static void printList(int L, int sum, int min) {
		System.out.printf("%2d (%3d: %3d) : ", ++cnt, sum, min);
		for(int i=1; i<L; i++)
			System.out.printf("%2d", list[i]);
		System.out.println();
	}
	
	// 1. 프로토타입 작성
	//   - 리턴형 결정 : 성공(1)/실패(0), 찾아야 하는 값이 있으면 리턴이 아닌 전역변수로 관리, void형은 모든 경우의 수를 수행하는 경우
	//   - 인수 리스트 : 반드시 종료에 대한 인수가 있어야 함. 이전 레벨까지의 어떤 상태 정보를 사용할 경우 인수 추가
	// 2. 리턴형이 int이면 마지막 줄에 return 0; 삽입
	// 3. depth 까지만 실행되도록 종료조건 작성
	// 4. 재귀함수 호출 및 결과값을 찾고자 하는 검색 조건 작성
	// 5. 가지치기
	private static void DFS(int L, int S) { // L:건물 번호, S:비용합
		if(L > N) {
			if(S < min) {
				min = S;
				for(int i=1; i<=N; i++) best[i] = list[i];
			}
			printList(L, S, min);
			return;
		}
		
		for(int i=1; i<=N; i++) { // 장소번호
			if(chk[i] == 1) continue;
			if(S+a[L][i] >= min) {
				// System.out.printf("After.. i:%d, S:%d, S+a[%d][%d]=%d , min = %d\n",i,S, L,i, S+a[L][i], min);
				continue;
			}
			
            System.out.printf("Before..L:%d i:%d, S:%d, S+a[%d][%d]=%d , min = %d\n",L, i,S, L,i, S+a[L][i], min);			

			chk[i] = 1; list[L] = i;
			DFS(L+1, S+a[L][i]);
			
			System.out.printf("Popping..L:%d i:%d, S:%d, S+a[%d][%d]=%d , min = %d\n",L, i,S, L,i, S+a[L][i], min);
			
			chk[i] = 0; list[L] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		DFS(1, 0);
		output();
		System.out.println();
		sc.close();
	}

}
