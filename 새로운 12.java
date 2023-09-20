
/*
5
8 1
7 2
8 3
10 4
9 4

-->

35


*/

import java.util.*;

public class Main {
	//int N;//손님 수
	//int P[] = new int[10000 + 10];//음식 값
	//int T[] = new int[10000 + 10];//예약 희망 시간
	static int rev[] = new int[10000 + 10];//예약 확정, rev[시간] = 가격
	
	static int N = 5;
	static int P[] = {8,7,8,10,9};
	static int T[] = {1,2,3,4,4};
	
	//static int N = 4;
	//static int P[] = {10,7,8,2};
	//static int T[] = {3,5,1,1};
		
	public static void main(String[] args){	
		
		int sum=0;
		int price = 0;
		
		for (int i=0; i < N; i++) {
			price = P[i];
			System.out.printf("i=%d, price=%d \n",i, price);
			for (int j=T[i]; j>0; j--) {
				
				if (rev[j]==0) {
					rev[j] = price;
					System.out.printf("reserve at rev[%d]=%d\n",j, price);
					break;
					
				} else {
					if (rev[j]<price) {
                         int temp=rev[j];
						 rev[j] = price;
						 price = temp;
						 System.out.printf("reserve swap : rev[%d]=%d\n", j, rev[j]);
					}
				}	
			
		    }
			
		}
		for (int i=0; i < 10000; i++) {
			sum +=rev[i];
		}
		
		System.out.println("sum : "+sum);
	}
}