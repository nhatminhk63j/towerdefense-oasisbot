package Entity.Tower;

public class MachineGunTower extends Tower {
    public MachineGunTower(int x, int y){
        super(100, 3, 50, 150);
        setType("MachineGunTower");
        setxPos(x);
        setyPos(y);
    }

    public static int getPrice(){
        return 100;
    }
}
