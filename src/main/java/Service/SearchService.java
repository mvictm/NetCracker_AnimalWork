package Service;

import AnimasPack.Animal;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by 1 on 20.12.2017.
 */
public class SearchService {
    private static PetShopStorage petShopStorage = PetShopStorage.getInstance();

    private static SearchService ourInstance = new SearchService();

    public static SearchService getInstance() {
        return ourInstance;
    }

    private SearchService() {
    }

    public Animal searchAnimalByBreed(String breed) {
        Object[] a = petShopStorage.getAnimalList().stream().filter(s -> breed.equals(s.getBreed())).limit(1).toArray();
        return a.length > 0 ? (Animal) a[0] : null;
    }

    public Animal searchAnimalByName(String name) {
        Object[] a = petShopStorage.getAnimalList().stream().filter(s -> name.equals(s.getName())).limit(1).toArray();
        return a.length > 0 ? (Animal) a[0] : null;
    }

    public Animal searchAnimalByCost(Integer cost) {
        Object[] a = petShopStorage.getAnimalList().stream().filter(s -> cost.equals(s.getCost())).limit(1).toArray();
        return a.length > 0 ? (Animal) a[0] : null;
    }

    public Animal searchAnimalByCost(Integer lowCost, Integer highCost) {
        Object[] a = petShopStorage.getAnimalList().stream().filter(s -> lowCost >= (s.getCost()) && highCost <= s.getCost()).limit(1).toArray();
        return a.length > 0 ? (Animal) a[0] : null;
    }

    public Animal searchAnimalByChatacter(String character) {
        Object[] a = petShopStorage.getAnimalList().stream().filter(s -> character.equals(s.getCharacter())).limit(1).toArray();
        return a.length > 0 ? (Animal) a[0] : null;
    }
}
