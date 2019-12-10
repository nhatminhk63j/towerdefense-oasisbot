package Entity.Tower;

import Game.Screen;
import Game.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Remove {
    private int xMouse, yMouse;
    private int xRemove, yRemove;
    private boolean isVisiable =  false;
    private Image remove = new ImageIcon("res/remove.png").getImage();
    private boolean isRemove = false;
    private int numberTowerSelect;

    public void select(MouseEvent e){
        xMouse = e.getX() - (Screen.frame.getWidth() - Screen.myWidth - 8);
        yMouse = e.getY() - (Screen.frame.getHeight() - Screen.myHeight - 8);

        for(int i = 0; i < Screen.listTower.towerList.size(); i++){
            Tower tower = Screen.listTower.towerList.get(i);
            if(xMouse >= tower.getxPos() && xMouse <= tower.getxPos() + 64 && yMouse >= tower.getyPos() && yMouse <= tower.getyPos() + 64){
                xRemove = tower.getxPos();
                yRemove = tower.getyPos();
                numberTowerSelect = i;
                isVisiable = true;
                break;
            } else{
                isVisiable = false;
            }
        }

        if(xMouse >= xRemove + 64 && xMouse <= xRemove + 64 + 16 && yRemove >= yRemove -16 && yRemove <= yRemove - 16 + 16){
            System.out.println("Selected");
            Screen.listTower.towerList.remove(numberTowerSelect);
        }

    }
    public void draw(Graphics2D g2d){
        if(isVisiable){
            g2d.drawImage(remove, xRemove + 64, yRemove - 16, 16, 16, null);
        }
    }
}
