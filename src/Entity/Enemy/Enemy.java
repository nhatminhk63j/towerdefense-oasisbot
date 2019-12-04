package Entity.Enemy;

import Entity.Entity;
import Game.Screen;
import Map.SpawnPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Enemy extends Entity {
    public int health;
    int damage;
    int speed;
    int armor;
    int route;
    int xC, yC, enemyMove;
    public boolean inGame = false;
    public double angle;

    public boolean hasUp = false;
    public boolean hasDown = false;
    public boolean hasRight = false;
    public boolean hasLeft = false;

    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int DOWN = 3;
    public static final int UP = 4;

    public Enemy(int health, int damage, int speed, int armor){
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.armor = armor;
        this.center = this.getCenter();

        this.setxPos((int) Screen.spawnPoint.spawnPoint.getX());
        this.setyPos((int) Screen.spawnPoint.spawnPoint.getY());
        xC = 0;
        yC = 1;
    }
    public Shape collider() {
        return new Rectangle2D.Double(getxPos() + 30, getyPos() + 30, 2, 2);
    }

    public Point getCenter(){
        return new Point(getxPos() + 32, getyPos() + 32);
    }

    public int moveFrame = 0, moveSpeed = 4;

    public void move(){

        if(moveFrame >= moveSpeed){
            switch (route){
                case RIGHT:
                    setxPos(getxPos() + speed);
                    angle = 0;
                    break;
                case LEFT:
                    setxPos(getxPos() - speed);
                    angle = 180;
                    break;
                case DOWN:
                    setyPos(getyPos() + speed);
                    angle = 90;
                    break;
                case UP:
                    setyPos(getyPos() - speed);
                    angle = 270;
                    break;
            }
            enemyMove++;
            moveFrame = 0;
        } else moveFrame++;

    }

    public void findRoute(){
        if(enemyMove >= 64){
            if(route == RIGHT){
                xC++;
                hasRight = true;
            } else if(route == LEFT){
                xC--;
                hasLeft = true;
            } else if(route == DOWN){
                yC++;
                hasDown = true;
            } else if(route == UP){
                yC--;
                hasUp = true;
            }

            if(!hasLeft){
                try{
                    if(Screen.map.map[yC][xC + 1] == 1){
                        route = RIGHT;
                    } else if(Screen.map.map[yC][xC + 1] == 15){
                        health = 0;
                        Screen.player.health -= damage;
                    }
                } catch (Exception e){};
            }

            if(!hasRight){
                try{
                    if(Screen.map.map[yC][xC - 1] == 1){
                        route = LEFT;
                    } else if(Screen.map.map[yC][xC - 1] == 15){
                        health = 0;
                        Screen.player.health -= damage;
                    }
                } catch (Exception e){};
            }

            if(!hasUp){
                try{
                    if(Screen.map.map[yC + 1][xC] == 1){
                        route = DOWN;
                    } else if(Screen.map.map[yC + 1][xC] == 15){
                        health = 0;
                        Screen.player.health -= damage;
                    }
                } catch (Exception e){};
            }

            if(!hasDown){
                try{
                    if(Screen.map.map[yC - 1][xC] == 1){
                        route = UP;
                    } else if(Screen.map.map[yC - 1][xC] == 15){
                        health = 0;
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

    }

    public void draw(Graphics2D graphics2D){
        Image image = new ImageIcon("res/" + this.getType() + ".png").getImage();
        graphics2D.rotate(angle, getxPos() + 32, getyPos() + 32);
        graphics2D.drawImage(image, getxPos(), getyPos(), null);
        graphics2D.rotate(-angle, getxPos() + 32, getyPos() + 32);
        // Draw Health of enemy
        findRoute();
        move();
    }

}
