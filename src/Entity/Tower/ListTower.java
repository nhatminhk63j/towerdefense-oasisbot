package Entity.Tower;

import Entity.Enemy.Enemy;
import Entity.Enemy.ListEnemy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListTower {
    public List<Tower> towerList = new ArrayList<>();

    public static final int NORMAL_TOWER = 1;
    public static final int MACHINE_GUN_TOWER = 2;
    public static final int SNIPER_TOWER = 3;

    public int chosen = 0;

    public void add(int x, int y){
        if(chosen == 1){
            towerList.add(new NormalTower(x, y));
        } else if(chosen == 2){
            towerList.add(new MachineGunTower(x, y));
        } else {
            towerList.add(new SniperTower(x, y));
        }
    }

    public int getPrice(){
        if(chosen == 1){
            return NormalTower.getPrice();
        } else if(chosen == 2){
            return MachineGunTower.getPrice();
        } else{
            return SniperTower.getPrice();
        }
    }

    public void attackEnemy(ListEnemy listEnemy){
        for(Tower tower : towerList){
            tower.attackEnemy((ArrayList<Enemy>) listEnemy.enemyList);
        }
    }

    public void draw(Graphics2D g2d){
        for(Tower tower : towerList){
            tower.draw(g2d);
        }
    }

    public void combat(){

    }
}
