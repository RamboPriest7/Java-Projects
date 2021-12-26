
/* Christian Jarmon
CMPSCI 111L - Spring 2020
Project 1 */
import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class CMPSCI111P1 {
public static void main(String args[]) {
Scanner scan= new Scanner(System.in);
String name = "";
int number = 0;
double fraction = 0.00;

//input along with storage
System.out.println("Enter your name.");
name = scan.nextLine();
if (name.equals("")) {
System.out.println("No input.");
System.exit(1);
}
System.out.println("Enter an integer number between 10 to 30: ");
number = scan.nextInt();
if (!(number >= 10 && number <= 30)) {
System.out.println("Not a number between 10 and 30");
System.exit(1);
}
System.out.println("Enter a floating point number between 0.44 to 0.66:");
fraction = scan.nextDouble();
if (!(fraction <= 0.66 && fraction >= 0.44)) {
System.out.println("Not a floating point between 0.44 and 0.66");
System.exit(1);
}
/*beginning of calculations
*using temp variables and then adding them together at end
*/

int constant = 2;
double temp1res = 0.0;
double temp2res = 0.0;
double result;
if (number == 30) {
temp1res = number + constant;
} else if (number >= 25 && number < 29) {
temp1res = number - constant;
} else if (number >= 20 && number < 24) {
temp1res = number / constant;
} else if (number >= 10 && number < 20) {
temp1res = number% constant;
}
if (fraction > 0.55 && fraction <= 0.66) {
temp2res = temp1res * fraction;
}  else{
temp2res = temp1res / fraction;
}
//OUTPUT
result = temp2res;



System.out.println("Enter your name." + name);
System.out.println("Enter an integer number between 10 to 30: " + number);
System.out.println("Enter a floating point number between 0.44 to 0.66: " + fraction);
System.out.println(name + ", your result is: " + result);     
     
if (name.toLowerCase().equals("bob")) {
System.out.println("How cool! My grandpa's name is also " + name + "!");

}








} 
}//class ends



