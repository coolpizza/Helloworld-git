
/*
n개를 전체 두개의 그룹으로 나누어서 합산할 때 최대값이 될 수 있도록
-->
위의 프로그램은 [1, 2, 3, 4, 5]와 같은 배열을 입력으로 받아서 두 그룹으로 나누어 합산할 때 최대값을 계산합니다. 
재귀 함수 divideGroups는 현재 처리 중인 인덱스, 첫 번째 그룹과 두 번째 그룹의 합을 매개변수로 받습니다. 
재귀 호출을 통해 모든 가능한 그룹 나누기를 시도하며, 각 경우의 합산 결과 중 최대값을 반환합니다.

프로그램을 실행하면 "두 그룹으로 나누어 합산한 최대값: 9"라는 결과가 출력됩니다. 
입력 배열을 필요에 맞게 수정하여 원하는 숫자로 프로그램을 실행해볼 수 있습니다.

*/

public class MaximumSumGroups {
    public static int maxSum(int[] nums) {
        int n = nums.length;
        
        // 두 그룹으로 나누어 합산한 최대값을 구하는 재귀 함수 호출
        return divideGroups(nums, n, 0, 0, 0);
    }
    
    public static int divideGroups(int[] nums, int n, int index, int sum1, int sum2) {
        // 모든 숫자를 처리한 경우, 두 그룹의 합산 결과를 반환
        if (index == n) {
            return sum1 + sum2;
        }
        
        // 현재 숫자를 첫 번째 그룹에 포함한 경우
        int max1 = divideGroups(nums, n, index + 1, sum1 + nums[index], sum2);
        
        // 현재 숫자를 두 번째 그룹에 포함한 경우
        int max2 = divideGroups(nums, n, index + 1, sum1, sum2 + nums[index]);
        
        // 두 경우 중 더 큰 합을 반환
        return Math.max(max1, max2);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int maxSum = maxSum(nums);
        System.out.println("maxSum into two Group: " + maxSum);
    }
}
