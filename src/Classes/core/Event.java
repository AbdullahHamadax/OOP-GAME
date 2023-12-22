package Classes.core;

import java.util.*;

public abstract class Event {
     private final String eventName;
     protected int id;
     public Event(String eventName) {
         this.eventName = eventName;
     }


     public abstract Event start(Scanner sc);

 }
