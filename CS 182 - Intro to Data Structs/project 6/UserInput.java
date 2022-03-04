import java.util.Scanner;

public class UserInput {
    static Scanner input = new Scanner(System.in);

    public static int getInt() {
        System.out.print("Enter an integer: ");
        int intValue = input.nextInt();
        input.nextLine();
        System.out.println("You entered the integer " + intValue);
return intValue;
    } //getInt ends
    public static char getChar() {
        System.out.print("Enter a character: ");
        char letter = input.next().charAt(0);
        input.nextLine();
        System.out.println("You entered the character: " + letter);
        
return letter;
    } //getChar ends       
    public static double getDouble() {
        System.out.print("Enter a double value: ");
        double doubleValue = input.nextDouble();
        System.out.println("You entered the double value " +
            doubleValue);
        
return doubleValue;
    } //getDouble ends
    public static String getString() {

        System.out.print("Enter a string without space: ");
        input.nextLine();
        String string = input.nextLine();
        System.out.println("You entered the string -> " + string);
        
return string;
    } //getString ends

    //____________________________________________________________________________________
    //OverLoaded Methods
    public static int getInt(int min, int max) {
        System.out.print("Enter an integer: ");
        int intValue = input.nextInt();
        input.nextLine();
        System.out.println("You entered the integer " + intValue);
        while (intValue > max ^ intValue < min) {


            System.out.print("Number not in range, range is (" + min + "," + max + "), try again.");
            intValue = input.nextInt();
            System.out.println("You entered the integer " + intValue);

        } //while ends
        
return intValue;
    } //getInt ends
    public static char getChar(char min, char max) {
        System.out.print("Enter a character: ");
        char letter = input.next().charAt(0);
        input.nextLine();
        System.out.println("You entered the character: " + letter);
        while (letter > max ^ letter < min) {


            System.out.print("Letter not in range, range is (" + min + "," + max + "), try again.");
            letter = input.next().charAt(0);
            System.out.println("You entered the character " + letter);
        } //while ends
        
        return letter;
    } //getChar ends       
    public static double getDouble(double min, double max) {
        System.out.print("Enter a double value: ");
        double doubleValue = input.nextDouble();
        System.out.println("You entered the double value " + doubleValue);
        while (doubleValue > max ^ doubleValue < min) {


            System.out.print("Double not in range, range is (" + min + "," + max + "), try again.");
            doubleValue = input.nextDouble();
            System.out.println("You entered the double " + doubleValue);
        } //while ends
        
return doubleValue;
    } //getDouble ends




    public static String getString(int min, int max) {
        System.out.println("Enter a string: ");
        String string = input.nextLine();
        System.out.println("you have entered: " + string);
        
        

        /*while (string.length() > max ^ string.length() < min) {


            System.out.print("String length not in range, length range is (" + min + "," + max + "), try again.");
            string = input.nextLine();
            System.out.println("You entered the string -> " + string);
        } //while ends
        */
        
        return string;
    } //getString ends






  /*  public static void main(String[] args) {
System.out.println("start");
        int state = 1;
        while (state != 9) {
            switch (state) {
                case 1:
                    System.out.println("Test: " + state);
                    getInt();
                    break;
                case 2:
                    System.out.println("Test: " + state);
                    getChar();
                    break;
                case 3:
                    System.out.println("Test: " + state);
                    getDouble();
                    break;
                case 4:
                    System.out.println("Test: " + state);
                    getString();
                    break;
                case 5:
                    System.out.println("Test: " + state);
                    getInt(2, 20);
                    break;
                case 6:
                    System.out.println("Test: " + state);
                    getChar('B', 'R');
                    break;
                case 7:
                    System.out.println("Test: " + state);
                    getDouble(6.8, 54.9);
                    break;
                case 8:
                    System.out.println("Test: " + state);
                    getString(2, 6);
                    break;
                default:
                    System.out.println("Done.");
                    break;
                    
            } //switch ends
            state++;
        } //while ends


    } //main ends
*/
} //class ends