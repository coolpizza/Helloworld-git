/*
입력 예
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

출력 예
3
7
8
9
 */
 
 import java.util.*;
 
 
 public class apt {
	
	static int N; 
	static int[][] a; 
	static int[][] visit; 
	
	static int gCnt;
	static int[] group;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	static void printAry() {
		System.out.println();
		for (int i=0; i < N; i++) {
			for (int j=0; j < N; j++) {
			   System.out.printf("%d ",a[i][j]);
			}
		    System.out.println();
		}
		
	}
	
	
	static void input(Scanner sc) {
		N = sc.nextInt();
		a = new int[N+2][N+2];
		group = new int[N+2];
		visit = new int[N+2][N+2];
		
		for(int i=0; i<N; i++) {
		 char[] t = sc.next().toCharArray();  
			
			for(int j=0; j< N; j++) {
				a[i][j] = t[j] - '0';
				
			}
			
		}
		
		printAry();
		
		
	}
	
	
	static void dfs(int r, int c) {
		
		if (visit[r][c] != 0) return;
		visit[r][c] = 1;
		group[gCnt]++; 
		
		//System.out.println("-->group["+gCnt+"]="+group[gCnt]);
		
		int nr;
		int nc;
		//System.out.println("2----------");
		for (int i=0; i<4; i++) {
			nr = dr[i]+r;
			nc = dc[i]+c;
			if (nr > N || nr <0 || nc > N || nc <0) continue;
			if (visit[nr][nc] ==1) continue; 
			if (a[nr][nc]==0) continue;	
			
			dfs(nr, nc);
			
		}
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		
		gCnt = 0;
	//group[gCnt]   
		for (int r=0 ; r<N; r++) {
			for (int c=0; c<N; c++){				
				if (a[r][c]==1 && visit[r][c] ==0 ){
					//System.out.println("1----------");
					dfs(r, c);
					gCnt++;
					System.out.println("-->gCnt : "+ gCnt);
				}
			}
		}
		
		
		
	}	
	
 }