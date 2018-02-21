package core;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import util.SheetsServiceUtil;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;


public class SheetIntegration {

    private static Sheets sheetsService;

    public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = SheetsServiceUtil.getSheetsService();
    }

    //liest den Zelleninhalt von Zelle x,y gibt ihn als string zurück
    public static String read(String x, String y, String z) throws IOException {
        //List<String> ranges = Arrays.asList("A1", "A4");
        BatchGetValuesResponse readResult = sheetsService.spreadsheets().values()
                .batchGet(z)
                .setRanges(Collections.singletonList(x+y))
                .execute();

        ValueRange cell = readResult.getValueRanges().get(0);
        String cellValue;
        if ((cell.getValues() != null)) {
            cellValue = cell.getValues().get(0).get(0).toString();
            System.out.print(cellValue+"\n");
            return cellValue;
        }

        else {
            System.out.print("emptyCollumn!"+"\n");
            return "";
        }

    }
}

