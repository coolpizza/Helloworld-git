
/*
4
-15 5
-10 36
10 73
27 44

-->

2



*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;

	static class Temp implements Comparable<Temp>{
		int low,high;

		public Temp(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Temp o) {
			return this.high-o.high;
		}
		
	
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		Temp[] t=new Temp[n];
		for (int i = 0; i < n; i++) {
			t[i]=new Temp(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(t);
		int cnt=1;

		int max=t[0].high;
		for (int i = 1; i < t.length; i++) {
			if(t[i].low>max) {
				//max=t[i].low;
				max=t[i].high;
				cnt+=1;
			}
		}
		System.out.println(cnt);
		
		
	}
}