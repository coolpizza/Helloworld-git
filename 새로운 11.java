
import java.util.*;

// 5개에서 2개 고르는 조합.

class Main {


	static void dfs(int []arr, int []output, boolean []visit, int depth, int start, int r) {
		
		if (depth == r) {
			
			System.out.println(" 2:-----");  // 어쨌든 r개를 조합하는 횟수만큼 호출된다. 
			                                 // 그러므로 이 조합으로 다른 계산을 하려면 여기에서 원하는 함수를 호출하면 된다.
                                             // 예제) 치킨거리 											 
			for (int i=0; i < r; i++) {
				System.out.print(output[i]+ " ");
			}		
			System.out.println();
			return;
		}	
		System.out.println(" 3:-----");
		for (int i=start; i < arr.length; i++) {
			
			if (!visit[i]) {
				//System.out.println(" 4:-----");
				visit[i] = true;
				output[depth] = arr[i];
				dfs(arr, output, visit, depth+1, i+1,r);
				//System.out.println(" 5:-----");
				visit[i] = false;
			}
			
			
		}
		//System.out.println(" 6:-----");
		
		
	}

	public static void main(String[] args) {

		int r = 2;
		int []arr = {20,50,40,30};
		int []output = new int[r];
		
		boolean []visit = new boolean[arr.length];
		
		visit[0] = false;
		
		dfs(arr, output, visit, 0,0,r);
		System.out.println(" 1:-----");
		
	}
	
}