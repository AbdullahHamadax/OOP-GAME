//package classes.core.battle;
//
//import classes.core.Game;
//import classes.entity.Enemy;
//import classes.entity.Player;
//import classes.core.Game;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//import static classes.core.Utility.printOptionsMenu;
//
//public class SaveAction extends ActionStrategy {
//
//    @Override
//    protected boolean execute(Player player, Enemy[] enemies, Scanner sc) {
//        try {
//            Game.saveGame(currentGame);
//            System.out.println("Game saved successfully!");
//            return true;
//        } catch (Exception e) {
//            System.out.println("Error! Couldn't save the game.");
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    protected int selectTarget(Enemy[] enemies, Scanner sc) {
//        return -1;
//    }
//}
