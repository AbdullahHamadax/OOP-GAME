package Classes.Core.Battle;

import Classes.Entity.Enemy;
import Classes.Entity.Item;
import Classes.Entity.Player;

import java.util.ArrayList;
import java.util.Scanner;

import static Classes.Core.Utility.printOptionsMenu;

public class ItemAction extends ActionStrategy{
    @Override
    protected boolean execute(Player player, ArrayList<Enemy> enemies, Scanner sc) {
        int choice;
        String[] itemNames = new String[enemies.size()];
//        String[] options = player.items.stream().map(Item::getItemName).toArray(String[]::new);

        for(int i = 0; i < enemies.size(); i++)
            itemNames[i] = enemies.get(i).getName();

        choice = printOptionsMenu(itemNames, sc, true);

        if(choice == -1)
            return false;

        player.items.get(choice - 1).use(player);
        return true;
    }
}
