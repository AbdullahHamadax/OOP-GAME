package classes.core;

public class Data{
    private static double gameSpeed = Game.MEDIUM_TEXT;

    public static double getGameSpeed() {
        return gameSpeed;
    }

    public static void setGameSpeed(double gameSpeed) {
        Data.gameSpeed = gameSpeed;
    }


}
