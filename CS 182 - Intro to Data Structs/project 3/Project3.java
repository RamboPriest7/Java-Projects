/***************************************************************
  Project Number 3 - Comp Sci 182 - Data Structures (w/ Swing)
  Start Code - Build your program starting with this code
               Card Game
  Copyright 2005-2016 Christopher C. Ferguson
  This code may only be used with the permission of Christopher C. Ferguson
***************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Project3 extends JFrame implements ActionListener {

    private static int winxpos = 0, winypos = 0; // place window here


    private JButton shuffleButton, exitButton, newButton, hitButton, standButton, resultButton;
    private CardList theDeck = null;
    private JPanel northPanel;
    private MyPanel centerPanel;
    private static JFrame myFrame = null;
    BlackJack game = new BlackJack();
private int sizex = 800, sizey = 700;
    ////////////              MAIN      ////////////////////////
    public static void main(String[] args) {
        Project3 tpo = new Project3();

    } //main ends


    ////////////            CONSTRUCTOR   /////////////////////
    public Project3() {
        myFrame = this; // need a static variable reference to a JFrame object
        northPanel = new JPanel();
        northPanel.setBackground(Color.white);
        //shuffleButton = new JButton("Shuffle");
        //northPanel.add(shuffleButton);
        // shuffleButton.addActionListener(this);
        newButton = new JButton("New Deck");
        northPanel.add(newButton);
        newButton.addActionListener(this);
        exitButton = new JButton("Exit");
        northPanel.add(exitButton);
        exitButton.addActionListener(this);
        getContentPane().add("North", northPanel);
        hitButton = new JButton("Hit?");
        standButton = new JButton("Stand?");


        centerPanel = new MyPanel();


        centerPanel.add(hitButton);
        hitButton.addActionListener(this);
        centerPanel.add(standButton);
        standButton.addActionListener(this);
        getContentPane().add("Center", centerPanel);


        game.playGame();

        //        resultButton.addActionListener(this);
        theDeck = new CardList(52);
        //theDeck.getFirstCard().printCard();
        setSize(sizex, sizey);
        setLocation(winxpos, winypos);

        setVisible(true);

    }

    ////////////   BUTTON CLICKS ///////////////////////////
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            dispose();
            System.exit(0);
        }
        if (e.getSource() == shuffleButton) {
            theDeck.shuffle();
            repaint();
        }
        if (e.getSource() == newButton) {
            game.playGame();
            repaint();

        }
        if (e.getSource() == hitButton) {

            game.hitCard();
            repaint();
        }
        if (e.getSource() == standButton) {
            JOptionPane.showMessageDialog(myFrame, "You " + game.checkResult());
            game.cleanHands();
            dispose();
            Project3 replay = new Project3();
            repaint();
            game.playGame();

        }

    }


    // This routine will load an image into memory
    //
    public static Image load_picture(String fname) {
        // Create a MediaTracker to inform us when the image has
        // been completely loaded.
        Image image;
        MediaTracker tracker = new MediaTracker(myFrame);


        // getImage() returns immediately.  The image is not
        // actually loaded until it is first used.  We use a
        // MediaTracker to make sure the image is loaded
        // before we try to display it.

        image = myFrame.getToolkit().getImage(fname);

        // Add the image to the MediaTracker so that we can wait
        // for it.
        tracker.addImage(image, 0);
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        if (tracker.isErrorID(0)) {
            image = null;
        }
        return image;
    }
    // --------------   end of load_picture ---------------------------

    class MyPanel extends JPanel {

        ////////////    PAINT   ////////////////////////////////
        public void paintComponent(Graphics g) {
            //
            int xpos = sizex/2 - 50 - 20 - 5, ypos = 30;
            if (game.getDealer() == null) return;
            Card current = game.getDealer().getFirstCard();
            while (current != null) {
                Image tempimage = current.getCardImage();
                g.drawImage(tempimage, xpos, ypos, this);
                //g.drawString("this is text", xpos, ypos);
                // note: tempimage member variable must be set BEFORE paint is called
                xpos += 80;
                if (xpos > 700) {
                    xpos = 25;
                    ypos += 105;
                }
                current = current.getNextCard();
            } //while
            g.drawString(game.getScoreDealer(), xpos, ypos + 25);


            Image blank = Project3.load_picture("images/gbCard52.gif");
g.drawImage(blank, 350, 175, this );

            int xpos2 = sizex/2 - 50 - 20 - 5, ypos2 = 335;
            if (game.getPlayer() == null) return;
            Card current2 = game.getPlayer().getFirstCard();
            while (current2 != null) {
                Image tempimage2 = current2.getCardImage();
                g.drawImage(tempimage2, xpos2, ypos2, this);
                //g.drawString("this is text", xpos, ypos);
                // note: tempimage member variable must be set BEFORE paint is called
                xpos2 += 80;
                if (xpos2 > 700) {
                    xpos2 = 25;
                    ypos2 += 105;
                }
                current2 = current2.getNextCard();
            } //while
            g.drawString(game.getScorePlayer(), xpos2, ypos2 + (25));

        } //my paint ends
    } //my panel ends

} // End Of class Project3

/*****************************************************************
   Class Link, the base class for a link list of playing cards
   May be placed in a file named Link.java

******************************************************************/
class Link {
    protected Link next;

    public Link getNext() {
        return next;
    }
    public void setNext(Link newnext) {
        next = newnext;
    }

} // end class Link

/*****************************************************************
   Class Card, the derived class each card is one object of type Card
   May be placed in a file named Card.java
******************************************************************/

class Card extends Link {
    private Image cardimage;
    String suit = "";
    int numValue;
    String cardName;

    public Card(int cardnum) {
        cardName = "gbCard" + cardnum + ".gif";
        // code ASSUMES there is an images sub-dir in your project folder
        printCard();
        if (cardnum < 13) {
            suit = "club";
        } else if (cardnum < 26 && cardnum > 12) {
            suit = "diamond";
        } else if (cardnum < 39 && cardnum > 25) {
            suit = "heart";
        } else if (cardnum < 52 && cardnum > 38) {
            suit = "spade";
        }
        if (suit == "club") {
            if (cardnum == 0) {
                numValue = 1;
            }
            if (cardnum >= 1 && cardnum <= 9) {
                numValue = cardnum + 1;
            }
            if (cardnum >= 10) {
                numValue = 10;
            }
        } //club if ends
        if (suit == "diamond") {
            if (cardnum == 13) {
                numValue = 1;
            }
            if (cardnum >= 14 && cardnum <= 22) {
                numValue = cardnum - 12;
            }
            if (cardnum >= 23) {
                numValue = 10;
            }
        } //diamond if ends   
        if (suit == "heart") {
            if (cardnum == 26) {
                numValue = 1;
            }
            if (cardnum >= 27 && cardnum <= 35) {
                numValue = cardnum - 25;
            }
            if (cardnum >= 36) {
                numValue = 10;
            }
        } //heart if ends
        if (suit == "spade") {
            if (cardnum == 39) {
                numValue = 1;
            }
            if (cardnum >= 40 && cardnum <= 48) {
                numValue = cardnum - 38;
            }
            if (cardnum >= 49) {
                numValue = 10;
            }
        } //diamond if ends


    }

    public Card getNextCard() {
        return (Card) next;
    }
    public Image getCardImage() {
        return cardimage;
    }
    public String getSuit() {
        return suit;
    }
    public int getNumValue() {
        return numValue;
    }
    public String getCardName() {
        return cardName;
    }
    public void printCard() {
        cardimage = Project3.load_picture("images/" + getCardName());
        if (cardimage == null) {
            System.out.println("Error - image failed to load: " + getCardName());
            System.exit(-1);
        }
    }
} //end class Card

/*****************************************************************
   Class CardList, A Linked list of playing cards
   May be placed in a file named CardList.java

   Note : This class can be used to create a 'hand' of cards
   Just Create another CardList object, and delete cards from
   'theDeck' and insert the cards into the new CardList object

******************************************************************/

class CardList {
    private Card firstcard = null;
    private int numcards = 0;
    public int getNumCards() {
        return numcards;
    }
    public CardList(int num) {
        numcards = num; //set numcards in the deck
        for (int i = 0; i < num; i++) { // load the cards
            Card temp = new Card(i);
            if (firstcard != null) {
                temp.setNext(firstcard);
            }
            firstcard = temp;
        }
    }

    public Card getFirstCard() {
        return firstcard;
    }

    public Card deleteCard(int cardnum) {
        Card target, targetprevious;

        if (cardnum > numcards)
            return null; // not enough cards to delete that one
        else
            numcards--;

        target = firstcard;
        targetprevious = null;
        while (cardnum-- > 0) {
            targetprevious = target;
            target = target.getNextCard();
            if (target == null) return null; // error, card not found
        }
        if (targetprevious != null)
            targetprevious.setNext(target.getNextCard());
        else
            firstcard = target.getNextCard();
        return target;
    }

    public void insertCard(Card target) {
        numcards++;
        if (firstcard != null)
            target.setNext(firstcard);
        else
            target.setNext(null);
        firstcard = target;
    }

    public void shuffle() {
        for (int i = 0; i < 300; i++) {
            int rand = (int)(Math.random() * 100) % numcards;
            Card temp = deleteCard(rand);
            if (temp != null) insertCard(temp);
        } // end for loop
    } // end shuffle


} // end class CardList