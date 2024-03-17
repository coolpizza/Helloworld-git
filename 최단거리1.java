

/*






*/
public class ShortDistance {
    
	static int sum = 0;
	static int max = 0;
	
	static int [][]cost = new int[6][6];
	
	public static void main(String[] args) {

		cost[1][2]=1;
		cost[2][1]=1;
		cost[1][3]=3;
		cost[3][1]=3;
		cost[2][3]=1;
		cost[3][2]=1;
		cost[2][4]=2;
		cost[4][2]=2;
		cost[3][4]=4;
		cost[4][3]=4;
		cost[4][5]=6;
		cost[5][4]=5;
		cost[3][5]=5;
		cost[5][3]=5;
		
		for (int i=0; i<6 ; i++) {
			for (int j=0; j<6; j++) {
				System.out.printf("cost[%d][%d]=%d \n", i, j, cost[i][j]);
			}
		}
		
	}
	
	
}