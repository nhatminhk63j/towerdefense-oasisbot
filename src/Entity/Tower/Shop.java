package Entity.Tower;

import Game.Screen;
import Game.Value;

import javax.script.ScriptEngine;
import javax.swing.*;
import javax.xml.validation.Validator;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    public List<Tower> items = new ArrayList<>();
    public Image[] itemImages = new Image[3];
    public boolean holdItem = false;
    int x, y;
    int xMouse, yMouse;
    int holdX, holdY;
    boolean mouseDown = false;


    public Shop(){
        init();
    }

    private void init() {
        itemImages[0] = new ImageIcon("res/NormalTower.png").getImage();
        itemImages[1] = new ImageIcon("res/MachineGunTower.png").getImage();
        itemImages[2] = new ImageIcon("res/SniperTower.png").getImage();
    }

    public void click(MouseEvent e){
        xMouse = e.getX() - (Screen.frame.getWidth() - Screen.myWidth - 8);
        yMouse = e.getY() - (Screen.frame.getHeight() - Screen.myHeight - 8);
        x = (int)((xMouse - 60) / Value.SIZE_TILE);
        y = (int)(yMouse / Value.SIZE_TILE);

        mouseDown = true;

        if(holdItem){
            if(x < 20 && y < 9){
                if(Screen.map.isCanPutTower[y][x]){
                    if(Screen.player.money >= Screen.listTower.getPrice()){
                        Screen.player.money -= Screen.listTower.getPrice();
                        Screen.listTower.add(60 + x * Value.SIZE_TILE, y * Value.SIZE_TILE, Value.SIZE_TILE, Value.SIZE_TILE);
                        Screen.listTower.setFlag(0);
                    }
                }
                holdItem = false;
            }
        }
        mouseUpdate(e);
    }

    private void mouseUpdate(MouseEvent e) {
        if(mouseDown && !holdItem){

            if(xMouse >= 60 && xMouse <= 124 && yMouse >= 640 && yMouse <= 704){
                holdItem = true;
                mouseDown = false;
                Screen.listTower.flag = 1;
            }
            if(xMouse >= 144 && xMouse <= 208 && yMouse >= 640 && yMouse <= 704){
                holdItem = true;
                mouseDown = false;
                Screen.listTower.flag = 2;
            }
            if(xMouse >= 228 && xMouse <= 292 && yMouse >= 640 && yMouse <= 704){
                holdItem = true;
                mouseDown = false;
                Screen.listTower.flag = 3;
            }

        }
        if(xMouse >= 500 && xMouse <= 564 && yMouse >= 640 && yMouse <= 704){
            Screen.isPauseGame = true;
            System.out.println("Clicked");
        }
        if(Screen.isPauseGame){
            if(xMouse >= 500 && xMouse <= 564 && yMouse >= 640 && yMouse <= 704){
                Screen.isPauseGame = false;
            }
        }
    }

    public void mouseMoved(MouseEvent e){
        holdX = e.getX() - (Screen.frame.getWidth() - Screen.myWidth - 8);
        holdY = e.getY() - (Screen.frame.getHeight() - Screen.myHeight - 8);
    }

    public void draw(Graphics2D g2d){
        // Vẽ danh sách các Tower để lựa chọn.
        g2d.drawImage(itemImages[0], 60, 640, Value.SIZE_TILE, Value.SIZE_TILE, null);
        g2d.drawImage(itemImages[1], 144, 640, Value.SIZE_TILE, Value.SIZE_TILE, null);
        g2d.drawImage(itemImages[2], 228, 640, Value.SIZE_TILE, Value.SIZE_TILE, null);

        // Vẽ item đang được chọn di chuyển theo chuột.
        if(holdItem){
            if(Screen.listTower.flag == 1) g2d.drawImage(itemImages[0], holdX - Value.SIZE_TILE/2, holdY - Value.SIZE_TILE/2, Value.SIZE_TILE, Value.SIZE_TILE, null);
            else if(Screen.listTower.flag == 2) g2d.drawImage(itemImages[1], holdX - Value.SIZE_TILE/2, holdY - Value.SIZE_TILE/2, Value.SIZE_TILE, Value.SIZE_TILE, null);
            else if(Screen.listTower.flag == 3) g2d.drawImage(itemImages[2], holdX - Value.SIZE_TILE/2, holdY - Value.SIZE_TILE/2, Value.SIZE_TILE, Value.SIZE_TILE, null);
        }



        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("HEALTH: ", 350, 640);
        g2d.setColor(Color.RED);
        g2d.fillRect(450, 640 - 15, 200, 20);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(450, 640 - 15, Screen.player.health, 20);

        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("Coin: " + Screen.player.money, 350, 700);

    }


}
