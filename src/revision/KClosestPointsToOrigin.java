package revision;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static List<Point> kClosestPoints(Point[] points, int k) {
        PriorityQueue<Distance> pq = new PriorityQueue<>(Comparator.comparingInt(d -> -d.distance));
        for (Point p : points) {
            pq.add(new Distance(p));
            if (pq.size() > k)
                pq.poll();
        }
        List<Point> result = new ArrayList<>();
        for (Distance d : pq) {
            result.add(d.p);
        }
        return result;
    }

    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(0, 0), new Point(-2, 4), new Point(0, -2), new Point(-1, 0), new Point(3, 5), new Point(-2, -3), new Point(3, 2)};
        System.out.println(kClosestPoints(points, 2));
    }

}

class Distance {
    public Point p;
    public int distance;

    public Distance(Point p) {
        this.p = p;
        this.distance = (int) (Math.pow(p.x, 2) + Math.pow(p.y, 2));
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

