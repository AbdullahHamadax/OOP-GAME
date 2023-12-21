package Classes.Core;

import Classes.Entity.Item;
import Classes.Entity.Player;

import java.util.*;

import static Classes.Core.Utility.*;
import static Classes.Core.Data.*;


public class Game {
    private static final String WELCOME_MESSAGE = Color.GREEN.getColor()+"Greetings, adventurer! The ROGUE REALMS welcomes you!"+ Color.RESET.getColor();
    public static final double slowText = 2, mediumText = 1, fastText = 0.4;


    String[] options = new String[]{"Slow","Fast","Medium"};


    private final HashMap<String, Move> movesTable;
    private final ArrayList<Item> items;

    public void textSpeed(Scanner sc){
        int textSpeedChoice= printOptionsMenu(options,sc,false);
        switch (textSpeedChoice){
            case 1 -> {
                System.out.println("The text speed of the game is now on "+Color.RED.getColor()+"Slow"+Color.RESET.getColor());
                 setGameSpeed(slowText);
            }
            case 2 -> {
                System.out.println("The text speed of the game is now on "+Color.GREEN.getColor()+"Fast"+Color.RESET.getColor());
                setGameSpeed(fastText);
            }
            case 3 -> {
                System.out.println("The text speed of the game is now on "+Color.YELLOW.getColor()+"Medium "+Color.RESET.getColor());
                setGameSpeed(mediumText);
            }
        }
    }

    public Game() {
        movesTable = new HashMap<>();
        items = new ArrayList<>();
    }

    public void initialize(Scanner sc) {
        int choice;

        String[] options = new String[]{"Start game", "Text Speed","Exit"};
        while (true) {
            System.out.flush();
            slowPrint(WELCOME_MESSAGE,48); // original value is 48 but this is for fast testing!!
            clearTerminal();

            choice = printOptionsMenu(options, sc, false);

            switch (choice) {
                case 1 -> startGame(sc);
                case 2 -> textSpeed(sc);
                case 3 -> {
                    System.out.print(Color.MAGENTA.getColor() + "As the games fades to black, your legacy will continue to live in the Rogue Realms, farewell brave adventurer!"+Color.RESET.getColor());
                    System.exit(0);
                }
            }
        }
    }

    private void initItemsTable() {

    }


    private void shop(Scanner in, Player player) {
        Item healingElixir = new Item("Healing Elixir", "Restores a moderate amount of health", 50);
        Item vitalityDraught = new Item("Vitality Draught", "Restores a small amount of health", 30);
        Item celestialTonic = new Item("Celestial Tonic", "Heals a substantial amount of health", 100);
        System.out.println("First Item : Healing Elixir \n Item Description : Restores a moderate amount of health \n Price : 50$ \n ********************************");
        System.out.println("Second Item : Vitality Draught \n Item Description : Restores a small amount of health \n Price : 30$ \n ********************************");
        System.out.println("Third Item : Celestial Tonic \n Item Description : Heals a substantial amount of health \n Price : 100$ \n ********************************");
        System.out.println("Choose the item you need : ");

        int x = in.nextInt();
        switch (x) {
            case 1 -> {
                if (player.getCurrency() >= 50) {
                    player.addItem(healingElixir);
                    player.setCurrency(player.getCurrency() - 50);
                    System.out.println(Color.GREEN.getColor() + "Successfully purchased a Healing Elixir.");
                } else {
                    System.err.println("Sorry! You can't buy a Healing Elixir due to insufficient funds!");
                }
            }
            case 2 -> {
                if (player.getCurrency() >= 30) {
                    player.addItem(vitalityDraught);
                    player.setCurrency(player.getCurrency() - 30);
                    System.out.println(Color.GREEN.getColor() + "Successfully purchased a Vitality Draught.");
                } else {
                    System.err.println("Sorry! You can't buy a Vitality Draught due to insufficient funds!");
                }
            }
            case 3 -> {
                if (player.getCurrency() >= 100) {
                    player.addItem(celestialTonic);
                    player.setCurrency(player.getCurrency() - 100);
                    System.out.println(Color.GREEN.getColor() + "Successfully purchased a Celestial Tonic.");
                } else {
                    System.err.println("Sorry! You can't buy a Celestial Tonic due to insufficient funds!");
                }
            }
            default ->
                    System.err.printf("Sorry! No such item exists with number (%d) , please choose an item between (1-3)\n", x);
        }
    }

    private void printStats(Player player) {
        clearTerminal();
        System.out.println("\n\nPlayer name : " + player.getName());
        System.out.println("Player hp : " + player.getHp() + "/" + player.getMaxHP());
        System.out.println("Player mp : " + player.getMp() + "/" + player.getMaxMP());
        System.out.println("Player str : " + player.getStr());
        System.out.println("Player def : " + player.getDef());
        System.out.println("Player speed : " + player.getSpeed());
        System.out.println("Player level : " + player.getLvl());
        System.out.println("Player total xp : " + player.getTotalXP());
        System.out.println("Player xp till next level : " + player.getXPTillLvl());
    }

    private void startGame(Scanner sc) {
        int choice;
//        BattleManager battleManager = new BattleManager();
        String[] Options = new String[]{"Battle (easy)", "Battle (hard)", "Shop", "Current stats", "multi Enemy Battle test", "Main menu"};
        Random random = new Random(System.currentTimeMillis());
        GameManager gameManager = new GameManager(sc);

        Player player = gameManager.getPlayer();
        gameManager.start();

//        while (true) {
//            clearTerminal();
//
//            choice = printOptionsMenu(Options, sc, false);
//
//            switch (choice) {
//                case 1 -> shop(sc, player);
//                case 2 -> printStats(player);
//                case 3 -> {
//                    return;
//                }
//            }
//
//        }
    }
}
