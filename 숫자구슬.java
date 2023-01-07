
/*

숫자구슬:정올 4791
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=4300&sca=30

https://oein.tistory.com/112
https://ghdic.github.io/ps/boj-2613/


*/

import java.util.*;

public class Main {

	static int N, M;
	static int[] marbleNum;

	static boolean check_(int mid) {
		int cnt = 1;
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if (sum + marbleNum[i] <= mid) {
				sum += marbleNum[i];
			}
			else {
				if (marbleNum[i] <= mid)
					sum = marbleNum[i];
				else return false;
				cnt++;
			}
		}
		return cnt <= M; // 그룹 수가 적으면 false 넘으면 true
	}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 N, M을 입력받기
        N = sc.nextInt();
        M = sc.nextInt();
         
        marbleNum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            marbleNum[i] = sc.nextInt();
        }

		int low = 1;
		int high = 30000;

		while (low < high)
		{
			int mid = (low + high) / 2; // 각 그룹의 합 중 최댓값이 최소가 되도록 M개의 그룹으로 나누었을 때 그 최댓값
			if (check_(mid)) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}

		System.out.println("high : "+high);
	}
	
	
	
}