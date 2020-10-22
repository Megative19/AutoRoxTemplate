package Util.TimeUtil;

import Bean.ResponseBody;
import Bean.ResponseBodyGuava;
import Util.ExcelUtil;
import Util.RequestHandler;
import Util.TelegramUtil.BotStarter;
import Util.TelegramUtil.ReqOxBot;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimerTask;

public class Executor extends TimerTask {
    public static void doProcess() {
        String postUrl = "";
        String getUrl="";
        try {

            ResponseBody answeredResponse = RequestHandler.doPost(postUrl);
            ResponseBodyGuava responseBodyGuava = RequestHandler.doGet(getUrl);
            ExcelUtil.startExcel(answeredResponse,responseBodyGuava);
            BotStarter.startBot();
            ReqOxBot reqOxBot = new ReqOxBot();
            reqOxBot.tellRequestsToAutoReqGroup("Amount from RFI: " + answeredResponse.getAmount() + "\n" + "Moscow Date: " + LocalDateTime.now(ZoneId.of("Europe/Moscow")).format(DateTimeFormatter.ofPattern("d.MM.yyyy HH:mm"))
                    + "\n"
                    + "\n" + "Amount from Guava: " + responseBodyGuava.getAvailable_amount() + "\n" + "Baku Date : " + new Date());

//            reqOxBot.tellRequestsToTestGroup("Amount from RFI: " + answeredResponse.getAmount() + "\n" + "Moscow Date: " + LocalDateTime.now(ZoneId.of("Europe/Moscow")).format(DateTimeFormatter.ofPattern("d.MM.yyyy HH:mm"))
//                    + "\n"
//                    + "\n" + "Amount from Guava: " + responseBodyGuava.getAvailable_amount() + "\n" + "Baku Date : " + new Date());


         //   JOptionPane.showMessageDialog(null, "Requests has been sent at: " + new Date());
        }catch (Exception exception){
            exception.printStackTrace();
            BotStarter.startBot();
            ReqOxBot reqOxBot = new ReqOxBot();
            reqOxBot.tellRequestsToAutoReqGroup("Exception Localized Message : "+exception.getLocalizedMessage() + "\n"
            + "Message: "+exception.getMessage() +"\n" + "Cause: "+exception.getCause() + "\n" + "Class: "+ exception.getClass() );
//
//            reqOxBot.tellRequestsToTestGroup("Exception Localized Message : "+exception.getLocalizedMessage() + "\n"
//                    + "Message: "+exception.getMessage() +"\n" + "Cause: "+exception.getCause() + "\n" + "Class: "+ exception.getClass() );
        }
    }

    @Override
    public void run() {
        try {
            doProcess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
