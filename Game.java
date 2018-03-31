
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */ 
import java.io.*;
public class Game implements Serializable
{
    //field variables
    private Player human;
    private Player machine;
    
    private boolean computerTurn;
    
    private boolean paused;
    
    private Board b1;
    private Board b2;
    
    
    
    //Declare constants 
     
    public Game()
    {
        b1=new Board();
        b2=new Board();
       
        human=new HumanPlayer(b1,b2);
        machine=new ComputerPlayer(b2,b1);
        
        paused=false;
        
        
        computerTurn=false;
      
    }
    
    public void play()
    {
      
      System.out.println("--------HumanPlayer Board----------");
      b1.displayBoard();// display human board before ships placement 
      System.out.println("to choose Direction, enter character (H) for Horizontal or (V) for Vertical");
      System.out.println("put the ship type of length: "+b1.getShipSize(0));
      human.placeShips();// place ships on human's Board
      b1.displayBoard();// display after ships placement
     
      
      machine.placeShips();//the place all the ships on computer's Board
      //b2.displayBoard();
      
      
      try
      {
      //saveGame(new File("battleshipGame.txt"));
       }
       catch(Exception e)
       { 
        }
      //paused=true;
      while(!(human.winner() ||machine.winner()) && !paused)
      {
          
          
         // humanPlayer's turn to shoot
         if(!computerTurn)
         {  
             System.out.println("Your Turn: Shoot on Oppenent's Board");
             human.shoot();
             computerTurn=true;
             continue;
         }
         System.out.println("Computer Turn: Shoot on Oppenent's Board");
         machine.shoot();
         System.out.println("-------HumanPlayer Board ----"); 
         computerTurn=false;
      }
      
      System.out.println("Bye Bye");
      
    }
    
    public void saveGame(File f) throws FileNotFoundException
    {
        if(!f.exists())
        {
            try{
            f.createNewFile();
        }
          catch(IOException e)
          {
            System.out.println("File already Exists!");
           }
        }
      try {   
        FileOutputStream fileStream = new FileOutputStream(f);   
        ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);   

        objectStream.writeObject(b1);   
        objectStream.writeObject(b2);   
        objectStream.writeObject(human);   
        objectStream.writeObject(machine);  
        objectStream.writeObject(new Boolean(computerTurn)); 
        objectStream.writeObject(new Boolean(paused)); 
  
            
    } catch (Exception e) {   
          System.out.println("unable to save the file: " +e);  
    }   
    }
    
    public void loadGame(File f) throws IOException
    {
        
        try{
        FileInputStream fileStream = new FileInputStream(f);   
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);   
     
        b1 = (Board) objectStream.readObject();   
        b2 = (Board) objectStream.readObject();   
        human = (HumanPlayer) objectStream.readObject();   
        machine =(ComputerPlayer) objectStream.readObject();   
        computerTurn = (Boolean)objectStream.readObject(); 
    }
        catch(Exception e)
        {
            
        }
    }
    
    public static void main(String args[])
    {
        
        Game g=new Game();
        g.play();
    }
        
}
