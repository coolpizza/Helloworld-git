
/*

https://www.acmicpc.net/problem/18185
https://gudwnsrns1234.tistory.com/9
https://velog.io/@7h13200/Python%EB%B0%B1%EC%A4%80-18185%EB%B2%88-%EB%9D%BC%EB%A9%B4-%EC%82%AC%EA%B8%B0-Small
https://hsdevelopment.tistory.com/540

3
1 0 1
-->
6


5
1 1 1 0 2
-->
13


*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] factories = new int[N];

        for (int i = 0; i < N; i++) {
            factories[i] = sc.nextInt();
        }

        int totalCost = 0;

        for (int i = 0; i < N; i++) {
            if (i >= 2 && factories[i - 2] > factories[i - 1]) {
                // Buy 3 noodles individually
                totalCost += factories[i];
            } else if (i >= 1 && factories[i - 1] > factories[i]) {
                // Buy 2 noodles (i and i-1) together
                totalCost += factories[i];
                totalCost += factories[i - 1];
                i++; // Skip the next factory
            } else {
                // Buy 1 noodle individually
                totalCost += factories[i];
            }
        }

        System.out.println(totalCost);
    }
}
