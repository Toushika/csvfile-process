package com.enigma.dev.csvFileProcessor;

import com.enigma.dev.readFile.ReadCSVFile;
import com.enigma.dev.writeFile.WriteCSVFile;

public class csvFileProcessor {
    public static void main(String[]args){
        ReadCSVFile readCSVFile = new ReadCSVFile();
        WriteCSVFile writeCSVFile =new WriteCSVFile();
        String fileName="F://Learn/CSVFile/test1.csv";
        readCSVFile.readCsvFile(fileName);
        WriteCSVFile.writeCsvFile(fileName);
    }
}
