
/*
https://www.acmicpc.net/problem/12865

https://code-lab1.tistory.com/74
https://st-lab.tistory.com/141
https://fbtmdwhd33.tistory.com/60

여행에 필요하다고 생각하는 N개의 물건이 있다. 
각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 
준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.



4 7
6 13
4 8
3 6
5 12

-->

14

*/

import java.util.*;



public class Baekjoon_12865 {
    static int N,K;
    static int dp[][], w[], v[];
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        dp = new int[N+1][K+1];
        w = new int[N+1];    // 무게 저장
        v = new int[N+1];    // 가치 저장
        
        for(int i=0; i<N; i++) {
            w[i]= sc.nextInt();
            v[i] = sc.nextInt();
        }
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                dp[i][j] = dp[i-1][j];     // 이전 행 결과 복사
                if(j - w[i]>=0) {    // 무게가 남으면
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]]+v[i]); // 더 큰 값으로 갱신
                }
            }
        }
        
        System.out.println(dp[N][K]);
 
    }
    
}