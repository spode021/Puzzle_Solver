package bridge;

import framework.Move;
import framework.Problem;
import java.util.ArrayList;
import java.util.List;
/**
 * This class represents the Bridge Crossing problem.
 * It provides an introductory message describing the problem,
 * stores the problem's possible moves and current state, and
 * checks for whether the problem has been successfully solved.
 * Note that this class extends the abstract class <b>Problem</b> and
 * therefore imports <b>framework.Problem</b>.
 * This class inherits the <b>setIntroduction(), setCurrentState()</b>, and
 * <b>setMoves()</b> methods from its parent
 * and thus it should not have any instance fields for these attributes.
 * @author your name here
 */
public class BridgeProblem extends Problem {
    
    /**
     * Constructs a new bridge problem object.  A new bridge state object
     * should be constructed with P1, P2, P5, P10, and the flashlight all on the
     * west side of the bridge with zero time elapsed.
     * This state should be set as the current state of the problem using
     * the inherited <b>setCurrentState()</b> method.
     * The ten valid bridge moves should be created and stored on a list using
     * the inherited <b>setMoves()</b> method.
     * The appropriate introduction string for this problem should be stored
     * using the inherited <b>setIntroduction()</b>.
     */
    public BridgeProblem() {
        
            List<Move> moves = new ArrayList<>();
    BridgeState  startingState = new BridgeState(Position.WEST,Position.WEST,Position.WEST, Position.WEST,
    Position.WEST, 0);
        
    setCurrentState(startingState);

    BridgeMove p1 = new BridgeMove("P1 crosses alone");
    BridgeMove p2 = new BridgeMove("P2 crosses alone");
    BridgeMove p5 = new BridgeMove("P5 crosses alone");
    BridgeMove p10 = new BridgeMove("P10 crosses alone");
    BridgeMove p1p2 = new BridgeMove("P1 crosses with P2");
    BridgeMove p1p5 = new BridgeMove("P1 crosses with P5");
    BridgeMove p1p10 = new BridgeMove("P1 crosses with P10");
    BridgeMove p2p5 = new BridgeMove("P2 crosses with P5");
    BridgeMove p2p10 = new BridgeMove("P2 crosses with P10");
    BridgeMove p5p10 = new BridgeMove("P5 crosses with P10");
    
    moves.add(p1);
    moves.add(p2);
    moves.add(p5);
    moves.add(p10);
    moves.add(p1p2);
    moves.add(p1p5);
    moves.add(p1p10);
    moves.add(p2p5);
    moves.add(p2p10);
    moves.add(p5p10);
    
    setMoves(moves);
    
    String intro = "Welcome to the Bridge Crossing Problem.\n\n" +
                "Person Pn can cross the bridge in n minutes.\n" +
                "Only one or two persons can cross at a time because it is dark,\n" +
                "and the flashlight must be taken on every crossing.\n" +
                "When two people cross, they travel at the speed of the slowest person.\n" +
                "Devise a sequence of crossings so that all four people get across\n" +
                "the bridge in no more than 17 minutes.\n\n";
    
    setIntroduction(intro);
    }
    
    /**
     * Returns whether the current state of this problem is a success.
     * Note that this method implements the abstract <b>success</b> method declared
     * in the parent.
     * Note also that the current state of the problem must be gotten using the
     * inherited <b>getCurrentState()</b> method.
     * Since that method returns a value of type <b>State</b>, it must be cast to
     * <b>BridgeState</b> before processing.
     * The current state is a success if P1, P2, P5, and P10 are all on the
     * east side of the bridge and the time taken to cross is less than 18 minutes.
     * @return <b>true</b> if the current state is a success, <b>false</b> otherwise
     */
    @Override
    public boolean success() {
        BridgeState currentState = (BridgeState) getCurrentState();
       
        if ((currentState.getTimeSoFar() <= 17) && (currentState.getP1Position() == Position.EAST) && (currentState.getP2Position() == Position.EAST) && 
                (currentState.getP5Position() == Position.EAST) && (currentState.getP10Position() == Position.EAST) &&
                (currentState.getFlashlightPosition() == Position.EAST)){

            System.out.print("Congragulations! You have successfully solved the problem! \n Exiting program now. \n \n");
            return true;
        }
        else
            return false; // You must provide
    }
    

    
    
    // Private instance fields are not necessary since they are inherited.
}
