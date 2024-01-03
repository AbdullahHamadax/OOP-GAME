package classes.entity;

public class Weapon extends  Equipment{
    int durability;
    public Weapon(String name, int atk, int durability) {
        super(name, 0, atk);
        this.durability=durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
