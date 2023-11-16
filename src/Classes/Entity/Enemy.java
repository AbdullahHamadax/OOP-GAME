package Classes.Entity;

import Classes.Move;

import java.util.ArrayList;

public class Enemy extends Character{
    private int xpValue;
    public Enemy(String name, int maxHP, int maxMP, int str, int def, int speed, ArrayList<Move> moves, int xpValue) {
        super(name, maxHP, maxMP, str, def, speed, moves);
        this.xpValue = xpValue;
    }
    public int getXpValue() {
        return xpValue;
    }

    public void setXpValue(int xpValue) {
        this.xpValue = xpValue;
    }
}
