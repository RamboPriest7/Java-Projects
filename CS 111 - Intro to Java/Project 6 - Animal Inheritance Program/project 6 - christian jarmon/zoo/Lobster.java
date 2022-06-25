/* Christian Jarmon
CMPSCI 111L - Spring 2020
Project 6 */
public class Lobster extends Crab {
 protected int food;
 public Lobster(int number, int time, int food) {
  super(number, time);
  this.food = food;
 }
 public void showProfile() {
  println("This is a lobster that is " + number + " feet tall.");
 }
 public void pinch() {
  super.pinch();
  println("...except that it is actually a lobster.");
 }
 public void pinch(int extra) {
  println("This lobster can pinch for " + time + " seconds.");
  println("Using force extends it by " + extra + " seconds.");
 }
 public void eat() {
  println("This lobster can eat " + food + " shrimp/day.");
 }
 
 public void println(String str) {
  System.out.println(str); 
   
 }
}