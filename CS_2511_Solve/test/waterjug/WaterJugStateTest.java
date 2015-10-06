package waterjug;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugState class
 * @author your name here
 */
public class WaterJugStateTest {
    
    private String state1String = "       |   |\n" +
                                  "|   |  |   |\n" +
                                  "|   |  |   |\n" +
                                  "|   |  |   |\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
    
    private WaterJugState state1 = new WaterJugState(0, 0, 0);
                                 
    
    private String state2String = "       |***|\n" +
                                  "|***|  |***|\n" +
                                  "|***|  |***|\n" +
                                  "|***|  |***|\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
    
    private WaterJugState state2 = new WaterJugState(3, 4, 2);
    
    private WaterJugState state1Copy = new WaterJugState(0, 0, 4);
    
    // You may want to add more instance fields for testing

    /**
     * This method tests the accessors (getters) for <b>WaterJugState</b> objects.
     */
    @Test
    public void testAccessors() {
        assertTrue(state2.getXJugLevel() == 3);
        assertTrue(state2.getYJugLevel() == 4);
        assertTrue(state2.getMoveNumber() == 2);
    }

    /**
     * This method tests the <b>equals</b> method for <b>WaterJugState</b> objects.
     */
    @Test
    public void testEquals() {
        assertFalse(state1.equals(state2));
        assertTrue(state1.equals(state1Copy));
        assertFalse(state1==state1Copy);
    }

    /**
     * This method tests the <b>toString</b> method for <b>WaterJugState</b> objects.
     * Look at the definitions of <b>state1String</b> and <b>state2String</b> to see
     * how <b>toString</b> should format a state's string representation.
     */
    @Test
    public void testToString() {
    assertTrue(state1.toString().equals(state1String));
    assertTrue(state2.toString().equals(state2String));
    }
}
