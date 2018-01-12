package Utils;

import AnimalPack.*;
import Operation.BuyAndSell;
import Service.PetShopStorage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * Created by 1 on 23.12.2017.
 */
public class Util {

    private static final Logger LOGGER = LogManager.getLogger(Util.class.getName());

    public static String getPath() {

        Properties property = new Properties();
        String root = "";

        try (InputStream fis = Util.class.getClassLoader().getResourceAsStream("settings.properties");) {

            property.load(fis);
            root = property.getProperty("root");
            File rootDirectory = new File(root);

            if (!rootDirectory.exists()) {
                rootDirectory.mkdirs();
            } else {
                StringBuilder infoString = new StringBuilder();
                infoString.append("Root directory can't be created with path [").append(root).append("].");
                LOGGER.info(infoString);
            }
        } catch (IOException e) {
            StringBuilder errorString = new StringBuilder();
            errorString.append("Property file is not found!");
            LOGGER.error(errorString);
        }
        return root;
    }

    public static String randomName() {

        String symbols = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randString = new StringBuilder();
        int count = new Random().nextInt(9);

        for (int i = 0; i < count; i++) {
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        return String.valueOf(randString);
    }

    public static Integer randomCost() {
        return new Random().nextInt(6000);
    }

    public static Animal createRandomAnimal() {

        Animal animal = null;
        int i = (int) (Math.random() * 4 + 1);

        switch (i) {
            case 1:
                animal = new Dog();
                break;
            case 2:
                animal = new Cat();
                break;
            case 3:
                animal = new Shark();
                break;
            case 4:
                animal = new Wolf();
                break;
            default:
                System.out.println("Рандом вышел из под контроля");
        }
        return animal;
    }

    public static Animal getRandomAnimal() {

        if (PetShopStorage.getInstance().getSize() > 0) {
            return PetShopStorage.getInstance().getAnimal(0);
        } else {
            BuyAndSell.getInstance().buy();
            return PetShopStorage.getInstance().getAnimal(0);
        }
    }

    public static void useDb() {

        JSONParser parser = new JSONParser();

        try {

            JSONObject object = (JSONObject) parser.parse(new FileReader(Util.getPath() + "/" + "Db.json"));

            String type = (String) object.get("Type");
            System.out.println("Type: " + type);

            String name = (String) object.get("Name");
            System.out.println("Name: " + name);

            String character = (String) object.get("Character");
            System.out.println("Character: " + character);

            String cost = (String) object.get("Cost");
            System.out.println("Cost: " + cost);

            String breed = (String) object.get("Breed");
            System.out.println("Breed: " + breed);

        } catch (IOException | ParseException ex) {
            System.out.println("Не парсится " + ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
    }

    public static Integer randomNumb() {
        return new Random().nextInt(2);
    }
}

