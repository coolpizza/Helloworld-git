/*

아래는 dp나 재귀를 사용하지 않고, 다른 방식으로 주어진 숫자 n을 두 개의 그룹으로 나누어 합산할 때 최대값을 구하는 자바 프로그램입니다. 
이 프로그램은 탐욕적인(Greedy) 접근 방식을 사용하여 문제를 해결

==>

위의 프로그램은 [1, 2, 3, 4, 5]와 같은 배열을 입력으로 받아서 두 그룹으로 나누어 합산할 때 최대값을 계산합니다. 
프로그램은 입력 배열을 내림차순으로 정렬한 후, 
홀수 인덱스에 있는 숫자들은 첫 번째 그룹에, 짝수 인덱스에 있는 숫자들은 두 번째 그룹에 할당합니다. 
이후, 각 그룹의 숫자들을 합산하여 최대값을 구합니다.


*/

import java.util.Arrays;

public class MaximumSumGroups {
    public static int maxSum(int[] nums) {
        // 입력 배열을 내림차순으로 정렬
        Arrays.sort(nums);
        reverse(nums);
        
        int n = nums.length;
        
        int group1Sum = 0;
        int group2Sum = 0;
        
        for (int i = 0; i < n; i++) {
            // 홀수 인덱스일 때는 첫 번째 그룹에 숫자를 추가
            if (i % 2 == 0) {
                group1Sum += nums[i];
            }
            // 짝수 인덱스일 때는 두 번째 그룹에 숫자를 추가
            else {
                group2Sum += nums[i];
            }
        }
        
        // 두 그룹으로 나누어 합산한 최대값 반환
        return group1Sum + group2Sum;
    }
    
    // 배열을 역순으로 정렬하는 함수
    public static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int maxSum = maxSum(nums);
        System.out.println("maxSum into two Group: " + maxSum);
    }
}
