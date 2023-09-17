
import java.util.*;


class Main {

	static class Paper {
		boolean isMine;
		int priority;
		Paper(int p, boolean m) {
			priority = p;
			isMine = m;		
		}
	}


	static int solution(int [] priorities, int location) {
		//List<Paper> queue = new LinkedList<>();
		Queue<Paper> queue = new LinkedList<>();
		
		for (int i=0 ; i < priorities.length ; i++) {
			queue.offer(new Paper(priorities[i], i == location));
		}
		int answer = 0;
		while (!queue.isEmpty()) {
			//Paper now = queue.remove(0);
			Paper now = queue.poll();
			boolean printable = true;
			for (Paper p : queue) {
				if (now.priority < p.priority) {
					printable = false;
					break;
				}
			}
			if (!printable) {
				queue.offer(now);
				continue;
			}
			answer++;
			if (now.isMine) return answer;
		}
		return answer;
			
	}
		


	public static void main(String[] args) {
				 
		int ans = -1;
		int []pri = {1, 1, 9, 1, 1, 1};  // location : 0
		int loc = 0;  // 5 
		//int []pri = {2,1,3,2};           // location 2
		//int loc = 2;    // 1
		ans = solution(pri, loc);
		System.out.println("answer : "+ans);
	}
}