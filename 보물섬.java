/*
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=734&sca=99&sfl=wr_subject&stx=%EB%B3%B4%EB%AC%BC%EC%84%AC
 * 
 문제
보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다. 보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 
각 칸은 육지(L)나 바다(W)로 표시되어 있다. 이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다.
보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다. 육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안된다.

예를 들어 위와 같이 지도가 주어졌다면 보물은 아래 표시된 두 곳에 묻혀 있게 되고, 이 둘 사이의 최단 거리로 이동하는 시간은 8시간이 된다.
보물 지도가 주어질 때, 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간을 구하는 프로그램을 작성하시오.

입력형식
입력 파일의 첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다. 
이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다. 보물 지도의 가로, 세로의 크기는 각각 50이하이다.

출력형식
첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.

입력 예
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW

출력 예
8
 */

package Day5;

import java.util.Scanner;

import javax.swing.JTable.PrintMode;

// BFS - Queue
// 1. 시작점 : 육지 모두 다 (a[i][j] == 'L')
// 2. 도착점 : while(wp > rp) {}을 수행할 때 마지막 방문한 정점
//          Queue[wp-1]에 있는 정점 => 마지막 정점
// 3. 연결점 : 상/하/좌/우
// 4. 정점 타입/개수 : 좌표 / 50x50
// 5. 큐 : 좌표 , 50 x 50
// 6. 비용식 : +1
// 7. 방문표시 : 별도 배열 사용
// 8. 입력 : a[][]
public class Main_D5_2047_treasure {

	private static int R;
	private static int C;
	private static char[][] map;
	private static int[][] visit;
	
	// 큐 관련 변수
	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static Node[] Queue;
	static int wp, rp;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	static void input(Scanner sc) {
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R+2][C+2];
		
		for(int i=1; i<=R; i++)
			map[i] = ("W" + sc.next() + "W").toCharArray();
	}
	
	static void printAry(int[][] a) {
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++)
				System.out.print(a[i][j]);
			System.out.println();
		}
	}
	
	static int BFS(int r, int c) {
		// 필요 변수
		Node out;
		int nr, nc;
		
		visit = new int[R+2][C+2];
		Queue = new Node[R*C];
		
		// 0. 큐 관련 변수 초기화
		wp = rp = 0;
		// 1. 시작점을 큐에 넣고 방문표시
		Queue[wp++] = new Node(r, c);
		visit[r][c] = 1;
		
		// 2. 큐에 정점이 있으면 계속 반복
		while(wp > rp) {
		//    2.1 큐에서 정점을 거내 out에 저장
			out = Queue[rp++];
		//    2.2 out과 "방문하지 않은" 연결점을 찾아, 도착점이면 반환하고 아니면 큐에 넣고 방문표시
			for(int i=0; i<4; i++) {
				nr = out.r + dr[i];
				nc = out.c + dc[i];
				if(nr < 1 || nc < 1 || nr > R || nc > C) continue;
				
				if(visit[nr][nc] == 0 && map[nr][nc] == 'L' ) {
					Queue[wp++] = new Node(nr, nc);
					visit[nr][nc] = visit[out.r][out.c] + 1;
				}
			}
		}
		
		out = Queue[wp-1];
				
		//System.out.printf("wp:[%d] \n", wp);
		
		System.out.printf("\n visit[%d][%d]=%d, %d  wp : %d, rp : %d \n", 
		                   out.r, out.c, visit[out.r][out.c],visit[out.r][out.c]-1, wp, rp);
		
		return visit[out.r][out.c]-1;
	}
	
	static int getSolution() {
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(map[i][j] == 'L') {
					int cost = BFS(i,j);
					System.out.printf("cost : "+cost);
					max = (max < cost) ? cost : max;
					System.out.printf(" max : "+max);
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		//printAry(map);
		System.out.println(getSolution());
		sc.close();
	}

}
