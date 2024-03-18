/**
 * https://cano721.tistory.com/36
   https://velog.io/@embeddedjune/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%81%B0%EB%8F%8C-Chapter-4-%EB%B9%84%ED%8A%B8%EB%A7%88%EC%8A%A4%ED%82%B9-%EB%B0%B1%EC%A4%80-2234%EB%B2%88-%EC%84%B1%EA%B3%BD
   https://lotuslee.tistory.com/65
   
 
 
 * 비트마스크 문제
 * 
 * 성의 크기와 각 벽의 위치가 주어짐
 * 
 * 1. 각 벽을 비트단위로 해당위치 저장
 * 
 * 2. bfs로 방 개수 파악 및 방 별 넓이 확인
 *   1) visited에 현재 위치가 몇번방인지 저장
 *   2) 해시맵에 방번호 : 방사이즈로 저장
 * 
 * 3. visited(현재위치 방번호)를 4방향 돌면서 다른 방 만났을때,
 *    현재방 사이즈 + 다른방 사이즈가 최대값인지 비교
 * 
 * 
[   0001
-   0010
]   0100
_   1000

 0~15,   11 :  1011,  ㄷ
                 6 :   0110, ㄱ
                 3 : 0011,  ┌
               10 :  1010,  =
                 7 : 0111, |ㄱ
                9 : 1001, ㄴ 

------------------
7 4
11 6 11 6 3 10 6
7 9 6 13 5 15 5
1 10 12 7 13 7 5
13 11 10 8 10 12 13

-->

5
9
16
 
 
 */
import java.util.*;
import java.io.*;

public class BJ2234_castle {
    
    public static int n,m,brokenMax,maxRoom;
    public static int[][] arr,visited;
    public static Map<Integer,Integer> map = new HashMap<>(); // 방번호 : 방사이즈

    public static int[] dirX = {0,-1,0,1};
    public static int[] dirY = {-1,0,1,0};

    public static Queue<int[]> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++){
           st = new StringTokenizer(br.readLine());
           for(int j = 0; j < m; j++){
               arr[i][j] = Integer.parseInt(st.nextToken());
           }
        }
        // 방번호 및 방 크기 체크(visited에 체크)
        bfs();
        // visited를 돌면서 다른 번호일때, 합구하기
        brokenBfs();

        bw.write(map.size() +"\n");
        bw.write(maxRoom +"\n");
        bw.write(brokenMax +"\n");
        bw.flush();
        bw.close();
    }

    // 성 돌기
    public static void bfs(){ 

        q = new LinkedList<>();
        int roomNum = 0;
        int roomSize = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 미방문한곳이면 방문
                if(visited[i][j] == 0){
                    // 방 번호 설정
                    visited[i][j] = ++roomNum;
                    // 방 크기
                    roomSize = 1;
                    q.offer(new int[] {i,j});

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
    
                        int x = cur[0];
                        int y = cur[1];
    
                        for(int idx = 0; idx < 4; idx++){
                            int nx = x + dirX[idx];
                            int ny = y + dirY[idx];
    
                            // 성 벗어난 경우
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                                continue;
                            }
                            // 벽이 없으면서 방문하지 않았으면
                            if((arr[x][y] & (1<<idx)) == 0 && visited[nx][ny] == 0){
                                visited[nx][ny] = visited[x][y];
                                q.offer(new int[] {nx,ny});
                                // 방 크기 증가
                                roomSize++;
                            }
                        }
                    }
                    // 방 저장
                    map.put(roomNum,roomSize);
                    // 최대방이면 변경
                    maxRoom = Math.max(maxRoom,roomSize);
                }
                
            }
        }
    }


    // 다른 방 만나면 체크
    public static void brokenBfs(){ 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 현재방번호
                int roomNum = visited[i][j];

    
                for(int idx = 0; idx < 4; idx++){
                    int nx = i + dirX[idx];
                    int ny = j + dirY[idx];

                    // 성 벗어난 경우
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                        continue;
                    }
                    // 현재방번호랑 다를 시
                    if(visited[nx][ny] != roomNum){
                        // 현재방 + 다른방 최대값 비교
                        brokenMax = Math.max(brokenMax, map.get(roomNum)+ map.get(visited[nx][ny]));
                    }
                }
            }
        }
    }
}