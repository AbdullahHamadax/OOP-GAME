import Classes.Core.ChoiceEvent;
import Classes.Core.DialogueEvent;
import Classes.Core.Game;

import java.awt.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        game.initialize(sc);

//        String [] lines =new String[]{
//                "Narrator: The sun dipped below the horizon, casting long shadows upon the cobblestone streets of the ancient town of Eldoria. The once lively market square now stood empty, the air thick with an eerie silence. Two brave heroes, Sir Tristan and Lady Seraphina, ventured into the heart of the abandoned town, their senses alert to the ominous stillness.",
//                "Sir Tristan: (gruff voice) This place gives me the creeps, Seraphina. It's as if the very stones are watching us.",
//                "Lady Seraphina: (confident) Aye, Tristan, but we can't turn back now. The townsfolk have vanished without a trace, and we must uncover the mystery behind this forsaken place.",
//                "Narrator: As the heroes explored the narrow alleys, the flickering glow of an old lantern revealed a faint trail of footprints leading towards the town square.",
//                "Sir Tristan: (raising his sword) Look there! Fresh footprints. Someone-or something-passed through here recently.",
//                "Lady Seraphina: (gripping her bow) We must tread carefully. Eldoria was known for its enchantments, and rumors spoke of magic woven into its very foundations.",
//                "Narrator: The heroes reached the desolate square, where a dilapidated fountain stood as a monument to the town's former glory."
//        };
//        String[] lines2 = new String[]{
//                "Sir Tristan: (whispering) I sense a presence, Seraphina. Something unnatural.",
//                "Lady Seraphina: (nodding) Agreed. We'll split up to cover more ground, but stay within sight. The heart of this mystery lies here.",
//                "Narrator: Suddenly, a ghostly whisper echoed through the air, sending shivers down their spines.",
//                "Mysterious Voice: (whispering) \"Beware, seekers of truth. The town holds secrets untold, and shadows walk where light once shone.\"",
//                "Sir Tristan: (grimacing) What sorcery is this?",
//                "Lady Seraphina: (focused) We press on. Eldoria may be lost, but we can still uncover the truth and perhaps lift the curse that haunts this forsaken land.",
//                "Narrator: The heroes, undeterred by the mysterious warning, continued their investigation, determined to unravel the secrets hidden within the ghostly echoes of Eldoria."
//        };
//
//        String[] pathChoice = new String[]{
//                "As Jack explores the dense and enchanted forest,",
//                "he stumbles upon a clearing where a mystical portal shimmers",
//                "with an otherworldly light. The air crackles with energy,",
//                "and a faint hum emanates from the portal.",
//                "As Jack approaches, he notices two distinct paths leading to different realms."
//        };
//
//
//
//        DialogueEvent d1 = new DialogueEvent("Introduction", sc, lines);
//        DialogueEvent d2 = new DialogueEvent("SecondIntroduction", sc, lines2);
//        d1.start();
//        d2.start();
//        ChoiceEvent e1= new ChoiceEvent("PathChoice",sc,pathChoice);
//        e1.start();
    }
}