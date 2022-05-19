class BlackJack {
  CardList dealer = new CardList(0);
  CardList player = new CardList(0);
  int playerScore = 0, dealerScore = 0;
  public void updatePlayerScore(int update) {
      playerScore += update;
      scorePlayer = "Player: " + playerScore;
  }
  public void endGame() {

      //BlackJack newGame = new BlackJack();
  }
  public void cleanHands() {
      for (int i = 0; i < dealer.getNumCards(); i++) {
          dealer.deleteCard(i);
      }
      for (int i = 0; i < player.getNumCards(); i++) {
          player.deleteCard(i);
      }
  } //clean hands ends
  public String checkResult() {
      String result = "";
      if (checkLose() == true)
          result = "lose";
      if (checkWin() == true)
          result = "win";
      if (checkTie() == true)
          result = "tied";

      return result;
  }


  public void playGame() {
      dealCards();

  }
  public void hitCard() {
      Card newC = new Card((int)(Math.random() * 51));
      updatePlayerScore(newC.getNumValue());
      player.insertCard(newC);
  }

  String scorePlayer = "", scoreDealer = "";

  public CardList getDealer() {
      return dealer;
  }
  public CardList getPlayer() {
      return player;
  }
  public String getScorePlayer() {
      return scorePlayer;
  }
  public String getScoreDealer() {
      return scoreDealer;
  }







  public void dealCards() { //to add cards in to the hand. this should also be used for Hit in game
      //whatever card has been added, remove that from the deck
      int newCardNum; //later when program is working, use this random, set that to a int and get that int from Deck
      for (int i = 1; i <= 2; i++) {
          newCardNum = (int)(Math.random() * 51);
          System.out.println("new card num is: " + newCardNum);
          Card newCard = new Card(newCardNum);

          dealer.insertCard(newCard);
          System.out.println(newCard.getSuit() + " " + newCard.getNumValue() + "card name is this: " + newCard.getCardName());
          // theDeck.deleteCard(newCardNum); 
          newCard.printCard();
          if (newCard.getNumValue() == 1) {
              System.out.println("ACE DETECTED!!!!!!!!!!!!!!!!!!!");
          }

          System.out.println("dealer dealt\n\n");




          newCardNum = (int)(Math.random() * 51);
          System.out.println("new card num is: " + newCardNum);
          Card newCard2 = new Card(newCardNum);
          player.insertCard(newCard2);
          System.out.println(newCard2.getSuit() + " " + newCard2.getNumValue() + " card name is this: " + newCard2.getCardName());
          //theDeck.deleteCard(newCardNum);
          newCard2.printCard();
          System.out.println("player dealt\n\n");
          if (newCard2.getNumValue() == 1) {
              System.out.println("ACE DETECTED!!!!!!!!!!!!!!!!!!!");
          }


          playerScore += newCard2.getNumValue();
          dealerScore += newCard.getNumValue();
          if ((playerScore == newCard2.getNumValue() + 1 ^ playerScore - newCard2.getNumValue() == 1) && playerScore < 11) {
              playerScore += 10;
              System.out.println("10 has been added to player score");
          }
          if ((dealerScore == newCard.getNumValue() + 1 ^ dealerScore - newCard.getNumValue() == 1) && dealerScore < 11) {
              dealerScore += 10;
              System.out.println("10 has been added to dealer score");
          }
          scorePlayer = "Player: " + playerScore;
          scoreDealer = "Dealer : " + dealerScore;
      } //for ends
      //Deck.deleteCard(newCardNum);
  } //dealCard ends


  public boolean checkLose() {
      if ((playerScore != 21 && dealerScore == 21) || (dealerScore > playerScore) && (dealerScore < 22) || (dealerScore < 22 && playerScore >= 22))
          return true;
      return false;
  }
  public boolean checkWin() {
      if (playerScore > dealerScore && (playerScore < 21 || playerScore == 21))
          return true;
      return false;

  }
  public boolean checkTie() {

      if (playerScore == dealerScore)
          return true;
      return false;
  }









} //blackjack class ends