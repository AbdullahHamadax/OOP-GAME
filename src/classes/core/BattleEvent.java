package classes.core;

import classes.core.battle.BattleManager;
import classes.entity.Enemy;
import classes.entity.Player;

import java.util.Random;
import java.util.Scanner;

public class BattleEvent extends Event {
    private final Player PLAYER;
    private final Enemy[] ENEMIES;
    private final BattleManager BATTLE_MANAGER;
    Event next;

    public BattleEvent(String eventName, BattleManager battleManager, Player player, Enemy enemy) {
        super(eventName);
        this.PLAYER = player;
        this.BATTLE_MANAGER = battleManager;
        this.ENEMIES = new Enemy[]{enemy};
    }
    public BattleEvent(String eventName, BattleManager battleManager, Player player, Enemy[] enemies) {
        super(eventName);
        this.PLAYER = player;
        this.BATTLE_MANAGER = battleManager;
        this.ENEMIES = enemies;
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
        BATTLE_MANAGER.initiateBattle(PLAYER, ENEMIES, sc, random);
        return next;
    }
}
