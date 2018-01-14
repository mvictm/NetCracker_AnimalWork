
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
        RealLifeEmulator realLifeEmulator =  RealLifeEmulator.getInstance();



        /*Shark shark = new Shark();
        Dog dog = new Dog();
        PetShopStorage petShopStorage = PetShopStorage.getInstance();
        petShopStorage.addToAnimalList(shark);
        petShopStorage.addToAnimalList(dog);

        DataStoringJob dataStoringJob = DataStoringJob.getInstance();
        dataStoringJob.run();*/

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
