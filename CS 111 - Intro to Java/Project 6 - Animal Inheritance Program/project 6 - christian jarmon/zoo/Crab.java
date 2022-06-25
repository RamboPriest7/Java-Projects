/* Christian Jarmon
CMPSCI 111L - Spring 2020
Project 6 */
public class Crab extends Animal implements Running, Swimming {
 protected int time;
 public Crab(int number, int time) {
  super(number);
  this.time = time;
 }
 public void showProfile() {
  println("This is a crab that is " + number + " feet tall.");
 }
 public void run() {
  int speed = number / 2;
  println("This crab can run at " + speed + " miles/hour.");
 }
 public void swim() {
  int speed = number * 2;
  println("This crab can swim at " + speed + " miles/hour.");
 }
 public void pinch() {
  println("This crab can pinch for " + time + " seconds.");
 }
  public void println(String str) {
  System.out.println(str); 
   
 }
}