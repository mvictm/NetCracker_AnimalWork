package Utils;

import AnimasPack.*;
import Operation.BuyAndSell;
import Service.PetShopStorage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

/**
 * Created by 1 on 23.12.2017.
 */
public class Util {
    private static final Logger LOGGER = LogManager.getLogger(Util.class.getName());

    private static final String REPORTPATH = "Report.txt";

    private static final String DATABASEPATH = "Database.json";

    public static String getRootPath() {
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
                infoString.append("Repeated take ").append(root).append(" path");
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

            JSONObject object = (JSONObject) parser.parse(new FileReader(Util.getRootPath() + "/" + Util.getDatabasePath()));

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

    public static void newSession() {
        try (FileWriter writer = new FileWriter(getRootPath() + "/" + getReportPath(), true)) {

            Date date = new Date();
            writer.write("-----------------NEW SESSION------------------------");
            writer.write(date.toString() + "\n");
            writer.write("\n");
            writer.flush();
            writer.close();

            StringBuilder infoString = new StringBuilder();
            infoString.append("Start session");
            LOGGER.info(infoString);
        } catch (IOException e) {
            StringBuilder errorString = new StringBuilder();
            errorString.append("Problem with start session");
            LOGGER.info(errorString);
        }
    }

    public static String getReportPath() {
        return REPORTPATH;
    }

    public static String getDatabasePath() {
        return DATABASEPATH;
    }

    public static List<Animal> parseDatabaseFile() {
        List<Animal> animalList = new ArrayList<>();

        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader(Util.getRootPath() + "/" + "Database.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject jo = (JSONObject) obj;
        JSONArray animalArray = (JSONArray) jo.get("Animals");
        Iterator animalItr = animalArray.iterator();

        while (animalItr.hasNext()) {
            Animal animal;

            JSONObject test = (JSONObject) animalItr.next();
            String type = (String) test.get("Type");
            String name = (String) test.get("Name");
            String breed = (String) test.get("Breed");
            String cost = (String) test.get("Cost");
            Integer intCost = Integer.parseInt(cost);
            String character = (String) test.get("Character");

            animal = whatAnimalCreate(type, name, breed, intCost, character);

            animalList.add(animal);

            StringBuilder infoString = new StringBuilder();
            infoString.append("Take information from ").append(getDatabasePath()).append(" about animal: ").append(animal.getType()).append(" - ").append(animal.information());
            LOGGER.info(infoString);
        }
        return animalList;
    }

    private static Animal whatAnimalCreate(String type, String name, String breed, Integer cost, String character) {
        Animal animal = null;
        switch (type) {
            case "Dog":
                animal = new Dog(name, breed, cost, character);
                break;
            case "Cat":
                animal = new Cat(name, breed, cost, character);
                break;
            case "Shark":
                animal = new Shark(name, breed, cost, character);
                break;
            case "Wolf":
                animal = new Wolf(name, breed, cost, character);
                break;
        }
        return animal;
    }
}

