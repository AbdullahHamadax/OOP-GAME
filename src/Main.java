import Classes.Entity.Player;
import Classes.Game;

import Classes.Entity.Character;

import java.util.*;

public class Main {

//    static void battle(Character player, Character enemy, Scanner inputScanner, RandomGenerator random){
//        int turnCounter = 1, choice = 0;
//
//        Character current = null;
//        PriorityQueue<Character> battleQueue = new PriorityQueue<>(new The_Comparator());
//        System.out.println(player.getName() + " vs " + enemy.getName());
//
//        while(true){
//            battleQueue.add(player);
//            battleQueue.add(enemy);
//            System.out.println("It is now turn " + turnCounter);
//
//            while(!battleQueue.isEmpty()){
//                current = battleQueue.poll();
//                System.out.println("It is " + current.getName() + "'s turn!");
//
//                if(current == player){
//                    System.out.println("Please choose your move : ");
//                    for(int i = 0; i < current.moves.size(); i++){
//                        String name = current.moves.get(i).getName();
//                        System.out.printf("%d. %s", i+1, name);
//                    }
//
//                    choice = inputScanner.nextInt() - 1;
//                    current.use()
//
//                    }
//
//                }
//                else{
//                    choice = random.nextInt();
//
//                    switch (choice){
//                        case 1:
//                            break;
//                        case 2:
//                            break;
//                        case 3:
//                            break;
//                        default:
//                            break;
//                    }
//                }
//
//            }
//
//        }
//    }


    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        game.initialize(sc);

    }
}