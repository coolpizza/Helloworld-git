package Day1;

import java.util.Scanner;

public class Main_2557_loststudent {

	private static int CNT;
	private static int T, R; // 전체 학생수, 돌아온 학생수
	private static int[] data;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		sc.close();
	}

	private static void output() {
		// TODO Auto-generated method stub
		for(int i=1; i<=T; i++)
			if(data[i] == 0) System.out.print(i);
		System.out.println("");
	}

	private static void input(Scanner sc) {
		// TODO Auto-generated method stub
		CNT = sc.nextInt();
		for(int i=0; i<CNT; i++) {
			T = sc.nextInt(); // 전체 학생수
			R = sc.nextInt(); // 돌아온 학생수
			
			data = new int[T+2];
			// 돌아온 학생 표기
			for(int r=1; r<=R; r++)
				data[sc.nextInt()] = 1;

			output();
		}
		
	}

}
