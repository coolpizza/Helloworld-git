/*

7 1 4

-->

4 1 6 5 7 3 2 
*/

import java.util.*;
import java.util.Scanner;

public class Main {
	int N; //직원 수
	int S; //시작 직원 번호
	int M; //건너 뛰기 
		
	
	void solve(){
		
		int qq;
		Queue <Integer> q = new LinkedList <Integer>(); 		
		for (int i =1; i <= N; i++) {
           q.add(i);     
        }

        for (int i =1; i < S; i++) {
           qq = q.poll();
           q.add(qq);
        }
		while (N>0) {
			for (int i =1; i <= M; i++) {
			   qq = q.poll();
			   if (i !=M) q.add(qq);
			   else {
				   System.out.printf("%d \n", qq);
				   N--;
			   }
			}         
		}
		
	}

	void InputData(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); S = sc.nextInt(); M = sc.nextInt();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.InputData();//입력 함수
		
		//	코드를 작성하세요
		m.solve();

	}
}