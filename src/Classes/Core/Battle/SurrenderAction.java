package Classes.Core.Battle;

import Classes.Core.Utility;
import Classes.Entity.Enemy;
import Classes.Entity.Player;

import java.util.Scanner;

import static Classes.Core.Utility.waitForEnter;

public class SurrenderAction extends ActionStrategy{
    @Override
    protected boolean execute(Player player, Enemy[] enemies, Scanner sc) {
        player.setHp(-1);
        System.out.println(Utility.Color.MAGENTA.getColor() + "The battle-worn adventurer " + player.getName() + " raises their hands in surrender.");

        waitForEnter(sc);

        return true;
    }
}
