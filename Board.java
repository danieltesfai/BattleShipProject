
/**
 * Write a description of class Board here.
 *
 * @author 
 * @version (1.0)
 */
import java.util.*;
import java.io.*;
public class Board implements Serializable
{
    private Location[][] locations; // a 2D array of locations
    public final Ship[] ships=new Ship[]{ 
        new Ship(5),
        new Ship(4),
        new Ship(3),
        new Ship(3),
        new Ship(2)
    };
    
    private ArrayList<Position> hints=new ArrayList<Position>();// holds all positions that are missed on the board
    
    
    private static final int SHIP_TYPES=5; // fives types of ship
    public static final int BOARD_SIZE=10; //Board size 10 by 10
    public static final int TOTAL_SHIPS=17;
    
 
    public Board()
    {
        // initialise board with empty locations
        locations=new Location[BOARD_SIZE][BOARD_SIZE];
        
       for(int i=0;i<BOARD_SIZE;i++)
       {
           for(int j=0;j<BOARD_SIZE;j++)
           {
               locations[i][j]=new Location();
            }
        }
    }
    
    public Location[][] getLocations()
    {
        return locations;
    }

    public ShotStatus getStatus(Position p){
        
        Location l = locations[p.getX()][p.getY()];
        Ship sh = l.getShip();
        if(sh==null){
            return ShotStatus.MISS;
        }
        else{
            return sh.getStatus(l.getSquare());
        }
    }
    
    
    public ShotStatus shoot(Position p)
    {
        Location l=locations[p.getY()][p.getX()];
        Ship sh=l.getShip();
        if(sh==null)
        {
             return ShotStatus.MISS;
        } 
        
        return sh.shoot(l.getSquare());
        
    }
     
    public int getShipSize(int pos)
    {
     
        return ships[pos].getSize();
    }
    public void updateBoard()
    {
        
    }
    
    public boolean winner(int score)
    {
        return (score==TOTAL_SHIPS);   
    }
     
    public boolean validCoordinates(Position p)
    {
        return (p.getX()>=0 && p.getX()<BOARD_SIZE) && (p.getY()>=0 && p.getY()<BOARD_SIZE);
    }
    
    public boolean outsideBoard(Position p,int shipSize,boolean horizontal)
    {
        int end=(horizontal)?p.getX()+shipSize:p.getY()+shipSize; 
        return end>=Board.BOARD_SIZE;
    }
    
    public boolean isValidPosition(Position p,int shipSize,boolean horizontal)
    { 
         
        if(!validCoordinates(p))
        {
            System.out.println("x & y cooardinates must be between 0 & 9 ");
            return false;
        }
       
        if(outsideBoard(p,shipSize,horizontal))
        { 
            System.out.println("Outside Board exception");
            return false;
        } 
        
          int xDifference = 0; int yDifference = 0;
          if(horizontal) {
            xDifference = 1;
        } else {
            yDifference = 1;
        }
            for(int i=0;i<shipSize;i++)
            {
                Location l=locations[p.getY()+i*yDifference][p.getX()+i*xDifference];
                Ship sh=l.getShip();
                if(sh!=null)
                {
                 System.out.println("Overlapped");
                 return false; 
                }                   
            } 
           
        return true;
    }
    
    public void placeShip(Ship sh,Position p, boolean horizontal)
    { 
        int xDifference = 0; int yDifference = 0;
        if(horizontal) {
            xDifference = 1;
        } else {
            yDifference = 1;
        }
        for(int i = 0; i < sh.getSize() ; i++) {
            locations[p.getY() + i* yDifference][p.getX()+ i*xDifference].setShip(sh,i);
        } 
    }
    
    public void displayBoard()
    {
        //display column heading
        System.out.print("\t");
        for(int i=0;i<Board.BOARD_SIZE;i++)
        {
          System.out.print(i+"\t"); 
        }
        System.out.println();
        for(int i=0;i<Board.BOARD_SIZE;i++)
        {
            System.out.print(i+"\t");
            
            Location l;
            for(int j=0;j<Board.BOARD_SIZE;j++)
            {
                 
                l=locations[i][j];
                Ship sh=l.getShip();
                if(sh==null){ 
                       char icon=(l.getAttempt())?'*':'O'; 
                       System.out.print(icon +"\t");
               }
               else{
                    ShotStatus status=sh.getStatus(l.getSquare());
                    if(ShotStatus.MISS==status)
                    {
                      System.out.print("S"+"\t");
                    }
                    else{
                       System.out.print(status+"\t");
                     }
                }
                
                   
            }
            System.out.println();
        }
    }
    
    public void clearBoard()
    {
        for(int x=0;x<Board.BOARD_SIZE;x++)
        {
            for(int y=0;y<Board.BOARD_SIZE;y++)
            {
                locations[x][y]=new Location();
            }
        }
    }
    
  }