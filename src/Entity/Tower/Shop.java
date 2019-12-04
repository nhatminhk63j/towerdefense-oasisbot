package Entity.Tower;

import Game.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    public List<Tower> listItem = new ArrayList<>();

    Image[] item = new Image[3];
    Image coinItem;

    public boolean holdsItem = false;
    boolean mouseDown = false;
    public int xPos, yPos;
    public int holdXPos, holdYPos;

    public int[] price = {NormalTower.getPrice(), MachineGunTower.getPrice(), SniperTower.getPrice()};
    public int[] range = {300, 150, 200};

    public Shop(){
        define();
    }

    private void define() {
        item[0] = new ImageIcon("res/NormalTower.png").getImage();
        item[1] = new ImageIcon("res/MachineGunTower.png").getImage();
        item[2] = new ImageIcon("res/SniperTower.png").getImage();
    }

    public void creatListItem(){
        listItem.add(new NormalTower(60, 640));
        listItem.add(new MachineGunTower(144, 640));
        listItem.add(new SniperTower( 228, 640));
    }

    public void click(java.awt.event.MouseEvent e){
        xPos = (e.getX() - 60) / 64;
        yPos = (e.getY()) / 64;

        mouseDown = true;
        if(holdsItem){
            if(xPos < 20 && yPos < 9){
                if(Screen.map.isCanPutTower[yPos][xPos]){
                    if(Screen.player.money >= Screen.listTower.getPrice()){
                        Screen.listTower.add(e.getX() - 34, e.getY() - 64);
                        Screen.player.money -= Screen.listTower.getPrice();
                    }

                }
                holdsItem = false;
            }
        }
        mouseUpdate(e);
    }

    private void mouseUpdate(MouseEvent e) {

        if(mouseDown && !holdsItem){

            if(e.getX() >= 72 && e.getX() <= 124 && e.getY() >= 672 && e.getY() <= 730){
                holdsItem = true;
                Screen.listTower.chosen = 1;
            }
            if(e.getX() >= 155 && e.getX() <= 215 && e.getY() >= 672 && e.getY() <= 730){
                holdsItem = true;
                Screen.listTower.chosen = 2;
            }
            if(e.getX() >= 235 && e.getX() <= 300 && e.getY() >= 672 && e.getY() <= 730){
                holdsItem = true;
                Screen.listTower.chosen = 3;
            }

//            Screen.listTower.chosen = -1;
        }
    }

    public void mouseMoved(MouseEvent e){
        holdXPos = e.getX();
        holdYPos = e.getY();
    }

    public void draw(Graphics2D g2d){
        if(holdsItem){
            if(Screen.listTower.chosen == 1){
                g2d.drawImage(item[0], holdXPos - 34, holdYPos - 64, null);
                g2d.setColor(Color.RED);
                g2d.drawOval(holdXPos - range[0]/2, holdYPos - 30 - range[0]/2, range[0], range[0]);
            } else if(Screen.listTower.chosen == 2){
                g2d.drawImage(item[1], holdXPos - 34, holdYPos - 64, null);
                g2d.setColor(Color.RED);
                g2d.drawOval(holdXPos - range[1]/2, holdYPos - 30 - range[1]/2, range[1], range[1]);
            } else{
                g2d.drawImage(item[2], holdXPos - 34, holdYPos - 64, null);
                g2d.setColor(Color.RED);
                g2d.drawOval(holdXPos - range[2]/2, holdYPos - 30 - range[2]/2, range[2], range[2]);
            }
        }
        int i = 0;
        for(Tower tower : listItem){
            tower.draw(g2d);
            g2d.setColor(Color.DARK_GRAY);
            g2d.setFont(new Font("Arial", Font.BOLD, 8));
            g2d.drawString(tower.getType(), tower.getxPos() + 8, tower.getyPos());
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            g2d.drawString("" + price[i++] ,tower.getxPos() + 16, tower.getyPos() + 75);
            if(i == 3) i = 0;
        }

        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("HEALTH: ", 350, 640);
        g2d.setColor(Color.RED);
        g2d.fillRect(450, 640 - 15, 200, 20);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(450, 640 - 15, Screen.player.health - 50, 20);

        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("Coin: " + Screen.player.money, 350, 700);
    }
}
