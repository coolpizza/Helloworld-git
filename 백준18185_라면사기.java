
/*

https://www.acmicpc.net/problem/18185
https://gudwnsrns1234.tistory.com/9
https://velog.io/@7h13200/Python%EB%B0%B1%EC%A4%80-18185%EB%B2%88-%EB%9D%BC%EB%A9%B4-%EC%82%AC%EA%B8%B0-Small
https://hsdevelopment.tistory.com/540

3
1 0 1
-->
6

3
1 2 1
--> 10

3
1 1 1
-->7


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
        int[] factories = new int[N+2];

        for (int i = 0; i < N; i++) {
            factories[i] = sc.nextInt();
        }

        int totalCost = 0;

		for (int i = 0; i < N; i++) {
			if (factories[i + 1] > factories[i + 2]) {
				int two = Math.min(factories[i], factories[i + 1] - factories[i + 2]);
				System.out.printf("--i:%d, two:%d, fac(%d):%d,fac(%d):%d,fac(%d):%d \n", 
				                 i,two,i,factories[i],i+1,factories[i+1],i+2,factories[i+2]);
				
				totalCost += 5 * two;
				factories[i] -= two;
				factories[i + 1] -= two;
	 
				int three = Math.min(factories[i], Math.min(factories[i + 1], factories[i + 2]));
				totalCost += 7 * three;
				
				System.out.printf("--i:%d, three:%d, fac(%d):%d,fac(%d):%d,fac(%d):%d \n", 
				                 i,three,i,factories[i],i+1,factories[i+1],i+2,factories[i+2]);
				factories[i] -= three;
				factories[i + 1] -= three;
				factories[i + 2] -= three;
			}
			else {
				int three = Math.min(factories[i], Math.min(factories[i + 1], factories[i + 2]));
				
				System.out.printf("++ i:%d, three:%d, fac(%d):%d,fac(%d):%d,fac(%d):%d \n", 
				                 i,three,i,factories[i],i+1,factories[i+1],i+2,factories[i+2]);
				
				
				totalCost += 7 * three;
				factories[i] -= three;
				factories[i + 1] -= three;
				factories[i + 2] -= three;
	 
				int two = Math.min(factories[i], factories[i + 1]);
				System.out.printf("++ i:%d, two:%d, fac(%d):%d,fac(%d):%d \n", 
				                 i,two,i,factories[i],i+1,factories[i+1]);
				
				
				totalCost += 5 * two;
				factories[i] -= two;
				factories[i + 1] -= two;
			}    
			totalCost += 3 * factories[i]; 
			System.out.printf("--------------------------------\n");
		}		
		System.out.println(totalCost);
	}
}