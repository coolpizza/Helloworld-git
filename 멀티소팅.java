

/*
	N차원 정렬.
     
    int[][] arr = {{1,5000},{2,3000},{3,7000},{4,1000}};
	
    arr[0][0]=1  arr[0][1]=5000
	arr[1][0]=2  arr[1][1]=3000
	arr[2][0]=3  arr[2][1]=7000
	arr[3][0]=4  arr[3][1]=1000

*/


import java.util.*;


public class Sort{

// N차원  배열 정렬
	public static void exComparator () {
    // 배열의 0번값을 기준으로 정렬 comparator
    Comparator<int[]> com1 = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] -o2[0]; // 반대로 바꾸면 큰값부터 내림차순 정렬
        }
    };
    // 배열의 1번값을 정렬하는 Comparator
    Comparator<int[]> com2 = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    };
    // 2차원배열에 물품번호, 가격이 담겨있다고 가정
    int[][] arr = {{1,5000},{2,3000},{3,7000},{4,1000}};
	
	for (int i=0; i < 4; i++) {
		for (int j=0; j < 2; j++) {
			System.out.printf(" arr[%d][%d]=%d ",i,j, arr[i][j]);
		}
		System.out.printf("\n");
	}			
	
    System.out.println("com1 sorting ---");
    Arrays.sort(arr, com1);
    for (int[] a : arr)
        System.out.println(a[0]+" "+a[1]);
    System.out.println("com2 sorting ---");
    Arrays.sort(arr, com2);
    for (int[] a : arr)
        System.out.println(a[0]+" "+a[1]);
	}


    public static void main(String[] args)  {
	 
		Sort m = new Sort();
		m.exComparator();
	 
	 
	}
}