

import java.util.*;


public class Main {
	// test....
	
	void solve() {
		int N=35;   // 35 min.
		int A=3;    // dig 1 person.
		int B=2;    // plant 1 person.
		
		int []x={4,6,5};  // needed time for 1 dig.. 
		int []y={3,2};  // needed time for 1 plant. 
			
		int dig_time = N / 2;
		int plant_time = N - dig_time;
		
		System.out.println("dig_time : "+ dig_time);
		System.out.println("plant_time : "+ plant_time);
		
		// int no_of_dig = dig_time / x[0];    // init. worst case
		// int no_of_plant = plant_time / y[0];  // init. worst case 
		int no_of_dig = 0;
		int no_of_plant = 0;
			
		for (int i=0; i < A; i++) {
			// summation of all members per each time
			 no_of_dig += dig_time / x[i];
		}
		//no_of_dig = dig_time / x[0] + dig_time / x[1]+ dig_time / x[2];
			
		
		for (int i=0; i < B; i++) {
			// summation of all members per each time
			 no_of_plant += plant_time / y[i];
		}
		//no_of_plant = plant_time / y[0] +plant_time / y[1];	
			
		
		System.out.println("no_of_dig : "+ no_of_dig);
		System.out.println("no_of_plant : "+ no_of_plant);
		
		// no_of_dig >= no_of_plant
		// if no_of_plant > no_of_dig --> stop
		
		while (no_of_plant > no_of_dig) {
			dig_time++;
			System.out.println("-->dig_time : "+ dig_time);
			plant_time--;
			System.out.println("-->plant_time : "+ plant_time);
		
			//no_of_dig = dig_time / x[0];
			//no_of_plant = plant_time / y[0];
		
		    no_of_dig = dig_time / x[0] + dig_time / x[1]+ dig_time / x[2];
			no_of_plant = plant_time / y[0] +plant_time / y[1];
				
			System.out.println("-->no_of_dig : "+ no_of_dig);			
			System.out.println("-->no_of_plant : "+ no_of_plant);
			
		}
		
		
		
		
	}


	public static void main(String [] args) {
	
	
		Main m = new Main();
		
		
		m.solve();
		
	
	}




}