package Entity.Tower;

public class NormalTower extends Tower{
    public NormalTower(int x, int y){
        super(100, 1, 50, 300);
        setType("NormalTower");
        setxPos(x);
        setyPos(y);
    }

    public static int getPrice(){
        return 100;
    }
}
