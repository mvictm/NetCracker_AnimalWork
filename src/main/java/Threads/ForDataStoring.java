package Threads;

import Service.DataStoringJob;

/**
 * Created by 1 on 24.12.2017.
 */
public class ForDataStoring extends Thread {
    @Override
    public void run() {
        while (true) {
            DataStoringJob.getInstance().run();
        }
    }
}
