
/*
정올 1671 : 색종이(중)
http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=944&sca=2060

가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 
이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 둘레의 길이를 구하는 프로그램을 작성하시오.
예를 들어 흰색 도화지 위에 네 장의 검은색 색종이를 <그림 1>과 같은 모양으로 붙였다면 검은색 영역의 둘레는 96 이 된다.

4 
3 7 
5 2 
15 7 
13 14

-->
96

*/
 
 
import java.util.*;
 
public class Main {
     
    static int[][] paper = new int[101][101];
    static boolean[][] isVisit = new boolean[101][101];
     
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
     
    static int round = 0;
     
	 
	static class Node {
		int x, y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}	
	 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int N = sc.nextInt();
         
        //입력부
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
             
            for (int r = x; r < x + 10; r++) {
                for (int c = y; c < y + 10; c++) {
                    paper[r][c] = 1;
                }
            }
        }
         
        //둘레 확인
        /* 1. 탐색하다가 1 만나면, 사방탐색
         * 2. 0인 공간 둘레 ++
         * 
         */
         
         
         
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper.length; j++) {
                if(paper[i][j] == 1 && !isVisit[i][j]) {
                    bfs(i,j);
                }
            }
        }
 
//      for (int i = 0; i < paper.length; i++) {
//          for (int j = 0; j < paper.length; j++) {
//              System.out.print(paper[i][j]);
//          }
//          System.out.println();
//      }
         
        System.out.println(round);
    }
 
    private static void bfs(int i, int j) {
   		Queue<Node> q = new LinkedList<>();
         
		q.add(new Node(i,j));
		
        isVisit[i][j] = true;
         
        while(!q.isEmpty()) {
			Node out = q.poll();
            
            int x = out.x;
			int y = out.y;
						 
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                 
                // 범위 밖 -> 아웃
                //if(!(0<= nx && nx < 101 && 0 <= ny && ny < 101)) continue;
				if(nx <0 || nx > 101 || ny < 0 || ny > 101) continue;
                 
                // 인접값이 0이면 체크, 꺾인 부분은 중복 체크 되도록 방문처리 안함
                if(paper[nx][ny] == 0) round++;
                 
                // 다음 값이 탐색 대상(1) 이고, 미방문이면 Q에 넣고 방문처리
                if(paper[nx][ny] == 1 && !isVisit[nx][ny]) {
                    isVisit[nx][ny] = true;
                   
					q.add(new Node(nx,ny));
                }
            }
        }
    }
 
}