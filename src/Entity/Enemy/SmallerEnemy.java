package Entity.Enemy;

public class SmallerEnemy extends Enemy {
    public SmallerEnemy(){
        super(1000, 50, 2, 1);
        setType("SmallerEnemy");
        route = RIGHT;
    }
}
