
/*

http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=763&sca=4080

https://saecom-dalcom.tistory.com/2


140
5
100 30 100 40 50 60
5 10 4 11 7

-->

16
3
1 3 5


*/

import java.util.ArrayList;
import java.util.Scanner;
 
 

public class Q1492_cmp {

		static class Point{//문제 해결을 위해 class생성 일반적으로 불필요
			String path="";//경로를 저장 변수
			int number = 0;//총 정비시간
			int count = 0;//정비소에 들리는 횟수
			public Point(String path, int number, int count) {
				// TODO Auto-generated constructor stub
				this.path = path;
				this.number = number;
				this.count = count;
			}
			public Point() {
				// TODO Auto-generated constructor stub
			}
		}


		static int maxLength;
		static int[] lengthList;
		public static void main(String[] args) {
        
        int sum =0;
        //입력을 위한 부분
        Scanner sc = new Scanner(System.in);
        maxLength = sc.nextInt();// 최대 이동거리
        int mecCount = sc.nextInt();// 정비소 갯수
        lengthList = new int[mecCount + 1];
        //start위치와 end위치를 모두 포함하여+2 start,end는 시간이 0
        int[] repTime = new int[mecCount+2];
        for (int i = 0; i <= mecCount; i++) {
            lengthList[i] = sc.nextInt();
            sum  = sum+lengthList[i];
        }
        for (int i = 1; i <= mecCount; i++) {
            repTime[i] = sc.nextInt();
        }
        //한번에 갈수 있는 경우 0을 출력
        if(sum<maxLength){
            System.out.println(0);
            return;
        }
        ArrayList<Point> result = new ArrayList<Point>();//최소 결과값 저장
        //0포인트 생성 추가
        result.add(new Point());
        for(int i =1;i<=mecCount+1;i++){
            //새로운 포인트의 값을 구하기위해 포인트 기본 설정
            result.add(new Point());
            //최소 정비 시간을 구하기위한 min 변수
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            //result[i]로 올수있는 포인트를 i와 가까운것부터 찾음
            //가까운 부터 찾아야 최소횟수로 반복문을 실행할수 있음
            for(int j = i-1; j>=0;j--){
                Point point = result.get(j);
                //j포인트에서 i포인트까지 한번에 올수 있는지 확인하는 부분
                if(checkLength(j,i)){
                    //result[j]를 구하고 그곳과 i점까지의 거기를 구해서
                    //수리시간이 최소가 되는 곳을 구함
                    if(min>point.number+repTime[i]){
                        min=point.number+repTime[i];
                        minIndex = j;
                    }
                }else{
                    //한번에 오지못하는 곳을 찾는다면 그 이하의 경우 모두 한번에 오지 못하므로
                    break;
                }
            }
            
            //경로,카운트,최소정비시간을 저장
            //마지막포인트의 경우 무의미 하므로 빼줫음
            String path = result.get(minIndex).path;
            int count = result.get(minIndex).count;
            if(i!=mecCount+1){
                path = path+" "+i;
                count = count+1;
            }
            result.set(i, new Point(path,min,count));
        }
        
        //출력부분
        System.out.println(result.get(mecCount+1).number);
        System.out.println(result.get(mecCount+1).count);
        System.out.println(result.get(mecCount+1).path.trim());
        
    }
    //start부터 end까지 한번이 이동할수 있는지 판별하는 함수
    static public boolean checkLength(int start, int end){
        int temp =0;
        
        for(int i =start;i<end;i++){
            temp = temp +lengthList[i];
        }
        if(maxLength<temp){
            return false;
        }else{
            return true;
        }
    }
    
}