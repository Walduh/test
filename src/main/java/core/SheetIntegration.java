package core;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import util.STATIC;
import util.SheetsServiceUtil;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;

public class SheetIntegration {

    private static Sheets sheetsService;
    private static String SPREADSHEET_ID = STATIC.BAUSTEINE;


    public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = SheetsServiceUtil.getSheetsService();
    }

    public static void whenWriteSheet_thenReadSheetOk() throws IOException {
        ValueRange body = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList("einBrot"),
                        Arrays.asList("books", "30"),
                        Arrays.asList("pens", "10"),
                        Arrays.asList("Expenses February"),
                        Arrays.asList("clothes", "20"),
                        Arrays.asList("shoes", "5")));
        UpdateValuesResponse result = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, "A1", body)
                .setValueInputOption("RAW")
                .execute();
    }


    public void test() throws IOException {
        Spreadsheet spreadSheet = new Spreadsheet().setProperties(
                new SpreadsheetProperties().setTitle("My Spreadsheet"));
        Spreadsheet result = sheetsService
                .spreadsheets()
                .create(spreadSheet).execute();

        //assertThat(result.getSpreadsheetId()).isNotNull();
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

    //ermittlet wie viele Zellen unter "c" in Zeile "collumn" noch Strings enthalten --> upper für random
    public static int columnlentgh(String collumn, int c, String z) throws IOException {
        while (c < 999) {
            String row = String.valueOf(c);
            String cellvalue = read(collumn,row,z);
                if (cellvalue == "")
                   break;
                else c +=1;
        }
        return c-1;
    }

    public static int rowlentgh(String row, int c, String z) throws IOException {
        while (c < 999) {
            //String collumn = String.valueOf(c);
            //String cellvalue = read(collumn,row,z);
            //if (cellvalue == "")
             //   break;
            //else c +=1;
        }
        return c-1;
    }

}
