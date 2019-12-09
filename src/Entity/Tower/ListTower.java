package Entity.Tower;

import Entity.Enemy.Enemy;
import Entity.Enemy.ListEnemy;
import Game.Value;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListTower {
    public List<Tower> towerList = new ArrayList<>();

    public static final int NORMAL_TOWER = 1;
    public static final int MACHINE_GUN_TOWER = 2;
    public static final int SNIPER_TOWER = 3;

    public int flag = 0;

    public void add(int x, int y, int width, int height){
        if(flag == 1){
            towerList.add(new NormalTower(x, y, width, height));
        } else if(flag == 2){
            towerList.add(new MachineGunTower(x, y, width, height));
        } else if(flag == 3){
            towerList.add(new SniperTower(x, y, width, height));
        }
    }

    public int getPrice(){
        if(flag == 1) return Value.NORMAL_TOWER_PRICE;
        else if(flag == 2) return Value.MACHINE_GUN_TOWER_PRICE;
        else if(flag == 3) return Value.SNIPER_TOWER_PRICE;
        else return -1;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
