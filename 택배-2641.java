
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 그리디, 2641 택배
 * 
 * @author whitebeard
 *
 http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1903&sca=3050
 https://eine.tistory.com/entry/KOI-2013-%EC%B4%88%EB%93%B1%EB%B6%80-%EB%AC%B8%EC%A0%9C-%ED%92%80%EC%9D%B4
 https://118k.tistory.com/337
 
 
 
 
4 40
6
3 4 20
1 2 10
1 3 20
1 4 30
2 3 10
2 4 20


-->
70 
 
 
 */
public class Problem2641 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();  // 마을수
		int c = in.nextInt();  // 트럭의 용량
		int m = in.nextInt();  // 보내는 박스 정보의 갯수

		int[][] array = new int[m][3];
		for (int i = 0; i < m; i++) {
			array[i][0] = in.nextInt();  // 출발
			array[i][1] = in.nextInt();  // 도착
			array[i][2] = in.nextInt();  // 박스 
		}
		in.close();

		// int n = 4;
		// int c = 40;
		// int m = 6;
		// int[][] array = { { 3, 4, 20 },
		// { 1, 2, 10 },
		// { 1, 3, 20 },
		// { 1, 4, 30 },
		// { 2, 3, 10 },
		// { 2, 4, 20 } };

		// int n = 6;
		// int c = 60;
		// int m = 5;
		// int[][] array = { { 1, 2, 30 },
		// { 2, 5, 70 },
		// { 5, 6, 60 },
		// { 3, 4, 40 },
		// { 1, 6, 40 } };

		// 배열을 도착지점 순서로 정렬하여 
		// 도착지점에 따라 용량을 제거해 준다. 
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[1] <= b[1]) ? -1 : 1;
			}
		});

		 System.out.println("---------------------");
		 for(int[] a : array)
		 System.out.printf("%d %d %2d\n", a[0], a[1], a[2]);

		// 거리별 용량을 담기 위한 배열 
		int[] capacity = new int[n + 1];
		Arrays.fill(capacity, c);

		int sum = 0;
		for (int i = 0; i < array.length; i++) {

			int dept = array[i][0];
			int arri = array[i][1];
			int box = array[i][2];

			sum += getBox(capacity, dept + 1, arri, box);
		}
		System.out.println("---------------------");
		System.out.println(sum);
	}

	public static int getBox(int[] capacity, int start, int end, int box) {

		int min = Integer.MAX_VALUE;
		
		System.out.printf("\nstart:%d, end:%d, box:%d \n", start, end, box);
		for (int i = start; i <= end; i++) {
			if (capacity[i] < min) {
				min = capacity[i];
			}
		}

		int result = 0;
		if (min > box) {
			result = box;
		} else {
			result = min;
		}

		for (int i = start; i <= end; i++) {
			capacity[i] -= result;
			System.out.printf("capacity[%d] : %d\n", i, capacity[i]);
			System.out.println("--------");
		}

		System.out.println("Delieved Box : "+result);
		
		return result;
	}
}