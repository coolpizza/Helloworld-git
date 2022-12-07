/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=391&sca=99&sfl=wr_subject&stx=%EB%93%B1%EC%82%B0

등산로 찾기
 
문제
n×n의 형렬로 지형도가 표시된 산이 있다. 
행렬의 원소의 값은 양의 정수값으로 그 위치에서의 높이를 말해준다. 
등산가들은 산의 바깥지역(높이 0)으로부터 정상에 도달하기 위하여 가장 경제적인 루트를 탐색하려고 한다. 
경제적인 경로란 힘을 가장 적게 들이고 정상까지 올라갈 수 있는 길을 말한다.

예를 보면서 설명해보자. 다음은 행렬 Mount[5,5]로 표시된 산악지형이다. 
산의 정상은 Mount[3,3]의 위치에 있으며, 그 높이는 6이다. 
그리고 이 산의 바깥지역은 모두 해발이 0이다. 등산가가 산에 오르는 시작점의 위치는 산의 바깥지역의 어디에서 시작해도 좋다.

등산가는 어떤 한 지역에서 그 위치에 인접한 네 방향(위, 아래, 왼쪽, 오른쪽)으로만 움직일 수 있다. 
인접한 지역으로 움직일 수 있는 경우는 (1) 평지로 이동할 경우, (2) 내려갈 경우, (3) 올라갈 경우의 세가지이다. 
이 세가지 경우에 필요한 "힘"의 양은 다음과 같이 표현될 수 있다. 
(1) 인접한 같은 높이의 지역을 수평이동할 경우에는 그냥 평지를 걸어가면 되므로 힘이 전혀 들지 않는다고 가정한다. 
    예를 들면 Mount[5,2]에서 Mount[5,3]으로 이동하는 경우와 Mount[4,5]에서 Mount[5,5]로 이동하는 경우에는 전혀 힘이 들지 않는다.
(2) 내리막길을 따라갈 경우(예를 들면, Mount[2,3]에서 Mount[2,2]로 갈 때)에는 그 높이 차이만큼의 힘이 든다. 
   즉 이 경우에는 5-3=2만큼의 힘이 든다.
(3) 오르막길을 오를 경우에는 이동할 두 지역의 높이 차의 제곱 만큼의 힘이 든다. 
   즉 Mount[1,2]에서 Mount[1,3]으로 갈 경우는 (4-2)^2=4 만큼의 힘이 든다.

입력형식
첫줄에는 산의 크기인 Mount[n,n]의 n값이 주어지고, 두 번째 줄에는 정상의 위치 Mount[i,j]의 i, j값이 주어진다. 
단, Mount[n,n]에서 n은 100 이하이고, 각 지형의 최대 높이는 50 이하라고 가정한다. 그 다음 n개의 줄은 산의 크기에 따른 각 지점의 높이가 양의 정수값으로 주어진다.

출력형식
첫째 줄에 정상까지 도달하는 가장 경제적인 경로를 따라 올라가는데 사용된 힘을 출력한다.

입력 예
5
3 3
1 2 4 3 2
1 3 5 4 4
2 3 6 5 1
3 1 4 1 3
2 3 3 5 3

출력 예
8

경로는 다음과 같다.

2[1,5]->3[1,4]->4[2,4]->5[3,4]->6[3,3] = 2*2 + 1*1 + 1*1 + 1*1 + 1*1 = 8

 */

package Day5;

import java.util.Scanner;

// BFS - Queue
// 1. 시작점 : 0번 전체 (Mount[0], Mount[N+1]....)
// 2. 도착점 : 정상 (좌표로 주어짐)
// 3. 연결점 : 상/하/좌/우
// 4. 정점 타입/개수 : 좌표 / 10,000 (100*100)
// 5. 큐 : 좌표, 10,000
// 6. 비용식 : 평지(다음정점 - 현정점 = 0)은 0, 오르막은 ^2, 내리막 정점의 차이
// 7. 방문표시 : 새로운 배열, 중복해서 갈 수 있지만 계산한 값이 더 적으면 업데이트하여 무한 반복 방지
// 8. 입력 : Mount[][]
public class Main_D5_2066_moutain_route {
	
	private static int N;
	private static int eR;
	private static int eC;
	private static int[][] Mount;
	private static int[][] Visit;
	
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
		N = sc.nextInt();
		eR = sc.nextInt();
		eC = sc.nextInt();
		Mount = new int[N+2][N+2];
		Visit = new int[N+2][N+2];
		Queue = new Node[N*N*20];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				Mount[i][j] = sc.nextInt();
				Visit[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	static void printAry(int[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.printf("%2d ", a[i][j]);
			}
			System.out.println();			
		}
		System.out.println(" \n");
	}
	
	static int BFS(int r, int c) {
		// 필요 변수
		Node out;
		int nr, nc;
		
		// 0. 큐 관련 변수 초기화
		wp = rp = 0;
		Queue = new Node[N*N*20];
		
		// 1. 시작점을 큐에 넣고 방문 표시 ==> 중복으로 오를 수 있어 방문 표시는 계산한 값이 더 적으면 기입하는 걸로
		Queue[wp++] = new Node(r, c);
		
		// 2. 큐에 정점이 있으면 계속 반복
		while(wp > rp) {
		//    2.1  큐에서 정점을 꺼내어 out에 저장
			out = Queue[rp++];
		//    2.1 out과 "방문하지 않은" 연결점을 찾아, 도착점이면 반환하고 아니면 큐에 넣고 방문 표시
			for(int i=0; i<4; i++) {
				nr = out.r + dr[i];
				nc = out.c + dc[i];
				if(nr < 1 || nc < 1 || nr > N || nc > N) continue;
				
				int cost = Mount[out.r][out.c] - Mount[nr][nc];				
				if(cost < 0) // 오르막
					cost *= cost;
				if(Visit[nr][nc] > Visit[out.r][out.c] + cost) { // 현재 정점의 값과 다음 정점 이동 비용을 합친 값이 더 적으면 방문하지 않은 것이거나 업데이트 필요
//					printAry(Visit);
//					System.out.println(wp + " : (" + out.r + "," + out.c + ") => (" + nr + "," + nc + ") = " + (Visit[out.r][out.c] + cost));
					Queue[wp++] = new Node(nr, nc);
					Visit[nr][nc] = Visit[out.r][out.c] + cost;
					
					if(nr == eR && nc == eC) {
						System.out.println("================BINGO===============");
						//break; // 도착점이면 멈추고 다른 거 수행 함
					}
				}
			}
		}
		
		return Visit[eR][eC];
	}
	
	static int getSolution() {
		int min = Integer.MAX_VALUE;
		int temp;
		
		for(int i=1; i<=N; i++) {
			temp = BFS(i, 0);
			//printAry(Visit);
			min = (min > temp) ? temp : min; 
			temp = BFS(i, N+1);
			min = (min > temp) ? temp : min; 
		}
		
		for(int j=1; j<=N; j++) {
			temp = BFS(0, j);
			min = (min > temp) ? temp : min; 
			temp = BFS(N+1, j);
			min = (min > temp) ? temp : min; 
		}
		
		return min;
	}
	
	static int BFS() {
		// 필요 변수
		Node out;
		int nr, nc;
		
		// 0. 큐 관련 변수 초기화
		wp = rp = 0;
		
		// 1. 시적점을 큐에 넣고 방문 표시
		for(int i=1; i<=N; i++) {
			Queue[wp++] = new Node(i, 1);
			Queue[wp++] = new Node(i, N);
			Visit[i][1] = Mount[i][1] * Mount[i][1];
			Visit[i][N] = Mount[i][N] * Mount[i][N];
		}
		for(int j=1; j<=N; j++) {
			Queue[wp++] = new Node(1, j);
			Queue[wp++] = new Node(N, j);
			Visit[1][j] = Mount[1][j] * Mount[1][j];
			Visit[N][j] = Mount[N][j] * Mount[N][j];
		}
		printAry(Visit);
		
		// 2. 큐에 정점이 있으면 계속 반복
		while(wp > rp) {
			// 2.1 큐에서 정점을 꺼내어 out에 저장
			out = Queue[rp++];
			// 2.2  out과 "방문하지 않은" 연결점을 찾아, 도착점이면 반환하고 아니면 큐에 넣고 방문표시
			for(int i=0; i<4; i++) {
				nr = out.r + dr[i];
				nc = out.c + dc[i];
				if(nc < 1 || nr < 1 || nr > N || nc > N) continue;
				
				int cost = Mount[out.r][out.c] - Mount[nr][nc];
				if(cost < 0) // 오르막
					cost *= cost;
				cost += Visit[out.r][out.c];
				if(Visit[nr][nc] > cost) {
					Queue[wp++] = new Node(nr, nc);
					Visit[nr][nc] = cost;
				}
			}
		}
		printAry(Visit);
		
		return Visit[eR][eC];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		//System.out.println(getSolution());
		System.out.println(BFS());
		sc.close();
	}

}
