package Util.TimeUtil;

import javax.swing.*;
import java.util.Date;
import java.util.TimerTask;

public class ClosingProgram extends TimerTask {
    @Override
    public void run() {
        System.out.println("Bye bye...");
        JOptionPane.showMessageDialog(null,"Program is closing now : "+ new Date());
        System.exit(0);
    }
}
