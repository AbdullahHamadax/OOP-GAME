package Classes.Core.Battle;

import Classes.Entity.Enemy;
import Classes.Entity.Item;
import Classes.Entity.Player;

import java.util.Scanner;

import static Classes.Core.Utility.printOptionsMenu;

public class ItemAction extends ActionStrategy{
    @Override
    protected boolean execute(Player player, Enemy[] enemies, Scanner sc) {
        int choice;
        String[] options = player.items.stream().map(Item::getItemName).toArray(String[]::new);
        choice = printOptionsMenu(options, sc, true);

        if(choice == -1)
            return false;

        player.items.get(choice - 1).use(player);
        return true;
    }
}
