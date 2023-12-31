package classes.core.battle;

import classes.core.Utility;
import classes.entity.Character;
import classes.entity.Enemy;
import classes.entity.Player;

import java.util.Scanner;

import static classes.core.Utility.*;

public class ObserveAction extends ActionStrategy{
    @Override
    protected boolean execute(Player player, Enemy[] enemies, Scanner sc) {
        int choice;

        String[] options = new String[1 + enemies.length];
        options[0] = "Current stats";
        for (int i = 1; i < options.length; i++)
            options[i] = enemies[i - 1].getName() + "'s stats";

        choice = printOptionsMenu(options, sc, true);
        if (choice == -1)
            return false;

        if (choice == 1)
            printCharacterStats(player, sc);

        else
            printCharacterStats(enemies[choice - 2], sc);

        return false;
    }
    private void printCharacterStats(Character character, Scanner sc) {
        clearTerminal();
        System.out.printf("Name : %s\n", character.getName());
        System.out.printf("hp : %d/%d\n", character.getMaxHP(), character.getHp());
        System.out.printf("sp : %d/%d\n", character.getMaxMP(), character.getMaxMP());

        if(character.getBattleStr() > character.getStr())
            System.out.printf("str : %s%d%s\n", Utility.Color.GREEN, character.getBattleStr(), Utility.Color.RESET);
        else if(character.getBattleStr() < character.getStr())
            System.out.printf("str : %s%d%s\n", Utility.Color.RED, character.getBattleStr(), Utility.Color.RESET);
        else
            System.out.printf("str : %d\n", character.getBattleStr());


        if(character.getBattleDef() > character.getDef())
            System.out.printf("def : %s%d%s\n", Utility.Color.GREEN, character.getBattleDef(), Utility.Color.RESET);
        else if(character.getBattleDef() < character.getDef())
            System.out.printf("def : %s%d%s\n", Utility.Color.RED, character.getBattleDef(), Utility.Color.RESET);
        else
            System.out.printf("def : %d\n", character.getBattleDef());

        if(character.getBattleSpeed() > character.getSpeed())
            System.out.printf("spd : %s%d%s\n", Utility.Color.GREEN, character.getBattleSpeed(), Utility.Color.RESET);
        else if(character.getBattleSpeed() < character.getSpeed())
            System.out.printf("spd : %s%d%s\n", Utility.Color.RED, character.getBattleSpeed(), Utility.Color.RESET);
        else
            System.out.printf("spd : %d\n", character.getBattleSpeed());

        waitForEnter(sc);
    }
}
