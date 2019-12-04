package Entity.Enemy;

public class BossEnemy extends Enemy {
    public BossEnemy(){
        super(5000, 300, 1, 3);
        setType("BossEnemy");
        route = RIGHT;
    }
}
