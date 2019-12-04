package Map;

import Game.Screen;

import java.awt.*;

public class SpawnPoint {
    public static Point spawnPoint;

    public SpawnPoint(){
        this.spawnPoint = findSpawnPoint();
    }

    public Point findSpawnPoint(){
        for(int y=0; y <9; y++){
            for(int x=0; x < 20; x++){
                if(Screen.map.map[y][x] == 14) return new Point((Screen.myWidth - 1280)/2 + 64 * x, 64 * y);
            }
        }
        return null;
    }

}
