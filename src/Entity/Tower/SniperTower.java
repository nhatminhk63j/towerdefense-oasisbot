package Entity.Tower;

public class SniperTower extends Tower {
    public SniperTower(int x, int y){
        super(120, 1, 5, 200);
        setType("SniperTower");
        setxPos(x);
        setyPos(y);
    }

    public static int getPrice(){
        return 120;
    }
}
