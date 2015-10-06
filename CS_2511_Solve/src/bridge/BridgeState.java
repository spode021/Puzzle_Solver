package bridge;

import framework.State;
import graph.SimpleVertex;
/**
 * This class represents states of the Bridge Crossing problem.
 * It creates new bridge states, tests states for equality,
 * and produces string representations of them.
 * Note that this class implements the <b>State</b> interface
 * and therefore imports <b>framework.State</b>.
 * Except for the import and the class header, this class can be
 * the same as in the previous assignment.
 * @author your name here
 */
public class BridgeState extends SimpleVertex implements State {

    /**
     * Creates a new bridge state.  
     * Besides storing the positions of the persons and flashlight, a
     * bridge state should also store the time taken to get to this state in
     * integer minutes.
     * @param p1Position position of the person who can cross in 1 minute
     * @param p2Position position of the person who can cross in 2 minutes
     * @param flashlightPosition position of the flashlight
     * @param p5Position position of the person who can cross in 5 minutes
     * @param p10Position  position of the person who can cross in 10 minutes
     * @param timeSoFar time taken so far
     */
    public BridgeState(Position p1Position, 
                       Position p2Position, 
                       Position flashlightPosition, 
                       Position p5Position, 
                       Position p10Position,
                       int timeSoFar) {
    
        posP1 = p1Position;
        posP2 = p2Position;
        posP5 = p5Position;
        posP10 = p10Position;
        posFlashlight = flashlightPosition;
        time = timeSoFar;
    }
    
    /**
     * Compares this bridge state with another for equality.
     * Note that this method overrides the <b>equals</b> method defined
     * in <b>java.lang.Object</b>.
     * Thus the argument of type <b>Object</b> must be cast to type
     * <b>BridgeState</b> before processing.
     * Two bridge states are equal if the positions of the persons and 
     * flashlight in one state are matched by their positions in the other.
     * Note that the time taken to cross so far is not taken into account
     * when considering equality.
     * @param other the other bridge state to be compared with this one.
     * @return whether this state is equal to the other state
     */
    public boolean equals(Object other) {
        BridgeState state = (BridgeState) other;
       if((this.posP1 == state.posP1) && (this.posP2 == state.posP2) &&
                (this.posP5 == state.posP5) && (this.posP10 == state.posP10) &&
                (this.posFlashlight == state.posFlashlight))
            return true;  
        else
            return false;
    }
    
    /**
     * Creates a string representation of this state for display to the user
     * trying to solve the problem.
     * Note that the time so far to cross is part of the string representation.
     * @return the string representation of this state
     */
    public String toString() {
        
            String strState = "";
        if(posP1 == Position.EAST)
            strState += "    |   | P1\n";
        else
            strState += " P1 |   |\n";
         
        if(posP2 == Position.EAST)
            strState += "    |   | P2\n";
        else
            strState += " P2 |   |\n";
        
        if(posFlashlight == Position.EAST)
            strState += "    |===| f\n";
        else
            strState += "  f |===|\n";
        
        if(posP5 == Position.EAST)
            strState += "    |   | P5\n";
        else
            strState += " P5 |   |\n";

        if(posP10 == Position.EAST)
            strState += "   |   | P10\n";
        else
            strState += "P10 |   |\n";
        
        String sMinutes = String.format("%02d", getTimeSoFar());
        
        strState += "Time elapsed so far: " + sMinutes +" minutes.\n";

        
        return strState;
    }

    /**
     * Getter (accessor) for the position of the flashlight in this state.
     * @return the position of the flashlight
     */
    public Position getFlashlightPosition() {
        return posFlashlight; // You must provide
    }

    /**
     * Getter (accessor) for the position of person P1 in this state.
     * @return the position of person P1
     */
    public Position getP1Position() {
        return posP1; // You must provide
    }

    /**
     * Getter (accessor) for the position of person P2 in this state.
     * @return the position of person P2
     */
    public Position getP2Position() {
        return posP2; // You must provide
    }

    /**
     * Getter (accessor) for the position of person P5 in this state.
     * @return the position of person P5
     */
    public Position getP5Position() {
        return posP5; // You must provide
    }

    /**
     * Getter (accessor) for the position of person P10 in this state.
     * @return the position of person P10
     */
    public Position getP10Position() {
        return posP10; // You must provide
    }

    /**
     * Getter (accessor) for the time taken to get to this state.
     * @return the time taken to get to this state
     */
    public int getTimeSoFar() {
        return time; // You must provide
    }
    
    // Private methods and instance fields should go here
    private Position posP1;
    private Position posP2;
    private Position posP5;
    private Position posP10;
    private Position posFlashlight;
    private int time = 0;
}
