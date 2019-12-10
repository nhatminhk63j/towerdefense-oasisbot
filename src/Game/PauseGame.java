package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class PauseGame {
    private Image pauseGame = new ImageIcon("res/pause_button.jpg").getImage();
    private int xMouse, yMouse;
    private int xPause = 1000, yPause = 640;

    public void sellect(MouseEvent e){
        xMouse = e.getX() - (Screen.frame.getWidth() - Screen.myWidth - 8);
        yMouse = e.getY() - (Screen.frame.getHeight() - Screen.myHeight - 8);
        if(xMouse >= xPause && xMouse <= xPause + 64 && yMouse >= yPause && yMouse <= yPause + 64){
            Screen.isPauseGame = true;
            Screen.running = false;
            Screen.flagMenu = 3;
        }
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(pauseGame, xPause, yPause, 64, 64, null);
    }
}
