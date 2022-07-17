import java.io.*;
import java.lang.*;
import java.io.File; 
import java.io.IOException;  

import java.io.FileWriter;

public class CreateFile {
    public static void main(String[] args) {
      try {
        File myObj = new File("results.txt");
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
        } else {
          System.out.println("File already exists.");
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }


      FileWriter myWriter = new FileWriter("results.txt");
     
      for (int i = 0; i < 1000; i++)
      {
          long number = i;
          myWriter.write(number + ": ");
          while (number != 1)
          {
              if (number % 2 == 0)
              {
                  number /= 2;
                  myWriter.write(number + " ");
              }
              else
              {
                  number = (number * 3) + 1;
                  myWriter.write(number + " ");
              }
          }
          myWriter.write("\n");
      }
      myWriter.close();


    }
  }