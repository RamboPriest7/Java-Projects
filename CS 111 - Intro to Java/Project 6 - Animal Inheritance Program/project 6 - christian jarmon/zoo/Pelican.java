/* Christian jamron
CMPSCI111L - Spring 2020
Project 6*/
public class Pelican extends Animal implements Flying, Swimming {
 protected int depth;
 public Pelican(int number, int depth) {
  super(number);
  this.depth = depth;
 }
 public void showProfile() {
  println("This is a pelican that is " + number + " feet tall.");
 }
 public void fly() {
  int speed = number * 2;
  println("This pelican can fly at " + speed + " miles/hour.");
 }
 public void swim() {
  int speed = number / 2;
  println("This pelican can swim at " + speed + " miles/hour.");
 }
 public void dive() {
  println("This pelican can dive " + depth + " feet deep.");
 }
 public void println(String str) {
  System.out.println(str); 
   
 }
}