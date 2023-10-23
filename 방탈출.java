/*

당신은 유능한 Java 게임 프로그래머로서 아래에 나오는 요구사항을 분석 하여 코딩을 해야 한다.
(1)물방울크기와 물방울위치가 각각 8,1,9,5,3 과 2,5,10,16,20 이 주어진다.  
(2)게임의 플레이어는 물방울과 물방울 사이의 첫번째 공간부터 시작하여 물방울 사이간 좌측 혹은 우측으로 이동할 수 있고 우측 끝까지 진행한다.
(3)플레이어가 움직일 수 있는 조건이 있는데, 물방울 위치간 거리를 d1 라고 할 때, d1 값의 크기가 좌측에 있는 물방울 크기 값보다 커야 그쪽을 통과할 수 있다.
(4)물방울 사이의 거리를 d2 라고 할 때, d2 값의 크기가 우측에 있는 물방울 크기 값보다 커야 그쪽을 통과할 수 있다.
(5)좌측이든 우측이든 플레이어가 통과가 가능하면 통과한 지역은 이전의 거리값과 합산하여 새로운 d3를 만든다.
(6)d3는 다시 (2)부터 적용된 알고리즘대로 진행한다.
(7)만약 (3),(4)에서 통과를 할 수 없다면 그 공간의 크기를 합산한다. 
(8)플레이어가 출발했을 때 탈출이 불가능한 공간 크기의 총합을 구하도록  Java로 구현하라.


*/

public class BubbleEscape {

    public static void main(String[] args) {
        int[] bubbleSize = {8, 1, 9, 5, 3};
        int[] bubblePosition = {2, 5, 10, 16, 20};

        System.out.println("Unescapable space size: " + calculateUnescapableSpace(bubbleSize, bubblePosition));
    }

    private static int calculateUnescapableSpace(int[] sizes, int[] positions) {
        int totalUnescapableDistance = 0;
        int previousPosition = 0;

        for (int i = 0; i < positions.length; i++) {
            int distanceToLeft = positions[i] - previousPosition;
            int distanceToRight = (i < positions.length - 1) ? positions[i + 1] - positions[i] : Integer.MAX_VALUE;

            boolean canPassLeft = distanceToLeft > sizes[i];
            boolean canPassRight = i < sizes.length - 1 && distanceToRight > sizes[i + 1];

            if (!canPassLeft && !canPassRight) {
                totalUnescapableDistance += (i < positions.length - 1) ? distanceToRight : distanceToLeft;
            }

            if (canPassLeft || canPassRight) {
                previousPosition = positions[i];
            }
        }

        return totalUnescapableDistance;
    }
}
