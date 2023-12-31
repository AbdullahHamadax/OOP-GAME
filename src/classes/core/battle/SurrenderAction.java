package Classes.core.battle;

import Classes.core.Utility;
import Classes.entity.Enemy;
import Classes.entity.Player;

import java.util.Scanner;

import static Classes.core.Utility.waitForEnter;

public class SurrenderAction extends ActionStrategy{
    @Override
    protected boolean execute(Player player, Enemy[] enemies, Scanner sc) {
        player.setHp(-1);
        System.out.println(Utility.Color.MAGENTA.getColor() + "The battle-worn adventurer " + player.getName() + " raises their hands in surrender.");

        waitForEnter(sc);

        return true;
    }
}
