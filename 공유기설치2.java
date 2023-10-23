
/*

https://katfun.tistory.com/entry/%EB%B0%B1%EC%A4%80-2110%EB%B2%88-%EA%B3%B5%EC%9C%A0%EA%B8%B0-%EC%84%A4%EC%B9%98
https://st-lab.tistory.com/277
https://leunco.tistory.com/79


5 3
1
2
8
4
9

--> 3


*/

import java.util.*;

public class Main {


	static ArrayList<Integer> arr = new ArrayList<>();

	// distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
	static int canInstall(int distance) {	
			
		// 첫 번째 집은 무조건 설치한다고 가정
		int count = 1;
		int lastLocate = arr.get(0);
			
		for(int i = 1; i < arr.size(); i++) {
			int locate = arr.get(i);
			
			/*
			 *  현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
			 *  최소 거리(distance)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
			 *  마지막 설치 위치를 갱신해준다. 
			 */
			if(locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		System.out.printf("installable count:%d\n", count);
		return count;
			
	}


    public static void main(String[] args) {
        //  집의 개수(N)와 공유기의 개수(C)를 입력받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        // 전체 집의 좌표 정보를 입력받기
        //ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // 이진 탐색을 위해 정렬 수행
        Collections.sort(arr);

        int start = 1; // 가능한 최소 거리(min gap)
        int end = arr.get(n - 1) - arr.get(0); // 가능한 최대 거리(max gap)
        int result = 0;

		System.out.printf("start:%d, end:%d\n", start, end);

        while (start <= end) {
			
			/*
            // mid는 가장 인접한 두 공유기 사이의 거리(gap)을 의미
            int mid = (start + end) / 2;
            // 첫째 집에는 무조건 공유기를 설치한다고 가정
            int value = arr.get(0);
            int cnt = 1;
			
			
            // 현재의 mid 값을 이용해 공유기를 설치하기
            for (int i = 1; i < n; i++) { // 앞에서부터 차근차근 설치
                if (arr.get(i) >= value + mid) {
                    value = arr.get(i);
                    cnt += 1;
                }
            }
            // C개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기
            if (cnt >= c) {
                start = mid + 1;
                result = mid; // 최적의 결과를 저장
            }
            // C개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소시키기
            else {
                end = mid - 1;
            }
			*/
		
			int mid = (end + start) / 2;
			System.out.printf("mid : %d\n", mid);
				
			/*
			 * mid 거리에 대해 설치 가능한 공유기 개수가 M 개수에 못미치면
			 * 거리를 좁혀야 하기 때문에 hi 를 줄인다.
			 */
			if(canInstall(mid) <= c) {
				end = mid;
				System.out.printf("change end:%d\n", end);
			}
			else {
				/**
				 * 설치 가능한 공유기 개수가 M 개수보다 크거나 같으면
				 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를
				 * 찾아낸다.
				 */
				start = mid + 1;
				System.out.printf("change start:%d\n", start);
			}
				
				
				
		}
        System.out.println(end-1);
    }
}


