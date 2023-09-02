package com.tests;

import com.utils.ExcelReader;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ExcelReadWrite {
   @Test
    public void excelReadWriteTest() {

       ExcelReader reader = new ExcelReader("/Users/prasanna/FrameWork/Automation/src/main/resources/testdata/testdata.xls");
       int col = reader.getColumnCount("register");
       System.out.println(col);


       String cell = reader.getCellData("register", "firstname", 2);
       System.out.println(cell);
       reader.addSheet("naveen");

       Object data[][] = reader.getSheetData("register");
       System.out.println(Arrays.deepToString(data));

      reader.removeSheet("naveen");
   }
}
