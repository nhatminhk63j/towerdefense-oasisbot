package Entity.Enemy;

import Game.Value;

import javax.swing.*;
import java.awt.*;

public class NormalEnemy extends Enemy {
    private Image enemy = new ImageIcon("res/NormalEnemy.gif").getImage();

    public NormalEnemy(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.setArmor(Value.NORMAL_ENEMY_ARMOR);
        this.setRewardMoney(Value.NORMAL_ENEMY_REWARD);
        this.setSpeed(Value.NORMAL_ENEMY_SPEED);
        this.setHp(Value.NORMAL_ENEMY_HP);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.rotate(getAngle(), getxPos() + Value.SIZE_TILE/2, getyPos() + Value.SIZE_TILE/2);
        g2d.drawImage(enemy, getxPos(), getyPos(), Value.SIZE_TILE, Value.SIZE_TILE, null);
        g2d.rotate(-getAngle(), getxPos() + Value.SIZE_TILE/2, getyPos() + Value.SIZE_TILE/2);
        move();
    }
}
