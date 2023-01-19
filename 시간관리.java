
/*

https://www.acmicpc.net/problem/1263
https://developer-ellen.tistory.com/88

진영이는 캠프 조교를 온 후 효율적으로 시간 관리를 해야 한다는 것을 깨달았다. 
진영이는 하루에 해야 할 일이 총 N개가 있고 이 일들을 편하게 1번부터 N번까지 차례대로 번호를 붙였다.

진영이는 시간을 효율적으로 관리하기 위해, 할 일들에 대해 끝내야할 시간과 걸리는 시간을 적은 명단을 만들었다. 
즉, 이 명단은 i번째 일은 일을 처리하는데 정확히 Ti 시간이 걸리고 Si 시 내에 이 일을 처리하여야 한다는 것을 담고 있다. 진영이는 0시부터 활동을 시작할 수 있고, 두 개 이상의 일을 같은 시간에 처리할 수 없다.

진영이가 바라는 점은 최대한 늦잠을 자는 것이다. 
문제는 이러한 진영이를 도와 일들은 모두 마감시간 내에 처리할 수 있는 범위 내에서 최대한 늦게 일을 시작할 수 있는 시간이 몇 시인지 알아내는 것이다.

4
3 5
8 14
5 20
1 16
-->
2

입력
첫째 줄에 일의 수 N이 입력되고 다음 N개의 줄에 대해 i+1번째 줄에는 i번째 일에 대한 Ti와 Si가 입력된다.

출력
진영이가 일을 모두 끝마칠 수 있는 가장 늦은 시간을 출력한다. 만약 0시부터 시작하여도 일을 끝마칠 수 없다면 -1을 출력한다.




*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] work = new int[n][n];
		
		for(int i=0;i<n;i++) 
		{
			String[] ts = br.readLine().split(" ");
			work[i][0] = Integer.parseInt(ts[0]);
			work[i][1] = Integer.parseInt(ts[1]);
		}
		
		Arrays.sort(work, (o1, o2) -> o2[1] - o1[1]); // 큰값부터 작은값으로 내림차순
		
		int answer = work[0][1] - work[0][0];
		
		for(int i=1;i<n;i++) 
		{
			if(work[i][1] < answer) 
			{
				answer = work[i][1];
			}
			answer -= work[i][0];
		}
		
		if(answer > 0) 
		{
			bw.write(String.valueOf(answer));
		} else 
		{
			bw.write(String.valueOf(-1));
		}
		
		bw.flush();
		bw.close();
		
	}

}