package waterjug;

import framework.State;
import graph.SimpleVertex;

/**
 * This class represents states of the Water Jug problem.
 * It creates new water jug states, tests states for equality,
 * and produces string representations of them.
 * Note that this class implements the <b>State</b> interface
 * and therefore imports <b>framework.State</b>.
 */
public class WaterJugState extends SimpleVertex implements State {

    // You must provide a constructor
    /**
     * Creates a new Water Jug state
     * Besides storing the water levels of the water jugs,
     * water jug state should also store the number of moves that
     * the user has used to attempt to solve this problem
     * @param xLevel water level of Jug X
     * @param yLevel water level of Jug W
     * @param moves number of moves taken to attempt to solve this problem
     */
    public WaterJugState(int xLevel, int yLevel, int moves){
        
        xJugLevel = xLevel;
        yJugLevel = yLevel;
        moveNumber = moves;
        
        
    }

    /**
       Tests for equality between this state and the argument state.
       Two states are equal if the X jugs have the same amount of water
       and the Y jugs have the same amount of water.
       @param other the state to test against this state
       @return whether the states are equal
    */
    public boolean equals(Object other) {
        Boolean equal = false;
        WaterJugState state = (WaterJugState) other;
        if(this.xJugLevel == state.xJugLevel && this.yJugLevel == state.yJugLevel)
            equal = true;
        
        return equal;
    }

    /**
       Creates a primitive, non-GUI representation of this WaterJugState object.
       @return the string representation of this water jug state
     */
    public String toString() {
	
        String strState = "";
        if(yJugLevel == 4)
            strState += "       |***|\n";
        else
            strState += "       |   |\n";
        
        for(int i = 3; i > 0; i--){
            if (xJugLevel >= i && yJugLevel >= i)
                strState += "|***|  |***|\n";
            else if(xJugLevel >= i && !(yJugLevel >= i))
                strState += "|***|  |   |\n";
            else if(!(xJugLevel >= i) && yJugLevel >= i)
                strState += "|   |  |***|\n";
            else
                strState += "|   |  |   |\n";
            
        }
        strState += "+---+  +---+\n" +
                    "  X      Y  \n";
        
        return strState;
    }
    
    /*
    * Getter (accessor) for the water level of Jug X in this state
    * @return the water level of Jug X
    */
    public int getXJugLevel(){
        return xJugLevel;
    }

    /*
    * Getter (accessor) for the water level of Jug Y in this state
    * @return the water level of Jug Y
    */
    public int getYJugLevel(){
        return yJugLevel;
    }
    /*
    * Getter (accessor) for the number of moves in this state used 
    * to attempt to solve this problem
    * @return the move number of this state.
    */
    public int getMoveNumber(){
        return moveNumber;
    }
    // Private methods and instance fields should go here
    private int xJugLevel;
    final int xJugLevelMax = 3;
    private int yJugLevel;
    final int yJugLevelMax = 4;
    private int moveNumber;
}
