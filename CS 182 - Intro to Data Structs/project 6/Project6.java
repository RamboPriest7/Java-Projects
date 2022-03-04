/***************************************************************

Project Number 6 - Comp Sci 182 - Data Structures
Start Code - Build your program starting with this code

Copyright 2005,2016 Christopher C. Ferguson
This code may only be used with the permission of Christopher C. Ferguson

***************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.Hashtable;

public class Project6 extends JFrame implements ActionListener {

private static int win_xpos=0,win_ypos=0;// place window here
private static int win_xsize=700,win_ysize=500;//  window size

// Private state variables.

private Font boldfont = new Font ("TimesRoman",Font.BOLD,18);
private Font plainfont = new Font ("TimesRoman",Font.PLAIN,12);

private JButton hashbutton,exitbutton;
private JPanel northPanel;
private MyJPanel centerPanel;
private JTextField hashsizefield;
private String thetext = "211";
JTextArea crash;
HashTable table;
static Project6 tpo;

//////////// MAIN////////////////////////

public static void main(String[] args) {
    tpo = new Project6();

        tpo.addWindowListener(new WindowAdapter() {   // this exits the program when X box clicked
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
}

////////////CONSTRUCTOR/////////////////////
public Project6 getProject() {
    return tpo;
}
public Project6 ()  {
       northPanel = new JPanel();
       northPanel.add(new Label("Enter a hashtable size: "));
       hashsizefield = new JTextField(thetext,20);
       northPanel.add(hashsizefield);
       hashbutton = new JButton("CreateHash");
       northPanel.add(hashbutton);
       hashbutton.addActionListener(this);
       exitbutton = new JButton("Exit");
       northPanel.add(exitbutton);
       exitbutton.addActionListener(this);
       getContentPane().add("North",northPanel);
       centerPanel = new MyJPanel();
       getContentPane().add("Center",centerPanel);
       crash = new JTextArea("test", 0, 0);
       centerPanel.add(crash);
       getContentPane().add(centerPanel, "West");
/*
       int y = 30;
JTextArea crash;
       // need more init stuff? try here.
       for (int i = 0; i < table.getCrashes().length; i++) {
        crash = new JTextArea(table.getCrashes()[i], 20, y);
        centerPanel.add(crash);
        y+= 10;
       }//for ends  */
       setSize(win_xsize,win_ysize);
       setLocation(win_xpos,win_ypos);
       setVisible(true);
}

////////////BUTTON CLICKS ///////////////////////////

public void actionPerformed(ActionEvent e) {
         if (e.getSource()==exitbutton) {
               dispose(); System.exit(0);
         }

         if (e.getSource()==hashbutton) {
            int y = 30;
               thetext = hashsizefield.getText();
               table = new HashTable(Integer.parseInt(thetext));
              
               crash.setText("test2");
               crash.setLocation(0, y);
               centerPanel.add(crash);
               getContentPane().add(centerPanel, "West");
               repaint();
               System.out.println("doing everything");
               table.doEverything();
           
             
               System.out.println("printing crashes");
               System.out.println(table.getCrashLength());
                      for (int i = 0; i < table.getCrashes().length; i++) {
                      //System.out.println("printing crashes");  ->>>//reached
                        crash.setText(table.getCrashes()[i]);
                       crash.setLocation(0, (i * 30));
                       centerPanel.add(crash);
                       getContentPane().add(crash);
                       repaint();
              
                     System.out.print(i + "," + table.getCrashes()[i].charAt(3) + "->");
                       y+= 10;
                       if (table.getCrashes()[i + 1].equals("")) {System.out.println("shit is done"); break;}
                      }//for ends  
                    
         }
} // end actionPerformed



class MyJPanel extends JPanel {

 ////////////    PAINT   ////////////////////////////////
  public void paintComponent (Graphics g) {
//int yposition = 30;
         g.setFont(plainfont);
         thetext = hashsizefield.getText();
               table = new HashTable(Integer.parseInt(thetext));
         table.doEverything();
         int y = 30;
         for (int i = 0; i < table.getCrashes().length; i++) {
          System.out.println("testing" + table.getCrashes()[i]);
          g.drawString(table.getCrashes()[i], 20,y);
           y+=25;
           if (table.getCrashes()[i + 1].equals("")) {System.out.println("shit is done"); break;}
         }
       /*
         for (int i = 0; i < table.getCrashes().length; i++) {
         g.drawString(table.getCrashes()[i], 20,yposition);
         yposition += 10;
        }//for ends     */
  }

  public void justAdd() {
    int y = 30;
    JTextArea crash;
           // need more init stuff? try here.
           for (int i = 0; i < table.getCrashes().length; i++) {
            crash = new JTextArea(table.getCrashes()[i], 20, y);
            centerPanel.add(crash);
            y+= 10;
           }//for ends  
  }
} // End Of MyJPanel

}     // End Of Project6