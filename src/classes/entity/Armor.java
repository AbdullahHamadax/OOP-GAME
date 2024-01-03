package classes.entity;

public class Armor extends Equipment{
    int durability;
    public Armor(String name, int def, int durability) {
        super(name, def, 0);
        this.durability=durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
