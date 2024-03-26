
/*


https://www.acmicpc.net/problem/2632
https://moonsbeen.tistory.com/308

7
5 3
2
2
1
7
2
6
8
3

-->

5

- 이제 A, B로 만들 수 있는 모든 피자조각의 경우의 수를 카운트 해 주었다.
- 우리가 원하는 값은 size만큼 만들 수 있는 피자 조각의 경우의 수이다.
- 그러므로 (0 ~ size) 만큼 탐색하여 
  A, B 조각의 경우의 수의 합이 size가 되는 경우 각각의 경우의 수 끼리 곱한 값을 누적하면 원하는 답을 구할 수 있다. 

*/

import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        //입력
        int size = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        int[] a_pizza = new int[a];
        int max_a = 0;
        for(int i = 0; i < a; i++) {
            a_pizza[i] = scan.nextInt();
            max_a += a_pizza[i];
        }
 
        int[] b_pizza = new int[b];
        int max_b = 0;
        for(int i = 0; i < b; i++) {
            b_pizza[i] = scan.nextInt();
            max_b += b_pizza[i];
        }
        //입력 끝!
 
        int[] a_count = new int[Math.max(max_a, size) + 1];
        a_count[0] = 1;
        a_count[max_a] = 1;
        count(a_pizza, a_count, size);
 
        int[] b_count = new int[Math.max(max_b, size) + 1];
        b_count[0] = 1;
        b_count[max_b] = 1;
        count(b_pizza, b_count, size);
 
        int result = 0;
        for(int i = 0; i <= size; i++) {
            result += (a_count[i] * b_count[size - i]);
        }
        System.out.println(result);
    }
 
    public static void count(int[] pizza, int[] count, int size) {
        for(int i = 0; i < pizza.length; i++) { //시작하는 피자의 인덱스
            int sum = 0;
            for(int j = 1; j < pizza.length; j++) { //선택하는 피자 조각의 개수
                int sum_j = pizza[(i + j) % pizza.length];
                if(sum + sum_j > size) break;
                sum += sum_j;
                count[sum]++;
            }
        }
    }
}
