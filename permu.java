
/*
 
 순열구현
 https://velog.io/@cgw0519/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%88%9C%EC%97%B4-%EC%A4%91%EB%B3%B5%EC%88%9C%EC%97%B4-%EC%A1%B0%ED%95%A9-%EC%A4%91%EB%B3%B5%EC%A1%B0%ED%95%A9-%EC%B4%9D%EC%A0%95%EB%A6%AC
 
 */

import java.util.*;


public class Main {

    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r){
        if(depth == r){
            for(int num: out) System.out.print(num+" ");
            System.out.println();
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }

	public static void main(String[] args) {

		Main m = new Main();
		System.out.println("Test go \n");
		
		int[] arr = {1, 2, 3, 4, 5};
        //int r = 2;
        int r = 3;
		permutation(arr, new int[r], new boolean[arr.length], 0, r);
		
	}

	
}