 
 
 import java.util.*;
 
 
 
 class Main {
 
 
	static boolean solution(String[] words) {
		Set<String> set = new HashSet<>();
		set.add(words[0]);
		char last = words[0].charAt(words[0].length()-1);
		
		for (int i=1 ; i < words.length; i++) {
			String w = words[i];
			char first = w.charAt(0);
			if (last != first) return false;
			if (!set.add(words[i])) return false;
			last = w.charAt(w.length()-1);
			
		}
		
		return true;    // set.size() == words.length
		
	}
 
 
	public static void main(String[] args) {
		
		
		boolean answer;
		String []words = {
		"tank","kick","know","wheal","laud","dream","mother","robust","tank" };
		//String []words = {
		//   "tank","kick","know","wheel","laud","dream"};
			
		System.out.println("words.length : "+words.length);
		System.out.println("words[0].length() : "+words[0].length());
			
		answer = solution(words);
		
		System.out.println("answer : "+answer);
	}
		
		
}
	
 