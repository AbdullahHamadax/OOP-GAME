package Classes.Core;

import java.util.Scanner;

public class ChoiceEvent extends Event {
    Event[] nextEvents ;
    String choiceMessage;
    String[] choices;

    public ChoiceEvent(String eventName, String choiceMessage, String[] choices) {
        super(eventName);
        this.choiceMessage = choiceMessage;
        this.choices=choices;
    }


    public Event[] getNextEvents() {
        return nextEvents;
    }

    public void setNextEvents(Event[] nextEvents) {
        this.nextEvents = nextEvents;
    }

    @Override
    public Event start(Scanner sc) {
        for (String line : choices) {
            Utility.slowPrint(line , 5);
            System.out.println();
        }
        int choice = Utility.printOptionsMenu(new String[]{"Enter the Portal of Shadows","Enter the Portal of Radiance"}, sc, false);
        if(choice==1) System.out.println("Entered Portal Of Shadows");
        else System.out.println("Entered Portal Of Radiance");
        return nextEvents[choice-1];
    }
}
