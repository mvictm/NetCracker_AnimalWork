package Service;

import AnimasPack.Animal;

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

    public Animal searchAnimalBreed(String breed) {
        Animal animal = null;
        for (int i = 0; i < petShopStorage.getSize(); i++) {
            if (petShopStorage.getAnimal(i).getBreed().equals(breed)) {
                animal = petShopStorage.getAnimal(i);
                System.out.println(animal.information());
                return animal;
            }
        }
        return animal;
    }

    public Animal searchAnimalName(String name) {
        Animal animal = null;
        for (int i = 0; i < petShopStorage.getSize(); i++) {
            if (petShopStorage.getAnimal(i).getName().equals(name)) {
                animal = petShopStorage.getAnimal(i);
                System.out.println(animal.information());
                return animal;
            }
        }
        return animal;
    }

    public Animal searchAnimalCost(Integer cost) {
        Animal animal = null;
        for (int i = 0; i < petShopStorage.getSize(); i++) {
            if (petShopStorage.getAnimal(i).getCost().equals(cost)) {
                animal = petShopStorage.getAnimal(i);
                System.out.println(animal.information());
                return animal;
            }
        }
        return animal;
    }

    public Animal searchAnimalCost(Integer lowCost, Integer highCost) {
        Animal animal = null;
        for (int i = 0; i < petShopStorage.getSize(); i++) {
            if (petShopStorage.getAnimal(i).getCost() >= lowCost && petShopStorage.getAnimal(i).getCost() <= highCost) {
                animal = petShopStorage.getAnimal(i);
                System.out.println(animal.information());
                return animal;
            }
        }
        return animal;
    }

    public Animal searchAnimalChatacter(String character) {
        Animal animal = null;
        for (int i = 0; i < petShopStorage.getSize(); i++) {
            if (petShopStorage.getAnimal(i).getCharacter().equals(character)) {
                animal = petShopStorage.getAnimal(i);
                System.out.println(animal.information());
                return animal;
            }
        }
        return animal;
    }
}
