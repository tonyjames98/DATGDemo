package com.orasi.utils;

import org.apache.commons.lang3.time.StopWatch;
import static com.orasi.utils.Constants.MAX_SLEEP_TIME;
import com.orasi.AutomationException;

public class Sleeper {
    public static void sleep(double seconds) {
    	if (seconds>=MAX_SLEEP_TIME) {
    		throw new AutomationException("Sleep time exceeds "+MAX_SLEEP_TIME+" seconds.");
    	}
        TestReporter.logTrace("Sleeping for [ " + seconds + " ] seconds");
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        do {

        } while ((double)(stopwatch.getTime()/1000.0) < seconds);
        stopwatch.stop();
        stopwatch.reset();
    }
}
