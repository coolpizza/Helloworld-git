/*

백준 안전영역 2468
https://www.acmicpc.net/problem/2468
https://youngest-programming.tistory.com/500
https://loosie.tistory.com/297
https://velog.io/@alstjdwo1601/%EB%B0%B1%EC%A4%80-2468%EB%B2%88-%EC%95%88%EC%A0%84-%EC%98%81%EC%97%ADJAVA
https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-2468%EB%B2%88-%EC%95%88%EC%A0%84-%EC%98%81%EC%97%AD-with-%EC%9E%90%EB%B0%94


5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
-->
5

7
9 9 9 9 9 9 9
9 2 1 2 1 2 9
9 1 8 7 8 1 9
9 2 7 9 7 2 9
9 1 8 7 8 1 9
9 2 1 2 1 2 9
9 9 9 9 9 9 9

-->
6




*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] checked;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0,- 1, 0, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		int maxHeight=0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > maxHeight) {
					maxHeight =map[i][j];
				}
			}
		}
		
		int max =0;
		// 1. 모든 지역 탐색
		for(int height=0; height<maxHeight+1; height++) {
			checked = new boolean[n][n];
			int cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					// 2. 안전 영역 탐지
					if(!checked[i][j] && map[i][j] > height){
						cnt+=dfs(i,j,height); // 해당 안전영역 탐색 시작
					}
					
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	// 안전 영역 DFS탐색
	static int dfs(int x, int y, int height) {
		checked[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x +dx[i];
			int ny = y +dy[i];
			
			if(nx<0 || ny<0 || nx>n-1 || ny >n-1) continue;
			if(checked[nx][ny]) continue;
			if(map[nx][ny]> height) {
				dfs(nx,ny, height);
			}
		}
		return 1;
	}
}