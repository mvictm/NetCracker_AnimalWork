package Service;

import java.io.FileWriter;
import java.io.IOException;

import AnimasPack.Animal;
import Utils.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Created by 1 on 21.12.2017.
 */
public class DataStoringJob {
    private static final Logger lOGGER = LogManager.getLogger(DataStoringJob.class.getName());

    private PetShopStorage petShopStorage = PetShopStorage.getInstance();

    private static DataStoringJob ourInstance = new DataStoringJob();

    public static DataStoringJob getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataStoringJob();
        }
        return ourInstance;
    }

    private DataStoringJob() {
    }

    public void run() {
        List<Animal> list = petShopStorage.getAnimalList();
        try {

            FileWriter file = new FileWriter(Util.getRootPath() + "/" + Util.getDatabasePath());
            JSONObject firstObj = new JSONObject();
            JSONArray array = new JSONArray();

            for (Animal animal : list) {
                JSONObject object = new JSONObject();
                object.put("Type", animal.getType());
                object.put("Name", animal.getName());
                object.put("Character", animal.getCharacter());
                object.put("Cost", animal.getCost().toString());
                object.put("Breed", animal.getBreed());
                array.add(object);
            }

            firstObj.put("Animals", array);
            file.write(firstObj.toJSONString() + "\n");
            file.close();

            StringBuilder infoString = new StringBuilder();
            infoString.append("Successful recording in file" + Util.getDatabasePath());
            lOGGER.info(infoString);
        } catch (IOException e) {
            StringBuilder errorString = new StringBuilder();
            errorString.append("Can't write in file " + Util.getDatabasePath());
            lOGGER.error(errorString);
        }
    }
}



