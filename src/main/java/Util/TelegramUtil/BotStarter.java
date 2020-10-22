package Util.TelegramUtil;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

public class BotStarter {
    public static void startBot() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new ReqOxBot());
            System.out.println("ReqOxBot started to work");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
