package Classes.Entity;

import Classes.Item;
import Classes.Move;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Character {
    public ArrayList<Move> moves;
    public ArrayList<Item> items;
    private String name;
    private int maxHP, maxMP;
    private int hp, mp;
    private int str, def, speed;
    private int battleStr, battleDef, BattleSpeed;
    private int lvl;

    public Character(String name, int maxHP, int maxMP, int str, int def, int speed, ArrayList<Move> moves) {
        this.name = name;
        this.maxHP = maxHP;
        this.maxMP = maxMP;
        this.str = str;
        this.def = def;
        this.hp = maxHP;
        this.mp = maxMP;
        this.speed = speed;
        this.lvl = 1;
        this.moves = moves;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if(this.hp < 0)
            this.hp = 0;
        else if(this.hp > this.maxHP)
            this.hp = maxHP;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
        if(this.mp < 0)
            this.mp = 0;
        else if(this.mp > this.maxMP)
            this.mp = maxMP;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void restore(){
        this.hp = this.maxHP;
        this.mp = this.maxMP;
    }
    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    public void updateHp(int value){
        setHp(this.hp + value);

    }
    public void updateMp(int value){
        setMp(this.mp + value);
    }
    public int use(Character target, Move move){
        return move.use(this, target);
    }
    public int use(Character target, Item item){
        item.use(this);
        items.remove(item);

        return 0;
    }
}
