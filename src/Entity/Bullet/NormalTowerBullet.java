package Entity.Bullet;

import Entity.Tower.Tower;
import Game.Value;

import java.awt.*;


public class NormalTowerBullet extends Bullet {

    public NormalTowerBullet(Tower tower, int x, int y, int width, int height, double angle) {
        super(tower, x, y, width, height, angle);
        this.setSpeed(Value.NORMAL_BULLET_SPEED);
        this.setDamage(Value.NORMAL_BULLET_DAMAGE);
    }

    @Override
    public void draw(Graphics2D g2d) {
        // draw something...
        g2d.setColor(Color.CYAN);
        g2d.fillOval(getxPos(), getyPos(), getWidth() / 4, getHeight() / 4);
    }
}
