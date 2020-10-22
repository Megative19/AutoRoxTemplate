package Util.TelegramUtil;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;

public class ReqOxBot extends TelegramLongPollingBot {
    public Long chatId = null;

    public void onUpdateReceived(Update update) {

        String input = update.getMessage().getText();
        SendMessage output = new SendMessage();

        if (input.equals("/myname") || input.equals("/myname@ReqoxBot")) {
            System.out.println(update.getMessage().getFrom().getFirstName());
            output.setText(update.getMessage().getFrom().getFirstName());
        }

        if (input.equals("/mylastname") || input.equals("/mylastname@ReqoxBot")) {
            System.out.println(update.getMessage().getFrom().getLastName());
            output.setText(update.getMessage().getFrom().getLastName());
        }

        if (input.equals("/chatid") || input.equals("/chatid@ReqoxBot")) {
             chatId = update.getMessage().getChatId();
            System.out.println("chatId = " + chatId);
            output.setText("chatid is  = " + chatId);
        }

        else{
            System.out.println(update.getMessage().getFrom().getFirstName());
            System.out.println(update.getMessage().getChatId());
            output.setText("Sorry i dont understand these words yet");
        }

        output.setChatId(update.getMessage().getChatId());
        try {
            execute(output);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void tellToTestGroup() {
        SendMessage message = new SendMessage();

        message.enableMarkdown(true);
        message.setChatId((long) chatId); //put chatId manually here as number
        message.setText("Hello my human friends Date is = " + new Date());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
    public void tellRequestsToTestGroup(String request) {
        SendMessage message = new SendMessage();

        message.enableMarkdown(true);
        message.setChatId((long) chatId); //put chatId manually here as number
        message.setText(request);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void tellRequestsToAutoReqGroup(String request) {
        SendMessage message = new SendMessage();

        message.enableMarkdown(true);
        message.setChatId((long) chatId); //put chatId manually here as number
        message.setText(request);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
    public String getBotUsername() {
        return "ReqOxBot";
    }

    String botToken;
    public String getBotToken() {
        return botToken;
    }
}
