package Entity.Bullet;

import Entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class NormalTowerBullet extends Entity {
    private double speed;
    private int dange;
    private double angle;
    private int flag;
    public Image texture;

    public NormalTowerBullet(double speed, int dange, double angle){
        this.speed = speed;
        this.dange = dange;
        this.angle = angle;
        this.flag = 0;
        this.texture = new ImageIcon("res/NormalTowerBullet.png").getImage();
    }

    public void move() {
        switch (flag) {
            case 1: {
                setxPos((int) (getxPos() - getSpeed() * Math.cos(angle)));
                setyPos((int) (getyPos() - getSpeed() * Math.sin(angle)));
                break;
            }
            case 2: {
                setxPos((int) (getxPos() - getSpeed() * Math.cos(angle)));
                setyPos((int) (getyPos() + getSpeed() * Math.sin(angle)));
                break;
            }
            case 3: {
                setxPos((int) (getxPos() + getSpeed() * Math.cos(angle)));
                setyPos((int) (getyPos() - getSpeed() * Math.sin(angle)));
                break;
            }
            case 4: {
                setxPos((int) (getxPos() + getSpeed() * Math.cos(angle)));
                setyPos((int) (getyPos() + getSpeed() * Math.sin(angle)));
                break;
            }
        }

    }

    public Shape collider() {
        return new Rectangle2D.Double(getxPos(), getyPos(), texture.getWidth(null), texture.getHeight(null));
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDange() {
        return dange;
    }

    public void setDange(int dange) {
        this.dange = dange;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public Point getCenter() {
        return null;
    }
}
