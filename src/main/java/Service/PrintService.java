package Service;

import AnimasPack.Animal;
import Utils.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by 1 on 20.12.2017.
 */
public class PrintService {
    private static final Logger lOGGER = LogManager.getLogger(PrintService.class.getName());

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
        String str;
        if (buyOrSell) {
            str = "Buy new animal";
        } else {
            str = "Sell animal";
        }

        try (FileWriter writer = new FileWriter(Util.getRootPath() + "/" + Util.getReportPath(), true)) {

            Date date = new Date();
            writer.write(date.toString() + "\n");
            writer.write(str + " : " + animal.getType() + "\n" + animal.information() + "\n");
            writer.write("\n");
            writer.flush();
            writer.close();

            StringBuilder infoString = new StringBuilder();
            infoString.append("Successful recording in file " + Util.getReportPath());
            lOGGER.info(infoString);
        } catch (IOException e) {
            StringBuilder errorString = new StringBuilder();
            errorString.append("Problem with recording to file " + Util.getReportPath());
            lOGGER.info(errorString);
        }
    }
}
