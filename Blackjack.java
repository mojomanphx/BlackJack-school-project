//Lesson 8 Exercises CIS263AA
//Blackjack Class 
//Written by Jeriod Ruschell Jer2181272 on 12/13

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class Blackjack extends JPanel implements ActionListener
{//declarations
   //button declarations 
   JButton hitButton = new JButton("Hit"); 
   JButton stayButton = new JButton("Stay"); 
   JButton resetButton = new JButton("Reset");
   //labeldeclaration player and computer suit type
   JLabel pSuit1 = new JLabel("TEST"); 
   JLabel pSuit2 = new JLabel("TEST"); 
   JLabel pSuit3 = new JLabel("TEST"); 
   JLabel pSuit4 = new JLabel("TEST"); 
   JLabel pSuit5 =  new JLabel("TEST"); 
   JLabel playerTag = new JLabel("User"); 
   JLabel cSuit1 = new JLabel("TEST"); 
   JLabel cSuit2 = new JLabel("TEST"); 
   JLabel cSuit3 = new JLabel("TEST"); 
   JLabel cSuit4 = new JLabel("TEST"); 
   JLabel cSuit5 = new JLabel("TEST"); 
   JLabel computerTag = new JLabel("Computer");
   //CardPanel declarations for player and computer cards 
   CardPanel plCard1 = new CardPanel("X"); 
   CardPanel plCard2 = new CardPanel("X"); 
   CardPanel plCard3 = new CardPanel("X"); 
   CardPanel plCard4 = new CardPanel("X"); 
   CardPanel plCard5 = new CardPanel("X"); 
   CardPanel comCard1 = new CardPanel("X"); 
   CardPanel comCard2 = new CardPanel("X"); 
   CardPanel comCard3 = new CardPanel("X"); 
   CardPanel comCard4 = new CardPanel("X"); 
   CardPanel comCard5 = new CardPanel("X"); 
   //CardPanel for player and computer scores
   CardPanel playerScore = new CardPanel("0"); 
   CardPanel computerScore = new CardPanel("0"); 
   //Labels for Game Board housed in first level
   JLabel title = new JLabel("Jay Rod's High Stakes BlackJack"); 
   JLabel playerInst = new JLabel("Pretty easy instructions closest player to 21 wins"); 
   JLabel playResults = new JLabel("Good Luck!");   
   //Panel creation 
   JPanel blackJack = new JPanel(new GridLayout(4,1));//creates initial panel in 4 horizontal rows 
   JPanel instructions = new JPanel(new GridLayout(3,1,5,5));//breaks first horizontal row of blackjack into three horizontal rows for game instructions 
   JPanel player = new JPanel(new GridLayout(2,6,5,5));//breaks second horizontal row of blackjack into a grid of 2 rows and six columns(player card and suit information) 
   JPanel computer = new JPanel(new GridLayout(2,6,5,5));//breaks third horizontal row of blackjack panel into grid of 2 rows and six colums(computer card and suit information) 
   JPanel buttons = new JPanel(new GridLayout(1,3,5,5));//breaks fourth horizontal row of blackjack panel into three columns to house three buttons
   JPanel insTitle = new JPanel();//new panels to control centering of label in instructions panels 
   JPanel instPlayInst= new JPanel();//new panel to control centering of label in instructions panels 
   JPanel instPlayResult = new JPanel(); //new panel to control centering of label in instructions panels
   
   
   Random rand =  new Random();//new instance of random for selection from card deck array 
   String[] cardDeck = new String[52]; //creates card deck array 
   ArrayList<Integer> usedElements = new ArrayList<Integer>(10);//creates array list to house used card deck array selections to ensure unique card selection during gameplay  
   
   int x,y,z;//loop control variables
   int cardChoice;//variable to hold the random card choice
   int playerWins, computerWins; //variables to hold player wins and computer wins
    
   
   String setCard;//variable for card selection from array 
   String setSuit;//variable to hold suit selection 
   
   public Blackjack()
   {
     
      setBackground(Color.WHITE);//sets background to white 
      setSize(500,500);//sets the size of the Frame 
      setLayout(new GridLayout(4,1));//sets the layout of the 
      add(instructions);//adds instruction panel 
      add(player);//adds player panel 
      add(computer);//adds computer panel  
      add(buttons);//adds button panel 
      //Instructions area of JFrame 
      instructions.add(insTitle);//add secondary holding for title  
      instructions.add(instPlayInst);//add secondary holding container for instructions  
      instructions.add(instPlayResult);//adds secondary holding container for play results 
      instPlayResult.add(playResults);//adds label for win tracking 
      insTitle.add(title);//adds label for title  
      instPlayInst.add(playerInst);//adds label for instruction
      //sets fonts for instruction panels 
      title.setFont(new Font("Verdana", Font.BOLD, 24));
      playerInst.setFont(new Font("Arial",Font.ITALIC, 16));
      playResults.setFont(new Font("Mono",Font.BOLD, 16));
      //Player Card area of JFrame
      //added 5CardPanel for cards and 5 labels for suit identifier(Player)
      player.add(plCard1); 
      player.add(plCard2); 
      player.add(plCard3); 
      player.add(plCard4); 
      player.add(plCard5);
      player.add(playerScore); 
      player.add(pSuit1); 
      player.add(pSuit2); 
      player.add(pSuit3);
      player.add(pSuit4); 
      player.add(pSuit5); 
      player.add(playerTag);
      //Computer card area of JFrame
      //added 5 CardPanels for cards and 5 labels for suit identifier(Computer)
      computer.add(comCard1); 
      computer.add(comCard2); 
      computer.add(comCard3); 
      computer.add(comCard4); 
      computer.add(comCard5); 
      computer.add(computerScore);
      computer.add(cSuit1); 
      computer.add(cSuit2);  
      computer.add(cSuit3); 
      computer.add(cSuit4); 
      computer.add(cSuit5); 
      computer.add(computerTag);
      //button area of JFrame 
      //adds button to the button area of the panel
      buttons.add(hitButton); 
      buttons.add(stayButton); 
      buttons.add(resetButton); 
      //Listens for button clicks from all three buttons
      hitButton.addActionListener(this); 
      stayButton.addActionListener(this); 
      resetButton.addActionListener(this);   
             
      //for loop to load a deck of cards into an array of strings 
      //for use during each game.        
       for(x = 0; x < 4; ++x)//loops four times one for each suit 
      {
         for(y = 2; y <= 14; ++y)
         { 
            
            if(y<=10)//2-10 loads into array as string representation of the number 
            {          
               cardDeck[z] = Integer.toString(y);
               
            }
            else if(y == 11)//at 11th iteration loads Jack 
            { cardDeck[z] = "J"; }
            else if(y == 12)//at 12th iteration loads Queen
            { cardDeck[z] = "Q"; }
            else if(y == 13)//at 13th iteration loads king 
            { cardDeck[z] = "K"; }
            else if(y == 14)//at 14th iteration loads Ace
            { cardDeck[z] = "A"; }
            z = z+1;//adds one to control variable moving to next array element  
            
         }
      }
      
      resetBoard();//calls method to reset game board with two cards for player and one for computer        
   }
   
   public int setUniqueElement()//sets unique card that has not been used.  
   {  int cont; //loop control 
      int select; //temp variable for card selection 
      do//loop to continue while card is not unique
      {  
         select = rand.nextInt(52);//selects random number upto 51 
         cont = 0;//sets control to zero 
         for(x = 0; x < usedElements.size(); ++x)//loops used elements
         {
            if(select == usedElements.get(x))//if the current array selection and the random number are the same
            {
               cont = 1;//sets control to one to institute do while loop
               break;//breaks inner for loop but continues do while loop
            }
            else
            {
               cont = 0;//ensures control stays zero
            }
         }
      }while(cont == 1);
      
      usedElements.add(select);//once unique selection is found it is added to an arraylist 
      return select; //returns unique selection
   }
   
   public int calculateCardValue(String c)//method to calculate the current card value passes card value "2-A"
   {
      int cardValue = 0;//ensures starting point is zero 
      
      switch(c)
      {//switch to analyze and assign value based on card given
         case "2": 
         { cardValue = 2;
            break;        }
         case "3":
         { cardValue = 3;
            break;       }
         case "4":
         { cardValue = 4;
            break;       }
         case "5":
         { cardValue = 5;
            break;       }
         case "6":
         { cardValue = 6;
            break;       }
         case "7": 
         { cardValue = 7;
            break;       }
         case "8": 
         { cardValue = 8;
            break;       }
         case "9": 
         { cardValue = 9;
            break;       }
         case "10","J","Q","K":
         { cardValue = 10;
            break;       }
         case "A":
         { cardValue = 11;
              break;     }
         case "X":
         { cardValue = 0;
            break;      }
          
      }
    
      return cardValue; //returns the value of the card
      
      
   }
   
   public void setGameCard(CardPanel pnl, JLabel lbl)
   {
     cardChoice = setUniqueElement(); //call method to obtain unique array element for game play
     setCard = cardDeck[cardChoice];//pulls card from array 
     pnl.setString(setCard); //calls CardPanel setString method to set variable 
     //Nested else if statement that assigns the appropriate suit identifier based on block of array elements
     //0-12 Hearts, 13 - 25 Diamonds, 26 - 38 Spades, and the rest is considered clubs
     //sets the completed panel and label to visible     
       if(cardChoice < 13)//
       { lbl.setText(" Hearts");
            pnl.setVisible(true);
            lbl.setVisible(true); 
            
       }
       else if (cardChoice > 12 && cardChoice < 26)
       { lbl.setText("Diamonds");
            pnl.setVisible(true); 
            lbl.setVisible(true); 
            
       }
       else if (cardChoice > 25 && cardChoice < 39)
       { lbl.setText(" Spades");
            pnl.setVisible(true); 
            lbl.setVisible(true); 
             
       } 
       else 
       { lbl.setText("  Clubs");
            pnl.setVisible(true); 
            lbl.setVisible(true);
             
       }
      findTotalPoints();//calls method to calculate points for both players
      pnl.repaint();//repaints the panel             
                
   }
   
   public void findTotalPoints()
   {  //variables to hold card values 
      int card1, card2, card3, card4, card5, total; 
      //grabs the current selection of string from each of the 5 player CardPanels
      //analyzes their value in calculateCardValue() method. passes get string method for CardPanel 
      card1 = calculateCardValue(plCard1.getString());
      card2 = calculateCardValue(plCard2.getString()); 
      card3 = calculateCardValue(plCard3.getString()); 
      card4 = calculateCardValue(plCard4.getString()); 
      card5 = calculateCardValue(plCard5.getString());
      total = card1+card2+card3+card4+card5;//adds all instances up
      playerScore.setString(Integer.toString(total));//Sets string to player score panel converts from int to string
      playerScore.repaint();//repaints player score panel
      //repeats steps from above but calls the computer section of the panel 
      card1 = calculateCardValue(comCard1.getString()); 
      card2 = calculateCardValue(comCard2.getString()); 
      card3 = calculateCardValue(comCard3.getString()); 
      card4 = calculateCardValue(comCard4.getString()); 
      card5 = calculateCardValue(comCard5.getString()); 
      total = card1+card2+card3+card4+card5;
      computerScore.setString(Integer.toString(total));
      computerScore.repaint(); 
   } 
   
   public void checkResults()//method to check the results of the game board to decide a winner.  
   {
      int playa; //variable to hold player point total 
      int comp; //variable to hold computer point total
      
      playa = Integer.parseInt(playerScore.getString());//loads player total from playerscore cardPanel(converts to int) 
      comp = Integer.parseInt(computerScore.getString());//loads computer total from computer score cardPanel(converts to int)
      for(x = 0; x==0; ++x)//creates loop that will only iterate once to allow for the use of the break statements
      {//if statements identify possible winning combinations and will display a message, update winner total and reset the board for a new game
         //once found breaks out of loop and moves on in code
       if(comp > 21)//if computer goes over 21
       {
          JOptionPane.showMessageDialog(null, "BUSTED!!!!");
          playerWins += 1;
          resetBoard(); 
          break;
       }
       if(comp > playa && comp <22)//if computer score is greater than player score 
       {
          JOptionPane.showMessageDialog(null, "You lose I beat you fair and square!");
          computerWins += 1; 
          resetBoard();   
          break; 
       }
       else if(playa > comp && playa < 22) //if player score is greater than computer score  
       {
          JOptionPane.showMessageDialog(null, "You Won by being a better BlackJack player");
          playerWins += 1;
          resetBoard();
          break; 
       } 
       else if(comp == playa)//if both are equal 
       {
          JOptionPane.showMessageDialog(null, "Holy Smokes we pushed...Nobody wins or everybody wins");
          resetBoard();
          break;  
       }
      }
        
   }
   
   public void checkBust(CardPanel c)//seperate method to check player cards to see if they exceed 21
   {
      if( Integer.parseInt(c.getString()) > 21)//if found displays message updates winner and resets board
      {  JOptionPane.showMessageDialog(null, " Player BUSTED!!!!");
         if(c.getString().equals(playerScore.getString()))
         {  computerWins += 1; }
         else if(c.getString().equals(computerScore.getString()))
         { playerWins += 1; }  
         resetBoard();
      }
   }
   
   
   public void resetBoard()//method to reset board back to beginning of play
   {
      CardPanel[] pnls = {plCard1,plCard2,plCard3,plCard4,plCard5,comCard1,comCard2,comCard3,comCard4,comCard5};//loads all CardPanels into an array 
      JLabel[] lbls =  {pSuit1,pSuit2,pSuit3,pSuit4,pSuit5,cSuit1,cSuit2,cSuit3,cSuit4,cSuit5};//loads all labels into an array
      
      for (x = 0; x < pnls.length; ++x)//loops through Card Panel array
      {
         pnls[x].setString("X");//sets string variable to X
         pnls[x].setVisible(false); //makes them invisible 
         pnls[x].repaint(); //repaints the image
      }
      for (x = 0; x < lbls.length;++x)
      {
         lbls[x].setText(" "); //clears all text
         lbls[x].setVisible(false); //makes labels invisible 
      } 
      usedElements.clear(); //clears arraylist for selected carddeck elements
      findTotalPoints(); //resets player score and computer score to zero
      
      setGameCard(plCard1, pSuit1); //chooses 1st card for the player 
      setGameCard(comCard1, cSuit1); //chooses 1st card for the computer
      setGameCard(plCard2, pSuit2);  //chooses 2nd card for the player 
      findTotalPoints();//finds new totals for cards just choosen  

          
   }
   
   
   
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
        
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource(); 
      
      if (source == hitButton)
      {//if player hits 
         int score = Integer.parseInt(playerScore.getString());//instatiates and sets score variable 
        if(plCard3.getString().equals("X")&& score<22)//checks player card 3
        {
         setGameCard(plCard3,pSuit3);//sets player card 3
         
        }
        else if(plCard4.getString().equals("X")&& score < 22)//checks player card 4
        {
         setGameCard(plCard4,pSuit4);//sets player card 4
         
        }
        else if(plCard5.getString().equals("X")&& score < 22)//checks player card 5
        {
         setGameCard(plCard5,pSuit5);//sets player card 5
        }
       else if(score < 22)//if all five are fill and score is less than 21
        {
         JOptionPane.showMessageDialog(null, "You Won.  You recieved a 5 card Charlie win!"); 
         
        }
         score = Integer.parseInt(playerScore.getString());//updates score 
        checkBust(playerScore);//checks player score to see if they exceeded 21
              
       

      }
      else if(source == stayButton)
      {//player presses stay the computer will take its turn.  This is done with a do while loop with a nested if and if else statements.  
      //Do while loop will continue to operate while computer score is less than 17.        
         
        do
        {//if statemenst compare Panel information to see if card is present and computer score is less than 17.  
        //if criteria is met then appropriate card panel and label is sent to method to set randomized card and suit information
           if(comCard2.getString().equals("X")&& Integer.parseInt(computerScore.getString())<17)//checks panel 2
            {
               setGameCard(comCard2, cSuit2);//sets panel 2
               
            }
           if(comCard3.getString().equals("X")&& Integer.parseInt(computerScore.getString())<17)//checks panel 3
            {
             setGameCard(comCard3,cSuit3);//sets panel 3
              
            }
            else if(comCard4.getString().equals("X")&& Integer.parseInt(computerScore.getString()) < 17)//checks panel 4
            {
             setGameCard(comCard4,cSuit4);//sets panel 4
              
            }
            else if(comCard5.getString().equals("X")&& Integer.parseInt(computerScore.getString()) < 17)//checks panel 5
            {
             setGameCard(comCard5,cSuit5);//sets panel 5
             
            }
                        
            
        }while(Integer.parseInt(computerScore.getString()) < 17);//contorl expression that will have the computer continue to draw cards while the computer score is under 17 for each hand
        checkResults();//calls method to check results of the game  

      }
      else if(source == resetButton)
      {// if player presses reset button It will display a message that the overall player stats will be deleted and a new one started
         JOptionPane.showMessageDialog(null, "This will reset the overall player stats and begin a new game");
         resetBoard(); //resets board
         computerWins = 0; //resets computer win total 
         playerWins = 0;//resets player win total
      }
      
      playResults.setText("Player: "+playerWins+" - Computer: "+computerWins);//Setlabel to display win total for both player and computer
   }
   
   public static void main(String[] args)
   {
      Blackjack panel = new Blackjack(); //new Blackjack panel created
      JFrame frame = new JFrame(); //new JFrame created
      frame.add(panel);//add panel to JFrame 
      frame.setSize(550,500);//set frame size
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set close operation 
      frame.setVisible(true);//sets JFrame to visible 
   } 
   
}