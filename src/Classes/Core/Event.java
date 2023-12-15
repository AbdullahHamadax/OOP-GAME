package Classes.Core;

import java.util.*;

public abstract class Event {
     private final String eventName;
     protected Scanner sc;
     protected int id;
     public Event(String eventName, Scanner sc) {
         this.eventName = eventName;
         this.sc= sc;
     }


     public abstract Event start();

 }
