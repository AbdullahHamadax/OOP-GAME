package Classes.core.battle;

import Classes.core.Utility;
import Classes.core.Utility.Color;
import Classes.entity.Enemy;
import Classes.entity.Player;

import java.util.ArrayList;
import java.util.Scanner;

import static Classes.core.Utility.printOptionsMenu;
import static Classes.core.Utility.waitForEnter;

public class FightAction extends ActionStrategy {
    @Override
    public boolean execute(Player player, Enemy[] enemies, Scanner sc) {
        int choice, target = 0;
        String[] moveNames = new String[player.moves.size()];
        String[] movePower = new String[player.moves.size()];
        String[] moveAccuracy = new String[player.moves.size()];

        for(int i = 0; i < moveNames.length; i++) {
            moveNames[i] = player.moves.get(i).getName()+ " (ac: "+player.moves.get(i).getAccuracy() +"% "+ " || pow: "+player.moves.get(i).getPower() + ")";
        }

        choice = printOptionsMenu(moveNames, sc, true);
        if (choice == -1)
            return false;

        choice--;

        if (enemies.length > 1)
            target = selectTarget(enemies, sc);

        if (target == -1)
            return false;

        System.out.printf("%s chose to use %s on %s\n", player.getName(), player.moves.get(choice).getName(), enemies[target].getName());
        int value = player.use(enemies[target], player.moves.get(choice));

        if (value == -1)
            System.out.println("It was a total " +Color.CYAN.getColor()+"miss!"+Color.RESET.getColor());

        else
            System.out.printf("It dealt %d points of damage\n", value);

        waitForEnter(sc);
        return true;
    }
}
