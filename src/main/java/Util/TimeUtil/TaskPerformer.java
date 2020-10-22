package Util.TimeUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TaskPerformer {
    public static void doAutoReqTask(int hour, int minute){
        Executor executor = Context.getInstanceOfExecutor();
        Timer timer = Context.getInstanceOfTimer();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        timer.schedule(executor, date);
    }
    public static void doAutoReqTaskForTomorrow(int hour, int minute){
        Executor executor = Context.getInstanceOfExecutor();
        Timer timer = Context.getInstanceOfTimer();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        timer.schedule(executor, date);
    }
    public static void doClosingTask(int hour, int minute){
        Calendar lastCal = Calendar.getInstance();
        ClosingProgram closingProgram = new ClosingProgram();
        lastCal.set(Calendar.HOUR_OF_DAY, hour);
        lastCal.set(Calendar.MINUTE, minute);
        lastCal.set(Calendar.SECOND, 0);
        lastCal.set(Calendar.MILLISECOND, 0);
        Date lastDate = lastCal.getTime();
        Timer lastTimer = new Timer();
        lastTimer.schedule(closingProgram,lastDate);
    }
    public static void doClosingTaskForTomorrow(int hour, int minute){
        Calendar lastCal = Calendar.getInstance();
        ClosingProgram closingProgram = new ClosingProgram();
        lastCal.add(Calendar.DAY_OF_YEAR, 1);
        lastCal.set(Calendar.HOUR_OF_DAY, hour);
        lastCal.set(Calendar.MINUTE, minute);
        lastCal.set(Calendar.SECOND, 0);
        lastCal.set(Calendar.MILLISECOND, 0);
        Date lastDate = lastCal.getTime();
        Timer lastTimer = new Timer();
        lastTimer.schedule(closingProgram,lastDate);
    }

}
