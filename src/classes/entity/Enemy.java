package classes.entity;


import java.util.ArrayList;

public class Enemy extends Character implements Cloneable {
    private int xpValue;
    private int currencyValue;
    private String[] enemyTaunts = new String[]{};

    public String[] getEnemyTaunts() {
        return enemyTaunts;
    }

    public void setEnemyTaunts(String[] enemyTaunts) {
        this.enemyTaunts = enemyTaunts;
    }

    public Enemy(String name, int maxHP, int maxMP, int str, int def, int speed, int xpValue) {
        super(name, maxHP, maxMP, str, def, speed);
        this.xpValue = xpValue;
    }

    public int getXpValue() {
        return xpValue;
    }

    public void setXpValue(int xpValue) {
        this.xpValue = xpValue;
    }

    public int getCurrencyvalue() {
        return currencyValue;
    }

    public void setCurrencyvalue(int currencyvalue) {
        this.currencyValue = currencyvalue;
    }

    @Override
    public Enemy clone() {
        try {
            Enemy clone = (Enemy) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
