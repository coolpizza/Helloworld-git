/*
  백준 13305 : 주유소
  https://www.acmicpc.net/problem/13305
  
4
2 3 1
5 2 4 1
--> 18


4
3 3 4
1 1 1 1
--> 10

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] distances = new long[N - 1];
        long[] prices = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        long minPrice = prices[0];
        long totalCost = 0;

        for (int i = 0; i < N - 1; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            totalCost += minPrice * distances[i];
        }

        System.out.println(totalCost);
    }
}
