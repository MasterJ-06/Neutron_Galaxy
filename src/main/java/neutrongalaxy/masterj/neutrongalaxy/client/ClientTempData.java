package neutrongalaxy.masterj.neutrongalaxy.client;

public class ClientTempData {
// 0 = normal
// 1 = hot
// 2 = cold
    private static int playerTemp;

    public static void set(int temp) {
        ClientTempData.playerTemp = temp;
    }

    public static int getPlayerTemp() {
        return playerTemp;
    }
}
