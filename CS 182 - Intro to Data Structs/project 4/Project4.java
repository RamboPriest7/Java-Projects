/***************************************************************

Project Number 4 - Comp Sci 182 - Data Structures
Start Code - Build your program starting with this code

Snakes! I Hate Snakes!   -   Indiana Jones

Copyright 2003,2005 Christopher C. Ferguson
This code may only be used with the permission of Christopher C. Ferguson

***************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Project4 extends JFrame implements ActionListener {

    /**
    	 *
    	 */
    private static final long serialVersionUID = 1L;
    private static int xpos = 0, ypos = 0;// place window at this position
private static int xsize=700,ysize=500;// set window to this size

// Private state variables.

private JPanel northPanel,centerPanel, fuckingPanel;
private JLabel picture;
private JButton pushButton,popButton,restartButton,exitButton;
private JTextField colorField;
private JTextField codeField;
private JTextArea outputArea, doorsText;
static String newcolor;
static int newcode;
Path game;



////////////MAIN////////////////////////

public static void main(String[] args) {
        Project4 tpo = new Project4();
}

////////////CONSTRUCTOR/////////////////////

public Project4 ()
{
    game = new Path();
       addScreenComponents();   // put the stuff on the screen

       // Exit when the window is closed. i.e. when top right X box pressed
       addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
           //   System.exit(0);
            }
        });

/*
        if (game.getRooms().getSize() > 0) {
while (!(game.getRooms().peek().equals("gold"))) {
    game.Continue();
}
}

*/
       setSize(xsize,ysize);
       setLocation(xpos,ypos);
       setVisible(true);

}

public void addScreenComponents()  {
    northPanel = new JPanel();
    northPanel.add(new JLabel("Enter A Color: "));
    colorField = new JTextField("",15);
    northPanel.add(colorField);
    northPanel.add(new JLabel("And A Code: "));
    codeField = new JTextField("",5);
    northPanel.add(codeField);

    pushButton = new JButton("Push");
    northPanel.add(pushButton);
    pushButton.addActionListener(this);
    popButton = new JButton("Pop");
    northPanel.add(popButton);
    popButton.addActionListener(this);
    restartButton = new JButton("Restart");
    northPanel.add(restartButton);
    restartButton.addActionListener(this);
    exitButton = new JButton("Exit");
    northPanel.add(exitButton);
    exitButton.addActionListener(this);

    getContentPane().add("North",northPanel);

    centerPanel = new JPanel();
    outputArea = new JTextArea("Who Dares Enter.... The Temple of Gloom!",0,0);
    printDoors((Room)game.getRooms().peek());
    centerPanel.add(outputArea);

   
    getContentPane().add(centerPanel,"Center");
    

}
public void printDoors(Room obj){
 //if (obj.getColor().equalsIgnoreCase("gold"))
System.out.println("printing doors");
    centerPanel.removeAll();
 repaint();
 
centerPanel.add(new JTextArea("you are now in the " + obj.getColor() + " room, pick a room dammit------>"));
for (int i = 0; i < obj.getDoors().length; i++) {
 outputArea = new JTextArea(obj.getDoors()[i]);
centerPanel.add(outputArea);
}
}//print doors ends
/* 
picture = new JLabel();
       picture.setIcon(new ImageIcon("images/green.png"));
    picture.setPreferredSize(new Dimension(100, 200));




*/
////////////BUTTON CLICKS ///////////////////////////

public void actionPerformed(ActionEvent e) {
/*when you push and pop, you need to repaint the room with the color squares that represent the room respective doors, with the square of the current room at the bottom of the screen
figure how to print the images of squares, since the doors are represented as arrays, name the image files the same as the color and use a loop to print ->>
for (int i = 0; i < game.getRooms().size; i++) {
colorSquare = Project4.load_picture("images/" + game.getRooms().get(i).getColor());
okay maybe not load picutre
}//for ends


*/
         if (e.getSource()== exitButton) {
            dispose(); System.exit(0);
         }

         if (e.getSource()== popButton) {
            //when room is gold, tel player that they have gotten thte kyeboard      
            newcolor = colorField.getText();
                newcode = Integer.parseInt(codeField.getText());
                
                if (game.checkValidPop(newcode, newcolor) == false) 
               {endGame(); dispose(); System.exit(0);}
          game.getRooms().pop();
                System.out.println(game.getRooms().peek().getColor());
                printDoors((Room)game.getRooms().peek());
                if (game.getRooms().peek().getColor().equals("green") && game.getRooms().getSize() == 1) {
                    System.out.println(game.getRooms().getSize());
System.out.println("you did it");
winGame();
                }
                System.out.println("room popped");
               
                //outputArea.setText("Pop returning to " + newcolor);
                
         
         }

         if (e.getSource()== pushButton) {
                newcolor = colorField.getText();
                newcode = Integer.parseInt(codeField.getText());
                if (String.valueOf(newcode).length() != 3) {
                    endGame();
                }
                outputArea.setText("Push entering " + newcolor);
               if (game.checkValidPush(newcode, newcolor) == false) {endGame();} 
               if (!(newcolor.equals("gold"))) {
               game.Continue(); } 
              else { game.getRooms().push(new Room("gold", newcode));  }
             
              System.out.println("printing doors for room " + game.getRooms().peek().getColor());
                printDoors((Room)game.getRooms().peek());
                if (newcolor.equals("gold")) centerPanel.add(new JTextArea("you have retrieved the gold keyboard"));
                 // add code to push color/code ON the stack and change to that color room
         }

         if (e.getSource()== restartButton) {
                //System.out.println("Stack Contents restart: ");
             game.Restart();
             printDoors((Room) game.getRooms().peek());
             
              
             
                
         }

}
public void loadRoomDetails() {//this method prints out the doors, and any other relevant info

}//loadRoomDetails ends

public static String sendColor() {
    return newcolor;
}//sendColor ends
public static int sendCode() {
    return newcode;
}//sendCode ends
public void endGame() {
    System.out.println("failure");
    JOptionPane.showMessageDialog(centerPanel, "you failed");
   dispose();

 
 //outputArea.setText("die a horrible death");
game = new Path();
 
}
public void winGame() {
    System.out.println("you win");
    JOptionPane.showMessageDialog(centerPanel, "you win");
   dispose();
}
}     // End Of Project4