package Day1;

/*
 * 정올 - 문제은행 -1437번 - 같은 모양 찾기
 * 문제 내용
 * 모눈종이에서 찾고 싶은 모양 패턴의 모양이 몇 개가 있는지 검사하려고 한다.
 * 입력
 * 첫번재 줄에는 모눈종이의 크기(0<=M<=100)가 주어진다.
 * 두번째 줄 부터 M 줄 까지는 모눈종이에 그린 그림을 칠한 칸을 1로, 칠하지 않은 칸을 0으로 모눈종이의 줄별로 입력한다.
 * 다음 줄에는 패턴의 크기 P(0<=P<=100)가 주어진다.
 * 다음 줄 부터 P개의 줄에 걸쳐 찾고 싶은 모양이 주어진다. 모양이 있는 부분만 1로 입력하고 나머지는 0으로 처리한다.
 * 
 * 출력
 * 출력은 찾고 싶은 패턴의 모양이 모눈종이에 그린 그림에 ㅣ몇개가 있는지 그 개수를 출력한다.
 */

 /*
 
 M = 5 :
 5
 01010
 11111
 01010
 11111
 01010
 
 N = 3:
 3
 010
 111
 010
 
 
 
 */
 
import java.util.Scanner;

public class sameshape {

	private static int M;
	private static char[][] a;
	private static int P;
	private static char[][] b;

	private static void input(Scanner sc) {
		// TODO Auto-generated method stub
		M = sc.nextInt();
		a = new char[M][M];
		for(int i=0; i<M; i++)
			a[i] = sc.next().toCharArray();
		
		P = sc.nextInt();
		b = new char[P][P];
		for(int j=0; j<P; j++)
			b[j] = sc.next().toCharArray();
	}
	
	// 모눈종이 sr, sc 위치에서 패턴검사 했을 때 같으면 1, 다르면 0
	private static int check(int sr, int sc) {
		for(int i=0; i<P; i++) {
			for(int j=0; j<P; j++) {
				if(a[i+sr][j+sc] != b[i][j]) return 0;
			}
		}
		return 1;
	}

	private static int getSolution() {
		// TODO Auto-generated method stub
		int cnt = 0;
		
		// 시작위치 지정, 모양이 같은지 확인, 같은 개수를 반환
		for(int r=0; r<M-P; r++) {
			for(int c=0; c<M-P; c++)
				cnt += check(r, c);
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		System.out.println(getSolution());
		sc.close();
	}

}
