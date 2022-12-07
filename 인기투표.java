/*

5
messi ronaldo messy suarez ronaldu
6
messy 3
suarez 3
ronaldo 1
messi 1
ronaldoo 10
messi 1

-->

messy 3
suarez 3
messi 2



*/

import java.util.Scanner;
import java.util.*;

public class Main {

	int N;//후보자수
	String str[];//후보자 이름
	int M;//투표참가인원
	String name[];//투표용지에 써있는 이름
	int score[];//점수

		
	static class ranking implements Comparable<ranking> {
				
		String name_r;
		int score_r;
		
		public ranking(String name_r, int score_r) {
			this.name_r = name_r;
			this.score_r = score_r;
		}
		
		
		@Override
		public int compareTo(ranking other) {			
			if (this.score_r < other.score_r) {
				return 1;
			} 
			return -1;
			
		}
		
		
	}
	
	
	
	void InputData(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();sc.nextLine();
		str = sc.nextLine().split(" ");
		M = sc.nextInt();
		name = new String[M]; score = new int[M];
		for (int i = 0; i < M; i++){
			name[i] = sc.next(); score[i] = sc.nextInt();
		}
		
		//System.out.printf("\n");
		//for (String i : str) {
		//	System.out.printf("%s\n",i);
		//}
		
	}
	
	void solve() {
		
		ranking [] rk;
		rk = new ranking[M];		
		ArrayList <String> st = new ArrayList<>();
		HashMap <String, Integer> hm = new HashMap<>();
		ranking [] rk_result;
		rk_result = new ranking[M];
		
		for (int i = 0; i < M; i++){
			rk[i] = new ranking(name[i],score[i]); 
		}
		Arrays.sort(rk);  // 결과적으로 현재 단계에서는 의미가 없다.
		
		for (int i=0; i<M; i++) {
			System.out.printf("name:%s score:%d \n", rk[i].name_r, rk[i].score_r);			
		}
		
		for (String ss : str) {
			st.add(ss);
		}
		System.out.println("registerd name:"+st);
		
			//AL.add(new ranking(name[i], score[i]));
		
		for (int i=0; i<M; i++) {
			//String name_l;
			
			if (st.contains(rk[i].name_r)) {
				System.out.printf("filtered name:%s score:%d \n", rk[i].name_r, rk[i].score_r);
				
				if (!hm.containsKey(rk[i].name_r)) {
					hm.put(rk[i].name_r, rk[i].score_r);
				} else {
					hm.put(rk[i].name_r, hm.get(rk[i].name_r)+rk[i].score_r);
					
				}
				
			}			
		}
			
		int k=0;		
		for(String key : hm.keySet()) {
			 System.out.printf("Hashed name: %s %d\n", key, hm.get(key));
			 rk_result[k++] = new ranking(key, hm.get(key));
			 			 
		}
		Arrays.sort(rk_result,0,k);
		
		for (int i=0; i <3; i++) {
			System.out.printf("name: %s score %d\n", rk_result[i].name_r, rk_result[i].score_r);			
		}
		
		
		
	}
	
	

	public static void main(String[] args){
		Main m = new Main();

		m.InputData();				//	입력 함수

		//	코드를 작성하세요
		m.solve();
	}
}