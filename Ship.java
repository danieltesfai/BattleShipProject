
/**
 * Write a description of class Ship here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class Ship implements Serializable
{
 
    private ShotStatus[] squares;
    private int size;
     
    public Ship(int size)
    {
        this.size = size;
        squares = new ShotStatus[size];
        for(int i =0; i< size; i++){
            squares[i] = ShotStatus.MISS;
        }
        
    }

    public ShotStatus getStatus(int square){
        return  squares[square];
    }

    public ShotStatus shoot(int square)
    {
        squares[square]=ShotStatus.HIT;
       
        if(isSunk())
        {
           return ShotStatus.SUNK; 
        }
        return ShotStatus.HIT;
    }
    
    public boolean isSunk()
    {
        int hitCounts=0;
        for(int i=0;i<squares.length;i++)
        {
           if(!squares[i].equals(ShotStatus.HIT))
           {
               break;
            }
            hitCounts++;
        }
        return (hitCounts==squares.length);
    }
    
    public int getSize()
    {
        return size;
    }
}