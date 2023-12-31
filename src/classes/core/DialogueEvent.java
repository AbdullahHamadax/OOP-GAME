package Classes.core;

import java.util.Scanner;

public class DialogueEvent extends Event {
    String[] lines;
    Event next;
    public DialogueEvent(String eventName, String[] lines) {
        super(eventName);
        this.lines = lines;
    }

    @Override
    public Event start(Scanner sc) {
        for (String line : lines) {
            Utility.slowPrint(line , 5);
            System.out.println();
        }
        Utility.slowPrint(Utility.PRESS_ENTER_MESSAGE, 10);
        sc.nextLine();
        Utility.clearTerminal();
        return next;
    }
}
