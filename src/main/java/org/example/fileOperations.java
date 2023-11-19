package org.example;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

public class fileOperations {
   public static doubleLinkedList transferFileDataToDoubleLinkedList(String file) throws FileNotFoundException {
        try {
            doubleLinkedList list = new doubleLinkedList();
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                list.insertAscending(count,data);
                count++;
            }
            myReader.close();
            return list;

        } catch (FileNotFoundException e) {

            throw e;
        }
    }

    public static void writeInFile(String fileName){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
