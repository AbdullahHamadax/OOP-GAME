package classes.entity;


public class Player extends Character {
    private int totalXP, XPTillLvl;
    private int currency = 0;

    public Player(String name, int maxHP, int maxMP, int str, int def, int speed) {
        super(name, maxHP, maxMP, str, def, speed);
        this.totalXP = CalculateXPTillLvl(this.getLvl());
        this.XPTillLvl = CalculateXPTillLvl(this.getLvl() + 1);
    }

    private int CalculateXPTillLvl(int lvl) {
        final double XPCONST1 = 0.3;
        final double XPCONST2 = 2.0;
        return (int) ((lvl / XPCONST1) * XPCONST2) + this.getTotalXP();
    }

    private void levelUp() {
        this.setLvl(this.getLvl() + 1);
        this.currency += 100;
    }

    public int getTotalXP() {
        return totalXP;
    }

    public int getXPTillLvl() {
        return XPTillLvl;
    }

    public void setTotalXP(int totalXP) {
        this.totalXP = totalXP;
        while (this.totalXP >= this.XPTillLvl) {
            levelUp();
            System.out.println("PLAYER LEVELED UP!! he is now level " + this.getLvl());
            this.XPTillLvl = CalculateXPTillLvl(this.getLvl() + 1);
            updateStats();
            this.restore();
        }
    }

    public void updateStats() {
        this.setMaxHP((int) (this.getMaxHP() * (1.25)));
        this.setMaxMP((int) (this.getMaxMP() * (1.25)));
        this.setStr(this.getStr() + 1);
        this.setDef(this.getDef() + 1);

    }

    public void updateTotalXP(int value) {
        setTotalXP(this.totalXP + value);
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
}
