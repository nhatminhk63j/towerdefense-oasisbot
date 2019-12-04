package Map;

import Game.Screen;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    public int[][] map;
    public static boolean[][] isCanPutTower = new boolean[9][20];
    public int tileSize = 64;

    public Map(String str){
        map = loadMap(str);
    }

    public int[][] loadMap(String str){
        int[][]save = new int[9][20];
        try{
            File src;
            Scanner sc = new Scanner(new File(str));
            while(sc.hasNextInt()){
                for(int y = 0; y < 9; y++){
                    for(int x = 0; x < 20; x++){
                        save[y][x] = sc.nextInt();
                    }
                }

                for(int y = 0; y < 9; y++){
                    for(int x = 0; x < 20; x++){
                        if(sc.nextInt() == 0){
                            isCanPutTower[y][x] = true;
                        } else isCanPutTower[y][x] = false;
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return save;
    }


    public void draw(Graphics g){
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 20; x++){
                Image image = new ImageIcon("res/" + map[y][x] + ".png").getImage();
                g.drawImage(image, (Screen.myWidth - 1280)/2 + 64 * x, 64 * y, tileSize, tileSize, null);
            }
        }
    }
}
