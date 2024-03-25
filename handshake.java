package Day1;

/*
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1932&sca=99&sfl=wr_subject&stx=%EC%95%85%EC%88%98
 * 문제
R행 C열의 격자 모양의 지역에 몇 명의 사람이 서 있다. 한 격자에는 최대 한 명의 사람이 있다.
각 사람들은 자신과 인접한 사람과 정확히 한 번씩 악수하는데, 인접한 사람은 아래 그림과 같이 주위 8방향에 있는 사람을 말한다.
민혁이는 이 지역의 빈 격자 중 한 곳에 들어가서 이 지역에서 일어난 악수의 총 횟수가 최대가 되게 하려고 한다.
민혁이가 들어간 후 이 지역에서 일어난 악수의 총 횟수를 구하여라. 만약 빈 격자가 없다면 민혁이는 아무 행동도 하지 않는다.

입력형식
첫 번째 줄에는 격자의 크기 R, C가 주어진다. (1 ≤ R, C ≤ 50) 두 번째 줄부터 R개의 줄에는 이 지역의 현재 상태가 주어진다. 'O'는 사람이 있는 곳을, '.'는 사람이 없는 곳을 나타낸다.

출력형식
민혁이가 들어간 후 이 지역에서 일어난 악수의 총 횟수를 출력한다.

입력 예
2 3
..o
o..
출력 예
2

입력 예
2 2
oo
oo
출력 예
6

Hint!
민혁이가 1행 2열 또는 2행 2열에 들어가면 민혁이가 기존에 있던 두 사람과 악수하게 되어 총 2번의 악수가 일어난다.
 */
import java.util.Scanner;

public class handshake {
	static int R, C;
	static char[][] map_state;
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static int handshake(int cr, int cc) {
		int cnt = 0;
		int nr, nc;
		
		// 8방향 돌면서 인접을 구함
		for(int i=0; i<dr.length; i++) {
			nr = cr + dr[i];
			nc = cc + dc[i];
			
			if(map_state[nr][nc] == 'o')
				cnt++;
		}
		
		return cnt;
	}
	
	public static void input(Scanner sc) {
		R = sc.nextInt();
		C = sc.nextInt();
		map_state = new char[R+2][C+2];
		
		for(int i=1; i<=R; i++) {
//			System.out.println(sc.next());
			map_state[i] = (" " + sc.next() + " ").toCharArray();
		}
		
		for(int i=1; i<=R; i++) {
			for (int j=1; j <=C; j++) {
				System.out.println(">>map_state["+i+"]["+j+"]"+map_state[i][j]);
			}
			
		}

	}
	
	public static int getSolution() {
		int max_mh = 0; // 민혁이의 악수 max
		int sum_inhabitants = 0; // 주민끼리의 악수 합
		
		for(int r=1; r<=R; r++) {
			for(int c=1; c<=C; c++) {
				if(map_state[r][c] == 'o') {
					sum_inhabitants += handshake(r, c);
					System.out.println("sum of inhabitants : " + sum_inhabitants);
				}
				else {
					int tempCnt = handshake(r, c);
					if(tempCnt > max_mh)
						max_mh = tempCnt;
					System.out.println("max minhyeok : " + max_mh);
				}
			}
		}
		System.out.println(sum_inhabitants);
		
		return sum_inhabitants/2 + max_mh;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		System.out.println(getSolution());
		sc.close();
	}

}
