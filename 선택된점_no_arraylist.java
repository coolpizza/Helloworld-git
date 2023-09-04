
public class Main {
    static int minDistance = Integer.MAX_VALUE;
    static int maxDistance = Integer.MIN_VALUE;
    static Point[] minPoints = new Point[2];
    static Point[] maxPoints = new Point[2];

    public static void main(String[] args) {
        Point[] points = {
                new Point(2, 3),
                new Point(4, 7),
                new Point(1, 6),
                new Point(3, 8),
                new Point(5, 5)
        };

        Point[] selectedPoints = new Point[2];
        findMinAndMaxDistance(points, selectedPoints, 0, 0, 0, new Point(1, 2));

        System.out.println("Minimum distance: " + minDistance);
        System.out.println("Points for minimum distance:");
        System.out.println("Point 1: (" + minPoints[0].getRow() + ", " + minPoints[0].getColumn() + ")");
        System.out.println("Point 2: (" + minPoints[1].getRow() + ", " + minPoints[1].getColumn() + ")");

        System.out.println("\nMaximum distance: " + maxDistance);
        System.out.println("Points for maximum distance:");
        System.out.println("Point 1: (" + maxPoints[0].getRow() + ", " + maxPoints[0].getColumn() + ")");
        System.out.println("Point 2: (" + maxPoints[1].getRow() + ", " + maxPoints[1].getColumn() + ")");
    }

    static void findMinAndMaxDistance(Point[] points, Point[] selectedPoints, int index, int totalDistance, int selectedCount, Point origin) {
        if (selectedCount == 2) {
            int distanceToOrigin = totalDistance + Math.abs(selectedPoints[1].getRow() - origin.getRow()) + Math.abs(selectedPoints[1].getColumn() - origin.getColumn());
            if (distanceToOrigin < minDistance) {
                minDistance = distanceToOrigin;
                minPoints[0] = selectedPoints[0];
                minPoints[1] = selectedPoints[1];
            }
            if (distanceToOrigin > maxDistance) {
                maxDistance = distanceToOrigin;
                maxPoints[0] = selectedPoints[0];
                maxPoints[1] = selectedPoints[1];
            }
            return;
        }

        if (index >= points.length) {
            return;
        }

        selectedPoints[selectedCount] = points[index];
        findMinAndMaxDistance(points, selectedPoints, index + 1, totalDistance + Math.abs(points[index].getRow() - origin.getRow()) + Math.abs(points[index].getColumn() - origin.getColumn()), selectedCount + 1, origin);
        selectedPoints[selectedCount] = null;
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
