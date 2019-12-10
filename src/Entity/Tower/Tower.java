package Entity.Tower;

import Entity.Bullet.Bullet;
import Entity.Bullet.MachineGunTowerBullet;
import Entity.Bullet.NormalTowerBullet;
import Entity.Bullet.SniperTowerBullet;
import Entity.Enemy.Enemy;
import Entity.Entity;
import Game.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Tower extends Entity {
    private int price;
    private int range;
    private int attackSpeed;
    private double angle;
    private int flag;

    private double xDistance;
    private double yDistance;

    private String type;

    private Image baseTower = new ImageIcon("res/BaseTower.png").getImage();


    private long timeAttack;

    public Tower(int x, int y, int width, int height){
        super(x, y, width, height);
        this.flag = 0;
    }

    public boolean checkCollision(ArrayList<Enemy> listEnemy){
        if(listEnemy.isEmpty()) return false;
        for(Enemy enemy : listEnemy){
            if(getShapeCollider().intersects((Rectangle2D) enemy.getShapeCollider())){
                xDistance = enemy.getCenter().x - this.getCenter().x;
                yDistance = enemy.getCenter().y - this.getCenter().y;
                this.angle = Math.atan(Math.abs(yDistance / xDistance));
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.drawOval(getxPos() - getRange()/2 + 32, getyPos() - getRange()/2 + 32, getRange(), getRange());
        g2d.drawImage(baseTower, getxPos(), getyPos(), 64, 64, null);

    }

    public void move() {
        // Nothing write here...
    }

    public Point getCenter() {
        return new Point(getxPos() + Value.SIZE_TILE/2, getyPos() + Value.SIZE_TILE/2);
    }

    public Shape getShapeCollider() {
        return new Ellipse2D.Double(getxPos() - getRange() / 2 + getWidth() / 2, getyPos() - getRange() / 2 + getHeight() / 2, getRange(), getRange());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
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

    public double getxDistance() {
        return xDistance;
    }

    public void setxDistance(double xDistance) {
        this.xDistance = xDistance;
    }

    public double getyDistance() {
        return yDistance;
    }

    public void setyDistance(double yDistance) {
        this.yDistance = yDistance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void attackEnemy(ArrayList<Enemy> enemyList);
}
