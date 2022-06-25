/* Christian Jarmon
CMPSCI 111L - Spring 2020
Project 5 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CMPSCI111P5 {
    // The Main Method
    public static void main(String[] args) {
        // File Input
        if (args.length < 1) {
            error("Please enter a command line argument.");
        }
        String inputFile = args[0];
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(inputFile);
        } catch (Exception e) {
            error(inputFile + " not found.");
        }
        // Scanning the File
        Scanner scanner = new Scanner(inputStream);
        int lineNumber = 0;
        ArrayList<LineOfText> textFile = new ArrayList<LineOfText>();
        while (scanner.hasNextLine()) {
            String sentence = scanner.nextLine();
            lineNumber++;
            LineOfText line = new LineOfText(sentence, lineNumber, " ");
            textFile.add(line);
        }
        // Closing the Input
        scanner.close();
        try {
            inputStream.close();
        } catch (Exception e) {
            error("Unable to close the input stream.");
        }
        // Print the text file before changing it
        System.out.println("Before:");
        for (LineOfText line : textFile) {
            System.out.println(line);
        }
        // Change every line in the text file
        for (int i = 0; i < textFile.size(); i++) {
            textFile.set(i, changeTheLine(textFile.get(i)));
        }
        // Change the space displayed in the text file
        for (LineOfText line : textFile) {
            changeTheSpace(line);
        }
        // Print the text file after changing it
        System.out.println("After:");
        for (LineOfText line : textFile) {
            System.out.println(line);
        }
        // File Output
        String outputFile = "output-" + inputFile;
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(outputFile);
        } catch (Exception e) {
            error("Cannot create " + outputFile + ".");
        }
        // Writing the File
        PrintWriter writer = new PrintWriter(outputStream);
        for (LineOfText line : textFile) {
            writer.println(line.toSentence());
        }
        // Closing the Output
        writer.close();
        try {
            outputStream.close();
        } catch (Exception e) {
            error("Unable to close the output stream.");
        }
    }

    // Other Methods
    public static LineOfText changeTheLine(LineOfText line) {
        LineOfText result = new LineOfText(line);
        for (int i = 0; i < result.getLength(); i++) {
            String word = result.getWord(i);
            if (i % 2 == 0) {
                word = word.toUpperCase();
            } else {
                word = word.toLowerCase();
            }
            result.setWord(i, word);
        }
        return result;
    }

    public static void changeTheSpace(LineOfText line) {
        line.setSpace("_");
    }

    public static void error(String message) {
        System.out.println("Error: " + message);
        System.exit(1);
    }

    public static void println(String Statement) {
        System.out.println(Statement);
    }

    public static void print(String Statement) {
        System.out.print(Statement);
    }
}