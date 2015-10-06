package waterjug;

import framework.Move;
import framework.State;

/**
 * This class represents moves in the Water Jug problem.
 * A move object stores its move name and knows how to apply itself
 * to a water jug state to create a new state representing the result
 * of the move.
 * Note that this class extends the abstract class <b>Move</b> and
 * therefore imports <b>framework.Move</b>.
 * This class inherits the <b>getMoveName()</b> method from its parent
 * and thus it should not have an instance field for the move name.
 * @author your name here
*/
public class WaterJugMove extends Move {

    /**
     * Constructs a new water jug move object.
     * Note that the move name is passed to the parent constructor
     * using <b>super</b>.
     * @param moveName the name of this move.
     * It is an error if the name is not one of the following:
     * <ul>
     * <li> "Fill Jug X" </li>
     * <li> "Fill Jug Y" </li>
     * <li> "Empty Jug X" </li>
     * <li> "Empty Jug Y" </li>
     * <li> "Transfer Jug X to Jug Y" </li>
     * <li> "Transfer Jug Y to Jug X" </li>
     * </ul>
     */
    public WaterJugMove(String moveName) {
	super(moveName);
        
        switch(moveName)
        {
            case "Fill Jug X":
                move = moveName;
                break;
            case "Fill Jug Y":
                move = moveName;
                break;
            case"Empty Jug X":
                move = moveName;
                break;
            case "Empty Jug Y":
                move = moveName;
                break;
            case "Transfer Jug X to Jug Y":
                move = moveName;
                break;
            case "Transfer Jug Y to Jug X":
                move = moveName;
                break;
            default:
                move = "ERROR";
                throw new IllegalArgumentException("Invalid Entry: " + moveName);
                
        }
    }

    /**
     * Attempts to perform this move on a given water jug state.
     * Note that this method implements the abstract <b>doMove</b> method declared
     * in the parent.
     * Thus the argument of type <b>State</b> must be cast to type
     * <b>WaterJugState</b> before processing.
     * The move to perform is determined by this object's move name.
     * If the move can be performed a new water jug state object is returned that
     * reflects this move.
     * A move cannot be performed if trying to fill or transfer to an already
     * full jug, or if trying to empty or transfer from an empty jug.
     * If the move cannot be performed <b>null</b> is returned.
     * @param otherState the water jug state on which this move is to be performed
     * @return a new water jug state reflecting the move, or <b>null</b> if it
     * cannot be performed
     */
    public State doMove(State otherState) {
	WaterJugState state = (WaterJugState) otherState;
    
        // number of levels left 
        int difference;
        Boolean canMove = false;
        WaterJugState newJug = null;
        switch (getMoveName()) {
            
            //Fill Jug X
            case "Fill Jug X":
                // check if Jug is full.
                if(state.getXJugLevel() != state.xJugLevelMax){
                    newJug = new WaterJugState(3, state.getYJugLevel(), state.getMoveNumber() + 1);
                
                canMove = true;
                }
            break;
                
            case "Fill Jug Y":
                if(state.getYJugLevel() != state.yJugLevelMax){
                    newJug = new WaterJugState(state.getXJugLevel(), 4, state.getMoveNumber() + 1);
                
                canMove = true;
                }
            break;
                
            case "Empty Jug X":
                if(state.getXJugLevel() != 0){
                    newJug = new WaterJugState(0,state.getYJugLevel(), state.getMoveNumber() + 1);
                    canMove = true;
                }
            break;
            
            case "Empty Jug Y":
                if(state.getYJugLevel() != 0){
                    newJug =  new WaterJugState(state.getXJugLevel(), 0, state.getMoveNumber() + 1);
                    canMove = true;
                }
            break;
           
            case "Transfer Jug X to Jug Y":
                if(state.getXJugLevel() != 0 && state.getYJugLevel() != state.yJugLevelMax){
                    difference = state.yJugLevelMax - state.getYJugLevel();
                    if(state.getXJugLevel() > difference){
                    newJug = new WaterJugState(state.getXJugLevel() - difference, state.getYJugLevel() + difference, state.getMoveNumber() + 1);
                    }
                    else{
                        newJug = new WaterJugState(0, state.getXJugLevel() + state.getYJugLevel(), state.getMoveNumber() + 1);
                    }
                    canMove = true;
                }
            break;
            
            case "Transfer Jug Y to Jug X":
            if(state.getYJugLevel() != 0 && state.getXJugLevel() != state.xJugLevelMax){
                    difference = state.xJugLevelMax - state.getXJugLevel();
                    if(state.getYJugLevel() > difference){
                    newJug = new WaterJugState(state.getXJugLevel() + difference, state.getYJugLevel() - difference, state.getMoveNumber() + 1);
                    }
                    else{
                        newJug = new WaterJugState(state.getXJugLevel() + state.getYJugLevel(), 0, state.getMoveNumber() + 1);
                    }
                    canMove = true;
            }
            break;
                
            default:
                canMove = false;
        }
        if(canMove == false)
            return null;
        else
            return newJug;
        
    }
    
    // Private methods and instance fields should go here
    String move;
}
