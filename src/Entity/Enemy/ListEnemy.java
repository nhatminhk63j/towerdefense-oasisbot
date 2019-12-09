package Entity.Enemy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListEnemy {
    public List<Enemy> enemyList = new ArrayList<>();

    int spawnTime = 1;
    int amount = 10;

    public void addEnemy(Enemy enemy){
        enemy.inGame = true;
        enemyList.add(enemy);
    }

    public void delete(){
        for(int i = 0; i < enemyList.size(); i++){
            if(enemyList.get(i).getHp() <= 0){
                enemyList.remove(i);
            }
        }
    }

    public boolean isCreateNewEnemy(){
        if(spawnTime -- == 0 && amount-- > 0){
            spawnTime = 300;
            return true;
        }
        return false;
    }

    public Enemy createEnemy(){
        return new NormalEnemy(0, 0, 64, 64);
    }

    public void draw(Graphics2D graphics2D){
        for(Enemy enemy : enemyList){
            enemy.draw(graphics2D);
        }
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



}
