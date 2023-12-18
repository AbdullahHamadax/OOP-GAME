package Classes.Core.Battle;

import Classes.Core.Move;
import Classes.Entity.Enemy;
import Classes.Entity.Player;

import java.util.Scanner;

import static Classes.Core.Utility.printOptionsMenu;
import static Classes.Core.Utility.waitForEnter;

public class FightAction extends ActionStrategy {
    @Override
    public boolean execute(Player player, Enemy[] enemies, Scanner sc) {
        int choice, target = 0;
        String[] moveNames = player.moves.stream().map(Move::getName).toArray(String[]::new);

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
            System.out.println("It was a total miss!");

        else
            System.out.printf("It dealt %d points of damage\n", value);

        waitForEnter(sc);
        return true;
    }
}
