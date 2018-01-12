package Service;

import Operation.BuyAndSell;
import Threads.ForDataStoring;
import Utils.Util;

import java.util.Random;

/**
 * Created by 1 on 24.12.2017.
 */
public class RealLifeEmulator {

    private static RealLifeEmulator ourInstance = new RealLifeEmulator();

    public static RealLifeEmulator getInstance() {
        if (ourInstance == null) {
            ourInstance = new RealLifeEmulator();
        }
        return ourInstance;
    }

    private RealLifeEmulator() {
        new ForDataStoring().start();

        while (true) {
            int a = new Random().nextInt(10);
            switch (a) {
                case 1:
                case 2:
                case 3:
                case 4:
                    BuyAndSell.getInstance().buy();
                    break;
                case 5:
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
