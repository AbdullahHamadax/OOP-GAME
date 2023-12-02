package Classes;


import Classes.Entity.Character;

public class Move {
    int id;
    String name;
    int power;
    int accuracy;
    int type;

    public Move(String name, int power, int type, int id, int accuracy) {
        this.name = name;
        this.power = power;
        this.type = type;
        this.id = id;
        this.accuracy = accuracy;
    }
    @Override
    public int hashCode(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int use(Character user, Character target){
        int damage = (int)(((double) user.getStr() / 10) * power) + 1;
        double randomValue = Math.random();
        if(randomValue >= (double)accuracy/ 100)
            return -1;


        target.updateHp(damage * -1);
        return damage;
    }
}
