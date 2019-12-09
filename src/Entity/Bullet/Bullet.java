package Entity.Bullet;

import Entity.Entity;
import Entity.Tower.Tower;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Bullet extends Entity {
    private double speed;
    private int damage;
    private double angle;
    private Point center;
    private Tower tower;
    private int flag;

    public Bullet(Tower tower,int x, int y, int width, int height, double angle) {
        super(x, y, width, height);
        this.tower = tower;
        this.angle = angle;
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
        setCenter();
    }

    public Shape getShapeCollider(){
        return new Rectangle2D.Double(getxPos(), getyPos(), getWidth()/4, getHeight()/4);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public Point getCenter() {
        return center;
    }


    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
