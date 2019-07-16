import java.util.*;

//Kian Carroll
//Ted Knecht
//CS 140
//5/21/2019


/*This program will play a number guessing game 
in which the computer generates a random number and 
you try to guess it in as few tries as possible. If
you guess wrong, you will be told whether the answer
is higher or lower than your estimate. At the end of
 your game you will be shown results of your playthrough.*/
 
public class Guess{
   
   public static void main(String[] args)
   {
      //OBJECTS:
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      
      //INITIALIZED VARIABLES:
      int guessCount = 0;
      int ttlGuessCount = 0;
      int bestGame = Integer.MAX_VALUE;
      int gameCount = 0;
      String retry = "";
      
      //START:
      giveIntro();
      
      while(!retry.equalsIgnoreCase("N"))
      {
         
         guessCount = beginGame(gameCount, ttlGuessCount, rand, console);
         bestGame= hiScore(guessCount, bestGame);
         retry = gameAgain( rand, console);
         gameCount++;
         ttlGuessCount = ttlGuessCount+ guessCount;
         
          
      }
      
      displayResults(guessCount, ttlGuessCount, gameCount, bestGame);
      
   }// end of main
   
//Game Loop - Begin Game - Returns guessCount
   public static int beginGame(int gameCount, int ttlGuessCount, Random rand, Scanner console)
   {//start beginGame
      
      int guessCount = 1;
      int ans = rand.nextInt(99)+1;
      System.out.println ();
      System.out.println("I'm thinking of a number between 1 and 100...");
      System.out.println ();
      System.out.print("Your guess? ");
      int num = console.nextInt();
      
      while(num != ans)
      {
         
         if(num < ans)
         {
            System.out.println("It's Higher");
            System.out.print("Your guess? ");
            num = console.nextInt(); 
         }//if hi
         
         if(num > ans)
         {
            System.out.println ("Its Lower");
            System.out.print("Your guess? ");
            num = console.nextInt();
         }//if low
         
         guessCount++;
        
      }//end while
      
      System.out.println("you win");
      //check/store hiScore
      if(guessCount>1)
      {
         System.out.println("You got it right in " +guessCount+ " guesses");
      }else{
         System.out.println("You got it right in " +guessCount+ " guess");
      }
   
      return guessCount;
      
   }// end of beginGame

//Hi Score
//Updates the highscore counter 
   public static int hiScore(int guessCount, int bestGame)
   {

      while(guessCount != bestGame)
      {
      
         if(guessCount < bestGame){
            bestGame = guessCount;
            return bestGame;
         }else{
         return bestGame;    
         }
      }
      return bestGame;
      
   }


//Play Again - gameAgain returns retry
//Checks if the user wants to play another game
   public static String gameAgain( Random rand, Scanner console)
   {
      
      System.out.print("play again? ");
      String answer = console.next();
      String retry =answer.substring(0,1);
       
      if(retry.equalsIgnoreCase("N"))
      {          
         retry = "n";
         return retry;
      }//else N end
      return retry;
    
   }//End gameAgain
    
    
//Results
//Calculates and displays the overall results of the session 
   public static void displayResults(int guessCount, int ttlGuessCount, int gameCount, int bestGame)
   {
      System.out.println();
      System.out.println("Overall results:");
      System.out.println("Total games: " + gameCount);
      System.out.println("Total guesses: "+ ttlGuessCount);
      System.out.println("Guesses/game: "+ ttlGuessCount / gameCount);
      System.out.println("Best game: " + bestGame);
   }//end of display results

//Intro
//Displays an introducation to the user that explains the game
   public static void giveIntro()
   {
      System.out.println("This program allows you to play a guessing game");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until ");
      System.out.println("you get it. for each guess, I will tell you");
      System.out.println("whether the answer is higher or lower than your guess.");
    
   }//end give intro

}//end of Guessing Game