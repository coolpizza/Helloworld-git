
/*

1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하기
==> 1번 노드에서 가장 멀리 떨어진 노드는 4,5,6  (3개임)


*/

import java.util.*;

class Main {
		static class Node {
			int n;
			int dist = 0;
			boolean visit = false;
			List<Node> links = new LinkedList<>();
			Node(int n) {
				this.n = n;
			}
		}

	public static void main(String[] args) {
	
	int [][]edge = {{3,6}, {4,3}, {3,2}, {1,3},{1,2},{2,4},{5,2}};
		
		System.out.println("edge.length : "+edge.length);
				
		List<Node> list = new ArrayList<>();
		for (int i=0; i < edge.length; i++) {
			list.add(new Node(i+1));
		}
		
		for (int []e : edge) {
			System.out.println("ee1 : "+e[0]);
			System.out.println("ee2 : "+e[1]);
			System.out.println("ee1-1 : "+ (e[0]-1));
			System.out.println("ee2-1 : "+ (e[1]-1));
			Node n1 = list.get(e[0]-1);
			Node n2 = list.get(e[1]-1);
			n1.links.add(n2);
			n2.links.add(n1);
			
		}
		int maxDist = 0;
		Queue<Node> queue = new LinkedList<>();
		Node first = list.get(0);   // 1번 노드 ->  '0'
		first.visit = true;
		queue.offer(first);
		
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			for (Node node : now.links) {
				if (node.visit) continue;
				node.visit = true;
				node.dist = now.dist + 1;
				queue.offer(node);
				maxDist = Math.max(maxDist, node.dist);
				
			}
			
		}
		int answer = 0;
		for (Node node : list) {
			if (node.dist == maxDist) answer++;
		}
		
		System.out.println("answer : "+answer);
	}
	
}