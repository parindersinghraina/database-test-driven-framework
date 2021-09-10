package com.parinder.dbtd.helper;

public class WaitHelper {

    public static void waitForSeconds(Integer secondsToWait) {
        long millisToWait = secondsToWait * 1000;
        try {
            Thread.sleep(millisToWait);
        } catch (Exception e) {
            // do nothing as this will literally never happen
        }
    }

    public static void waitForMilliSeconds(Integer milliSecondsToWait) {
        try {
            Thread.sleep(milliSecondsToWait);
        } catch (Exception e) {
            // do nothing as this will literally never happen
        }
    }
}
