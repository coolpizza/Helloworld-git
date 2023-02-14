
/*
 
 조합구현
 https://velog.io/@cgw0519/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%88%9C%EC%97%B4-%EC%A4%91%EB%B3%B5%EC%88%9C%EC%97%B4-%EC%A1%B0%ED%95%A9-%EC%A4%91%EB%B3%B5%EC%A1%B0%ED%95%A9-%EC%B4%9D%EC%A0%95%EB%A6%AC
 
 */

import java.util.*;


public class Main {

    public static void combination(int[] arr, boolean[] visited, int start, int depth, int r){
        if(depth == r){
            for(int i=0; i<arr.length; i++){
                if(visited[i]) System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(arr, visited, i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }

	public static void main(String[] args) {

		Main m = new Main();
		System.out.println("Test go \n");
		
		int[] arr = {1, 2, 3, 4 ,5};
        int r = 3;
        
		combination(arr, new boolean[arr.length], 0, 0, r);
		
	}

	
}