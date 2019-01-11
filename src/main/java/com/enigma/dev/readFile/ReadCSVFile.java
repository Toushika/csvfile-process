package com.enigma.dev.readFile;

import com.enigma.dev.request.CSVRequest;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFile {
    private static final  String[]FILE_HEADER_MAPPING ={"id","firstName","lastName","gender","age"};
   // Employee attributes
    private static final String EMPLOYEE_ID = "id";
    private static final String EMPLOYEE_FNAME = "firstName";
    private static final String EMPLOYEE_LNAME = "lastName";
    private static final String EMPLOYEE_GENDER = "gender";
    private static final String EMPLOYEE_AGE = "age";

    public static void readCsvFile(String fileName)  {

        FileReader fileReader = null;

        CSVParser csvFileParser = null;

        //Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

        try {

            //Create a new list of student to be filled by CSV file data
            List <CSVRequest>employeeList = new ArrayList();

            //initialize FileReader object
            fileReader = new FileReader(fileName);

            //initialize CSVParser object
            csvFileParser = new CSVParser(fileReader, csvFileFormat);

            //Get a list of CSV file records
            List csvRecords = csvFileParser.getRecords();

            //Read the CSV file records starting from the second record to skip the header
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = (CSVRecord) csvRecords.get(i);
                //Create a new student object and fill his data
                CSVRequest employee = new CSVRequest(Long.parseLong(record.get(EMPLOYEE_ID)), record.get(EMPLOYEE_FNAME), record.get(EMPLOYEE_LNAME), record.get(EMPLOYEE_GENDER), Integer.parseInt(record.get(EMPLOYEE_AGE)));
                employeeList.add(employee);
            }

            //Print the new student list
            for (CSVRequest employee : employeeList) {
                System.out.println(employee.toString());
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader/csvFileParser !!!");
                e.printStackTrace();
            }
        }

    }
}
