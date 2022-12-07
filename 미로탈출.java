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

package Day3;

import java.util.Scanner;

// 미로탈출
/*
1. 시작점 : sR(sY), sC(sX)
2. 도착점 : eR(eY), eC(eX)
3. 연결점(인접점) : 상/하/좌/우
4. 정점(type, 개수) : 좌표, 10000(1<=X,Y<=100)
5. 큐 : 좌표 타입의 10000개 짜리 배열
6. 비용을 구하는 공식 : +1
7. 방문표시 방법 : 입력 배열 => 방문표시 + 비용저장 (int[][] a)
8. 입력배열 : 0(길, 방문하지 않음), 1(벽), 1,2,3,4,5,6....(비용)
 */

public class Main_D3_1411_maze {
	
	private static int R; // Y (행)
	private static int C; // X (열)
	private static int sC; // Start X
	private static int sR; // Start Y
	private static int eC; // Start X
	private static int eR; // Start Y
	private static int[][] a;

	// 정점의 모양
	static class Node {
		int r, c;
		Node(int nr, int nc) {
			r = nr;
			c = nc;
		}
	}
	static Node[] Queue = new Node[100*100]; // 1<=X,Y<=100
	static int wp, rp;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	
	static int BFS(int sr, int sc) {
		// 필요 변수
		Node out; // 큐에서 꺼낸 정점 저장용 변수
		int nr, nc; // 연결된 정점의 저장용 변수
		
		// 0. 큐 초기화
		wp = rp = 0;
		
		// 1. 시작점을 큐에 넣고 방문 표시
		Queue[wp++] = new Node(sr, sc);
		a[sr][sc] = 1;
		
		// 2. 큐에 정점이 있으면 계속 반복
		while(wp > rp) {
		//   2.1 큐에서 정점을 꺼내 out 변수에 저장
			out = Queue[rp++];
		//   2.2 out과 "방문하지 않은" 연결된 정점을 찾아, 도착점이면 반환하고 아니면 큐에 넣고 방문 표시
			for(int i=0; i<dr.length; i++) {
				nr = out.r + dr[i];
				nc = out.c + dc[i];
				if(nr < 1 || nc < 1 || nr > R || nc > C) continue;
				if(nr == eR && nc == eC) return a[out.r][out.c];
				if(a[nr][nc] == 0) {
					Queue[wp++] = new Node(nr, nc);
					a[nr][nc] = a[out.r][out.c] + 1; // 방문표시, 시간계산
				}
			}
		}
		
		return -1; // Fail
	}
	
	static void printAry() {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++)
				System.out.print(a[i][j]);
			System.out.println();
		}
	}

	static void input(Scanner sc) {
		C = sc.nextInt(); // X
		R = sc.nextInt(); // Y
		sC = sc.nextInt();
		sR = sc.nextInt();
		eC = sc.nextInt();
		eR = sc.nextInt();
		
		a = new int[R+2][C+2];
		
		/*
		for(int i=0; i<a[0].length; i++)
			a[0][i] = 1;
		for(int i=1; i<=R; i++) {
			char[] temp = ("1" + sc.next() + "1").toCharArray();
			for(int j=0; j<temp.length; j++)
				a[i][j] = temp[j] - '0';
		}
		for(int i=0; i<a[R+1].length; i++)
			a[R+1][i] = 1;
		
		*/
		
		
		for(int i=0; i<R; i++) {
			char[] temp = sc.next().toCharArray();
			for(int j=0; j<temp.length; j++)
				a[i][j] = temp[j] - '0';
		}
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		printAry();
		System.out.println(BFS(sR, sC));
		printAry();
		sc.close();
	}

}
