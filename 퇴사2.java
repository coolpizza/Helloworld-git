
/*

https://www.acmicpc.net/problem/14501

https://velog.io/@sj-lee33/%EB%B0%B1%EC%A4%80-14501%EB%B2%88-%ED%87%B4%EC%82%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-c-%ED%92%80%EC%9D%B4
https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-14501-%ED%87%B4%EC%82%AC-java

	1일	2일	3일	4일	5일	6일	7일
Ti	3	5	1	1	2	4	2
Pi	10	20	10	20	15	40	200

7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

-->

45



*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            int next = i + T[i];
            if (next > N + 1) { // 일할 수 있는 날짜를 넘어가는 경우
                dp[i] = dp[i + 1];
            } else {    // 돈을 더 많이 버는 경우를 계산
                dp[i] = Math.max(dp[i + 1], dp[next] + P[i]);
            }
        }
        bw.write(dp[1] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}