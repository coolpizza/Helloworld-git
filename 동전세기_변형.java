
import java.util.*;

/*
3원, 5원, 7원을 가지고 있는데 19원을 만들기 위한 최소의 동전 갯수를 구하는 코드를 자바로 작성.
-->
본 코드는 동적 프로그래밍(Dynamic Programming)을 이용하여 최소 동전 갯수를 구하는 코드입니다. 
coinChange 메소드에서는 dp 배열을 초기화하고, coins 배열을 순회하면서 각 금액에 대해 최소 동전 갯수를 구합니다. 
예를 들어, coins 배열이 {3, 5, 7}이고, amount가 19일 때, dp 배열은 다음과 같이 초기화됩니다.

dp[0]= 0
dp[1]= 20
dp[2]= 20
dp[3]= 1
dp[4]= 20
dp[5]= 1
dp[6]= 2
dp[7]= 1
dp[8]= 20
dp[9]= 3
dp[10]= 2
dp[11]= 3
dp[12]= 4
dp[13]= 3
dp[14]= 4
dp[15]= 3
dp[16]= 4
dp[17]= 5
dp[18]= 4
dp[19]= 5

dp[i]는 금액 i를 만들기 위해 필요한 최소 동전 갯수를 나타냅니다. 
예를 들어, dp[3]은 3원을 만들기 위해 필요한 최소 동전 갯수인 1을 나타냅니다. 
dp 배열을 구하는 방법은 다음과 같습니다.

dp[0]을 0으로 초기화합니다.
dp[1]부터 dp[amount]까지 순회합니다.
각 금액 i에 대해 coins 배열을 순회하면서, coins[j]가 i보다 작거나 같은 경우에만 최소 동전 갯수를 구합니다.
최소 동전 갯수는 dp[i - coins[j]]+ 1과 dp[i] 중 작은 값입니다.
dp[amount]가 amount보다 큰 경우, amount를 만들 수 없으므로 -1을 반환합니다. 그렇지 않으면 dp[amount]를 반환합니다.
위 코드에서는 Arrays.fill(dp, amount + 1)을 사용하여 dp 배열을 amount + 1로 초기화합니다. 
이는 dp[i]가 amount보다 큰 경우, amount를 만들 수 없다는 것을 나타냅니다. 

따라서 dp[amount]가 amount보다 큰 경우, amount를 만들 수 없으므로 -1을 반환합니다. 그렇지 않으면 dp[amount]를 반환합니다. 
위 코드의 시간 복잡도는 O(amount * coins.length)입니다.

*/

public class CoinChange {
    public static void main(String[]args) {
        int[]coins = {3, 5, 7};
        int amount = 19;
        int minCoins = coinChange(coins, amount);
        System.out.println("Minimum number of coins required: " + minCoins);
    }

    public static int coinChange(int[]coins, int amount) {
        int[]dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0]= 0;
		/*
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<= i) {
                    dp[i]= Math.min(dp[i], dp[i - coins[j]]+ 1);
                }
            }
        }
		*/
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i <= amount;i++) {
				if (i>=coins[j]) {
					dp[i]= Math.min(dp[i],dp[i-coins[j]]+1);
				}
			}
		}		
        return dp[amount]> amount ? -1 : dp[amount];
    }
}
