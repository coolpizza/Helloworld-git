/*
 * http://comganet.github.io/dfs/2016/06/03/dfs-1008
문제
도시의 지하에는 수많은 수도파이프가 설치 되어있다. 하지만 이 수도 파이프들이 너무나 무계획적으로 설치되었기 때문에, 실제로는 물이 흐르지 않는 수도파이프도 다수 설치되어 있다고 한다. 그래서 수도파이프 배치를 설계하는
사람들이 현재 도시의 수도파이프 설치 상태를 확인한 뒤, 실제 물이 흐르지 않는 수도파이프를 제거하는 공사를 시행하려 한다.
다음과 같이 파이프가 설치된 상태에서 (0,0) 수도 공급원 이라고 한다면 5개의 수도파이프는 물이 흐르지 않는 수도 파이프이므로 제거 대상이 된다.
다음과 같이 도시의 지하 수도파이프 설치 지도와 수도공급원의 위치가 주어졌을 때, 제거해야 할 수도 파이프의 개수를 구하시오.

 입력형식
입력의 첫째 줄에는 정사각형의 지도의 가로 사이즈 N이 주어진다. ( 4 <= N <= 10)
둘째 줄에는 수도공급원의 시작 좌표가 X,Y의 순서로 주어진다. ( 0<=X,Y<= 9 )
셋째 줄부터 N개의 줄에는 N X N 사이즈의 지도에 대한 정보가 주어진다.
지도 한칸의 파이프에 대한 정보는 숫자 0~9 그리고 A, B로 표현되며 그 의미는 다음과 같다.
0-(파이프 없음)
1 – (─), 2-(│), 3- (┌), 4 – (┐), 5-(┘),
6-(└), 7-(├), 8-(┬), 9-(┤), A-(┴), B-(┼)

 출력형식
사용되지 않은 파이프의 수를 출력한다.

 입력
4
0 0
2799
7439
0652
2172

 출력
5
 */

package Day5;

import java.util.Scanner;

// Flood Fill DFS
public class Main_D5_2138_pipe_remove {
	
	private static int N;
	private static int sR;
	private static int sC;
	private static int[][] map;
	private static int[][] visit;
	private static int cnt;
	
	static final int[][] pipe = {
		// { 좌, 상, 우, 하 },
			{ 0, 0, 0, 0 }, // 0
			{ 1, 0, 1, 0 }, // 1 -
			{ 0, 1, 0, 1 }, // 2 |
			{ 0, 0, 1, 1 }, // 3 
			{ 1, 0, 0, 1 }, // 4
			{ 1, 1, 0, 0 }, // 5
			{ 0, 1, 1, 0 }, // 6
			{ 0, 1, 1, 1 }, // 7
			{ 1, 0, 1, 1 }, // 8
			{ 1, 1, 0, 1 }, // 9
			{ 1, 1, 1, 0 }, // A
			{ 1, 1, 1, 1 }, // B
	};
	static final int[] dir = { 2, 3, 0, 1 }; // pipe에서 좌/상/우/하 연결되도록
	static final int[] dr = { 0, -1, 0, 1 };
	static final int[] dc = { -1, 0, 1, 0 };
	
	static void input(Scanner sc) {
		N = sc.nextInt();
		sR = sc.nextInt();
		sC = sc.nextInt();
		
		map = new int[N][N];
		visit = new int[N][N];
		for(int i=0; i<N; i++) {
			char[] temp = sc.next().toCharArray();
			for(int j=0; j<N; j++) {
				if(temp[j] >= 'A')
					map[i][j] = temp[j] - 'A' + 10;
				else
					map[i][j] = temp[j] - '0';
				if(map[i][j] != 0) cnt++;
			}
		}
	}
	
	static void output() {
		System.out.println(cnt);
	}
	
	static void print(int[][] a) {
		System.out.println("-----------------------");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++)
				System.out.printf("%2d ", a[i][j]);
			System.out.println();
		}
	}
	
	// 1. 프로토타입 작성
	//   - 리턴형 int 성공(1) / 실패(0) (찾는 값을 리턴하지 않고 전역변수 사용)
	//         void : 모든 경우의 수를 다 수행해야 할 경우
	//   - 인수 리스트 : 종료 조건 인수 추가, 이전 레벨의 상태정보를 넘겨줘야 할 경우 추가
	static int FF_DFS(int r, int c) {
		int nr, nc;
		visit[r][c] = 1;
		cnt--;
		
		// 3. depth 까지만 수행되도록 종료 조건 작성
		// if(L < N) return; // 여기서는 찾을 수 없을 때 까지 반복하여 생략
		// 4. 재귀함수 호출문 및 결과값을 찾고자 하는 조건 검색 작성
		for(int i=0; i<4; i++) { // 다음 칸 이동
			nr = r + dr[i];
			nc = c + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if((pipe[map[r][c]][i] == 1) && (visit[nr][nc] == 0 && pipe[map[nr][nc]][dir[i]] == 1)) { // 서로 연결되어 있으면
				FF_DFS(nr, nc);
			}
		}
		
		// 2. 리턴형이 int 인 경우 실패 반환
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		print(map);
		FF_DFS(sR, sC);
		//print(visit);
		output();
		sc.close();
	}

}
