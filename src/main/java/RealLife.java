
import AnimasPack.*;
import Operation.BuyAndSell;
import Service.DataStoringJob;
import Service.PetShopStorage;
import Service.RealLifeEmulator;
import Service.SearchService;
import Threads.CleaningJob;
import Threads.PollutionJob;
import Utils.Util;

/**
 * Created by 1 on 20.12.2017.
 */
public class RealLife {

    public static void main(String[] args) {
        // RealLifeEmulator realLifeEmulator =  RealLifeEmulator.getInstance();

        //Util.parseDatabaseFile();


        Shark shark = new Shark();
        Dog dog = new Dog();
        Cat cat = new Cat();
        PetShopStorage petShopStorage = PetShopStorage.getInstance();
        petShopStorage.addToAnimalList(shark);
        petShopStorage.addToAnimalList(dog);
        petShopStorage.addToAnimalList(cat);

        DataStoringJob dataStoringJob = DataStoringJob.getInstance();
        dataStoringJob.run();

        SearchService searchService = SearchService.getInstance();
        System.out.println(searchService.searchAnimalByBreed(cat.getBreed()).information());

        /*DataStoringJob dataStoringJob = DataStoringJob.getInstance();
        dataStoringJob.run();

        Util.parseDatabaseFile();*/
        //Util.useDb();

        /*System.out.println(shark.information());

        SearchService searchService = SearchService.getInstance();
        searchService.searchAnimalBreed(shark.getBreed());*/

        /*BuyAndSell buyAndSell = BuyAndSell.getInstance();
        for (int i = 0; i <5; i++) {
            buyAndSell.buy();
        }

        buyAndSell.sell();*/

    }

}
