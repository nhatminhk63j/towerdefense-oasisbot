package Game;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public static String title = "TowerDefense Alpha";
    public static Dimension size = new Dimension(1400, 800);

    public Frame(){
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        setSize(size);
    }


    public void init(){
        Screen screen = new Screen(this);
        add(screen);
        setVisible(true);
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}
