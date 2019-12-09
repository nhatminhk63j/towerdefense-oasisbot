package Entity.Tower;

import Entity.Bullet.Bullet;
import Entity.Bullet.NormalTowerBullet;
import Entity.Bullet.SniperTowerBullet;
import Game.Value;

import javax.swing.*;
import javax.xml.validation.Validator;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class SniperTower extends Tower {

    private Image bodyTower = new ImageIcon("res/BodySniperTower.png").getImage();
    private long timeAttack;

    public SniperTower(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.setType("SniperTower");
        this.setRange(Value.SNIPER_TOWER_RANGE);
        this.setAttackSpeed(Value.SNIPER_TOWER_ATTACK_SPEED);
        this.setPrice(Value.SNIPER_TOWER_PRICE);
    }


    public void draw(Graphics2D g2d){

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
