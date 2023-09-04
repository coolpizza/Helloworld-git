
/*

4
1 1 60
1 3 100
1 5 90
3 2 40
2 50 2

최대로 혜택볼 수 있는 지역의 갯수는 ?
--> 3   


*/


import java.util.*;

public class Main {

	static int []X = new int[100];
	static int []Y = new int[100];
	static int []R = new int[100];
	static int M;  // 인공강우 횟수
	static int Q;  // 인공강우량
	static int L;  // 인공강우 거리
	static int N;
	static int [][] visit = new int[100][100]; 
	
	void input() {
		Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
		
        for (int i = 0; i < N; i++) {           
			X[i] = sc.nextInt();
			Y[i] = sc.nextInt();
			R[i] = sc.nextInt(); 
        }	
		M = sc.nextInt();
		Q = sc.nextInt();
		L = sc.nextInt();	
		
	}


	void display() {
		for (int i = 0; i < N; i++) {           
			System.out.println("X:"+X[i]+" Y:"+Y[i]+" R:"+R[i]);   
        }
		System.out.println("M:"+M+" Q:"+Q+" L:"+L);
		
	}
	
	int dist(int x1, int y1, int x2, int y2) {		
		int dist_x;
		int dist_y;
		
		if (x1>=x2) { 
			dist_x = x1-x2;
		} else {
			dist_x = x2-x1;
		}
		if (y1>=y2) { 
			dist_y = y1-y2;
		} else {
			dist_y = y2-y1;
		}				
		return dist_x+dist_y;
	}
	
	void solve() {
		
		int cnt = 0;
		
		for (int i=0; i< N; i++) {
			for (int j=0; j < N; j++) {
				System.out.printf("distance : (%d,%d)-(%d,%d) = %d \n",X[0],Y[0],X[i],Y[j],
										dist(X[0],Y[0],X[i],Y[j]));
			}
		}
		// 중복금지 --> 이부분을 해결해야 함.  (X1,Y1)<->(X2-Y2)구간을 지났다는 표기가 필요하다. 
		for (int i=0; i< N; i++) {
			for (int j=i; j < N; j++) {				      
					 System.out.printf("X[%d]:%d, Y[%d]:%d \n", i,X[i],j,Y[j]);
						
			}
		}
	}



    public static void main(String[] args) {
		Main m = new Main();
		
		m.input();
        m.display();
		m.solve();
	 
        //System.out.println(max);
    }

}