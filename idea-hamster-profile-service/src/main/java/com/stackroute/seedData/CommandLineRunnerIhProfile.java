package com.stackroute.seedData;

import com.stackroute.domain.IdeaHamster;
import com.stackroute.dto.IdeaHamsterDto;
import com.stackroute.service.IdeaHamsterServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

@Component
public class CommandLineRunnerIhProfile implements CommandLineRunner {
    private IdeaHamster ideaHamster;
    private IdeaHamsterServiceImpl ideaHamsterService;
    private IdeaHamsterDto ideaHamsterDto;
    @Autowired
    public CommandLineRunnerIhProfile(IdeaHamster ideaHamster, IdeaHamsterServiceImpl ideaHamsterService, IdeaHamsterDto ideaHamsterDto) {
        this.ideaHamster = ideaHamster;
        this.ideaHamsterService = ideaHamsterService;
        this.ideaHamsterDto=ideaHamsterDto;
    }



    @Override
    public void run(String... args) throws Exception
    {
        // need to load Excel XLSX file to read
        File file = new File("ih-profile-service.xlsx");

        FileInputStream fileInputStream=new FileInputStream(file);


        // create an XSSF Workbook object for our XLSX Excel File
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

        // get the first sheet
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        // iterate on every rows
        Iterator<Row> rowIterator = xssfSheet.iterator();
        while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            // iterate on cells for the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                System.out.print(cell.toString() + ";");
            }
            System.out.println();
        }
        xssfWorkbook.close();
        fileInputStream.close();

        int rowNumber=xssfSheet.getLastRowNum();
        for(int i=0;i<=rowNumber;i++)
        {
            //using IdeaHamster object set xlsx data to IdeaHamster variables
            ideaHamster.setEmail(xssfSheet.getRow(i).getCell(1).toString());
            ideaHamster.setName(xssfSheet.getRow(i).getCell(0).toString());
            ideaHamster.setMobileNo(new Long(xssfWorkbook.getSheetAt(0).getRow(i).getCell(2).getRawValue()));

            ideaHamsterDto.setEmail(xssfSheet.getRow(i).getCell(1).toString());
            ideaHamsterDto.setUserName(xssfSheet.getRow(i).getCell(0).toString());
            ideaHamsterDto.setRole(xssfSheet.getRow(i).getCell(3).toString());
            ideaHamsterDto.setPassword(xssfSheet.getRow(i).getCell(4).toString());

            ideaHamsterService.saveIdeaHamster(ideaHamsterDto);
            ideaHamsterService.updateTheProfile(ideaHamster);

        }

    }
}
