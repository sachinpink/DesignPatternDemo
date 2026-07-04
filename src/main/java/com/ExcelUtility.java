package com;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class ExcelUtility
{
    public static HashMap<String, String> readExcel(String user_type) throws IOException
    {
        File file = new File(System.getProperty("user.dir")+"/src/test/resources/TestData/Users.xlsx");
        FileInputStream fis =new FileInputStream(file);
        XSSFWorkbook wb =new XSSFWorkbook(fis);
        XSSFSheet sheet= wb.getSheetAt(0);
        HashMap<String,String> hm = new HashMap<>();
        boolean flag=false;
        for(int i=1;i<=sheet.getLastRowNum();i++)
        {
            XSSFRow row = sheet.getRow(i);
            String userType= row.getCell(0).getStringCellValue();
            System.out.println("UserTypes "+ userType);
            if(userType.equalsIgnoreCase(user_type))
            {
               hm.put("UserName", row.getCell(1).getStringCellValue());
               hm.put("Password",row.getCell(2).getStringCellValue());
               flag=true;
               break;
            }
        }
        if(!flag)
        {
            System.out.println("Please provide correct user type");
        }
        return hm;

    }

}
