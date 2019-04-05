package Core;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {

    Workbook workbook = null;
    Map<String, String> data=new HashMap<String, String>();

    public Map<String, String> getLoginData(String methodName) throws Exception {

        /*String fullPath = System.getProperty("user.home") + "/IdeaProjects/SampleTest/src/test//resources/" + data;
            File file = new File(fullPath);*/
            /*if (!file.exists()) {
                throw new FileNotFoundException("File not exists in the specified path: " + fullPath);
            }*/
       /* FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
*/
         /*   FileInputStream inputStream = new FileInputStream(file);
            if (file.exists()) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                workbook = new XSSFWorkbook(inputStream);
            }*/

            //      return workbook;

        File file = new File("C://Users//venkata.jayanti//IdeaProjects//SampleTest//TestData//Data.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
           // Workbook workbook = (Workbook) new ExcelUtils().getLoginData("Data.xlsx");
            //Map<String, String> datamap = new HashMap<String, String>();
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheetAt(0);
            wb.close();
            int lastRowNum = sheet.getLastRowNum();
            int lastCellNum = sheet.getRow(0).getLastCellNum();
            //Object[][] obj = new Object[lastRowNum][1];

            for (int i = 0; i < lastRowNum; i++) {
                String ActMethodName = sheet.getRow(i).getCell(0).getStringCellValue();
                if (ActMethodName.equals(methodName)) {
                    for (int j = 0; j < lastCellNum; j++) {
                        data.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
                    }
                    break;
                }
            }
            return data;


    }

}
