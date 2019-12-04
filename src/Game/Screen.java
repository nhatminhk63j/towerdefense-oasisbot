package Game;

import Entity.Enemy.ListEnemy;
import Entity.Tower.ListTower;
import Entity.Tower.Shop;
import Handler.MouseHandler;
import Map.Map;
import Map.SpawnPoint;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.MouseListener;

public class Screen extends JPanel implements Runnable {

    public static int fpsFrame = 0, fps = 1000000;

    public Thread thread = new Thread(this);

    public static int myWidth, myHeight;

    public boolean isFirst = true;

    public static SpawnPoint spawnPoint;

    public static Map map;

    public ListEnemy listEnemy;
    public static ListTower listTower;
    public static Shop shop;
    public static Player player;
    public int timeFrame = 1000, timeDelay = 1000;

    public Screen(Frame frame){
        thread.start();

        frame.addMouseListener(new MouseHandler());
        frame.addMouseMotionListener(new MouseHandler());

    }

    public void define(){
        map = new Map("Level/mission1.nhatminh");
        listEnemy = new ListEnemy();
        listTower = new ListTower();
        shop = new Shop();
        shop.creatListItem();
        player = new Player();
        spawnPoint = new SpawnPoint();
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        g.clearRect(0, 0, getWidth(), getHeight());
        if(isFirst){
            myWidth = getWidth();
            myHeight = getHeight();
            define();
        }
        isFirst = false;

        map.draw(g);

        if(listEnemy.isCreateNewEnemy()){
            listEnemy.addEnemy(listEnemy.createEnemy());
        }

        if(!listEnemy.enemyList.isEmpty()){
            listEnemy.delete();
            listEnemy.draw(g2d);
        }
        if(!listTower.towerList.isEmpty()){
            listTower.attackEnemy(listEnemy);
            listTower.draw(g2d);
        }

        shop.draw(g2d);
    }

    public void run(){
        while (true){
            repaint();
            if(timeFrame >= timeDelay){
                timeFrame = 0;
            } else{
                timeFrame++;
            }

            try{
                Thread.sleep(1);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
