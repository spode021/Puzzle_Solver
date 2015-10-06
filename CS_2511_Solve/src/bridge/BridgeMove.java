package bridge;

import framework.Move;
import framework.State;

/**
 * This class represents moves in the Bridge Crossing problem.
 * A move object stores its move name and knows how to apply itself
 * to a bridge state to create a new state representing the result
 * of the move.
 * Note that this class extends the abstract class <b>Move</b> and
 * therefore imports <b>framework.Move</b>.
 * This class inherits the <b>getMoveName()</b> method from its parent
 * and thus it should not have an instance field for the move name.
 * Other than that, it can be essentially the same as in the previous
 * assignment.
 * @author your name here
 */
public class BridgeMove extends Move {

    /**
     * Constructs a new bridge move object.
     * Note that the move name is passed to the parent constructor
     * using <b>super</b>.
     * @param moveName the name of this move.
     * It is an error if the name is not one of the following:
     * <ul>
     * <li> "P1 crosses alone" </li>
     * <li> "P2 crosses alone" </li>
     * <li> "P5 crosses alone" </li>
     * <li> "P10 crosses alone" </li>
     * <li> "P1 crosses with P2" </li>
     * <li> "P1 crosses with P5" </li>
     * <li> "P1 crosses with P10" </li>
     * <li> "P2 crosses with P5" </li>
     * <li> "P2 crosses with P10" </li>
     * <li> "P5 crosses with P10" </li>
     * </ul>
     */
    public BridgeMove(String moveName) {
        super(moveName);
        
        switch(moveName)
        {
            case "P1 crosses alone":
                move = moveName;
                break;
            case "P2 crosses alone":
                move = moveName;
                break;
            case "P5 crosses alone" :
                move = moveName;
                break;
            case "P10 crosses alone" :
                move = moveName;
                break;
            case "P1 crosses with P2" :
                move = moveName;
                break;
            case "P1 crosses with P5" :
                move = moveName;
                break;
            case "P1 crosses with P10" :
                move = moveName;
                break;
            case "P2 crosses with P5" :
                move = moveName;
                break;
            case "P2 crosses with P10" :
                move = moveName;
                break;
            case "P5 crosses with P10" :
                move = moveName;
                break;
            default:
                move = "ERROR";
                throw new IllegalArgumentException("Invalid Entry: " + moveName);
        }
    }
    
    /**
     * Attempts to perform this move on a given bridge state.
     * Note that this method implements the abstract <b>doMove</b> method declared
     * in the parent.
     * Thus the argument of type <b>State</b> must be cast to type
     * <b>BridgeState</b> before processing.
     * The move to perform is determined by this object's move name.
     * If the move can be performed a new bridge state object is returned that
     * reflects this move.
     * A move cannot be performed if the flashlight is not on the same side
     * as the crossing person(s), or if a pair of persons who are crossing are not
     * on the same side.
     * If the move cannot be performed <b>null</b> is returned.
     * @param otherState the bridge state on which this move is to be performed
     * @return a new bridge state reflecting the move, or <b>null</b> if it
     * cannot be performed
     */
    public State doMove(State otherState) {
        BridgeState state = (BridgeState) otherState;
        
        //Move is legal
        Boolean canMove = false;
        BridgeState newBridge = null;
        
        //P1 crosses alone.
        switch (getMoveName()) {
            case "P1 crosses alone":
                //check if positions and flashlight position are the same.
                if((state.getP1Position() == Position.WEST) && (state.getFlashlightPosition() == Position.WEST)){ //Positions are on east side. 
                    
                    //Create new state with P1 and and Flashlight positions on EAST. Keep other positions the same.
                    newBridge = new BridgeState(Position.EAST, state.getP2Position(), //P1 position and P2 Position
                            Position.EAST, state.getP5Position(), //flashlight position and P5 Position
                            state.getP10Position(), state.getTimeSoFar() +1); //P10 Position and added time.
                
                    canMove = true;
                }
                else if((state.getP1Position() == Position.EAST) && state.getFlashlightPosition() == Position.EAST){
                    
                    //Create new state with P1 and and Flashlight positions on WEST. Keep other positions the same.
                    newBridge = new BridgeState(Position.WEST, state.getP2Position(), //P1 position and P2 Position
                            Position.WEST, state.getP5Position(), //flashlight position and P5 Position
                            state.getP10Position(), state.getTimeSoFar() +1); //P10 Position and added time.

                    canMove = true;
                }
        
             
                break;
            case "P2 crosses alone":
                //check if positions and flashlight position are the same.
                if((state.getP2Position() == Position.WEST) && (state.getFlashlightPosition() == Position.WEST)){ //Positions are on east side. 
                    
                    //Create new state with P2 and and Flashlight positions on EAST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), Position.EAST, //P1 position and P2 Position
                            Position.EAST, state.getP5Position(), //flashlight position and P5 Position
                            state.getP10Position(), state.getTimeSoFar() +2); //P10 Position and added time.
                
                    canMove = true;
                }
                else if((state.getP2Position() == Position.EAST) && state.getFlashlightPosition() == Position.EAST){
                    
                    //Create new state with P2 and and Flashlight positions on WEST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), Position.WEST, //P1 position and P2 Position
                            Position.WEST, state.getP5Position(), //flashlight position and P5 Position
                            state.getP10Position(), state.getTimeSoFar() +2); //P10 Position and added time.

                    canMove = true;
                }
        
           
                break;
            case "P5 crosses alone":
                //check if positions and flashlight position are the same.
                if((state.getP5Position() == Position.WEST) && (state.getFlashlightPosition() == Position.WEST)){ //Positions are on east side. 
                    
                    //Create new state with P5 and and Flashlight positions on EAST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), state.getP2Position(), //P1 position and P2 Position
                            Position.EAST, Position.EAST, //flashlight position and P5 Position
                            state.getP10Position(), state.getTimeSoFar() +5); //P10 Position and added time.
                
                    canMove = true;
                }
                else if((state.getP5Position() == Position.EAST) && state.getFlashlightPosition() == Position.EAST){
                    
                    //Create new state with P5 and and Flashlight positions on WEST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), state.getP2Position(), //P1 position and P2 Position
                            Position.WEST, Position.WEST, //flashlight position and P5 Position
                            state.getP10Position(), state.getTimeSoFar() +5); //P10 Position and added time.

                    canMove = true;
                }
        
          
                break;
            case "P10 crosses alone":
                 //check if positions and flashlight position are the same.
                if((state.getP10Position() == Position.WEST) && (state.getFlashlightPosition() == Position.WEST)){ //Positions are on east side. 
                    
                    //Create new state with P10 and and Flashlight positions on EAST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), state.getP2Position(), //P1 position and P2 Position
                            Position.EAST, state.getP5Position(), //flashlight position and P5 Position
                            Position.EAST, state.getTimeSoFar() +10); //P10 Position and added time.
                
                    canMove = true;
                }
                else if((state.getP10Position() == Position.EAST) && state.getFlashlightPosition() == Position.EAST){
                    
                    //Create new state with P10 and and Flashlight positions on WEST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), state.getP2Position(), //P1 position and P2 Position
                            Position.WEST, state.getP5Position(), //flashlight position and P5 Position
                            Position.WEST, state.getTimeSoFar() +10); //P10 Position and added time.

                    canMove = true;
                }
     
                break;
            case "P1 crosses with P2":
                 //check if positions and flashlight position are the same.
                if((state.getP1Position() == Position.WEST) && (state.getP2Position() == Position.WEST) && (state.getFlashlightPosition() == Position.WEST)){ //Positions are on east side. 
                    
                    //Create new state with P1, P2, and and Flashlight positions on EAST. Keep other positions the same.
                    newBridge = new BridgeState(Position.EAST, Position.EAST, //P1 position and P2 Position
                            Position.EAST, state.getP5Position(), //flashlight position and P5 Position
                            state.getP10Position(), state.getTimeSoFar() +2); //P10 Position and added time.
                
                    canMove = true;
                }
                else if((state.getP1Position() == Position.EAST) && (state.getP2Position() == Position.EAST) && state.getFlashlightPosition() == Position.EAST){
                    
                    //Create new state with P1, P2, and and Flashlight positions on WEST. Keep other positions the same.
                    newBridge = new BridgeState(Position.WEST, Position.WEST, //P1 position and P2 Position
                            Position.WEST, state.getP5Position(), //flashlight position and P5 Position
                            state.getP10Position(), state.getTimeSoFar() +2); //P10 Position and added time.

                    canMove = true;
                }
        
                break;
            case "P1 crosses with P5":
                //check if positions and flashlight position are the same.
                if((state.getP1Position() == Position.WEST) && (state.getP5Position() == Position.WEST) && (state.getFlashlightPosition() == Position.WEST)){ //Positions are on east side. 
                    
                    //Create new state with P1, P5, and and Flashlight positions on EAST. Keep other positions the same.
                    newBridge = new BridgeState(Position.EAST, state.getP2Position(), //P1 position and P2 Position
                            Position.EAST, Position.EAST, //flashlight position and P5 Position
                            state.getP10Position(), state.getTimeSoFar() +5); //P10 Position and added time.
                
                    canMove = true;
                }
                else if((state.getP1Position() == Position.EAST) && (state.getP5Position() == Position.EAST) && state.getFlashlightPosition() == Position.EAST){
                    
                    //Create new state with P1, P5, and and Flashlight positions on WEST. Keep other positions the same.
                    newBridge = new BridgeState(Position.WEST, state.getP2Position(), //P1 position and P2 Position
                            Position.WEST, Position.WEST, //flashlight position and P5 Position
                            state.getP10Position(), state.getTimeSoFar() +5); //P10 Position and added time.

                    canMove = true;
                }
        
              
                break;
            case "P1 crosses with P10":
                                                   //check if positions and flashlight position are the same.
                if((state.getP1Position() == Position.WEST) && (state.getP10Position() == Position.WEST) && (state.getFlashlightPosition() == Position.WEST)){ //Positions are on east side. 
                    
                    //Create new state with P1, P10, and and Flashlight positions on EAST. Keep other positions the same.
                    newBridge = new BridgeState(Position.EAST, state.getP2Position(), //P1 position and P2 Position
                            Position.EAST, state.getP5Position(), //flashlight position and P5 Position
                            Position.EAST, state.getTimeSoFar() +10); //P10 Position and added time.
                
                    canMove = true;
                }
                else if((state.getP1Position() == Position.EAST) && (state.getP10Position() == Position.EAST) && state.getFlashlightPosition() == Position.EAST){
                    
                    //Create new state with P1, P5, and and Flashlight positions on WEST. Keep other positions the same.
                    newBridge = new BridgeState(Position.WEST, state.getP2Position(), //P1 position and P2 Position
                            state.getP5Position(), Position.WEST, //flashlight position and P5 Position
                            Position.WEST, state.getTimeSoFar() +10); //P10 Position and added time.

                    canMove = true;
                }
        
               
                break;
                
            case "P2 crosses with P5":
                //check if positions and flashlight position are the same.
                if((state.getP2Position() == Position.WEST) && (state.getP5Position() == Position.WEST) && (state.getFlashlightPosition() == Position.WEST)){ //Positions are on east side. 
                    
                    //Create new state with P2, P5, and and Flashlight positions on EAST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), Position.EAST, //P1 position and P2 Position
                                                            Position.EAST, Position.EAST, //flashlight position and P5 Position
                                                            state.getP10Position(), state.getTimeSoFar() +5); //P10 Position and added time.
                
                    canMove = true;
                }
                else if((state.getP2Position() == Position.EAST) && (state.getP5Position() == Position.EAST) && state.getFlashlightPosition() == Position.EAST){
                    
                    //Create new state with P2, P5, and and Flashlight positions on WEST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), Position.WEST, //P1 position and P2 Position
                                                            Position.WEST, Position.WEST, //flashlight position and P5 Position
                                                            state.getP10Position(), state.getTimeSoFar() +5); //P10 Position and added time.

                    canMove = true;
                }
       
                break;
            case "P2 crosses with P10":
                
                                 //check if positions and flashlight position are the same.
                if((state.getP2Position() == Position.WEST) && (state.getP10Position() == Position.WEST) && (state.getFlashlightPosition() == Position.WEST)){ //Positions are on east side. 
                    
                    //Create new state with P10, P2, and and Flashlight positions on EAST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), Position.EAST, //P1 position and P2 Position
                                                            Position.EAST, state.getP5Position(), //flashlight position and P5 Position
                                                            Position.EAST, state.getTimeSoFar() +10); //P10 Position and added time.
                
                    canMove = true;
                }
                else if((state.getP2Position() == Position.EAST) && (state.getP10Position() == Position.EAST) && state.getFlashlightPosition() == Position.EAST){
                    
                    //Create new state with P10, P2, and and Flashlight positions on WEST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), Position.WEST, //P1 position and P2 Position
                                                            Position.WEST, state.getP5Position(), //flashlight position and P5 Position
                                                            Position.WEST, (state.getTimeSoFar() +10)); //P10 Position and added time.

                    canMove = true;
                }
        
               
                break;
                
            case "P5 crosses with P10":
                //          if((state.getP1Position() == state.getFlashlightPosition()))                           //check if positions and flashlight position are the same.
                if((state.getP5Position() == Position.WEST) && (state.getP10Position() == Position.WEST) && (state.getFlashlightPosition() == Position.WEST)){ //Positions are on east side. 
                    
                    //Create new state with P10, P5, and and Flashlight positions on EAST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), state.getP2Position(), //P1 position and P2 Position
                                                            Position.EAST, Position.EAST, //flashlight position and P5 Position
                                                            Position.EAST, state.getTimeSoFar() +10); //P10 Position and added time.
                
                    canMove = true;
                }
                else if((state.getP5Position() == Position.EAST) && (state.getP10Position() == Position.EAST) && state.getFlashlightPosition() == Position.EAST){
                    
                    //Create new state with P10, P5, and and Flashlight positions on WEST. Keep other positions the same.
                    newBridge = new BridgeState(state.getP1Position(), state.getP2Position(), //P1 position and P2 Position
                                                            Position.WEST, Position.WEST, //flashlight position and P5 Position
                                                            Position.WEST, (state.getTimeSoFar() +10)); //P10 Position and added time.

                    canMove = true;
                }
        
               
                break;
            
            default:
                canMove = false;
        }
        if(canMove == false)
            return null;
        else if(canMove == true)
            return newBridge;
        else
            return null;
    }
    
    // Private methods and instance fields should go here
    String move;
}
