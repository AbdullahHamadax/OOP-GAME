package Classes.Core;


import Classes.Entity.Character;

public class Move {
    private int id;
    private String name;
    private int power;
    private int accuracy;
    private int type;

    public Move(String name, int power, int type, int id, int accuracy) {
        this.setName(name);
        this.setPower(power);
        this.setType(type);
        this.setId(id);
        this.setAccuracy(accuracy);
    }

    @Override
    public int hashCode() {
        return getId();
    }

    public String getName() {
        return name;
    }

    public int use(Character user, Character target) {
        int damage = (int) (((double) user.getStr() / 10) * getPower()) + 1;
        double randomValue = Math.random();
        if (randomValue >= (double) getAccuracy() / 100)
            return -1;


        target.updateHp(damage * -1);
        return damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
