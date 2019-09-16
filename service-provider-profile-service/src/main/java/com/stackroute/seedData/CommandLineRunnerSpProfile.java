package com.stackroute.seedData;

import com.stackroute.domain.Role;
import com.stackroute.domain.ServiceProvider;
import com.stackroute.dto.ServiceProviderDto;
import com.stackroute.service.ServiceProviderServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Component
public class CommandLineRunnerSpProfile implements CommandLineRunner
{
  private ServiceProviderDto serviceProviderDto;
  private ServiceProviderServiceImpl serviceProviderServiceImpl;

  @Autowired
  public CommandLineRunnerSpProfile(ServiceProviderDto serviceProviderDto, ServiceProviderServiceImpl serviceProviderServiceImpl)
  {
       this.serviceProviderDto = serviceProviderDto;
       this.serviceProviderServiceImpl = serviceProviderServiceImpl;
  }


    @Override
    public void run(String... args) throws Exception
    {
        // need to load Excel XLSX file to read
        File file = new File("sp-profile-service.xlsx");

        FileInputStream fileInputStream=new FileInputStream(file);


        // create an XSSF Workbook object for our XLSX Excel File
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

        // get the first sheet
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        // iterate on every rows
        Iterator<Row> rowIterator = xssfSheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // iterate on cells for the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.print(cell.toString() + ";");
            }
            System.out.println();
        }
        xssfWorkbook.close();
        fileInputStream.close();

        int noOfRow=xssfSheet.getLastRowNum();
        for(int i=0;i<=noOfRow;i++)
        {

            ServiceProvider serviceProvider=new ServiceProvider();
            //using the ServiceProvider object set xlsx data to ServiceProvider variables
            serviceProvider.setName(xssfSheet.getRow(i).getCell(0).toString());
            serviceProvider.setChargePerHour(xssfSheet.getRow(i).getCell(5).toString());
            serviceProvider.setCurrentLocation(xssfSheet.getRow(i).getCell(6).toString());
            serviceProvider.setEmail(xssfSheet.getRow(i).getCell(1).toString());
            serviceProvider.setDomain(xssfSheet.getRow(i).getCell(3).toString());
            serviceProvider.setSubDomain(xssfSheet.getRow(i).getCell(4).toString());
            serviceProvider.setMobileNo(new Long(xssfWorkbook.getSheetAt(0).getRow(i).getCell(2).getRawValue()));

            Role role = new Role();
            role.setExperience(xssfSheet.getRow(i).getCell(9).toString());
            role.setRoleName(xssfSheet.getRow(i).getCell(8).toString());
            List<Role> list1 = new ArrayList<>();
            list1.add(role);
            serviceProvider.setRole(role);
            ArrayList list = new ArrayList<>(Collections.singleton(xssfSheet.getRow(i).getCell(10).toString()));
            role.setSkills(list);
            ArrayList list2=new ArrayList<>(Collections.singleton(xssfSheet.getRow(i).getCell(7).toString()));
            serviceProvider.setPreferredLocation(list2);

            serviceProviderDto.setPassword(xssfSheet.getRow(i).getCell(11).toString());
            serviceProviderDto.setEmail(xssfSheet.getRow(i).getCell(1).toString());
            serviceProviderDto.setUserName(xssfSheet.getRow(i).getCell(0).toString());
            serviceProviderDto.setRole(xssfSheet.getRow(i).getCell(12).toString());

            serviceProviderServiceImpl.saveServiceProvider(serviceProviderDto);
            serviceProviderServiceImpl.updateTheProfile(serviceProvider);

        }
    }
}
