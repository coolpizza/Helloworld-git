
/*


https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-15686-%EC%B9%98%ED%82%A8-%EB%B0%B0%EB%8B%AC-java
https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-15686%EB%B2%88-%EC%B9%98%ED%82%A8-%EB%B0%B0%EB%8B%AC-java
https://yabmoons.tistory.com/99
https://yabmoons.tistory.com/50

https://jaimemin.tistory.com/1059


<입력>
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.
둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.
도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다. 
집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 
치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.

<출력>
첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.

5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
-->

5,

5 3
0 0 1 0 2
0 0 2 0 1
0 1 2 0 0
2 0 1 0 0
0 0 0 0 2

-->

4,



*/


import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] map;
    static LinkedList<rowCol> chicken = new LinkedList<>();
    static int min = Integer.MAX_VALUE;
    static int[] drow = {0, 0, 1, -1};
    static int[] dcol = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            // 값을 입력받으면서 LinkedList에 미리 치킨집의 좌표 입력
            for(int j = 0; j<N; j++) {
                int space = Integer.parseInt(st.nextToken());
                map[i][j] = space;

                if(space == 2) {
                    chicken.add(new rowCol(i, j, 0));
                    map[i][j] = 0;
                }
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int count, int idx){
        //선택한 치킨집의 갯수가 M과 같아지면 bfs
        if(count == M){
			System.out.println(" 1.......");
            bfs();
            return;
        }
        //이전에 선택했던 치킨집은 확인하지 않아도 되므로 i는 idx에서 시작
        for(int i = idx; i<chicken.size(); i++){
            rowCol rc = chicken.get(i);
            int row = rc.row;
            int col = rc.col;

            if(map[row][col] == 2)
                continue;

            map[row][col] = 2;
            dfs(count+1, i);
            map[row][col] = 0;
        }
    }

    static void bfs(){
        int[][] sub = new int[N][N];
        Queue<rowCol> q = new LinkedList<>();
        int sum = 0;

        //원본 데이터를 보존하기 위하여 새로운 배열을 만들면서 이전 dfs에서
        //폐업하지 않기로 선택한 치킨집이 어딘지 확인
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                sub[i][j] = map[i][j];

                if(sub[i][j] == 2)
                    q.offer(new rowCol(i, j, 0));
            }
        }

        while(!q.isEmpty()){
            rowCol a = q.poll();

            for(int i = 0; i<4; i++){
                int dr = a.row + drow[i];
                int dc = a.col + dcol[i];

                if(dr<0||dc<0||dr>=N||dc>=N)
                    continue;
                //한번 이동한 공간은 다시 가지 않으므로 3을 넣어놓음
                if(sub[dr][dc] == 0){
                    sub[dr][dc] = 3;
                    q.offer(new rowCol(dr, dc, a.cnt+1));
                }
                //bst를 이용하였을 때 가장 먼저 집에 도착한 치킨집이
                //가장 가까운 치킨집이므로 sub[dr][dc]를 4로 초기화하고 큐에 삽입
                else if(sub[dr][dc] == 1){
                    sub[dr][dc] = 4;
                    q.offer(new rowCol(dr, dc, a.cnt+1));

                    sum += a.cnt+1;
                }
            }
        }

        min = Math.min(min, sum);
    }
}
//row col좌표 뿐만이 아니라 치킨집에서 얼마나 거리가 떨어져 있는지 알기 위해서 cnt사용
class rowCol{
    int row, col, cnt;

    rowCol(int row, int col, int cnt){
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}