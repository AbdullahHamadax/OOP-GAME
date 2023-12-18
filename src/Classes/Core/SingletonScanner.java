package Classes.Core;

import java.util.Scanner;

public class SingletonScanner {
    private static SingletonScanner instance = null;
    public Scanner sc;

    private SingletonScanner() {
        sc = new Scanner(System.in);
    }

    public static synchronized SingletonScanner getInstance() {
        if (instance == null) {
            instance = new SingletonScanner();
        }
        return instance;
    }

    public Scanner getScanner() {
        return sc;
    }
}