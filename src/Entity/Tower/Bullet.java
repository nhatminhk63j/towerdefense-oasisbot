package Entity.Tower;

import Entity.Enemy.Enemy;

import javax.swing.*;
import java.awt.*;

public class Bullet {
    public int x;
    public int y;
    public Image texture;
    public int timeMove = 3, timeMoved = 3;
    public String typeBullet = "";

    public Enemy target;
    public int speed;
    public double angle;
    public boolean inGame = false;

    public Bullet(int x, int y, int speed, Enemy target, String typeBullet){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.target = target;
        this.typeBullet = typeBullet;
        this.texture = new ImageIcon("res/" + typeBullet + ".png").getImage();
        this.inGame = true;
        updateAngle();
    }

    public void move(){
        if(timeMove >= timeMoved){
            updateAngle();
            this.x += speed * Math.cos(angle);
            this.y += speed * Math.sin(angle);
            timeMove = 0;
        } else {
            timeMove++;
        }

    }

    public void updateAngle(){
        this.angle = Math.atan2(this.target.getyPos()- this.y, this.target.getxPos() - this.x);
    }

    public void draw(Graphics2D g2d){
        if(typeBullet == "NormalTowerBullet"){
            g2d.rotate(angle + Math.toRadians(90), x + 15, y + 25);
            if(inGame){
                g2d.drawImage(texture, x, y, 30, 50, null);
            }
            g2d.rotate(-angle + Math.toRadians(-90), x + 15, y + 25);
        } else if(typeBullet == "MachineGunTowerBullet"){
            g2d.drawImage(texture, x, y, 16, 28, null);
        }
    }

    public Shape collider(){
        if(typeBullet == "NormalTowerBullet"){
            return new Rectangle(x, y, 30, 50);
        } else if(typeBullet == "MachineGunTowerBullet"){
            return new Rectangle(x, y, 30, 30);
        }
        return null;
    }
}
