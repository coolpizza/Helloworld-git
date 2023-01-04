
/*

https://www.acmicpc.net/problem/1911  (흙길보수)

https://zzang9ha.tistory.com/174
https://kosaf04pyh.tistory.com/135

어젯밤 겨울 캠프 장소에서 월드 본원까지 이어지는, 흙으로 된 비밀길 위에 폭우가 내려서 N (1 <= N <= 10,000) 개의 물웅덩이가 생겼다. 
월드학원은 물웅덩이를 덮을 수 있는 길이 L (L은 양의 정수) 짜리 널빤지들을 충분히 가지고 있어서, 
이들로 다리를 만들어 물웅덩이들을 모두 덮으려고 한다. 
물웅덩이들의 위치와 크기에 대한 정보가 주어질 때, 모든 물웅덩이들을 덮기 위해 필요한 널빤지들의 최소 개수를 구하여라.

3 3
1 6
13 17
8 12

-->

5



*/

import java.util.*;

public class Main {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
				
		int N = sc.nextInt();	// 웅덩이 개수
		int L = sc.nextInt();	// 널빤지 길이
				
		int[][] arr = new int[N][2];	// 물 웅덩이 시작, 끝위치
		for(int i=0; i<N; i++) {
			
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		Arrays.sort(arr, new Comparator<int []>() {

			// 물웅덩이의 시작 위치를 기준으로 오름차순 -> 시작 위치가 동일하면 끝 위치를 기준으로 오름차순
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		int nulpan = 0;	// 필요한 널빤지의 개수
		int range = 0;	// 널빤지를 물웅덮이에 덮었을때, 덮을 수 있는 범위
		
		for(int i=0; i<N; i++) {
			if(arr[i][0] > range)
				range = arr[i][0];
			if(arr[i][1] >= range) {
				while(arr[i][1] > range) {
					range += L;
					nulpan ++;
				}
			}
		}

		System.out.println(nulpan);
	}

}