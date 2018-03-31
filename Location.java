
/**
 * Write a description of class Location here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
public class Location implements Serializable
{
    private Ship ship; // will be null of no ship
    private int square;
    
    private boolean attempt;
    
    public Location()
    {
        
    }

    public void setShip(Ship sh, int square){
        ship = sh;
        this.square = square;
    }

    public Ship getShip(){
        return ship;
    }
    
    public int getSquare(){
        return square;
    }
    
    public boolean getAttempt()
    {
        return attempt;
    }
    
    public void setAttempt(boolean attempt)
    {
        this.attempt=attempt;
    }

}