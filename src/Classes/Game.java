package Classes;

import Classes.Entity.Character;
import Classes.Entity.Enemy;
import Classes.Entity.Item;
import Classes.Entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import static Classes.Util.optionsMenu;
import static Classes.Util.printTitle;
import static Classes.Util.Color;
import static Classes.Util.clearTerminal;

import static java.lang.Math.max;

public class Game {
    private static final String WELCOME_MESSAGE = "Greetings, adventurer! The ROGUE REALMS welcomes you!";


    private final HashMap<String, Move> movesTable;
    private final ArrayList<Item> items;

    public Game() {
        movesTable = new HashMap<>();
        items = new ArrayList<>();
    }

    public void initialize(Scanner sc) {
        int choice;

        String[] options = new String[]{"Start game", "Exit"};

        while (true) {
            System.out.flush();
            printTitle(WELCOME_MESSAGE);

            choice = optionsMenu(options, sc, false);

            switch (choice) {
                case 1 -> startGame(sc);
                case 2 -> {
                    System.out.print(Color.MAGENTA.getColor() + "As the games fades to black, your legacy will continue to live in the Rogue Realms, farewell brave adventurer!"+Color.RESET.getColor());
                    System.exit(0);
                }
            }
        }
    }

    private void initMovesTable() {
        this.movesTable.put("Punch", new Move("Punch", 5, 0, 0, 90));
        this.movesTable.put("Kick", new Move("Kick", 7, 0, 1, 75));
        this.movesTable.put("Slap", new Move("Slap", 3, 0, 2, 100));
        this.movesTable.put("Scratch", new Move("Scratch", 3, 0, 0, 95));
        this.movesTable.put("Bite", new Move("Bite", 2, 0, 3, 65));
    }

    private void initItemsTable() {

    }

    private Player initPlayer() {
        ArrayList<Move> moves = new ArrayList<>();

        moves.add(this.movesTable.get("Punch"));
        moves.add(this.movesTable.get("Kick"));
        moves.add(this.movesTable.get("Slap"));

        return new Player("jack", 80, 20, 10, 10, 20, moves);
    }

    private Enemy initEasyEnemy(int playerLvl) {
        ArrayList<Move> moves = new ArrayList<>();
        double lvlMultiplier = playerLvl * 0.15 + 1;

        moves.add(this.movesTable.get("Bite"));
        moves.add(this.movesTable.get("Scratch"));

        return new Enemy("wil", (int) (25 * lvlMultiplier), (int) (10 * lvlMultiplier),
                (int) (5 * lvlMultiplier), (int) (5 * lvlMultiplier), (int) (5 * lvlMultiplier), moves, (int) (5 * lvlMultiplier));

    }

    private Enemy initHardEnemy(int playerLvl) {
        ArrayList<Move> moves = new ArrayList<>();
        double lvlMultiplier = playerLvl * 0.15 + 1;

        moves.add(this.movesTable.get("Punch"));
        moves.add(this.movesTable.get("Kick"));
        moves.add(this.movesTable.get("Slap"));
        moves.add(this.movesTable.get("Scratch"));

        return new Enemy("wil2", (int) (50 * lvlMultiplier), (int) (10 * lvlMultiplier), (int) (10 * lvlMultiplier),
                (int) (10 * lvlMultiplier), (int) (8 * lvlMultiplier), moves, (int) (15 * lvlMultiplier));
    }

    private void shop(Scanner in, Player player) {
        Item healingElixir = new Item("Healing Elixir", "Restores a moderate amount of health", 50);
        Item vitalityDraught = new Item("Vitality Draught", "Restores a small amount of health", 30);
        Item celestialTonic = new Item("Celestial Tonic", "Heals a substantial amount of health", 100);
        System.out.println("First Item : Healing Elixir \n Item Description : Restores a moderate amount of health \n Price : 50$ \n ********************************");
        System.out.println("Second Item : Vitality Draught \n Item Description : Restores a small amount of health \n Price : 30$ \n ********************************");
        System.out.println("Third Item : Celestial Tonic \n Item Description : Heals a substantial amount of health \n Price : 100$ \n ********************************");
        System.out.println("Choose the Item you need : ");

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
        BattleManager battleManager = new BattleManager();

        String[] Options = new String[]{"Battle (easy)", "Battle (hard)", "Shop", "Current stats", "Main menu"};
        Random random = new Random(System.currentTimeMillis());

        initMovesTable();
        Player player = initPlayer();

        while (true) {
            clearTerminal();

            choice = optionsMenu(Options, sc, false);

            switch (choice) {
                case 1 -> battleManager.createBattle(player, this.initEasyEnemy(player.getLvl()), sc, random);
                case 2 -> battleManager.createBattle(player, this.initHardEnemy(player.getLvl()), sc, random);
                case 3 -> shop(sc, player);
                case 4 -> printStats(player);
                case 5 -> {
                    return;
                }
            }

        }
    }
}
