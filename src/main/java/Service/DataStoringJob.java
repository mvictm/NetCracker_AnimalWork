package Service;

import java.io.FileWriter;
import java.io.IOException;

import AnimasPack.Animal;
import Utils.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

        JSONObject object = new JSONObject();

        try (FileWriter writer = new FileWriter(Util.getRootPath() + "/" + Util.getDatabasePath())) {
            writer.write("{");

            for (int i = 0; i < list.size(); i++) {
                object.put("Type", list.get(i).getType());
                object.put("Name", list.get(i).getName());
                object.put("Character", list.get(i).getCharacter());
                object.put("Cost", list.get(i).getCost().toString());
                object.put("Breed", list.get(i).getBreed());

                if (i == list.size() - 1) {
                    try {
                        writer.write("\"Animal " + (i + 1) + "\":" + "\n");
                        writer.write(object.toJSONString() + "\n");

                        StringBuilder infoString = new StringBuilder();
                        infoString.append("Successful recording in file" + Util.getDatabasePath());
                        lOGGER.info(infoString);
                    } catch (IOException ex) {
                        StringBuilder errorString = new StringBuilder();
                        errorString.append("Can't put JSON object in file " + Util.getDatabasePath());
                        lOGGER.error(errorString);
                    }
                } else
                    try {
                        writer.write("\"Animal " + (i + 1) + "\":" + "\n");
                        writer.write(object.toJSONString() + "," + "\n");

                        StringBuilder infoString = new StringBuilder();
                        infoString.append("Successful recording in file" + Util.getDatabasePath());
                        lOGGER.info(infoString);
                    } catch (IOException ex) {
                        StringBuilder errorString = new StringBuilder();
                        errorString.append("Can't write in file " + Util.getDatabasePath());
                        lOGGER.error(errorString);
                    }
            }

            writer.write("}");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            StringBuilder errorString = new StringBuilder();
            errorString.append("Can't write in file " + Util.getDatabasePath());
            lOGGER.error(errorString);
        }
    }
}



