
/*
https://www.acmicpc.net/problem/17182
https://bleron.tistory.com/215
https://imnotabear.tistory.com/233


4 1
0 83 38 7
15 0 30 83
67 99 0 44
14 46 81 0

-->
74


3 0
0 30 1
1 0 29
28 1 0
-->
2

*/

import java.io.*;
import java.util.*;
 
public class Main {
 
    static int[][] dist;
    static int N, K, ans = Integer.MAX_VALUE;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        visited = new boolean[N];
        visited[K] = true;
        perm(1, K, 0);
        System.out.println(ans);
    }
 
    static void perm(int cnt, int prev, int d) {
        if (cnt == N) {
            ans = Math.min(ans, d);
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            perm(cnt+1, i, d + dist[prev][i]);
            visited[i] = false;
        }
    }
}