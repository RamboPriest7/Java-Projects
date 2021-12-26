//Written by Christian Jarmon
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.File;

public class BabyNameRanking {
    @SuppressWarnings("unchecked")
    private static LinkedHashMap<String, Integer>[] boys = new LinkedHashMap[10];
    @SuppressWarnings("unchecked")
    private static LinkedHashMap<String, Integer>[] girls = new LinkedHashMap[10];

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String answer;
        readNames(); // method to read the info from the files and add to our Map array
        // Get user input and continue until done
        do {
            System.out.print("Enter a year (2008-2017): ");
            int year = input.nextInt();
            input.nextLine();
            System.out.print("Boy or girl? ");
            String sex = input.nextLine().toLowerCase();
            System.out.print("Enter a name: ");
            String name = input.nextLine();
            switch (sex) {
            // display the output based on the sex (boy or girl)
            // boy or girl.get ("name")
            case "boy":
                System.out.println(
                        "Boy named " + name + " is ranked #" + boys[year - 2000 - 8].get(name) + " in " + year + ".");
                System.out.println();
                break;
            // boys[year - 2000 - 8].get(name)
            case "girl":
                System.out.println(
                        "Girl named " + name + " is ranked #" + girls[year - 2000 - 8].get(name) + " in " + year + ".");
                System.out.println();
                break;
            default:
                System.out.println("not a gender");
                break;
            // girls[year - 2000 - 8].get(name);
            }
            System.out.print("Do you want check another name (yes or no)?");
            answer = input.nextLine().toLowerCase();
        } while (answer.equals("yes"));
        input.close();
    } // end main
      // read information from each file and add to appropriate Map array

    public static void readNames() throws IOException {
        File infile;
        for (int i = 0; i < 10; ++i) { // each index in boys and girls is itself a hashmap
            boys[i] = new LinkedHashMap<String, Integer>(1000);
            girls[i] = new LinkedHashMap<String, Integer>(1000);

        } // end for loop
        for (int i = 0; i <= 9; ++i) { // this for loop is for each file
            // construct the file name

            String filename = (i + 8 <= 9) ? "babynameranking200" + (i + 8) + ".txt"
                    : "babynameranking20" + (i + 8) + ".txt";
            // System.out.println("printing file name");
            // System.out.println(filename);
            // System.out.println("file name printed");
            // System.out.println(i);
            infile = new File(filename);
            Scanner in = new Scanner(infile);
            while (in.hasNext()) {
                // read info from the file and add to Map arrays

                int rank = in.nextInt();
                String bName = in.next();
                int bNameRank = in.nextInt(); // this is the amount of babies with the name
                String gName = in.next();
                int gNameRank = in.nextInt(); // this is the amount of babies with the name

                // System.out.println(rank + " " + bName + " " + bNameRank + " " + gName + " " +
                // gNameRank);
                // System.out.println(bName);
                // System.out.println(gName);

                boys[i].put(bName, rank);
                girls[i].put(gName, rank);
                
                // System.out.println("vlues set" + rank);
                // System.out.println(in.nextLine());
            } // end while

            in.close();

        } // end for loop

    } // end readNames()
} // end Lab03
