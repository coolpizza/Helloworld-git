

import java.util.*;

public class Main {

	static class Word {
	   String word;
	   int depth;
	   Word(String word, int depth) {
		   this.word = word;
		   this.depth = depth;		   
	   }
		
	}

    public static int solution(String begin, String target, String[] words) {

       if (!Arrays.asList(words).contains(target)) return 0;
	   
		Set<String>  used = new HashSet<>();
		Stack<Word> stack = new Stack<>();
	    //stack.add(new Word(begin, 0));
		stack.push(new Word(begin, 0));
	    while (!stack.isEmpty()) {
			Word now = stack.pop();
			if (now.word.equals(target)) {
				return now.depth;
			}
			for (String w : words) {
				if (!changable(now.word, w)) continue;
				if (used.contains(w)) continue;
				used.add(w);
				//stack.add(new Word(w, now.depth+1));
				stack.push(new Word(w, now.depth+1));

				
			}
			
		}
	   
	   
	   return 0;
	}
	
	static boolean changable(String w1, String w2) {
		int len = Math.min(w1.length(), w2.length());
		int count = 0;
		for (int i=0; i < len && count < 2; i++) {
		   if (w1.charAt(i) != w2.charAt(i)) count++;
		}
		return count == 1;
	}


    public static void main(String[] args) {
	
		int answer;
		String []words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String target = "cog";
	
	    System.out.println("Arrays as list : "+ Arrays.asList(words).contains(target));
		answer = solution("hit", target, words);
		
	    System.out.println("answer : "+answer);
	
	
	
	
	}
}