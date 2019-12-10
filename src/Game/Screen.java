package Game;

import Entity.Bullet.Bullet;
import Entity.Enemy.Enemy;
import Entity.Enemy.ListEnemy;
import Entity.Tower.ListTower;
import Entity.Tower.Remove;
import Entity.Tower.Shop;
import Entity.Tower.Upgrade;
import Handler.MouseHandler;
import Map.Map;
import Map.SpawnPoint;
import Sound.Sound;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JPanel implements Runnable {

    public static int fpsFrame = 0, fps = 1000000;

    public Thread thread = new Thread(this);

    public static int myWidth, myHeight;

    public boolean isFirst = true;

    public static SpawnPoint spawnPoint;

    public static Map map;
    public static Frame frame;

    public ListEnemy listEnemy;
    public static ListTower listTower;
    public static List<Bullet> bullets = new ArrayList<>();
    public static Shop shop;
    public static Player player;
    public static Remove remove;
    public static Upgrade upgrade;

    public int timeFrame = 1000, timeDelay = 1000;

    public static boolean isPauseGame = false;
    public static int flagMenu = 0;
    public static PauseGame pauseGame;
    public static MenuGame menuGame;

    public Screen(Frame frame){
        this.frame = frame;
        thread.start();

        frame.addMouseListener(new MouseHandler());
        frame.addMouseMotionListener(new MouseHandler());

        menuGame = new MenuGame();
    }

    public void define(){
        map = new Map("Level/mission1.nhatminh");
        listEnemy = new ListEnemy();
        listTower = new ListTower();
        shop = new Shop();
        remove = new Remove();
        upgrade = new Upgrade();
        pauseGame = new PauseGame();

        player = new Player();
        spawnPoint = new SpawnPoint();
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
        if(flagMenu == 0 || flagMenu == 2) {
            menuGame.draw(g2d);
        }

        if(isFirst){
            myWidth = getWidth();
            myHeight = getHeight();
            Sound.play(Sound.backgroundSound);
            define();
        }
        isFirst = false;
        if(flagMenu == 1){

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
            remove.draw(g2d);
            upgrade.draw(g2d);
            pauseGame.draw(g2d);
        }
    }

    public void run(){
        while (true){
            repaint();


            try{
                Thread.sleep(3);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
