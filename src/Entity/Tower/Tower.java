package Entity.Tower;

import Entity.Enemy.Enemy;
import Entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Float;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Tower extends Entity {
    private static int price;
    private static int speed;
    private static int damage;
    private static int range;
    public Enemy target;

    private double angle;
    private int flag;

    private double xDistance;
    private double yDistance;
    public int xTargetEnemy;
    public int yTargetEnemy;
    public int timeFrameBullet = 200, timeBorn = 200;

    public List<Bullet> bulletList = new ArrayList<>();

    boolean isCollision = false;

    public Tower(int price, int speed, int damage, int range){
        this.price = price;
        this.speed = speed;
        this.damage = damage;
        this.range = range;
        this.center = this.getCenter();
    }

    public void attackEnemy(ArrayList<Enemy> enemyList){
        target = checkEnemyInRange(enemyList);
        if(this.getType() == "NormalTower"){
            if(target != null){
                if(timeFrameBullet >= timeBorn){
                    bulletList.add(new Bullet((int)getxPos(), (int)getyPos(), 15, target, "NormalTowerBullet"));
                    timeFrameBullet = 0;
                } else {
                    timeFrameBullet += 1;
                }
            }
            if(!bulletList.isEmpty() && target != null){
                for(Bullet bullet : bulletList){
                    if(!this.collider().contains(((Rectangle2D) bullet.collider()))){
                        bullet.inGame = false;
                    }
                    if(bullet.collider().contains((Rectangle2D) target.collider()) && bullet.inGame){
                        bullet.inGame = false;
                        target.health -= 50;
                        if(target.health <= 0) timeFrameBullet = timeBorn;
                    }
                }
            }
        } else if(this.getType() == "MachineGunTower"){
            if(target != null){
                if(timeFrameBullet >= timeBorn){
                    bulletList.add(new Bullet((int)getxPos(), (int)getyPos(), 20, target, "MachineGunTowerBullet"));
                    timeFrameBullet = 0;
                } else {
                    timeFrameBullet += 1;
                }
            }
            if(!bulletList.isEmpty() && target != null){
                for(Bullet bullet : bulletList){
                    if(!this.collider().intersects(((Rectangle2D) bullet.collider()))){
                        bullet.inGame = false;
                    }
                    if(bullet.collider().contains(target.getCenter()) && bullet.inGame){
                        bullet.inGame = false;
                        target.health -= 10;
                        if(target.health <= 0) timeFrameBullet = timeBorn;
                    }
                }
            }
        }
        else if(this.getType() == "SniperTower"){
            if(target != null){
                xTargetEnemy = target.getCenter().x;
                yTargetEnemy = target.getCenter().y;
                if(timeFrameBullet >= timeBorn){
                    target.health -= this.damage;
                    if(target.health <= 0) timeFrameBullet = timeBorn;
                }
            }
        }
    }

    public Enemy checkEnemyInRange(ArrayList<Enemy> enemyList){
        int count = 0;
        for(Enemy enemy : enemyList){
            if(enemy.inGame){
                if(collider().intersects((Rectangle2D) enemy.collider())){
                    xDistance = (double) enemy.getCenter().getX() - this.getCenter().getX();
                    yDistance = (double) enemy.getCenter().getY() - this.getCenter().getY();
                    this.angle = Math.atan(Math.abs(yDistance / xDistance));
                    return enemy;
                }
            }
        }
        return null;
    }

    public Shape collider() {
        return new Ellipse2D.Double(getxPos() - getRange() / 2 + 64 / 2, getyPos() - getRange() / 2 + 64 / 2, getRange(), getRange());
    }


    public void draw(Graphics2D graphics2D){

        Image image = new ImageIcon("res/" + this.getType() + ".png").getImage();
        graphics2D.drawImage(image, getxPos(), getyPos(), null);
        if(!bulletList.isEmpty()){
            for(Bullet bullet : bulletList){
                bullet.move();
                bullet.draw(graphics2D);
            }
        }
        if(this.getType() == "SniperTower" && target != null){
            graphics2D.drawLine(this.getCenter().x, this.getCenter().y, xTargetEnemy, yTargetEnemy);
        }

    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Tower.price = price;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Tower.speed = speed;
    }

    public static int getDamage() {
        return damage;
    }

    public static void setDamage(int damage) {
        Tower.damage = damage;
    }

    public static int getRange() {
        return range;
    }

    public static void setRange(int range) {
        Tower.range = range;
    }

    @Override
    public Point getCenter() {
        return new Point(getxPos() + 32, getyPos() + 32);
    }
}
