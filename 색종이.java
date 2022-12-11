/*
 * 출처 : http://jungol.co.kr/bbs/board.php?bo_table=pbank&sca=99&sfl=wr_homepage&stx=KOI%20%EB%B3%B8%EC%84%A0%202007%20%EC%B4%882
 * 문제
 * 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 
이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
예를 들어 흰색 도화지 위에 세 장의 검은색 색종이를 그림과 같은 모양으로 붙였다면 검은색 영역의 넓이는 260이 된다.

입력
첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다. 
색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고, 
두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다. 색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다.

출력형식
첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다.

앱력 예
3 
3 7 
15 7 
5 2

출력 예
260
 */

package Day3;

import java.util.Scanner;

public class Main_D3_2107_color_paper {
	
	private static int N;
	private static int[][] a;
	private static final int WHITE_PAPER_AREA = 100;
	private static final int BLACK_PAPER_AREA = 10;
	private static int[][] paper;
	
	static int fillPaper() {
		int x, y;
		int cnt = 0;
		paper = new int[WHITE_PAPER_AREA][WHITE_PAPER_AREA]; // 0:하얀색, 1:검은색(색종이)
		for(int p=1; p<=N; p++) {
			x = a[p][1]; y = a[p][2];
			for(int i=0; i<BLACK_PAPER_AREA; i++) {
				for(int j=0; j<BLACK_PAPER_AREA; j++) {
					
					System.out.printf("paper[%d][%d]= %d, cnt = %d \n",x+i, y+j, paper[x+i][y+j], cnt );					
					
					if(paper[x+i][y+j] == 0) {
						paper[x+i][y+j] = 1;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	static int fillPaper(int sY, int sX) {
		int cnt = 0;
		
		for(int i=0; i<BLACK_PAPER_AREA; i++)
			for(int j=0; j<BLACK_PAPER_AREA; j++)
				if(++paper[sY+i][sX+j] == 1) cnt++; // 겹친 영역 개수 또한 알 수 있음. 겹친 만큼 1씩 증가됨
		
		return cnt;
	}

	static int input(Scanner sc) {
		int sum = 0;
		N = sc.nextInt();
		a = new int[N+2][2+2]; // 입력이 X, Y 좌표 쌍으로만 입력됨
		paper = new int[WHITE_PAPER_AREA][WHITE_PAPER_AREA]; // 0:하얀색, 1:검은색(색종이)
		for(int i=1; i<=N; i++) {
			a[i][1] = sc.nextInt();
			a[i][2] = sc.nextInt();
			sum += fillPaper(a[i][2], a[i][1]);
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sol;
		Scanner sc = new Scanner(System.in);
		sol = input(sc);
		System.out.println(fillPaper());
		System.out.println(sol);
		sc.close();
	}

}
