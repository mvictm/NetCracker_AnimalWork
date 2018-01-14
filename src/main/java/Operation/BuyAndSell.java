package Operation;

import AnimasPack.Animal;
import Service.PetShopStorage;
import Service.PrintService;
import Utils.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by 1 on 20.12.2017.
 */
public class BuyAndSell {
    private static final Logger LOGGER = LogManager.getLogger(BuyAndSell.class.getName());

    private PetShopStorage petShopStorage = PetShopStorage.getInstance();

    private PrintService printService = PrintService.getInstance();

    private static BuyAndSell ourInstance = new BuyAndSell();

    public static BuyAndSell getInstance() {
        if (ourInstance == null) {
            ourInstance = new BuyAndSell();
        }
        return ourInstance;
    }

    private BuyAndSell() {
    }

    public void buy() {
        Animal animal = Util.createRandomAnimal();
        petShopStorage.addToAnimalList(animal);
        printService.printReport(animal, true);

        StringBuilder infoString = new StringBuilder();
        infoString.append("Buy new animal in shop " + animal.getType());
        LOGGER.info(infoString);
    }

    public void sell() {
        Animal animal = Util.getRandomAnimal();
        petShopStorage.removeAtAnimalList(animal);
        printService.printReport(animal, false);

        StringBuilder infoString = new StringBuilder();
        infoString.append("Sell animal " + animal.getType());
        LOGGER.info(infoString);
    }
}
