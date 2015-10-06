package waterjug;

import framework.State;
import framework.Move;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugMove class.
 * @author your name here
 */
public class WaterJugMoveTest {
    
    private State start = new WaterJugState(0, 0, 0);
    
    WaterJugMove FillX = new WaterJugMove("Fill Jug X");
        private WaterJugMove FillY = new WaterJugMove("Fill Jug Y");
        private WaterJugMove EmptyX = new WaterJugMove("Empty Jug X");
        private WaterJugMove EmptyY = new WaterJugMove("Empty Jug Y");
        private WaterJugMove TransXToY = new WaterJugMove("Transfer Jug X to Jug Y");
        private WaterJugMove TransYToX = new WaterJugMove("Transfer Jug Y to Jug X");
    
    // You should use the BridgeMoveTest class as a model for setting up
    // the tests with private instance fields here.

    /**
     * Tests filling jug X
     */
    @Test
    public void testFillX() {
        WaterJugState next = (WaterJugState) FillX.doMove(start);
        assertTrue((next.equals(new WaterJugState(3, 0, 1))));
        
        assertTrue(next.getMoveNumber() == 1);
        
    }

    /**
     * Tests filling jug Y
     */
    @Test
    public void testFillY() {
       WaterJugState next = (WaterJugState) FillY.doMove(start);
        assertTrue((next.equals(new WaterJugState(0, 4, 1))));
        
        assertTrue(next.getMoveNumber() == 1);
    }
    
    /**
     * Tests emptying jug X
     */
    @Test
    public void testEmptyX() {
       WaterJugState next = (WaterJugState) FillX.doMove(start);
        assertTrue((next.equals(new WaterJugState(3, 0, 1))));
        
        assertTrue(next.getMoveNumber() == 1);
        next = (WaterJugState) EmptyX.doMove(next); //perform same move
        assertTrue(next.equals(new WaterJugState(0, 0, 2)));            // should go back to original
        assertTrue(next.getMoveNumber() == 2);
    }
    
    /**
     * Tests emptying jug Y
     */
    @Test
    public void testEmptyY() {
       WaterJugState next = (WaterJugState) FillY.doMove(start);
        assertTrue((next.equals(new WaterJugState(0, 4, 1))));
        assertTrue(next.getMoveNumber() == 1);
      
        next = (WaterJugState) EmptyY.doMove(next); //perform same move
        assertTrue(next.equals(new WaterJugState(0, 0, 2)));             // should go back to original
        assertTrue(next.getMoveNumber() == 2);
    }
    
    /**
     * Tests transferring jug X to jug Y
     */
    @Test
    public void testXToY() {
        WaterJugState next = (WaterJugState) FillX.doMove(start);
        next = (WaterJugState) TransXToY.doMove(next);
        assertTrue(next.equals(new WaterJugState(0, 3, 2)));
        assertTrue(next.getMoveNumber() == 2);
    }
    
    /**
     * Tests transferring jug Y to jug X
     */
    @Test
    public void testYToX() {
        WaterJugState next = new WaterJugState(0, 4, 1);
        next = (WaterJugState) TransYToX.doMove(next);
        assertTrue(next.equals(new WaterJugState(3, 1, 2)));
        assertTrue(next.getMoveNumber() == 2);
    }
}
