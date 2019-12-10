package Entity.Tower;

import Entity.Bullet.Bullet;
import Entity.Bullet.MachineGunTowerBullet;
import Entity.Bullet.NormalTowerBullet;
import Entity.Bullet.SniperTowerBullet;
import Entity.Enemy.Enemy;
import Game.Value;
import Sound.Sound;

import javax.swing.*;
import javax.xml.validation.Validator;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class SniperTower extends Tower {

    private Image bodyTower = new ImageIcon("res/BodySniperTower.png").getImage();
    private long timeAttack;
    private List<Bullet> bullets = new ArrayList<>();

    public SniperTower(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.setType("SniperTower");
        this.setRange(Value.SNIPER_TOWER_RANGE);
        this.setAttackSpeed(Value.SNIPER_TOWER_ATTACK_SPEED);
        this.setPrice(Value.SNIPER_TOWER_PRICE);
    }

    public void attackEnemy(ArrayList<Enemy> enemies){
        if(checkCollision(enemies)){
            long TIME = System.currentTimeMillis();
            if(TIME - timeAttack < getAttackSpeed()) return;
            timeAttack = TIME;
            Bullet bullet = new SniperTowerBullet(this, getCenter().x - 8, getCenter().y - 8, Value.SIZE_TILE, Value.SIZE_TILE, getAngle());;


            if(getxDistance() <= 0 && getyDistance() <= 0) setFlag(1);
            else if(getxDistance() <= 0 && getyDistance() >= 0) setFlag(2);
            else if(getxDistance() >= 0 && getyDistance() <= 0) setFlag(3);
            else if(getxDistance() >=0 && getyDistance() >= 0) setFlag(4);

            bullet.setFlag(getFlag());
            bullets.add(bullet);
            // may be add Sound Effect in here...
            Sound.play(Sound.sniperBullet);
        }
        if(!bullets.isEmpty()){
            for(int i = 0; i < bullets.size(); i++){
                for(Enemy enemy : enemies){
                    if(enemy.beAttacked(bullets.get(i))) bullets.remove(i);
                }
            }
        }
        if(!bullets.isEmpty()){
            for(int i = 0; i < bullets.size(); i++){
                if(!getShapeCollider().contains((Rectangle2D) bullets.get(i).getShapeCollider())){
                    bullets.remove(i);
                }
            }
        }

    }


    public void draw(Graphics2D g2d){
        for(Bullet bullet : bullets){
            bullet.move();
            bullet.draw(g2d);
        }
        super.draw(g2d);
        switch (getFlag()){
            case 1:
                g2d.rotate(getAngle() + Math.toRadians(-90), getCenter().x, getCenter().y);
                break;
            case 2:
                g2d.rotate(-getAngle() + Math.toRadians(270), getCenter().x, getCenter().y);
                break;
            case 3:
                g2d.rotate(-getAngle() + Math.toRadians(90), getCenter().x, getCenter().y);
                break;
            case 4:
                g2d.rotate(getAngle() + Math.toRadians(90), getCenter().x, getCenter().y);
                break;
        }
        g2d.drawImage(bodyTower, getxPos(), getyPos(), 64, 64, null);
        switch (getFlag()){
            case 1:
                g2d.rotate(-getAngle() + Math.toRadians(90), getCenter().x, getCenter().y);
                break;
            case 2:
                g2d.rotate(getAngle() + Math.toRadians(-270), getCenter().x, getCenter().y);
                break;
            case 3:
                g2d.rotate(getAngle() + Math.toRadians(-90), getCenter().x, getCenter().y);
                break;
            case 4:
                g2d.rotate(-getAngle() + Math.toRadians(-90), getCenter().x, getCenter().y);
                break;
        }
    }
}
