/* Christian Jarmon
 CMPSCI 111L - Spring 2020
 Project 3 */
 
 import java.util.Scanner;
 
 public class CMPSCI111P3 {
     public static void main(String[] args) {
         //Storage
         Scanner input = new Scanner(System.in);
         //Input Part 1
         String linesText;
         if (args.length == 0) {
             System.out.print("Enter the number of lines to type: ");
             linesText = input.nextLine();
         } else {
             linesText = args[0];
         }
         //Input Part 2
         Scanner textScanner = new Scanner(linesText);
         if (!textScanner.hasNextInt()) {
             System.out.println("Error: Non-integer input.");
             System.exit(1);
         }
         int lines = textScanner.nextInt();
         if (lines < 1 || lines > 5) {
             System.out.println("Error: Invalid integer number.");
             System.exit(1);
         }
         //Input Part 3
         String[][] paragraph = new String[lines][];
         for (int i = 0; i < paragraph.length; i++) {
             System.out.print("Line " + i + ": ");
             String line = input.nextLine();
             paragraph[i] = line.split("\\s");
         }
         //Calculation Part 1
         for (int i = 0; i < paragraph.length; i++) {
             for (int j = 0; j < paragraph[i].length; j++) {
                 paragraph[i][j] = String.format("%-10s", paragraph[i][j]);
             }
         }
         //Calculation Part 2
         for (int i = 0; i < paragraph.length; i++) {
             for (int j = 0; j < paragraph[i].length; j++) {
                 paragraph[i][j] = paragraph[i][j].substring(0, 10);
             }
         }
         //Calculation Part 3
         for (int i = 0; i < paragraph.length; i++) {
             for (int j = 0; j < paragraph[i].length - 1; j++) {
                 for (int k = j + 1; k < paragraph[i].length; k++) {
                     if (paragraph[i][j].compareToIgnoreCase(paragraph[i][k]) > 0) {
                         String temporary = paragraph[i][j];
                         paragraph[i][j] = paragraph[i][k];
                         paragraph[i][k] = temporary;
                     }
                 }
             }
         }
         //Output
         for (int i = 0; i < paragraph.length; i++) {
             for (int j = 0; j < paragraph[i].length; j++) {
                 System.out.print(paragraph[i][j] + " ");
             }
             System.out.println();
         }
     }
 }
