
/*

https://www.acmicpc.net/problem/1508

https://velog.io/@pppp0722/%EB%B0%B1%EC%A4%80-%EA%B3%A8%EB%93%9C1-1508-%EB%A0%88%EC%9D%B4%EC%8A%A4-Java
https://rccode.tistory.com/254
https://velog.io/@chang626/1508-%EB%A0%88%EC%9D%B4%EC%8A%A4


세준이는 세준항공으로 돈을 무지막지하게 번 뒤, 레이스 대회를 개최했다. 레이스 트랙은 길이가 N인 직선이다.
세준이는 심판 M명을 적절한 곳에 배치시키려고 한다. 심판은 아무 곳에나 배치시킬 수 있지 않다. 심판은 미리 정해진 K개의 곳에만 위치할 수 있다.
세준이는 심판을 배치할 때, 가장 가까운 두 심판의 거리를 최대로 하려고 한다.

심판을 어디에 배치시켜야 할지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N, M, K가 주어진다. N은 1,000,000보다 작거나 같은 자연수이고, M은 K보다 작거나 같다. 
또, K는 2보다 크거나 같고, 50보다 작거나 같다. 둘째 줄에 심판이 있을 수 있는 K개의 위치가 주어진다. K개의 위치는 N보다 작거나 같은 자연수 또는 0이며, 오름차순으로 주어진다.

출력
첫째 줄에 심판을 어떻게 배치시켜야 가장 가까운 심판의 거리가 최대가 될 것이지 출력한다. 
출력할 때는 예제와 같이 심판을 세울 곳에는 1을, 세우지 않을 곳에는 0을 출력한다. 
만약 정답이 여러개일 경우에는 사전순으로 가장 늦는 것을 출력한다.

11 3 4
0 5 10 11
-->
1110

11 4 4
0 5 10 11
->
1111

1000 5 10
6 9 33 59 100 341 431 444 565 857
-->
1000010111


*/

import java.util.*;
import java.io.*;


public class Main {

    private static int n;
    private static int m;
    private static int k;
    private static int[] arr;

    public static void main(String[] args)  {
        init();
        System.out.println(binarySearch());
    }

    private static void init()  {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		arr = new int[k];
        
		for (int i = 0; i < k; i++) {        
			arr[i] = sc.nextInt();
        }
    }

    private static String binarySearch() {
        String answer = "";
        int l = 1;
        int r = n;
        while (l <= r) {
            int m = (l + r) / 2;
            String referees = setReferee(m);
            if ("-1".equals(referees)) {
                r = m - 1;
            } else {
                l = m + 1;
                answer = referees;
            }
        }
        return answer;
    }

    private static String setReferee(int dist) {
        StringBuilder sb = new StringBuilder();
        int ct = 1;
        sb.append("1");
        int lastIdx = arr[0];
        for (int i = 1; i < k; i++) {
            int curIdx = arr[i];
            if (curIdx - lastIdx < dist) {
                sb.append("0");
            } else {
                sb.append("1");
                lastIdx = curIdx;
                ct++;
            }
            if (ct == m) {
                sb.append("0".repeat(k - i - 1));
                break;
            }
        }
        return ct == m ? sb.toString() : "-1";
    }
}