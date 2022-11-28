package pointRectangle;

public class Rectangle {
    private Point A;
    private Point C;

    public Rectangle(Point A, Point C) {
        this.A = A;
        this.C = C;
    }

    public boolean contains(Point X) {
        return X.getX() >= A.getX() && X.getY() >= A.getY()
                && X.getX() <= C.getX() && X.getY() <= C.getY();
    }
}
