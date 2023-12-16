package Classes.Core;

import org.w3c.dom.events.EventTarget;

import java.util.Scanner;

public class ChoiceEvent extends Event {
    Scanner sc = new Scanner(System.in);
    Event[] nextEvents ;
    String choiceMessage;
    String[] choices;

    public ChoiceEvent(String eventName, Scanner sc, String choices[]) {
        super(eventName, sc);
        this.choices=choices;
    }


    public Event[] getNextEvents() {
        return nextEvents;
    }

    public void setNextEvents(Event[] nextEvents) {
        this.nextEvents = nextEvents;
    }

    @Override
    public Event start() {
        for (String line : choices) {
            Utility.slowPrint(line , 5);
            System.out.println();
        }
        int choice = Utility.optionsMenu(new String[]{"Enter the Portal of Shadows","Enter the Portal of Radiance"}, sc, false);
        if(choice==1) System.out.println("Entered Portal Of Shadows");
        else System.out.println("Entered Portal Of Radiance");
        return nextEvents[choice-1];
    }
}
