/*Christian Jarmon
CMPSCI 111L - Spring2020
Project 6 */
public class Squirrel extends Animal implements Running, Flying {
 protected int distance;
 public Squirrel(int number, int distance) {
  super(number);
  this.distance = distance;
 }
 public void showProfile() {
  println("This is a squirrel that is " + number + " feet tall.");
 }
 public void run() {
  int speed = number * 2;
  println("This squirrel can run at " + speed + " miles/hour.");
 }
 public void fly() {
  int speed = number / 2;
  println("This squirrel can fly at " + speed + " miles/hour.");
 }
 public void jump() {
 println("This squirrel can jump " + distance + " feet high.");
 }
 public void println(String str) {
  System.out.println(str); 
   
 }
}