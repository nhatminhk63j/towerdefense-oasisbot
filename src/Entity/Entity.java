package Entity;

import java.awt.*;
import java.util.Map.Entry;

public abstract class Entity {
    protected Point center;
    int xPos, yPos;
    int width, height;

    public Entity(int x, int y, int width, int height){
        this.xPos = x;
        this.yPos = y;
        this.width = width;
        this.height = height;
        this.center = new Point(this.xPos + this.width / 2, this.yPos + this.height / 2);
    }

    public abstract void draw(Graphics2D g2d);
    public abstract void move();
    public abstract Point getCenter();
    public abstract Shape getShapeCollider();

    public void setCenter() {
        this.center.x = this.xPos + this.width / 2;
        this.center.y = this.yPos + this.height / 2;

    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
