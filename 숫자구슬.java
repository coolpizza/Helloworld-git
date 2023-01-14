
/*

숫자구슬:정올 4791
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=4300&sca=30

https://oein.tistory.com/112
https://ghdic.github.io/ps/boj-2613/


8 3
5 4 2 6 9 3 8 7
-->
17
4 2 2


*/

import java.util.*;

public class Main {

	static int N, M;
	static int[] marbleNum;

/*
	여러개 그룹으로 나누는 유형은 항상 이런식으로 짜이는듯.. 그룹의 합의 최댓값을 val로 할때 m개 안으로 나눌수있는지 구하는 함수

*/


	static boolean maxMarbleSum(int val) {
		int cnt = 1;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (sum + marbleNum[i] <= val) {
				sum += marbleNum[i];
			}
			else {
				if (marbleNum[i] <= val)
					sum = marbleNum[i];
				else return false;
				cnt++;
			}
		}
		return cnt <= M; // 그룹 수가 적으면 false 넘으면 true
	}


/*
	static boolean maxMarbleSum(int val) {
		int cnt = 1, sum = 0;
		for (int i = 0; i < N; ++i) {
			if (marbleNum[i] > val)return false;
			if (sum + marbleNum[i] <= val) {
				 sum += marbleNum[i];
			}
			else {
				++cnt;
				sum = marbleNum[i];
			}
		}
		return cnt <= M;
	}
*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 N, M을 입력받기
        N = sc.nextInt();
        M = sc.nextInt();
         
        marbleNum = new int[N+1];
        for (int i = 0; i < N; i++) {
            marbleNum[i] = sc.nextInt();
        }

		int low = 1;
		int high = 30000;

		while (low < high)
		{
			int mid = (low + high) / 2; // 각 그룹의 합 중 최댓값이 최소가 되도록 M개의 그룹으로 나누었을 때 그 최댓값
			if (maxMarbleSum(mid)) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}

		System.out.println("high : "+high);

		int cnt = 0, sum = 0, group = 1;
		ArrayList <Integer> ans = new ArrayList<>();
		
		for (int i = 0; i < N; ++i) {
			sum += marbleNum[i];
			if (sum > high) {
				ans.add(cnt);
				sum = marbleNum[i];
				cnt = 0;
				++group;
			}
			++cnt;
		}
		ans.add(cnt);
		int pos = ans.size() - 1;
		int temp;
		
		while (group < M) {
			if (ans.get(pos) == 1) {
				--pos;
			}
			else {
			//	--ans[pos];
			temp = ans.get(pos);
			temp++;
			ans.add(pos,temp);
			
				ans.add(1);
				++group;
			}
		}
		for (int val : ans) {
			//cout << val << " ";
			System.out.printf("%d ",val);
		}

	}
	
}