package Threads;

import AnimasPack.Animal;
import Service.PetShopStorage;

import java.util.List;
import java.util.Random;

/**
 * Created by 1 on 24.12.2017.
 */
public class CleaningJob extends Thread {

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
                    e.printStackTrace();
                }
            }
        }
    }
}
