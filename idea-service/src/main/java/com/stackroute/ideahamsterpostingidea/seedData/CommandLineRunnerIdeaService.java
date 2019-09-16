package com.stackroute.ideahamsterpostingidea.seedData;

import com.stackroute.ideahamsterpostingidea.domain.Idea;
import com.stackroute.ideahamsterpostingidea.domain.Role;
import com.stackroute.ideahamsterpostingidea.service.IdeaServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class CommandLineRunnerIdeaService implements CommandLineRunner
{
    private IdeaServiceImpl ideaService;
    @Autowired
    public CommandLineRunnerIdeaService(IdeaServiceImpl ideaService)
    {
    this.ideaService=ideaService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        // need to load Excel XLSX file to read
        File file = new File("idea-service.xlsx");

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

        int rowNum=xssfSheet.getLastRowNum();
        for(int i=0;i<rowNum;i++)
        {
            Idea idea=new Idea();
            //using the Idea object set xlsx data to Idea variables
            idea.setTitle(xssfSheet.getRow(i).getCell(0).toString());
            idea.setDescription(xssfSheet.getRow(i).getCell(1).toString());
            idea.setDuration(xssfSheet.getRow(i).getCell(2).toString());
            idea.setCost(new Double(xssfWorkbook.getSheetAt(0).getRow(i).getCell(3).getRawValue()));
            idea.setStatus(xssfSheet.getRow(i).getCell(4).toString());
            idea.setLocation(xssfSheet.getRow(i).getCell(9).toString());
            idea.setDomain(xssfSheet.getRow(i).getCell(10).toString());
            idea.setSubDomain(xssfSheet.getRow(i).getCell(11).toString());
            idea.setPostedBy(xssfSheet.getRow(i).getCell(12).toString());

            Role role = new Role();
            role.setExperience(xssfSheet.getRow(i).getCell(6).toString());
            role.setRole(xssfSheet.getRow(i).getCell(5).toString());
            role.setNoOfPeople(xssfSheet.getRow(i).getCell(8).toString());
            List<Role> list1 = new ArrayList<>();
            list1.add(role);
            ArrayList list = new ArrayList<>(Collections.singleton(xssfSheet.getRow(i).getCell(7).toString()));
            role.setSkills(list);
            idea.setRole(list1);
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();
            idea.setPostedOn(dateobj);
            ideaService.save(idea);

        }
    }
}
