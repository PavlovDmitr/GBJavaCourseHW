package units;

public class Point2D {
    protected int posX;
    protected int posY;

    public Point2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    protected double getDistance(Point2D opponent){
        return Math.sqrt(Math.pow(posX - opponent.posX,2) + Math.pow(posY - opponent.posY,2));
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
