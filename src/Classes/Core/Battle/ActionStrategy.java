package Classes.Core.Battle;

import Classes.Entity.Enemy;
import Classes.Entity.Player;

import java.util.Arrays;
import java.util.Scanner;

import static Classes.Core.Utility.printOptionsMenu;

public abstract class ActionStrategy {

    protected abstract boolean execute(Player player, Enemy[] enemies, Scanner sc);

    protected int selectTarget(Enemy[] enemies, Scanner sc) {
        String message = "Select ENEMY TO ATTACK!";
        String[] enemyNames = Arrays.stream(enemies).map(Enemy::getName).toArray(String[]::new);


        int choice = printOptionsMenu(enemyNames, sc, true, message);
        if (choice == -1)
            return -1;

        return choice - 1;

    }
}
