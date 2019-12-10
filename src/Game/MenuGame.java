package Game;

import javax.script.ScriptEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class MenuGame {
    private Image background = new ImageIcon("res/background.jpg").getImage();
    private Image startButton = new ImageIcon("res/startButton.png").getImage();
    private Image moreInfo = new ImageIcon("res/moreInfo.png").getImage();
    private Image info = new ImageIcon("res/info.png").getImage();

    private int xMouse, yMouse;

    public void select(MouseEvent e){
        //write something in here
        xMouse = e.getX() - (Screen.frame.getWidth() - Screen.myWidth - 8);
        yMouse = e.getY() - (Screen.frame.getHeight() - Screen.myHeight - 8);
        if(xMouse >= 552 && xMouse <= 552 + 296 && yMouse >= 300 && yMouse <= 300 + 117){
            Screen.flagMenu = 1; // Select Start Button
        } else if(xMouse >= 513 && xMouse <= 513 + 376 && yMouse >= 500 && yMouse <= 500 + 135){
            Screen.flagMenu = 2;
            System.out.println("Clicked");
        }
    }

    public void exit(MouseEvent e){
        Screen.flagMenu = 0;
    }

    public void draw(Graphics2D g2d){
        // Write something in here
        if(Screen.flagMenu == 0){
            g2d.drawImage(background, 0, 0, Screen.myWidth, Screen.myHeight, null);
            g2d.drawImage(startButton, 552, 300, null);
            g2d.drawImage(moreInfo, 513, 500, null);
        } else if(Screen.flagMenu == 2){
            g2d.drawImage(info, 0, 0, null);
        }

    }
}
