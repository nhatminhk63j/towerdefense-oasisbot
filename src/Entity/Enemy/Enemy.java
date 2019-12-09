package Entity.Enemy;

import Entity.Bullet.Bullet;
import Entity.Entity;
import Game.Screen;
import Game.Value;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;

public abstract class Enemy extends Entity {
    private int hp;
    private double speed;
    private int armor;
    private int rewardMoney;
    private int damage;
    private int flag;
    private double angle;
    private int xMove, yMove;
    private int route;
    public int enemyMove;
    public boolean inGame = false;

    public boolean hasUp = false;
    public boolean hasDown = false;
    public boolean hasRight = false;
    public boolean hasLeft = false;

    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int DOWN = 3;
    public static final int UP = 4;


    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.flag = 0;
        inGame = true;
        this.setxPos((int) Screen.spawnPoint.spawnPoint.getX());
        this.setyPos((int) Screen.spawnPoint.spawnPoint.getY());

        route = RIGHT;

        xMove = 0;
        yMove = 1;
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

    public int timeMove = 1, timeDelay = 4;
    public void move(){

        if(timeMove >= timeDelay){
            switch (route){
                case RIGHT:
                    setxPos((int) (getxPos() + speed));
                    angle = 0;
                    break;
                case LEFT:
                    setxPos((int) (getxPos() - speed));
                    angle = 180;
                    break;
                case DOWN:
                    setyPos((int) (getyPos() + speed));
                    angle = 90;
                    break;
                case UP:
                    setyPos((int) (getyPos() - speed));
                    angle = 270;
                    break;
            }
            enemyMove++;
            timeMove = 0;
        } timeMove++;

        if(enemyMove >= 64){
            if(route == RIGHT){
                xMove++;
                hasRight = true;
            } else if(route == LEFT){
                xMove--;
                hasLeft = true;
            } else if(route == DOWN){
                yMove++;
                hasDown = true;
            } else if(route == UP){
                yMove--;
                hasUp = true;
            }

            if(!hasLeft){
                try{
                    if(Screen.map.map[yMove][xMove + 1] == 1){
                        route = RIGHT;
                    } else if(Screen.map.map[yMove][xMove + 1] == 15){
                        hp = 0;
                        Screen.player.health -= damage;
                    }
                } catch (Exception e){};
            }

            if(!hasRight){
                try{
                    if(Screen.map.map[yMove][xMove - 1] == 1){
                        route = LEFT;
                    } else if(Screen.map.map[yMove][xMove - 1] == 15){
                        hp = 0;
                        Screen.player.health -= damage;
                    }
                } catch (Exception e){};
            }

            if(!hasUp){
                try{
                    if(Screen.map.map[yMove + 1][xMove] == 1){
                        route = DOWN;
                    } else if(Screen.map.map[yMove + 1][xMove] == 15){
                        hp = 0;
                        Screen.player.health -= damage;
                    }
                } catch (Exception e){};
            }

            if(!hasDown){
                try{
                    if(Screen.map.map[yMove - 1][xMove] == 1){
                        route = UP;
                    } else if(Screen.map.map[yMove - 1][xMove] == 15){
                        hp = 0;
                        Screen.player.health -= damage;
                    }
                } catch (Exception e){};
            }

            hasRight = false;
            hasLeft = false;
            hasDown = false;
            hasUp = false;

            enemyMove = 0;
        }
        setCenter();
    }

    public boolean beAttacked(Bullet bullet){
        if(getShapeCollider().intersects((Rectangle2D) bullet.getShapeCollider())){
            hp -= bullet.getDamage();
            return true;
        }
        return false;
    }


    public Point getCenter(){
        return new Point(getxPos() + Value.SIZE_TILE/2, getyPos() + Value.SIZE_TILE/2);
    }

    public Shape getShapeCollider(){
        return new Rectangle2D.Double(getxPos(), getyPos(), getWidth(), getHeight());
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speedMove) {
        this.speed = speedMove;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(int rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }


}
