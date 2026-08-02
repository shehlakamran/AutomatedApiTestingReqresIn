package api.utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {

        String path = "testdata/APIData.xlsx";
        XLUtility xl = new XLUtility(path);

        int rownum = xl.getRowCount(path, "Sheet1");      // FIXED
        int colcount = xl.getColumnCount(path, "Sheet1", 0); // FIXED

        String[][] apidata = new String[rownum][colcount]; // FIXED

        for (int i = 1; i <= rownum; i++) {   // FIXED: include last row
            for (int j = 0; j < colcount; j++) {
                apidata[i - 1][j] = xl.getCellData(path, "Sheet1", i, j); // FIXED
            }
        }

        return apidata;
    }


    @Test
    public void getdatar() throws IOException {
        String[][] data = getAllData();

        for (String[] row : data) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();

        }
    }
}

