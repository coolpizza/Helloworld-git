public class CombinationExample {
    
	static int sum = 0;
	static int max = 0;
	
	public static void main(String[] args) {
        int [] arr = {20,50,40,30};
        int r = 2; // 조합의 길이

        int[] output = new int[r]; // 조합을 담을 배열
        boolean[] visited = new boolean[arr.length];
		
        combinationDFS(arr, output, visited, 0, r, 0);
		System.out.printf("max : %d\n", max);
    }

    public static void combinationDFS(int[] arr, int[] output, boolean[] visited, int depth, int r, int start) {
        if (depth == r) { // r개의 원소를 모두 선택한 경우
            for (int i = 0; i < r; i++) {                  
				 System.out.print(output[i] + " ");
				 sum = sum + output[i];
            }
			System.out.printf("sum : %d\n", sum);
            System.out.println();
			if (sum > max) max = sum;
			sum = 0;
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                combinationDFS(arr, output, visited, depth + 1, r, i + 1);
                visited[i] = false;
            }
        }
    }
}