

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class validCoordinates.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class validCoordinates
{
    /**
     * Default constructor for test class validCoordinates
     */
    public validCoordinates()
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
    public void validCoordinates()
    {
      Position p = new Position(2,9);
      
      assertTrue(p.getX()>=0);
      assertTrue(p.getX()<Board.BOARD_SIZE);
      assertTrue(p.getY()>=0);
      assertTrue(p.getY()<Board.BOARD_SIZE);
    }
      
      
}
