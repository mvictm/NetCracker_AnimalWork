package Service;

import AnimasPack.Animal;
import Utils.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 20.12.2017.
 */
public class PetShopStorage {
    private static final Logger LOGGER = LogManager.getLogger(PetShopStorage.class.getName());

    private List<Animal> animalList = new ArrayList<Animal>();

    private static PetShopStorage ourInstance = new PetShopStorage();

    public static PetShopStorage getInstance() {
        if (ourInstance == null) {
            ourInstance = new PetShopStorage();
        }
        return ourInstance;
    }

    private PetShopStorage() {
    }

    public void addToAnimalList(Animal animal) {
        animalList.add(animal);
    }

    public List<Animal> getAnimalList() {
        if (animalList.size() == 0) {
            animalList = Util.parseDatabaseFile();
        }
        return animalList;
    }

    public int getSize() {
        return animalList.size();
    }

    public void removeAtAnimalList(Animal animal) {
        animalList.remove(animal);

        StringBuilder infoString = new StringBuilder();
        infoString.append("Remove " + animal.getType() + " - " + animal.information());
        LOGGER.info(infoString);
    }

    public Animal getAnimal(int i) {
        StringBuilder infoString = new StringBuilder();
        infoString.append("Return animal number " + i);
        LOGGER.info(infoString);

        return animalList.get(i);
    }
}
