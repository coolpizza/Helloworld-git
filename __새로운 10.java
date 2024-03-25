
import java.util.*;



class Main {

	static int[] solution(int [] progress, int []speeds) {
		
		// [93, 30, 55],   [1, 30, 5]
		// [95,90,99,99,80,99],  [1,1,1,1,1,1]
		Queue <Integer> queue = new LinkedList<>();
		/*
		for (int i=0 ; i < progress.length; i++) {
			float p = progress[i];
			float s = speeds[i];
			int days = (int)Math.ceil((100-p)/s);
			queue.offer(days);
		}
		*/
		queue.offer(6);
		queue.offer(7);
		queue.offer(11);
		queue.offer(6);
		queue.offer(9);
		
		// [7, 3, 9]		
		Queue <Integer> answer = new LinkedList<>();
		int d = queue.poll();
		int count = 1;
		while(!queue.isEmpty()) {
			int n = queue.poll();
			if (d >=n ) {
				count++;
				continue;
			}
			answer.offer(count);
			count = 1;
			d=n; 
		}
		answer.offer(count);
		
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}



	public static void main(String[] args) {
		//int []prog = {93, 30, 55};   
		//int []speed = {1, 30, 5};
		
		int []prog = {95,90,99,99,80,99};   
		int []speed = {1,1,1,1,1,1};
		
		// [93, 30, 55],   [1, 30, 5]
		// [95,90,99,99,80,99],  [1,1,1,1,1,1]
	    int []result = new int[prog.length];
		
		result = solution(prog, speed);
	      
		for (int re : result) {
			System.out.println(re);
		}
	
	}
	
	
}