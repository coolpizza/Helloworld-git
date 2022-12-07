
/*

7
15 11 4 8 5 2 4

--> 2   // 열외시켜야 하는 병사의 수

* LIS (Longest Increasing Subequence) 문제

https://www.techiedelight.com/longest-increasing-subsequence-using-dynamic-programming/
https://www.youtube.com/watch?v=Ns4LCeeOFS4
https://leetcode.com/problems/longest-increasing-subsequence/


*/

import java.util.*;

public class Main {
	
    static int n;
    static ArrayList<Integer> v = new ArrayList<Integer>();
    static int[] dp = new int[2000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            v.add(sc.nextInt());
        }

		// 정렬전 ArrayList 내용보기
		System.out.println("ArrayList Before reverse----");
		System.out.println(v);


        // 순서를 뒤집어 '최장 증가 부분 수열' 문제로 변환
        Collections.reverse(v);


		// 정렬후 ArrayList 내용보기
		System.out.println("ArrayList After reverse----");
		System.out.println(v);

        // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (v.get(j) < v.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
					System.out.printf("DP[%d]: %d \n",i, dp[i]);
                }
            }
        }

		//for (int i=0 ; i < n ; i++) {
		//	System.out.println("DP : "+dp[i]);
			
			
		//}

        // 열외해야 하는 병사의 최소 수를 출력
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(n - maxValue);
    }
}