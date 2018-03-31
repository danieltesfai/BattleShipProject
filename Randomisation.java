import java.util.*;

public class Randomisation
{
    private Random rand;

    public Randomisation(){
        rand = new Random();
    }

    public Position getRandomPosition(){
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        Position p = new Position(x,y);
        return p;
    }
    
    public Position chooseFromList(ArrayList<Position> positions){
        int place = rand.nextInt(positions.size());
        Position p = positions.get(place);
        return p;
    }
}