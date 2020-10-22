package Util.TimeUtil;

import java.util.Timer;

public class Context {
    public static Timer getInstanceOfTimer() {
        return new Timer();
    }

    public static Executor getInstanceOfExecutor() {
        return new Executor();
    }
}
