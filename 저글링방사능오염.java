/*
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=358&sca=99&sfl=wr_subject&stx=%EC%A0%80%EA%B8%80%EB%A7%81
 * 
 * 문제 
 * 승훈이는 심심한 시간에 스타크래프트(Starcraft) 게임을 하며 놀고 있었다. 
스타크래프트 유닛중 하나인 저글링을 한 곳에 몰아세운 뒤, 방사능 오염 공격으로 없애보려고 했다.
그런데 좀 더 재미있게 게임을 하기 위해서 게임을 개조하여 방사능 오염 공격을 가하면 방사능은 1초마다 이웃한 저글링에 오염된다. 
그리고 방사능에 오염된 저글링은 3초 후에 죽게 된다.  

예를 들어 아래 왼쪽그림과 같이 모여 있는 저글링 중에 빨간 동그라미 표시를 한 저글링에게 방사능 오염공격을 가하면, 
총 9초 후에 저글링들이 죽게 된다. 아래 오른쪽에 있는 그림의 숫자들은 각 저글링들이 죽는 시간이다.

저글링을 모아놓은 지도의 크기와 지도상에 저글링들이 놓여 있는 격자 위치가 주어질 때, 
총 몇 초 만에 저글링들을 모두 없앨 수 있는지 알아보는 프로그램을 작성하시오.

입력형식
첫째 줄은 지도의 열의 크기와 행의 크기가 주어진다. 지도는 격자 구조로 이루어져 있으며 크기는 100×100칸을 넘지 않는다. 
둘째 줄부터는 지도상에 저글링들이 놓여있는 상황이 주어진다. 1은 저글링이 있는 곳의 표시이고 0은 없는 곳이다. 
마지막 줄에는 방사능오염을 가하는 위치가 열 번호 행 번호 순으로 주어진다.

출력형식
죽을 수 있는 저글링들이 모두 죽을 때까지 몇 초가 걸리는지 첫 번째 줄에 출력하고 둘째 줄에는 죽지 않고 남아 있게 되는 저글링의 수를 출력하시오.

입력 예
7 8 
0010000 
0011000 
0001100 
1011111 
1111011 
0011100 
0011100 
0001000
3 5

출력 예
9
0
 */

package Day4;

import java.util.Scanner;

/*
 * 1. 시작점 : sR, sC
 * 2. 도착점 : 없음 (갈 수 없을 때 까지) - while(wp > rp)
 * 3. 연결점 : 상/하/좌/우
 * 4. 정점(저글링)의 모양/수 : 좌표, 100*100
 * 5. 큐 : 100*100
 * 6. 비용식 : +1 // 초기값 3
 * 7. 방문표시 : 입력배열 ==> 방문표시 + 비용저장(3,4,5,6....)
 *    if 별도 배열 사용, int[][] visit에 입력배열(a)를 복사 후 방문표시 + 비용저장
 * 8. 입력 : int[][] a 또는 chr[][] a => 방문표시에 따라 다르게 할 수 있음
 */
public class Main_D4_2049_juggling {
	
	private static int C;
	private static int R;
	private static int[][] a;
	private static int[][] visit;
	private static int sC;
	private static int sR;
	
	static int time, remain;

	static void input(Scanner sc) {
		C = sc.nextInt();
		R = sc.nextInt();
		a = new int[R+2][C+2];
		
		for(int i=1; i<=R; i++) {
			char[] temp = ("0" + sc.next() + "0").toCharArray();
			for(int j=1; j<=C; j++) {
				a[i][j] = temp[j] - '0';
				if(a[i][j] == 1) remain++;
			}
		}
		
		sC = sc.nextInt();
		sR = sc.nextInt();
	}
	
	static void output() {
		System.out.println(time);
		System.out.println(remain);
	}
	
	static void print(int[][] imsi) {
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++)
				System.out.print(imsi[i][j]);
			System.out.println();
		}
	}
	
	static class Node {
		int r, c;
		int t;
		Node(int nr, int nc) {
			this.r = nr;
			this.c = nc;
		}
		
		Node(int nr, int nc, int t) {
			this.r = nr;
			this.c = nc;
			this.t = t;
		}
	}
	
	static Node[] Queue = new Node[100*100];
	static int wp, rp;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	
	static int BFS(int sr, int sc) {
		// 필요 변수
		Node out;
		int nr, nc;
		
		// 0. 큐를 초기화 한다
		wp = rp = 0;
		
		// 1. 시작점을 큐에 넣고 방문 표시, remain도 감소
		Queue[wp++] = new Node(sr, sc);
		a[sr][sc] = 3; // 초기값(3초 후에 죽음)
		remain--;
		
		// 2. 큐에 정점이 있으면 계속 반복
		while(wp > rp) {
		//   2.1 큐에서 정점을 꺼내 out에 저장
			out = Queue[rp++];
		//   2.2 out과 "방문하지 않은" 연결점을 찾아, 도착점이면 반환하고 아니면 큐에 넣고 방문 표시 (도착점이 없으니 끝까지 그냥 반복한다)
			for(int i=0; i<dr.length; i++) { // 4방향
				nr = out.r + dr[i];
				nc = out.c + dc[i];
				
				if(nr < 1 || nc < 1 || nr > R || nc > C) continue;
				if(a[nr][nc] == 1 ) {  // 연결점에 저글링이 있으면(1)
					Queue[wp++] = new Node(nr, nc);
					a[nr][nc] = a[out.r][out.c] + 1;
					if(time < a[nr][nc]) time = a[nr][nc];
					remain--;
				}
			}
		}
		
		return -1; // Fail
	}
	
	static int BFS(int sr, int sc, int t) {
		// 필요 변수
		Node out;
		int nr, nc;
		
		// 0. 큐 초기화
		wp = rp = 0;
		visit = new int[R+2][C+2];
		
		// 1. 시작점을 큐에 넣고 방문 표시
		Queue[wp++] = new Node(sr, sc, t);
		visit[sr][sc] = 1;
		
		// 2. 큐에 정점이 있으면 계속 반복
		while(wp > rp) {
			// 2.1 큐에서 꺼내어 out에 저장
			out = Queue[rp++];
			// 2.2 out과 "방문하지 않은" 연결점을 찾아, 도착점이면 반환하고 아니면 큐에 넣고 방문 표시
			for(int i=0; i<4; i++) {
				nr = out.r + dr[i];
				nc = out.c + dc[i];
				
				if(nr < 1 || nc < 1 || nr > R || nc > C) continue;
				// 방문하지 않은 인접 정점에 대해
				if(visit[nr][nc] == 0 && a[nr][nc] == 1) {
					Queue[wp++] = new Node(nr, nc, out.t+1);
					visit[nr][nc] = 1;
				}
			}
		}
		
		return (wp>0) ? Queue[wp-1].t : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		//print(a);
		BFS(sR, sC);
		print(a);
		output();
		
		//System.out.println(BFS(sR, sC, 3)); // 시작점의 비용은 초기값이 3
		//System.out.println(remain - wp);
		//print(visit);
		sc.close();
	}

}
