package Main;

import Util.TimeUtil.TaskPerformer;

import java.util.Date;

public class start {
    public static void main(String[] args) {

        System.out.println("Program Started at " + new Date());

        TaskPerformer.doAutoReqTask(12, 01);
        TaskPerformer.doAutoReqTask(15, 01);
        TaskPerformer.doAutoReqTask(18, 01);
        TaskPerformer.doClosingTask(18, 03);


    }

}
