package Entity.Bullet;

import Entity.Tower.Tower;
import Game.Value;

import java.awt.*;

public class MachineGunTowerBullet extends  Bullet {
    public MachineGunTowerBullet(Tower tower, int x, int y, int width, int height, double angle) {
        super(tower, x, y, width, height, angle);
        this.setSpeed(Value.MACHINE_GUN_TOWER_SPEED);
        this.setDamage(Value.MACHINE_GUN_TOWER_DAMAGE);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(getxPos(), getyPos(), getWidth() / 4, getHeight() / 4);
    }
}
