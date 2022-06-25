/* This is a debug program that is
meant to test out the Animal objects
that are required for Project 6.
DO NOT modify this program in ANY way.
Also DO NOT submit this file as part
of your submission for Project 6. */

public class TestTheAnimals {
	public static void main(String[] args) {
		System.out.println("*** PART 1 - SQUIRREL ***");
		Squirrel squirrel = new Squirrel(6, 15);
		squirrel.showProfile();
		squirrel.run();
		squirrel.fly();
		squirrel.jump();
		System.out.println("*** PART 2 - PELICAN ***");
		Pelican pelican = new Pelican(8, 20);
		pelican.showProfile();
		pelican.fly();
		pelican.swim();
		pelican.dive();
		System.out.println("*** PART 3 - CRAB ***");
		Crab crab = new Crab(10, 25);
		crab.showProfile();
		crab.run();
		crab.swim();
		crab.pinch();
		System.out.println("*** PART 4 - LOBSTER ***");
		Lobster lobster = new Lobster(12, 30, 35);
		lobster.showProfile();
		lobster.run();
		lobster.swim();
		lobster.pinch();
		lobster.pinch(4);
		lobster.eat();
		System.out.println("*** END OF TESTING ***");
	}
}