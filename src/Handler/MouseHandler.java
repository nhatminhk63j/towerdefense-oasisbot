package Handler;

import Game.Frame;
import Game.Screen;

import javax.script.ScriptEngine;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseMotionListener, MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(Screen.flagMenu == 0){
            Screen.menuGame.select(e);
        } else if(Screen.flagMenu == 1){
            Screen.shop.click(e);
            Screen.remove.select(e);
            Screen.upgrade.select(e);
            Screen.pauseGame.sellect(e);
        } else if(Screen.flagMenu == 2){
            Screen.menuGame.exit(e);
        } else if(Screen.flagMenu == 3){
            Screen.menuGame.pauseMenuSelect(e);
        }
//        int a = e.getX() - (Screen.frame.getWidth() - Screen.myWidth - 8);
//        int b = e.getY() - (Screen.frame.getHeight() - Screen.myHeight - 8);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Screen.shop.mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Screen.shop.mouseMoved(e);
    }
}
