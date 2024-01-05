package classes.core.battle;

import classes.core.Utility;
import classes.entity.Enemy;
import classes.entity.Player;

import java.util.Scanner;

import static classes.core.Utility.waitForEnter;

public class SurrenderAction extends ActionStrategy {
    @Override
    protected boolean execute(Player player, Enemy[] enemies, Scanner sc) {
        player.setHp(-1);
        System.out.println(Utility.Color.MAGENTA.getColor() + "The battle-worn adventurer " + player.getName() + " raises their hands in surrender.");

        waitForEnter(sc);

        return true;
    }
}
