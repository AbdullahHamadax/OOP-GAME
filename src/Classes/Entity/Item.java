package Classes.Entity;

import java.util.HashMap;

public class Item {
    private String itemName;
    private String itemDescription;
    private int itemPrice;
    private HashMap<String, Integer> effects;

    public Item(String itemname, String itemdescription, int itemprice) {
        this.itemName = itemname;
        this.itemDescription = itemdescription;
        this.itemPrice = itemprice;
        this.effects = new HashMap<>();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public HashMap<String, Integer> getEffects() {
        return effects;
    }

    public void setEffects(HashMap<String, Integer> effects) {
        this.effects = effects;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void use(Character character) {
        effects.forEach((key, value) -> {
            switch (key) {
                case "HP" -> character.updateHp(value);
                case "MP" -> character.updateMp(value);
                case "STR" -> character.updateStr(value);
                case "DF" -> character.updateDef(value);
                case "SPD" -> character.setSpeed(value);
                case "BATTLE_STR" -> character.updatBattleStr(value);
                case "BATTLE_SPEED" -> character.setBattleSpeed(value);
                case "BATTLE_DEF" -> character.setBattleDef(value);
            }
        });

    }
}


