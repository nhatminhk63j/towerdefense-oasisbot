package Entity.Enemy;

public class TankerEnemy extends Enemy {
    public TankerEnemy(){
        super(5000, 200, 1, 2);
        setType("TankerEnemy");
        route = RIGHT;
    }
}
