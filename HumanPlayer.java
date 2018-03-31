
/**
 * Write a description of class HumanPlayer here.
 *
 * @author (daniel)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class HumanPlayer implements Player,Serializable
{
    private int score;
    
    private Board myBoard;
    private Board oppBoard;
    
    private static final String HORIZONTAL="H";
    private static final String VERTICAL="V";
    
  
    
    public HumanPlayer(Board b1, Board b2)
    {
        score=0;
        
        myBoard=b1;
        oppBoard=b2;
        
    }

    public int getScore()
    {
        return score;
    }
    
    public Board getOppBoard()
    {
        return oppBoard;
    }
    
    public Board getMyBoard()
    {
        return myBoard;
    }
    
    public void placeShips()
    { 
        boolean direction;
        for(Ship sh:myBoard.ships)
        {
           direction=whichDirection();
           Position p=whichPosition(sh,direction);
           myBoard.placeShip(sh,p,direction);
           
        }
    }
    
    
    public boolean whichDirection() {
         Scanner input=new Scanner(System.in);
        String direction; 
        do {
            System.out.println("Horizontal or Vertical ?");
            direction = input.nextLine().trim().toUpperCase();
        }while (!HORIZONTAL.equals(direction) && !VERTICAL.equals(direction));

        return HORIZONTAL.equals(direction);
    }
    
    
    
    public Position whichPosition(Ship ship, boolean horizontal) {
        
        System.out.println("place next ship type of length: "+ship.getSize());
        Position p;
        do {
            System.out.println("please enter X and Y coordinates");
            p=getUserPosition();
            
           } while(!myBoard.isValidPosition(p, ship.getSize(), horizontal));

        return p;
    }
    
    
     public void shoot()
     { 
         Position p;
         do{ 
             p=getUserPosition();//guess a postion where you want to shoot
           }while(guessedBefore(p));
           
         ShotStatus status=oppBoard.shoot(p); 
         
        switch(status.toString())
        {
          case "SUNK":
                     System.out.println("Great Jop!  ship has sunk");
                     score++;
                     if(winner())
                     {
                       System.out.println("Cogratulations!!!! You won the game"); 
                     }
                     break;
          case "HIT":
                       System.out.println("Great! you " + status.toString()+ " ship");
                       break;
          default:    System.out.println("Failed! you " + status.toString()+ " ship");
                       break;
                
        }
         
         
         
         
     }
     
     
     
     public boolean guessedBefore(Position p)
     {
         Location l=oppBoard.getLocations()[p.getX()][p.getY()];
         Ship sh=l.getShip();
         
         if(l.getAttempt())
         {
             if(sh==null)
             {
               System.out.println("you lost you chance");
               return false; 
             }
             System.out.println("Ship already shooted. Try again");
             return true;             
             
         }
         oppBoard.getLocations()[p.getY()][p.getX()].setAttempt(true);
         return false;
     }
     
     public Position getUserPosition()
     {
         Scanner input=new Scanner(System.in);
        while(true)
        {
         try{   
          Position p;
          System.out.println("Enter X & Y cooardinates");
          int x=input.nextInt();//read x position
          int y=input.nextInt();//read y position
        
          p=new Position(x,y);
          return p;
        }
        catch(Exception e)
        {
          System.out.println(e);
        }
    
     }
    }
     
     public boolean winner()
     {
       return getScore()==myBoard.TOTAL_SHIPS;    
     }
    
    
}
