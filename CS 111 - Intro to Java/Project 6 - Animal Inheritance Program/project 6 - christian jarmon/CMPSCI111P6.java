
/* christian jarmon
CMPSCI 111L - Spring 2020
Project 6 */
import java.util.Random;
import java.util.Scanner;

public class CMPSCI111P6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random generator = new Random();

		print("Enter a length between 5 to 10: ");
		if (!(input.hasNextInt())) {
			error("Non-integer input.");
		}
		int length = input.nextInt();
		input.nextLine();
		if (length < 5 || length > 10) {
			error("Invalid length.");
		}
		input.close();
		// input ends
		Animal[] animals = new Animal[length];
		// calc & out 1
		println("*** Part 1 ***");
		for (int i = 0; i < animals.length; i++) {
			int number1 = generator.nextInt(4) + 1;
			int number2 = generator.nextInt(11) + 4;
			int number3 = generator.nextInt(21) + 15;
			int number4 = generator.nextInt(21) + 15;
			switch (number1) {
				case 1:
					animals[i] = new Squirrel(number2, number3);
					break;
				case 2:
					animals[i] = new Pelican(number2, number3);
					break;
				case 3:
					animals[i] = new Crab(number2, number3);
					break;
				case 4:
					animals[i] = new Lobster(number2, number3, number4);
					break;
				default:
					error("Invalid animal choice: " + number1 + ".");
			}
			println("Animal " + (i + 1) + ":");
			animals[i].showProfile();
		} // calc 1 ends
			// calc & out 2
		println("***part 2***");
		for (int i = 0; i < animals.length; i++) {
			println("Animal " + (i + 1) + ":");
			if (animals[i] instanceof Running) {
				Running runner = (Running) animals[i];
				runner.run();
			}
			if (animals[i] instanceof Flying) {
				Flying flyer = (Flying) animals[i];
				flyer.fly();
			}
			if (animals[i] instanceof Swimming) {
				Swimming swimmer = (Swimming) animals[i];
				swimmer.swim();
			}
		} // calc 2 ends
			// calc & out 3
		println("*** Part 3 ***");
		for (int i = 0; i < animals.length; i++) {
			println("Animal " + (i + 1) + ":");
			if (animals[i] instanceof Squirrel) {
				Squirrel squirrel = (Squirrel) animals[i];
				squirrel.jump();
			} else if (animals[i] instanceof Pelican) {
				Pelican pelican = (Pelican) animals[i];
				pelican.dive();
			} else if (animals[i] instanceof Crab) {
				Crab crab = (Crab) animals[i];
				crab.pinch();
				if (crab instanceof Lobster) {
					Lobster lobster = (Lobster) crab;
					int number5 = generator.nextInt(10) + 1;
					lobster.pinch(number5);
					lobster.eat();
				}
			} else {
				error("Invalid animal at index " + i + ".");
			}
		}
	}// calc 3 ends
		// error method

	public static void error(String message) {
		println("Error: " + message);
		System.exit(1);
	}// error ends

	public static void println(String str) {
		System.out.println(str);

	}// println ends

	public static void print(String str) {
		System.out.print(str);

	}// print ends

}