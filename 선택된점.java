
/*

두개의 점, A(r1,c1), B(r2,c2)가 있을 때, A와 B간의 거리는 abs(r2-r1)+abs(c2-c1)이라고 한다. 여기에서 abs(y)는 y의 절대값을 출력한다.   
5개의 점, a(2,3),b(4,7),c(1,6), d(3,8), e(5,5)가 있고, 임의의 점(1,2)에서 이중 2개의 점만을 거쳐서 다시 임의의 점으로 돌아올 때 임의의 점과 이점들을 지나간 거리의 총합 dd라고 할때,
dd가 최소가 되는 경우와 최대가 되는 경우를 구하는 java 코드를 작성하라. 그때의 점들도 함께 명시하라. arraylist를 사용하지 말고 작성하라.

*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    static int minDistance = Integer.MAX_VALUE;
    static int maxDistance = Integer.MIN_VALUE;
    static List<Point> minPoints = new ArrayList<>();
    static List<Point> maxPoints = new ArrayList<>();

    public static void main(String[] args) {
        Point[] points = {
                new Point(2, 3),
                new Point(4, 7),
                new Point(1, 6),
                new Point(3, 8),
                new Point(5, 5)
        };

        List<Point> selectedPoints = new ArrayList<>();
        findMinAndMaxDistance(points, selectedPoints, 0, 0, 0, new Point(1, 2));

        System.out.println("Minimum distance: " + minDistance);
        System.out.println("Points for minimum distance:");
        for (Point point : minPoints) {
            System.out.println("Point: (" + point.getRow() + ", " + point.getColumn() + ")");
        }

        System.out.println("\nMaximum distance: " + maxDistance);
        System.out.println("Points for maximum distance:");
        for (Point point : maxPoints) {
            System.out.println("Point: (" + point.getRow() + ", " + point.getColumn() + ")");
        }
    }

    static void findMinAndMaxDistance(Point[] points, List<Point> selectedPoints, int index, int totalDistance, int selectedCount, Point origin) {
        if (selectedCount == 2) {
            int distanceToOrigin = totalDistance + Math.abs(selectedPoints.get(1).getRow() - origin.getRow()) + Math.abs(selectedPoints.get(1).getColumn() - origin.getColumn());
            if (distanceToOrigin < minDistance) {
                minDistance = distanceToOrigin;
                minPoints.clear();
                minPoints.addAll(selectedPoints);
            }
            if (distanceToOrigin > maxDistance) {
                maxDistance = distanceToOrigin;
                maxPoints.clear();
                maxPoints.addAll(selectedPoints);
            }
            return;
        }

        if (index >= points.length) {
            return;
        }

        selectedPoints.add(points[index]);
        findMinAndMaxDistance(points, selectedPoints, index + 1, totalDistance + Math.abs(points[index].getRow() - origin.getRow()) + Math.abs(points[index].getColumn() - origin.getColumn()), selectedCount + 1, origin);
        selectedPoints.remove(selectedPoints.size() - 1);
        findMinAndMaxDistance(points, selectedPoints, index + 1, totalDistance, selectedCount, origin);
    }

    static class Point {
        private int row;
        private int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
}
