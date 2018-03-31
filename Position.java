
/**
 * Write a description of class Position here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
public class Position implements Serializable
{
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position(){
        }

    public void setX(int x)
    {
        this.x=x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
    
    public int getY(){
        return y;
    }
    
    public String toString()
    {
        return "x coordinate :"+getX() +" y Coordinate: "+getY();
    }
 
  }