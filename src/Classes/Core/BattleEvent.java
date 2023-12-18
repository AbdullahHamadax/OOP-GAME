package Classes.Core;

import Classes.Core.Battle.BattleManager;
import Classes.Entity.Enemy;
import Classes.Entity.Player;

import java.util.Random;
import java.util.Scanner;

public class BattleEvent extends Event {
    private final Player player;
    private final Enemy[] enemies;
    private final BattleManager battleManager;
    Event next;

    public BattleEvent(String eventName, BattleManager battleManager, Player player, Enemy enemy) {
        super(eventName);
        this.player = player;
        this.battleManager = battleManager;
        this.enemies = new Enemy[]{enemy};
    }
    public BattleEvent(String eventName, BattleManager battleManager, Player player, Enemy[] enemies) {
        super(eventName);
        this.player = player;
        this.battleManager = battleManager;
        this.enemies = enemies;
    }

    public Event getNext() {
        return next;
    }

    public void setNext(Event next) {
        this.next = next;
    }

    @Override
    public Event start(Scanner sc) {
        Random random = new Random();
        battleManager.initiateBattle(player, enemies, sc, random);
        return next;
    }
}
