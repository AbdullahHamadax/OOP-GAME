package Classes.core;

public class Data {
    private static double gameSpeed = Game.mediumText;

    public static double getGameSpeed() {
        return gameSpeed;
    }

    public static void setGameSpeed(double gameSpeed) {
        Data.gameSpeed = gameSpeed;
    }


}
