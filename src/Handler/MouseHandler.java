package Handler;

import Game.Frame;
import Game.Screen;

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
        Screen.shop.click(e);
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
