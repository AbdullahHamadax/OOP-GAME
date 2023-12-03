package Classes;

import Classes.Entity.Character;
import Classes.Entity.Enemy;
import Classes.Entity.Player;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import static Classes.Util.*;
import static java.lang.Math.max;

public class BattleManager {
    private final String[] playerActions = new String[]{"Fight", "Observe", "Surrender", "Use item"};


    public static String constructString(String s, int width){
        StringBuilder output = new StringBuilder(" ".repeat(width - 2));
        int start = width/2 - s.length()/2;
        for(int i = start, j = 0; j < s.length(); i++, j++)
            output.setCharAt(i, s.charAt(j));

        return output.toString();
    }
    private int checkIfBattleStatus(Character player, Character enemy) {
        if (player.getHp() == 0)
            return 2;
        else if (enemy.getHp() == 0)
            return 1;

        return 0;
    }
    private String printCurrentBattleStats(Player player, Enemy enemy, int turn){
        int width = max(player.getName().length(), enemy.getName().length()) * 2 + 15;
        StringBuilder message = new StringBuilder();

        String[] playerSection = new String[3];
        String[] enemySection = new String[3];

        message.append("*".repeat(12)).append("\n");
        message.append("Turn : ").append(turn).append("\n");
        message.append("*".repeat(width * 2 + 1)).append("\n");

        playerSection[0] = constructString(String.format("Name: %s", player.getName()), width);
        playerSection[1] = constructString(String.format("HP: %d/%d", player.getHp(), player.getMaxHP()), width);
        playerSection[2] = constructString(String.format("SP: %d/%d", player.getMp(), player.getMaxMP()), width);

        enemySection[0] = constructString(String.format("Name: %s", enemy.getName()), width);
        enemySection[1] = constructString(String.format("HP: %d/%d", enemy.getHp(), enemy.getMaxHP()), width);
        enemySection[2] = constructString(String.format("SP: %d/%d", enemy.getMp(), enemy.getMaxMP()), width);

        for(int i = 0; i < 3; i++)
            message.append(playerSection[i]).append("||").append(enemySection[i]).append("\n");

        message.append("*".repeat(width * 2 + 1));
        return message.toString();
    }

    private void printCharacterStats(Character character, Scanner sc){
        clearTerminal();
        System.out.println(character.getName());
        // will continue it later too lazy (someone else do it for me)
        sc.nextLine();
        System.err.println("Press enter to continue....");
        sc.nextLine();
    }

    private void playerTurn(Player player, Scanner sc, Enemy enemy, String currentStats){
        boolean notDone = true;
        int choice;

        while(notDone){

            choice = optionsMenu(playerActions, sc, false, currentStats);

            switch (choice){
                case 1 -> {
                    String[] moveNames = new String[player.moves.size()];
                    for (int i = 0; i < player.moves.size(); i++)
                        moveNames[i] = player.moves.get(i).getName();

                    System.out.println("Moves list : ");
                    choice = optionsMenu(moveNames, sc, true);
                    if(choice == -1)
                        break;

                    choice--;
                    System.out.printf("%s chose to use %s\n", player.getName(), player.moves.get(choice).getName());
                    int value = player.use(enemy, player.moves.get(choice));

                    if(value == -1)
                        System.out.println("it was a total miss");

                    else
                        System.out.printf("it dealt %d points of damage\n", value);
                    System.err.print(PRESS_ENTER);
                    sc.nextLine();
                    notDone = false;
                }
                case 2 -> {
                    String[] options = new String[]{"Current stats", enemy.getName() + "'s stats"};
                    choice = optionsMenu(options, sc,true);
                    if(choice == -1)
                        break;

                    switch (choice) {
                        case 1 -> printCharacterStats(player, sc);
                        case 2 -> printCharacterStats(enemy, sc);
                    }
                }
                case 3 ->{
                    player.setHp(-1);
                    slowPrint("You surrender like a loser hehehahhahah!\n", 50);


                    System.err.print(PRESS_ENTER);
                    sc.nextLine();

                    notDone = false;

                }
                case 4 -> System.out.println("Coming soon!!");

            }
        }
    }

    private void executePlayerFight(Player player, Enemy enemy, Scanner sc){

    }

    private void enemyTurn(Enemy enemy, Scanner sc, Player player, Random random, String battleMessage){
        int choice;

        System.out.print(battleMessage);
        System.out.println();
        System.out.println("It is " + enemy.getName() + "'s turn!");
        choice = random.nextInt(enemy.moves.size());
        System.out.printf("%s chose to use %s\n", enemy.getName(), enemy.moves.get(choice).getName());
        int value = enemy.use(player, enemy.moves.get(choice));
        if(value == -1)
            System.out.println("it was a total miss");

        else
            System.out.printf("it dealt %d points of damage\n", value);

        System.err.print(PRESS_ENTER);
        sc.nextLine();
    }

    public void createBattle(Player player, Enemy enemy, Scanner sc, Random random){

        boolean battleOngoing = true;
        Character[] battleChars = {player, enemy};
        int turnCounter = 1;
        String battleTitle = String.format("%s%s%s vs %s%s%s",
                Color.BLUE.getColor(), player.getName(), Color.RESET.getColor(), Color.RED.getColor(), enemy.getName(), Color.RESET.getColor());
        printTitle(battleTitle);

        sc.nextLine();
        System.out.print(PRESS_ENTER);
        sc.nextLine();

        for(Character chara : battleChars)
            chara.enterBattleState();


        while(battleOngoing){

            Arrays.sort(battleChars, Comparator.comparingInt(Character::getBattleSpeed).reversed());
            for(Character entity : battleChars){
                clearTerminal();
                String currentStatsMessage = printCurrentBattleStats(player, enemy, turnCounter);

                if(entity == player){
                    playerTurn(player, sc, enemy, currentStatsMessage);
                    sc.nextLine();
                }

                else
                    enemyTurn(enemy, sc, player, random, currentStatsMessage);

                int result = checkIfBattleStatus(player, enemy);

                if (result == 1) {

                    clearTerminal();

                    int xpGained = enemy.getXpValue();

                    System.out.printf("Battle is over! %s won!\n", player.getName());
                    player.updateTotalXP(enemy.getXpValue());
                    System.out.printf("%s gained %d xp! he needs %d more xp to reach level %d\n", player.getName(), xpGained, player.getXPTillLvl() - player.getTotalXP(), player.getLvl() + 1);

                    System.err.print(PRESS_ENTER);
                    sc.nextLine();

                    battleOngoing = false;
                    break;
                } else if (result == 2) {

                    clearTerminal();

                    int xpGained = max(enemy.getXpValue() / 2, 1);
                    System.out.printf("Battle is over! %s lost!\n", player.getName());
                    player.updateTotalXP(xpGained);
                    System.out.printf("%s gained %d xp! he needs %d more xp to reach level %d\n", player.getName(), xpGained, player.getXPTillLvl() - player.getTotalXP(), player.getLvl() + 1);

                    player.restore();

                    System.err.print(PRESS_ENTER);
                    sc.nextLine();

                    battleOngoing = false;
                    break;
                }
            }
            turnCounter++;

        }

    }
}
