package Service;

import AnimalPack.Animal;
import Utils.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by 1 on 20.12.2017.
 */
public class PrintService {

    private static final Logger lOGGER = LogManager.getLogger(PrintService.class.getName());

    private static final String PATH = "Report.txt";

    private static PrintService instance = new PrintService();

    public static PrintService getInstance() {
        if (instance == null) {
            instance = new PrintService();
        }
        return instance;
    }

    private PrintService() {
    }

    public void printReport(Animal animal, boolean buyOrSell) {

        JSONObject object = new JSONObject();

        String str;
        if (buyOrSell) {
            str = "Buy new animal";
        } else {
            str = "Sell animal";
        }

        try (FileWriter writer = new FileWriter(Util.getPath() + "/" + PATH, true)) {

            Date date = new Date();
            writer.write(date.toString() + "\n");
            writer.write(str + " : " + animal.getType() + "\n" + animal.information() + "\n");
            writer.write("\n");
            writer.flush();
            writer.close();

            StringBuilder infoString = new StringBuilder();
            infoString.append("Successful recording in file " + PATH);
            lOGGER.info(infoString);
        } catch (IOException e) {
            StringBuilder errorString = new StringBuilder();
            errorString.append("Problem with recording to file " + PATH);
            lOGGER.info(errorString);
        }
    }
}
