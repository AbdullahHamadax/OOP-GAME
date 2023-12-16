package Classes.Core;

import java.util.Scanner;

public class DialogueEvent extends Event {
    Event next;
    String[] lines;

    public DialogueEvent(String eventName, Scanner sc, String[] lines) {
        super(eventName, sc);
        this.lines = lines;
    }

    @Override
    public Event start() {
        for (String line : lines) {
            Utility.slowPrint(line , 5);
            System.out.println();
        }
        Utility.slowPrint(Utility.PRESS_ENTER_MESSAGE, 10);
        sc.nextLine();
        return next;
    }
}
