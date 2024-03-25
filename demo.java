/*

ID[i] -> 1 1 2 3 1 2 3 1

count[1] = 4
count[2] = 2 
count[3] = 2

seq[1]=1
seq[2]=2
seq[3]=3

demo test
 1
 1
 2
 3
 1
 2
 3
 1
count[1]=4
# j: 1
# j: 2
# j: 3
# j: 4
count[2]=2
# j: 5
# j: 6
count[3]=2
# j: 7
# j: 8
count : 4, j:8


*/

public class demo {

	static int ID[] = {1,1,2,3,1,2,3,1};
	static int seq[] = {0,1,2,3};
	
	public static void main(String[] args){
	    int count[] = new int[5];
		System.out.println("demo test");
	    int j=0;
		int cnt=0;
		
	    for (int i : ID) {
			System.out.println(" "+i);
			count[i]++;
		}
		for (int i=1; i <= 3;i++) {
			System.out.printf("count[%d]=%d \n",i,count[i]);
		
			for (int k=0; k <count[seq[i]]; k++) {
				if (ID[j++] != seq[i]) cnt++;
				System.out.printf("# j: %d \n", j);
			}			
		}
		System.out.printf("count : %d, j:%d\n", cnt,j);
	}
}