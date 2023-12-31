package Classes.core;

import java.util.*;

public abstract class Event {
     private final String EVENT_NAME;
     protected int id;
     public Event(String EVENT_NAME) {
         this.EVENT_NAME = EVENT_NAME;
     }


     public abstract Event start(Scanner sc);

 }
