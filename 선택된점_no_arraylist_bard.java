
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 5개의 점
        Point a = new Point(2, 3);
        Point b = new Point(4, 7);
        Point c = new Point(1, 6);
        Point d = new Point(3, 8);
        Point e = new Point(5, 5);

        // 임의의 점
        Point p = new Point(1, 2);

        // 최소 거리
        static int minDistance = Integer.MAX_VALUE;
        // 최소 거리의 점
        Point minPoint1, minPoint2;

        // 최대 거리
        static int maxDistance = Integer.MIN_VALUE;
        // 최대 거리의 점
        Point maxPoint1, maxPoint2;

        // 모든 경우의 수 계산
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                // 두 점의 거리 계산
                int distance = p.distanceTo(points[i]) + p.distanceTo(points[j]);

                // 최소 거리와 비교
                if (distance < minDistance) {
                    minDistance = distance;
                    minPoint1 = points[i];
                    minPoint2 = points[j];
                }

                // 최대 거리와 비교
                if (distance > maxDistance) {
                    maxDistance = distance;
                    maxPoint1 = points[i];
                    maxPoint2 = points[j];
                }
            }
        }

        // 결과 출력
        System.out.println("최소 거리: " + minDistance + ", " + minPoint1 + ", " + minPoint2);
        System.out.println("최대 거리: " + maxDistance + ", " + maxPoint1 + ", " + maxPoint2);
    }
	
	static class Point {

		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int distanceTo(Point other) {
			int dx = x - other.x;
			int dy = y - other.y;
			return (int) Math.sqrt(dx * dx + dy * dy);
		}
	}
	
	
	
}

