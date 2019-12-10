package Entity.Tower;

import Game.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Upgrade {
    private Image upgrade = new ImageIcon("res/upgrade.png").getImage();
    private int xMouse, yMouse;
    private int xUpgrade, yUpgrade;
    private boolean isVisiable = false;
    private int numberTowerSelect;

    public void select(MouseEvent e){
        xMouse = e.getX() - (Screen.frame.getWidth() - Screen.myWidth - 8);
        yMouse = e.getY() - (Screen.frame.getHeight() - Screen.myHeight - 8);

        for(int i = 0; i < Screen.listTower.towerList.size(); i++){
            Tower tower = Screen.listTower.towerList.get(i);
            if(xMouse >= tower.getxPos() && xMouse <= tower.getxPos() + 64 && yMouse >= tower.getyPos() && yMouse <= tower.getyPos() + 64){
                xUpgrade = tower.getxPos();
                yUpgrade = tower.getyPos();
                numberTowerSelect = i;
                isVisiable = true;
                break;
            } else{
                isVisiable = false;
            }
        }

        if(xMouse >= xUpgrade - 16 && xMouse <= xUpgrade - 16 + 16 && yMouse >= yUpgrade - 16 && yMouse <= yUpgrade - 16 + 16){
            System.out.println("Selected");
            Screen.listTower.towerList.get(numberTowerSelect).setAttackSpeed(Screen.listTower.towerList.get(numberTowerSelect).getAttackSpeed() + 50);
            Screen.listTower.towerList.get(numberTowerSelect).setRange(Screen.listTower.towerList.get(numberTowerSelect).getRange() + 50);
        }

    }
    public void draw(Graphics2D g2d){
        if(isVisiable){
            g2d.drawImage(upgrade, xUpgrade - 16, yUpgrade - 16, 16, 16, null);
        }
    }
}
