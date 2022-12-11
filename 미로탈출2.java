/*
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=934&sca=99&sfl=wr_homepage&stx=2013.04.13+%EB%AA%A8%EC%9D%98%ED%85%8C%EC%8A%A4%ED%8A%B8
 * 문제
 * 정올에서 미로탈출 로봇 대회를 개최하였다.
대회에 사용되는 미로는 가로(X), 세로(Y) 100이하의 크기이며, 미로를 한 칸 이동하는 데는 1초가 걸린다.
대회에 참가중인 민성이는 자신의 로봇이 가장 빨리 미로를 탈출하기 위해 미로의 모양을 입력받아서 도착점까지 가장 빠른 길을 찾으려고 한다.
프로그램을 작성하여 민성이를 도와주자.

입력형식
첫줄에 미로의 크기 X, Y(1≤X, Y≤100)가 주어진다. 둘째 줄에 출발점 x, y 좌표와 도착점 x, y 좌표가 공백으로 구분하여 주어진다. 
셋째 줄부터 미로의 정보가 길은 0, 벽은 1로 공백이 없이 들어온다.

출력형식
첫줄에 출발점에서 도착점까지 가장 빠른 시간을 출력한다.

입력 예
8 7
1 2 7 5
11111111
00000111
10110011
10111001
10111101
10000001
11111111

출력 예
9
 */
 
import java.util.Scanner;
 
public class maze2 {


	static int map[][];
	//static int visit[][];
	
	static char temp[];
	static int C;  
	static int R;
	
	static int sC;
	static int sR;

	static int eC;
	static int eR;

	static class NODE {
		int c, r;
		NODE (int c, int r) {
			this.c = c;
			this.r = r;				
		}
	}
	
	static NODE[] que = new NODE[100*100];
	static int wp;
	static int rp;
	
	static int[] dr = {0,1,0, -1};
	static int[] dc = {-1,0,1, 0};
		
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt();
		R = sc.nextInt();
		
		sC = sc.nextInt();
		sR = sc.nextInt();

		eC = sc.nextInt();
		eR = sc.nextInt();

		map = new int [R+2][C+2];
		//visit = new int [R+2][C+2];
		temp = new char [C+2];
		
		for (int i=1; i <= R ; i++) {
			temp = (" "+ sc.next()).toCharArray();
			for (int j=1; j <= C; j++) {			
				map[i][j] = temp[j] - '0';			
			}
		}		
		
	}

	static void display_map() {
	
	    System.out.printf("R:%d, C:%d \n\n", R,C );
		for (int i=1; i <= R; i++) {
			for (int j=1; j <= C; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println();
		}
		
		
	}

	static void check() {
	
	
	
	}
	
	
	static int solve() {
				
		NODE out;
		int nc, nr;
		nc = sC;
		nr = sR;
		wp = rp = 0;

		que[wp++] = new NODE(nc,nr);
		//visit[nr][nc] = 1;
		map[nr][nc] = 1;
		
		while(wp-rp>0) {
		
			out = que[rp++];
			
			System.out.printf("wp:%d,rp:%d,map:%d,nc=%d,nr=%d\n", wp, rp, map[nr][nc],nc,nr);
			for (int i=0; i < 4; i++) {
			
				nc = out.c + dc[i];
				nr = out.r + dr[i];
				
				if (nc < 1 || nr < 1 || nc > C || nr > R) continue;
				if (nc == eC && nr == eR) {
				
				   // destination ...
				   return map[out.c][out.r];
				
				}
				if (map[nc][nr] == 0)  {
					//map[nc][nr]++;
					map[nc][nr]=map[out.c][out.r]+1; // 숫자로 변경해야 계산이 가능하다.
					que[wp++] = new NODE(nc,nr);
				//	System.out.printf("visit : %d \n", visit[nc][nr]);
				}
						
			}
				
		
		}
		return -1;
		
	}



	public static void main(String [] args) {
		
		System.out.printf("Maze go..\n");
		input();
		display_map();
		System.out.printf("length = %d\n",solve());
		display_map();
	}
	



}	