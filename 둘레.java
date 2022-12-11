/*
 * http://comganet.github.io/dfs/2016/07/30/dfs-1
문제
농부 존은 그의 들판에 N(1≤N≤10,000)개의 건초 더미를 놓으려 한다. 
들판은 1x1 크기의 사각형으로 구성된 100x100 크기이고, 건초 더미들은 각각 1x1 크기의 사각형 한 칸을 차지한다. (한 칸에 두 개의 건초 더미가 놓이는 일은 없다)
농부 존은 건초 더미로 연결된 다양한 형태의 하나의 큰 영역이 생기는 것을 알았다. 
즉, 건초 더미들 모두 인접한 (동서남북으로 한 칸) 곳에 다른 건초 더미가 있다. 한 건초 더미에서 출발해서 다른 모든 건초 더미에 도달할 수 있다. 
건초 더미로 연결된 영역은 “구멍”을 포함하고 있다. 구멍은 건초 더미로 완전히 둘러싸인 빈 영역이다.
농부 존이 건초 베일에 의해 형성되는 영역의 둘레를 계산하는 것을 도와주시오. “구멍”은 둘레에 영향을 주지 않는다.

 입력형식
첫 번째 줄에 건초 더미의 수 N이 입력된다. (1≤N≤10,000)
두 번째 줄부터 N줄에 걸쳐 건초 더미가 놓인 곳의 위치 X(가로), Y(세로)가 공백으로 구분되어 입력된다. X, Y 모두 정수이고 1이상 100이하이다.

 출력형식
건초 더미로 연결된 영역의 둘레의 길이를 출력하라.

 입력
8
5 3
5 4
8 4
5 5
6 3
7 3
7 4
6 5

 출력
14
 */

package Day4;

import java.util.Scanner;

// Flood Fill
public class Main_D4_2147 {
	
	private static int N; // 건초더미 개수
	private static int[][] a; // 들판(100*100)
	private static final int R = 100;
	private static final int C = 100;
	private static int sR = Integer.MAX_VALUE;
	private static int sC = Integer.MAX_VALUE;
	private static int eR = Integer.MIN_VALUE;
	private static int eC = Integer.MIN_VALUE;
	
	// 4 방향
	private static int[] dr = { 0, -1, 0, 1 };
	private static int[] dc = { -1, 0, 1, 0 };
	private static int cnt;

	static void input(Scanner sc) {
		int r, c; // Y, X
		N = sc.nextInt();
		a = new int[R+2][C+2];
		
		for(int i=0; i<N; i++) {
			c = sc.nextInt(); // X
			r = sc.nextInt(); // Y
			a[r][c] = 1;
			
			if(sR > r) sR = r;
			if(sC > c) sC = c;
			if(eR < r) eR = r;
			if(eC < c) eC = c;
			
			System.out.println("sR:"+sR+" "+"sC:"+sC+" "+"eR:"+eR+" "+"eC:"+eC);
			
			
		}
		sR--; sC--;
		eR++; eC++;
	}
	
	static void printAry(int[][] arr) {
		for(int i=sR; i<=eR; i++) {
			for(int j=sC; j<=eC; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}
	
	// 1. 프로토타입 기술
	//    - 리턴형 : int 성공(1), 실패(0) => 결과값을 리턴하면 안되고 전역변수로 설정해야 함
	//            void는 모든 경우의 수를 수행해야 할 때 사용
	//    - 인수리스트 : 종료조건를 반드시 넘겨야 한다. (int L)
	//               이전 레벨까지의 어떤 상태 정보를 사용할 경우 인수에 추가한다
	// 2. 리턴형이 int이면 함수 마지막에 return 0
	// 3. depth 까지만 실행되도록 종료조건문 작성
	// 4. 재귀함수 호출문 및 결과값을 찾고자 하는 조건검색 작성
	// 5. 가지치기
	static void FF_DFS(int r, int c) {
		int nr, nc;
		
		a[r][c] = 2; // 방문표시
		
		for(int i=0; i<4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr < sR || nc < sC || nr > eR || nc > eC) continue; // 건초더미의 최소한의 면적으로 비교
			
			if(a[nr][nc] == 0) // 건초더미 밖안 면적을 색칠하기
				FF_DFS(nr, nc);
			else if(a[nr][nc] == 1) // 건초더미 밖안쪽 색칠하면서 건초더미를 만나면 둘레 1 증가
				cnt++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		//printAry(a);
		FF_DFS(sR, sC);
		printAry(a);
		System.out.println(cnt);
		sc.close();
	}

}
