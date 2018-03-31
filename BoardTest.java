

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BoardTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BoardTest
{
    /**
     * Default constructor for test class BoardTest
     */
    public BoardTest()
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
     public void OutSideBoard()
    {
        Position p=new Position(7,3);
        Ship sh=new Ship(4);
        boolean horizontal=false;
        
        int end = (horizontal) ? p.getY() + sh.getSize() - 1 : p.getX() + sh.getSize() - 1;
        assertTrue(end>=Board.BOARD_SIZE);
    }
}
