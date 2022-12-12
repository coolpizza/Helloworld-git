/*

http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=300&sca=2080
https://noneid52.tistory.com/76

<입력파일>
입력 파일의 첫째 줄에는 정수 N(3≤N≤100)이 주어지는데 1부터 N-1까지는 기본 부품이나 중간 부품의 번호를 나타내고 N은 완제품의 번호를 나타낸다.
그리고 그 다음 줄에는 정수 M(3≤M≤100)이 주어지고 그 다음 M개의 줄에는 어떤 부품을 완성하는데 필요한 부품들 간의 관계가 3개의 정수 X Y K로 주어진다. 
이 뜻은 "중간 부품이나 완제품 X를 만드는데 필요한 중간 부품 혹은 기본 부품 Y가 K개 필요하다"는 뜻이다.

7
8
5 1 2
5 2 2
7 5 2
6 5 2
6 3 3
6 4 4
7 6 3
7 4 5

<출력파일>
하나의 완제품을 조립하는데 필요한 기본 부품의 수를 한 줄에 하나씩 출력하되(중간 부품은 출력하지 않음) 반드시 기본 부품의 번호가 작은 것부터 큰 순서가 되도록 한다.
각 줄에는 기본 부품의 번호와 소요 개수를 출력한다.

1 16
2 16
3 9
4 17

*/

import java.util.*;
 
public class Main {
 
    static int n, m;
    static int arr[][] = new int [101][6];
    static int[] res = new int [101];
     
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
         
        int i, j;
         
        n = scan.nextInt();
        m = scan.nextInt();
         
        for (i = 0; i < m; i++) {
            for (j = 0; j < 3; j++) {
                arr[i][j] = scan.nextInt();
                 
            }
        }
         
        f(n,1);
         
        for (i = 1; i < n; i++) {
            if (res[i] != 0) {              
                System.out.println(i + " " + res[i]);   
            }
        }
         
    }
     
    private static void f(int n,int cnt) {
        int flag = 0;
        int i;
         
        for (i = 0; i < m; i++) {
            if (arr[i][0] == n) {
                flag = 1;
                f(arr[i][1], cnt * arr[i][2]);
            }
             
                 
        }
        if (flag == 0) {
                res[n] += cnt;
        }
    }
 
}