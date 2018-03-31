
/**
 * Write a description of class ComputerPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class ComputerPlayer implements Player,Serializable
{
    private int score; 
    private Board myBoard;
    private Board oppBoard;
    
    private Random random;
    
    private static final int HORIZONTAL=0;
    private static final int VERTICAL=1;
    
    private boolean horizontal;
  
    public ComputerPlayer(Board b1, Board b2 )
    {
        // initialise instance variables
        score=0; 
        myBoard=b1;
        oppBoard=b2;
        
        random=new Random(); 
    }

       
    public int getScore()
    {
        return score;
    }
    
    public void placeShips()
    { 
        for(Ship sh:myBoard.ships)
        {
             Position p=getValidPosition(sh);
             myBoard.placeShip(sh,p,horizontal);
            
        }
    }
    
    public Position getValidPosition(Ship sh)
    {  
      int direction; //0->horizontal and 1->vertical
      Position p;
       do
        {
         p=getRandomPosition();
         direction=getRandomDirection();// 0-> horizontal  1-> vertical 
        
         horizontal=(direction==0)?true:false;
          
        } 
         while(!myBoard.isValidPosition(p, sh.getSize(), horizontal));
      return p;
    }
    
    public Position getRandomPosition()
    {
       return new Position(random.nextInt(10),random.nextInt(10)); 
    }
    public int getRandomDirection()
    {
        return random.nextInt(2);
    }
    public void shoot()
    {
        Position p;
      do{
          p=getRandomPosition();
        }while(!attempted(p));            
         ShotStatus status=oppBoard.shoot(p); 
         
        switch(status.toString())
        {
          case "SUNK":
                     System.out.println("ship has sunk");
                     score++;
                     if(winner())
                     {
                       System.out.println("Cogratulations!!!! You won the game"); 
                     }
                     break;
          case "HIT":
                       System.out.println(status.toString());
                       break;
          default:    System.out.println(status.toString());
                       break;
                
        } 
       
    }
    
    public boolean attempted(Position p)
     {
         Location l=oppBoard.getLocations()[p.getY()][p.getX()];
         Ship sh=l.getShip();
         
         if(l.getAttempt())
         {             
             return true;
         }
         oppBoard.getLocations()[p.getY()][p.getX()].setAttempt(true);
         return false;
     }
    
    public boolean winner()
     {
       return getScore()==17;    
     }
}
