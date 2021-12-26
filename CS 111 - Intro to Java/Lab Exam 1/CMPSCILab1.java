
/* Christian Jarmon
CMPSCI 111L - Spring 2020
Lab Exam 1 */ 


import java.util.Scanner;

class CMPSCILab1 {
public static void main(String[] args) {
//VARIABLES
Scanner scan = new Scanner(System.in);
Scanner scan2 = new Scanner(System.in);
int input = 0;
String sentence;

//INPUTs
System.out.println("Enter a number between 2 and 5.");
if (scan.hasNextInt()) {
input = scan.nextInt();
} else  {
System.out.println("Not a number.");
System.exit(1);
}
if (input > 5 || input < 2) {
System.out.println("Not a number between 2 and 5");
System.exit(1);
}

System.out.println("Enter a sentence.");
sentence = scan2.nextLine();
if (sentence.equals("")) {
System.out.println("No sentence");
System.exit(1);
}
String [] words = sentence.split("\\s");
int option = 0;
//OUTPUTS
while (option != 4) {
System.out.println("Select and option: 1)Print every word uppercased");
System.out.println("                   2)Print the last character of every word");
System.out.println("                   3)Print every word multiple times");
System.out.println("                   4)Exit");
if (scan.hasNextInt()) {
option = scan.nextInt();
} else {
option = 0;
}

switch (option) {
case 1: for (int i = 0; i < words.length; i++) {
System.out.println(words[i].toUpperCase());
}
break;
case 2: for (int i = 0; i < words.length; i++) {
System.out.println(words[i].charAt(words[i].length()-1));
}
break;
case 3: for (int i = 0; i < words.length; i++) {
for (int j = 0; j < input; j++) {
System.out.print(words[i] + " ");
}
System.out.println();
}
break;
case 4: System.out.println("Goodbye");
System.exit(1);
default: System.out.println("Invalid option, try again");
System.exit(1);
}//switch ends

}//while ends



}//main method ends
}//class ends

