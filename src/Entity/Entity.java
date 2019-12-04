package Entity;

import java.awt.*;

public abstract class Entity {
    protected Point center;
    int xPos, yPos;
    int size;
    String type;

    public abstract Point getCenter();

    public int getxPos() { return xPos; }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
