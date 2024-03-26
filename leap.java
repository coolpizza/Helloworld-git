/*
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2048&sca=50&sfl=wr_subject&stx=%EB%8F%84%EC%95%BD&sop=and
문제
개구리가 연못 위에서 놀고 있다. 개구리는 N개의 연잎 들을 이용해서 이리저리 뛰어놀고 있다.
개구리가 뛰는 장면을 보던 강빈이는 개구리가 도약을 하는 경우가 얼마나 있는지 궁금해졌다. 여기서 도약은 아래 조건을 만족하는 경우를 말한다.
1. 개구리가 뛴 거리가 이전에 뛴 거리 이상 뛰지만 그 2배보다 멀리 뛰지는 않는다.
2. 개구리는 오른쪽으로만 뛴다.
3. 개구리는 두 번만 뛴다.
4. 위 세 가지 조건을 만족한다면 어느 곳에서든 시작할 수 있다.
허나, 연잎들이 너무 많기 때문에 가능한 횟수가 매우 많아질 것 같다고 생각한 강빈이는, 개구리가 오른쪽으로 도약하는 경우가 얼마나 되는지 구해달라고 했다. 강빈이를 위해 프로그램을 짜주자.

입력형식
첫 번째 줄에는 연잎의 수 N(3 ≤ N ≤ 1,000)이 주어진다. 두 번째 줄부터 N개의 줄에는 각 연잎의 좌표가 주어진다. 모든 좌표는 0 이상 108 이하이다.

출력형식
개구리가 오른쪽으로 도약하는 경우의 수를 출력한다.

입력예
5
3
1
10
7
4

출력예
4

힌트
개구리가 오른쪽으로 도약하는 경우는 다음 4가지뿐이다. (1, 3, 7), (1, 4, 7), (4, 7, 10), (1, 4, 10)
 */

package Day2;

import java.util.Scanner;

public class Main_D2_2622_leap {

	private static int N;
	private static int[] data;
	
	private static void simpleSort() {
		for(int i=1; i<N; i++) {
			for(int j=i+1; j<=N; j++) {
				if(data[i] > data[j]) {
					int t = data[i];
					data[i] = data[j];
					data[j] = t;
				}
			}
		}
	}
	
	private static void simpleSort(int s, int c) {
		for(int i=s; i<s+c; i++) {
			for(int j=i+1; j<=N; j++) {
				if(data[i] > data[j]) {
					int t = data[i];
					data[i] = data[j];
					data[j] = t;
				}
			}
		}
	}

	private static void simpleSort(int s, int c, int[] sortingData) {
		// TODO Auto-generated method stub
		for(int i=s; i<s+c; i++) {
			for(int j=i+1; j<=N; j++) {
				if(sortingData[i] > sortingData[j]) {
					int t = sortingData[i];
					sortingData[i] = sortingData[j];
					sortingData[j] = t;
				}
			}
		}
	}

	private static void input(Scanner sc) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		data = new int[N+2];
		for(int i=1; i<=N; i++)
			data[i] = sc.nextInt();
	}
	
	private static int getSolutionUsingLoop() {
		int cnt = 0;
		int fDistance, sDistance;
		int dist, distMin, distMax;
		
		for(int i=1; i<=N-2; i++) {
			for(int j=i+1; j<=N-1; j++) {
				fDistance = data[j] - data[i];
				dist = data[j] - data[i];
				for(int k=j+1; k<=N; k++) {
					sDistance = data[k] - data[j];
					if(fDistance > sDistance ) continue; // 이전 보다 적게 뛰거나
					if(fDistance*2 < sDistance) break; // 2배 이상 뛴 경우
					System.out.println(cnt+1+ " : " + data[i] + "," + data[j] + "," + data[k]);
					cnt++;


//					distMin = data[j] + dist;
//					distMax = distMin + dist;
//					if(data[k] >= distMin && data[k] <= distMax) {
//						cnt++;
//						System.out.printf("%5d : (%3d, %3d, %3d)", cnt, data[i], data[j], data[k]);
//						System.out.println();
//					}
//					if(data[k] > distMax) break;
				}
			}
		}
		
		return cnt;
	}
	
	// 찾고자 하는 데이터 보다 크거나 같은 것중 작은 것 (e = m - 1)
	private static int binarySearchLower(int s, int e, int searchingData) {
		int m, sol = -1;
		
		while(s <= e) {
			m = (s+e) / 2;
			if(data[m] >= searchingData) {
				e = m -1;
				sol = m;
			}
			else s = m + 1;
		}
		
		return sol;
	}
	
	// 찾고자 하는 데이터 보다 작거나 같은 것증 가장 큰 것 (s = m + 1)
	private static int binarySearchUpper(int s, int e, int searchingData) {
		int m, sol = -1;
		
		while(s <= e) {
			m = (s+e) / 2;
			if(data[m] <= searchingData) {
				s = m + 1;
				sol = m;
			}
			else e = m - 1;
		}
		
		return sol;
	}
	
	private static int getSolutionUsingBS() {
		int cnt = 0;
		int dist, distL, distU; // Lower, Upper
		int pL, pU;
		
		for(int i=1; i<=N-2; i++) {
			for(int j=i+1; j<=N-1; j++) {
				dist = data[j] - data[i];
				distL = data[j] + dist;
				distU = distL + dist;
				pL = binarySearchLower(j+1, N, distL);
				if(pL == -1) continue;
				if(data[pL] > distU) break;
				pU = binarySearchUpper(j+1, N, distU);
				if(pU == -1) continue;
				System.out.println(data[i]+ "," + data[j] + "," + data[pL] + "-" + data[pU]);
				cnt += pU - pL + 1; // 배열의 Index를 개산하는 것이라 +1 해줘야 함
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input(sc);
		simpleSort();
//		simpleSort(1, N);
//		simpleSort(1, N, data);
		System.out.println(getSolutionUsingLoop());
		//System.out.println(getSolutionUsingBS());
		sc.close();
	}

}
