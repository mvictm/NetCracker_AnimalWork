package Threads;

import AnimasPack.Animal;
import Service.PetShopStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 1 on 24.12.2017.
 */
public class CleaningJob extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(CleaningJob.class.getName());

    private PetShopStorage petShopStorage = PetShopStorage.getInstance();

    private List<Animal> animalList = petShopStorage.getAnimalList();

    private static CleaningJob ourInstance = new CleaningJob();

    public static CleaningJob getInstance() {
        if (ourInstance == null) {
            ourInstance = new CleaningJob();
        }
        return ourInstance;
    }

    private CleaningJob() {
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < animalList.size(); i++) {
                int value = new Random().nextInt(10) + 20;
                animalList.get(i).setDegreeOfPollution(-value);
                System.out.println("Очистил на " + value);
                System.out.println(animalList.get(i).getDegreeOfPollution());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    StringBuilder errorString = new StringBuilder();
                    errorString.append("Thread is no sleep");
                    LOGGER.error(errorString);
                }
            }
        }
    }
}
