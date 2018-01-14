package Threads;

import Service.DataStoringJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by 1 on 24.12.2017.
 */
public class ForDataStoring extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(ForDataStoring.class.getName());

    @Override
    public void run() {
        while (true) {
            DataStoringJob.getInstance().run();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                StringBuilder errorString = new StringBuilder();
                errorString.append("Thread is no sleep");
                LOGGER.error(errorString);
            }
        }
    }
}
