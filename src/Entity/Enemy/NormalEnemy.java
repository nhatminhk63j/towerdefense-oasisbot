package Entity.Enemy;

public class NormalEnemy extends Enemy {

    public NormalEnemy() {
        super(1000, 100, 1, 1);
        setType("NormalEnemy");
        route = RIGHT;
    }
}
