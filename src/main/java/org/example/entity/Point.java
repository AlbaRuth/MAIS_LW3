package org.example.entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Point {

    private static final Logger logger = LogManager.getLogger(Point.class);

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        logger.info("Создана точка: {}", this);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
