import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.junit.BeforeClass;
import org.junit.Test;
import util.STATIC;
import util.SheetsServiceUtil;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class GoogleSheetsIntegrationTest {
    private static Sheets sheetsService;
    private static String SPREADSHEET_ID = STATIC.BAUSTEINE;

    @BeforeClass
    public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = SheetsServiceUtil.getSheetsService();
    }
    @Test
    public void whenWriteSheet_thenReadSheetOk() throws IOException {
        ValueRange body = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList("Expenses January"),
                        //Arrays.asList("books", "30"),
                        //Arrays.asList("pens", "10"),
                        //Arrays.asList("Expenses February"),
                        //Arrays.asList("clothes", "20"),
                        Arrays.asList("shoes", "5")));
        UpdateValuesResponse result = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, "A1", body)
                .setValueInputOption("RAW")
                .execute();
    }

    @Test
    public void newSheet() throws IOException {
        Spreadsheet spreadSheet = new Spreadsheet().setProperties(
                new SpreadsheetProperties().setTitle("My Spreadsheet"));
        Spreadsheet result = sheetsService
                .spreadsheets()
                .create(spreadSheet).execute();

        //assertThat(result.getSpreadsheetId()).isNotNull();
    }
}
