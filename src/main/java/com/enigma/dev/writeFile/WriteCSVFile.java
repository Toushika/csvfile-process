package com.enigma.dev.writeFile;

import com.enigma.dev.request.CSVRequest;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteCSVFile {
    private static final String NEW_LINE_SEPARATOR ="\n";

    //csv file header
    private static final Object[] FILE_HEADER ={"id","firstName","lastName","gender","age"};
    public static void writeCsvFile(String fileName){
        CSVRequest csvRequest1 =new CSVRequest(1, "Ahmed", "Mohamed", "M", 2);
        CSVRequest csvRequest2 =new CSVRequest(2, "Sara", "Said", "F", 23);
        CSVRequest csvRequest3 =new CSVRequest(3, "Ali", "Hassan", "M", 24);
        CSVRequest csvRequest4 =new CSVRequest(4, "Sama", "Karim", "F", 20);
        CSVRequest csvRequest5 =new CSVRequest(5, "Khaled", "Mohamed", "M", 22);
        CSVRequest csvRequest6 =new CSVRequest(6, "Ghada", "Sarhan", "F", 21);

        List<CSVRequest>employeeList = new ArrayList();

        employeeList.add(csvRequest1);
        employeeList.add(csvRequest2);
        employeeList.add(csvRequest3);
        employeeList.add(csvRequest4);
        employeeList.add(csvRequest5);
        employeeList.add(csvRequest6);

        FileWriter fileWriter =null;
        CSVPrinter csvFilePrinter  = null;

        //Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
        //Create CSV file header

        try{
            fileWriter= new FileWriter(fileName);
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
            csvFilePrinter.printRecord(FILE_HEADER);

            for (CSVRequest employee : employeeList) {
                List studentDataRecord = new ArrayList();
                studentDataRecord.add(String.valueOf(employee.getId()));
                studentDataRecord.add(employee.getFirstName());
                studentDataRecord.add(employee.getLastName());
                studentDataRecord.add(employee.getGender());
                studentDataRecord.add(String.valueOf(employee.getAge()));
                csvFilePrinter.printRecord(studentDataRecord);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
            }
        }


    }
}
