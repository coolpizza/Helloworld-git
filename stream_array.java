
/*

https://lnsideout.tistory.com/entry/JAVA-%EC%9E%90%EB%B0%94-%EB%B0%B0%EC%97%B4-ArrayList-%EC%A4%91%EB%B3%B5%EC%A0%9C%EA%B1%B0-%EB%AA%A8%EB%93%A0%EB%B0%A9%EB%B2%95

*/

/*

  중복제거-int / string 변환 
  https://keichee.tistory.com/390
  https://velog.io/@sa833591/Java-Stream-3
  https://ryan-han.com/post/dev/java-stream/

*/

import java.util.*;

public class test {


    public static void main(String[] args) {
        
		/***
		int [] goodsList = {1,3,6,7,5,3,4};
        int [] output = new int[100];
		Set <Integer> map = new HashSet<>();

		for (int item : goodsList) {
			map.add(item);		
		}		

        System.out.println("map :"+map);
		
		output = map.stream().mapToInt(Integer::intValue).toArray();
		
		for (int item : output) {
			System.out.println("output :"+item);	
		}		
		*****/
        
		String[] goodsList = {"notebook", "TV", "monitor", "keyboard", "mouse", "TV", "monitor", "keyboard"};
        String[] output = new String[100];
		Set<String> map = new HashSet<>();

		for (String item : goodsList) {
			map.add(item);		
		}		

        System.out.println("map :"+map);
		
		//output = map.stream().mapToInt(Integer::intValue).toArray();
		// 동일한 컨셉으로 스트링 어레이를 만드는 방법
		
		output = map.toArray(new String[0]);
		
		
		for (String item : output) {
			System.out.println("output :"+item);	
		}	
        
    }

}