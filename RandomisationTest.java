import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class RandomisationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RandomisationTest
{
    /**
     * Default constructor for test class RandomisationTest
     */
    public RandomisationTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void position()
    {
        Randomisation randomis2 = new Randomisation();
        Position position1 = randomis2.getRandomPosition();
        assertTrue(position1.getX()>=0);
        assertTrue(position1.getX()<10);
        assertTrue(position1.getY()>=0);
        assertTrue(position1.getY()<10);
    }

    @Test
    public void positionInList()
    {
        Randomisation randomis2 = new Randomisation();
        ArrayList positions = new ArrayList<Position>();
        positions.add(new Position(2,3));
        positions.add(new Position(1,1));
        positions.add(new Position(0,9));
        positions.add(new Position(5,6));

        Position position1 = randomis2.chooseFromList(positions);
        positions.contains(position1);
    }
}