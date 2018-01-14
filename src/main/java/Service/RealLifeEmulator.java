package Service;

import Operation.BuyAndSell;
import Threads.CleaningJob;
import Threads.ForDataStoring;
import Threads.PollutionJob;
import Utils.Util;

import java.util.Random;

/**
 * Created by 1 on 24.12.2017.
 */
public class RealLifeEmulator {
    private static PollutionJob pollutionJob = PollutionJob.getInstance();

    private static CleaningJob cleaningJob = CleaningJob.getInstance();

    private static RealLifeEmulator ourInstance = new RealLifeEmulator();

    public static RealLifeEmulator getInstance() {
        if (ourInstance == null) {
            ourInstance = new RealLifeEmulator();
        }
        return ourInstance;
    }

    private RealLifeEmulator() {
        Util.newSession();
        new ForDataStoring().start();

        pollutionJob.start();
        cleaningJob.start();

        while (true) {
            int a = new Random().nextInt(10);
            switch (a) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    BuyAndSell.getInstance().buy();
                    break;
                case 5:
                    break;
                case 6:
                    if (PetShopStorage.getInstance().getSize() <= 1) {
                        BuyAndSell.getInstance().buy();
                    } else {
                        BuyAndSell.getInstance().sell();
                    }
                    break;
                case 7:
                    if (PetShopStorage.getInstance().getSize() <= 1) {
                        BuyAndSell.getInstance().buy();
                    } else {
                        PetShopStorage.getInstance().removeAtAnimalList(Util.getRandomAnimal());
                    }
                    System.out.println("Андрюха, у нас побег");
                    break;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
