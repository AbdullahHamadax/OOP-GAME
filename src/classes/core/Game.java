package classes.core;

import classes.entity.Item;
import classes.entity.Player;

import java.util.*;

import static classes.core.Utility.*;
import static classes.core.Data.*;


public class Game {
    private static final String WELCOME_MESSAGE = Color.GREEN.getColor()+"Greetings, adventurer! The ROGUE REALMS welcomes you!"+ Color.RESET.getColor();
    public static final double slowText = 2, mediumText = 1, fastText = 0.4;


    String[] options = new String[]{"Slow","Fast","Medium"};


    private final HashMap<String, Move> MOVES_TABLE;
    private final ArrayList<Item> ITEMS;

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
        MOVES_TABLE = new HashMap<>();
        ITEMS = new ArrayList<>();
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
                    System.out.println(Color.MAGENTA.getColor() + "As the games fades to black, your legacy will continue to live in the Rogue Realms, farewell brave adventurer!"+Color.RESET.getColor());
                    System.exit(0);
                }
            }
        }
    }

    private void initItemsTable() {

    }
    public static void printProduct(Scanner sc,ArrayList<Item> product,Player player){
        for(int i=0;i<product.size();i++){
            System.out.println((i+1)+" Item : " + product.get(i));
        }
        System.out.println("Press 0 To Quit The Shop");
        System.out.println("Choose The Item You Need : ");
        int x = sc.nextInt();
        while(x != 0){
                if (player.getCurrency() >= product.get(x - 1).getItemPrice()) {
                    player.addItem(product.get(x-1));
                    player.setCurrency(player.getCurrency() - product.get(x - 1).getItemPrice());
                    System.out.println(Color.GREEN.getColor() + "Successfully purchased a "+product.get(x - 1).getItemName());
                } else {
                    System.err.println("Sorry! You can't buy a "+product.get(x - 1).getItemName() +"due to insufficient funds!");
                }
                System.out.print("Choose Other Item You Need ( If You Want To Exit Shop Press 0 ) : ");
                x = sc.nextInt();
        }

    }
    private void shop(Scanner sc, Player player,ArrayList<Item> product ) {
        product = new ArrayList<>();
        product.add(new Item("Healing Elixir", "Restores a moderate amount of health", 50));
        product.add(new Item("Vitality Draught", "Restores a small amount of health", 30));
        product.add(new Item("Celestial Tonic", "Heals a substantial amount of health", 100));
        printProduct(sc,product,player );

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

//        while (true)
//        {
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
