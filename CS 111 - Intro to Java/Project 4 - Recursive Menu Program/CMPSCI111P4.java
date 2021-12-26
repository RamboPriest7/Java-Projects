/* Christian Jarmon
CMPSCI 111L - Spring 2020
Project 4 */
//QUICK NOTE: I created a method for printing because i got tired of typing System.out.println, hope that doesnt bother you. Its at the bottom.

import java.util.Random;
import java.util.Scanner;
public class CMPSCI111P4 {
 //Constant
 public static final int EXIT_OPTION = 4;
 //Global Variables
 public static int method1 = 0;
 public static int method2 = 0;
 public static int method3 = 0;
 public static Random generator = new Random();

 
 
 public static void main(String[] args) {
  //Storage
  Scanner input = new Scanner(System.in);
  //while loop
  int option = 0;
  while (option != EXIT_OPTION) {
   //input
   println("Select an option:");
   println("1) Print a sentence forwards and backwards");
   println("2) Find a random number between 0 to 100");
   println("3) Create a random password 10 characters long");
   println(EXIT_OPTION + ") Exit");
   System.out.print("Enter a number: ");
   if (input.hasNextInt()) {
    option = input.nextInt();
   } else {
    option = 0;
   }
   input.nextLine();
   //calc and out
   switch (option) {
    case 1:
     method1("There's no place like home");
     break;
    case 2:
     println("The random result is " + method2(0, 100));
     break;
    case 3:
     println("The password is " + method3(10));
     break;
    case EXIT_OPTION:
     goodbye();
     break;
    default:
     println("Bad input, try again.");
   }//switch ends
   println();
  }//while ends
 }//main ends
 //method 1
 public static void method1(String sentence) {
  
  int space = sentence.indexOf(" ");
  if (space >= 0) {
   String word = sentence.substring(0, space);
   String newSentence = sentence.substring(space + 1);
   println(word);
   method1(newSentence);
   println(word);
  } else {
   println(sentence);
  }
  method1++;
 }//method1 ends
 
//method 2
 public static int method2(int min, int max) {
  method2++;
  if (min < max) {
   if (generator.nextBoolean()) {
    return method2(min, max - 1);
   } else {
    return method2(min + 1, max);
   }//nested if ends
  } else {
   return max;
  }//outside if ends
  //method2++; unreacheabe. fix
 }//method2 ends
 
//method 3
 public static String method3(int length) {
  method3++;
  if (length > 0) {
   char character = (char)(generator.nextInt(95) + 32);
   return character + method3(length - 1);
  } else {
   return "";
  }
  //method3++; unreacheabe. fix
 }//method3 ends
 //goodbye
 public static void goodbye() {
  println("Here are the runtime statistics:");
  println("Method 1 was used " + method1 + " times.");
  println("Method 2 was used " + method2 + " times.");
  println("Method 3 was used " + method3 + " times.");
  println("Goodbye.");
 }
 //print method
 public static void println(String statement) {
 System.out.println(statement);
 
 }
 public static void println(){
 System.out.println();
 }
}//class ends