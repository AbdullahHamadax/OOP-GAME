import Classes.Core.BattleManager;
import Classes.Core.Game;
import Classes.Core.Move;
import Classes.Core.Utility;
import Classes.Entity.Enemy;
import Classes.Entity.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {


    private static Enemy createShadowSpawn(){
        ArrayList<Move> moves = new ArrayList<>();
        moves.add(new Move("Slash", 7, 0, 0, 100));
        moves.add(new Move("Cut", 10, 0, 1, 75));
        moves.add(new Move("Death Slice", 20, 0, 2, 45));
        moves.add(new Move("Dark Ball", 9, 0, 3, 95));

        return new Enemy("ShadowSpawn", 40, 20, 9, 10, 14, moves, 35);
    }

    private static Player createPlayer(){
        ArrayList<Move> moves = new ArrayList<>();
        moves.add(new Move("Slice", 25, 0, 0, 80));
        moves.add(new Move("Slam", 35, 0, 1, 75));
        moves.add(new Move("Strike", 15, 0, 2, 95));
        moves.add(new Move("Almighty Slash", 50, 0, 3, 65));

        return new Player("Sir Tristan", 150, 40, 20, 25, 20, moves);
    }
    public static void main(String[] args) {
//        Game game = new Game();
//        Scanner sc = new Scanner(System.in);
//        game.initialize(sc);
        Utility.clearTerminal();
        Scanner sc = new Scanner(System.in);
        String[][] storyText = {
                {
                        "Narrator: The sun dipped below the horizon, casting long shadows upon the cobblestone streets of the ancient town of Eldoria. The once lively market square now stood empty, the air thick with an eerie silence. Two brave heroes, Sir Tristan and Lady Seraphina, ventured into the heart of the abandoned town, their senses alert to the ominous stillness.",
                        "Sir Tristan: (gruff voice) This place gives me the creeps, Seraphina. It's as if the very stones are watching us.",
                        "Lady Seraphina: (confident) Aye, Tristan, but we can't turn back now. The townsfolk have vanished without a trace, and we must uncover the mystery behind this forsaken place.",
                        "Narrator: As the heroes explored the narrow alleys, the flickering glow of an old lantern revealed a faint trail of footprints leading towards the town square.",
                        "Sir Tristan: (raising his sword) Look there! Fresh footprints. Someone-or something-passed through here recently.",
                        "Lady Seraphina: (gripping her bow) We must tread carefully. Eldoria was known for its enchantments, and rumors spoke of magic woven into its very foundations.",
                        "Narrator: The heroes reached the desolate square, where a dilapidated fountain stood as a monument to the town's former glory."
                },
                {
                        "Sir Tristan: (whispering) I sense a presence, Seraphina. Something unnatural.",
                        "Lady Seraphina: (nodding) Agreed. We'll split up to cover more ground, but stay within sight. The heart of this mystery lies here.",
                        "Narrator: Suddenly, a ghostly whisper echoed through the air, sending shivers down their spines.",
                        "Mysterious Voice: (whispering) \"Beware, seekers of truth. The town holds secrets untold, and shadows walk where light once shone.\"",
                        "Sir Tristan: (grimacing) What sorcery is this?",
                        "Lady Seraphina: (focused) We press on. Eldoria may be lost, but we can still uncover the truth and perhaps lift the curse that haunts this forsaken land.",
                        "Narrator: The heroes, undeterred by the mysterious warning, continued their investigation, determined to unravel the secrets hidden within the ghostly echoes of Eldoria."
                },
                {
                        "Narrator: As Sir Tristan and Lady Seraphina advanced through the deserted town, their steps echoed in the emptiness. The air grew thicker, and the flickering lantern light cast eerie shadows on the ancient buildings. Suddenly, a guttural growl pierced the silence, and the heroes found themselves surrounded by a pack of shadowy creatures with glowing eyes.",
                        "Sir Tristan: (raising his sword) By the gods! What foul creatures are these?",
                        "Lady Seraphina: (nocking an arrow) Stay close, Tristan. We're not alone.",
                        "Narrator: The creatures, known as Shadowspawn, moved with unnatural speed, their forms shifting between the darkness and the dim light.",
                        "Sir Tristan: It seems those fiends are looking for a fight!",
                        "Lady Seraphina: Well, let us swiftly take care of them",
                }

        };
        String[][] afterBattleText = {
                {
                        "Narrator: The clash of steel and the twang of arrows had echoed through the deserted town square as Sir Tristan and Lady Seraphina valiantly battled the Shadowspawn. Now, the creatures lay defeated, their ethereal forms dissipating into the shadows.",
                        "Sir Tristan: (sheathing his sword) That was quite the skirmish. These Shadowspawn are unlike anything I've encountered before.",
                        "Lady Seraphina: (lowering her bow) Agreed, Tristan. And did you catch that cryptic message from the mysterious voice again?",
                        "Narrator: As the heroes caught their breath, the voice returned, its words lingering in the air.",
                        "Mysterious Voice: \"The shadows hunger for the light, and the light seeks refuge in the heart of darkness.\"",
                        "Sir Tristan: (frowning) More riddles. But this time, it feels like a warning."
                },
                {

                        "Lady Seraphina: (thoughtful) Perhaps there's a connection between the creatures and the enchantments in this town.",
                        "Narrator: The heroes turned their attention to the ancient fountain at the center of the square, its magic still shimmering faintly.",
                        "Sir Tristan: (gesturing to the fountain) This fountain seems to be at the center of it all. We should investigate.",
                        "Lady Seraphina: (approaching the fountain) Eldoria was known for its magical relics. This fountain might hold the key to understanding the town's fate.",
                },
                {
                        "Narrator: As the heroes examined the fountain, they discovered inscriptions in an ancient language, detailing a ritual that bound the town to a mystical force. It spoke of a delicate balance between light and shadow that had been disrupted, leading to the disappearance of the townsfolk.",
                        "Sir Tristan: (gruffly) We need to restore this balance. The fate of Eldoria depends on it.",
                        "Lady Seraphina: (nodding) Agreed, Tristan. We must find the source of this disturbance and rectify it.",
                        "Narrator: Armed with newfound knowledge, Sir Tristan and Lady Seraphina continued their quest, delving deeper into Eldoria's mysteries. The ominous aura lingered, but the heroes were determined to uncover the truth and bring light to the shadows that now gripped the ancient town."
                }
        };

        String[] crucialDecisionText = {
                "Narrator: With the fate of Eldoria hanging in the balance, Sir Tristan and Lady Seraphina faced a crucial decision at the fountain's base. The inscriptions hinted at two possible courses of action.",
                "Sir Tristan: (scrutinizing the inscriptions) It seems we have a choice to make, Seraphina.",
                "Lady Seraphina: (studying the runes) Aye, Tristan. The first option speaks of restoring the balance through a ceremonial offering at the town's ancient altar. The second suggests seeking guidance from the reclusive sage, Amara, who dwells in the hidden grove beyond the outskirts."
        };

        String[] choiceOne = {
                "Sir Tristan: (determined) Let's make our way to the ancient altar. A ceremonial offering might appease the magic and restore the balance.",
                "Lady Seraphina: (nodding) Agreed, Tristan. It's a more direct approach, and time is of the essence."
        };

        String[] choiceTwo = {
                "Lady Seraphina: (thoughtful) The sage, Amara, might hold the knowledge we need. Let's journey to the hidden grove and seek her guidance.",
                "Sir Tristan: (raising an eyebrow) A more unconventional path, but if it leads to answers, then I'm with you, Seraphina.",
                "Narrator: The heroes, their decision made, set forth on their chosen path. The ancient town of Eldoria awaited the resolution of its mystical imbalance, and the unfolding adventure would be shaped by the choices made by Sir Tristan and Lady Seraphina."
        };

        for (String[] strings : storyText) {
            for (String line : strings)
                Utility.slowPrint(line + "\n", 10);

            System.out.print(Utility.PRESS_ENTER_MESSAGE);
            sc.nextLine();
            Utility.clearTerminal();
        }

        Enemy enemy = createShadowSpawn();
        Player player = createPlayer();

        BattleManager battleManager = new BattleManager();
        int battleOutcome = battleManager.initiateBattle(player, enemy, sc, new Random());
        Utility.clearTerminal();

        if(battleOutcome == 1){
            for (String[] strings : afterBattleText) {
                for (String line : strings)
                    Utility.slowPrint(line + "\n", 10);

                System.out.print(Utility.PRESS_ENTER_MESSAGE);
                sc.nextLine();
                Utility.clearTerminal();
            }

            for(String line : crucialDecisionText)
                Utility.slowPrint(line + "\n", 10);

            System.out.print(Utility.PRESS_ENTER_MESSAGE);
            sc.nextLine();

            int choice = Utility.optionsMenu(new String[]{"Choose the Ancient Altar", "Seek Guidance from Sage Amara"}, sc, false);
            if(choice == 1){
                for(String line : choiceOne)
                    Utility.slowPrint(line + "\n", 10);

            }
            else if(choice == 2){
                for(String line : choiceTwo)
                    Utility.slowPrint(line + "\n", 10);

            }
        }
        else{
            System.out.print(Utility.Color.RED.getColor() + "Game end!" + Utility.Color.RESET.getColor());
            System.out.print(Utility.PRESS_ENTER_MESSAGE);
            sc.nextLine();
            System.exit(0);
        }
    }
}