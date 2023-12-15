package Classes.Core;

import java.util.Scanner;

public class BattleEvent extends Event {
    private Event next;

    public BattleEvent(String eventName, Scanner sc) {
        super(eventName, sc);
    }

    public Event getNext() {
        return next;
    }

    public void setNext(Event next) {
        this.next = next;
    }

    @Override
    public Event start() {
        return null;
    }
}
