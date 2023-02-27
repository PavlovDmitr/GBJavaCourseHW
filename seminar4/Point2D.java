package seminar4;

public class Point2D {
    private int x;
    private int y;
    private int value;

    public Point2D(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Point2D point2D = (Point2D) obj;

        return (Integer.compare(x, point2D.x) == 0
                && Integer.compare(y, point2D.y) == 0);

    }

    public boolean equalsValue(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Point2D point2D = (Point2D) obj;

        return Integer.compare(value, point2D.value) == 0;
    }
}