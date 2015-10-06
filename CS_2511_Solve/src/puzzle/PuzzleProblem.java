/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle;

import framework.Move;
import framework.Problem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrew Spoden
 */
public class PuzzleProblem extends Problem{
    
    public PuzzleProblem(){
        List<Move> moves = new ArrayList<>();
        PuzzleState startingState = new PuzzleState(PuzzlePosition.CENTERWEST,PuzzlePosition.TOPWEST,PuzzlePosition.TOPEAST, PuzzlePosition.CENTEREAST, PuzzlePosition.BOTTOMEAST, PuzzlePosition.CENTERCENTER, PuzzlePosition.BOTTOMWEST, PuzzlePosition.TOPCENTER, PuzzlePosition.BOTTOMCENTER);
        
        setCurrentState(startingState);
        
        PuzzleMove MoveBlock1 = new PuzzleMove("Move Block 1");
        PuzzleMove MoveBlock2 = new PuzzleMove("Move Block 2");
        PuzzleMove MoveBlock3 = new PuzzleMove("Move Block 3");
        PuzzleMove MoveBlock4 = new PuzzleMove("Move Block 4");
        PuzzleMove MoveBlock5 = new PuzzleMove("Move Block 5");
        PuzzleMove MoveBlock6 = new PuzzleMove("Move Block 6");
        PuzzleMove MoveBlock7 = new PuzzleMove("Move Block 7");
        PuzzleMove MoveBlock8 = new PuzzleMove("Move Block 8");
        
        moves.add(MoveBlock1);
        moves.add(MoveBlock2);
        moves.add(MoveBlock3);
        moves.add(MoveBlock4);
        moves.add(MoveBlock5);
        moves.add(MoveBlock6);
        moves.add(MoveBlock7);
        moves.add(MoveBlock8);
        
        setMoves(moves);
        
        String intro = "Welcome to the 8-Puzzle Problem\n\n" +
                "You are given a 3x3 board in which 8 numbered tiles can slide around.\n" +
                "There is one blank space that holds no tile. A legal move consists\n" +
                "of sliding a tile into the blank space if the tile is adjacent to it.\n" +
                "The goal is to move tiles around until the board looks like the final\n" +
                "state below.\n" +
                "            +---+---+---+\n" +
                "            | 1 | 2 | 3 |\n" +
                "            +---+---+---+\n" +
                "            | 8 |   | 4 |\n" +
                "            +---+---+---+\n" +
                "            | 7 | 6 | 5 |\n" +
                "            +---+---+---+\n";
        setIntroduction(intro);
    }
    
    @Override
    public boolean success(){
        PuzzleState currentState = (PuzzleState)getCurrentState();
        
        
        if(currentState.getPos1() == PuzzlePosition.TOPWEST &&
            currentState.getPos2() == PuzzlePosition.TOPCENTER &&
            currentState.getPos3() == PuzzlePosition.TOPEAST &&
            currentState.getPos4() == PuzzlePosition.CENTEREAST &&
            currentState.getPos5() == PuzzlePosition.BOTTOMEAST &&
            currentState.getPos6() == PuzzlePosition.BOTTOMCENTER &&
            currentState.getPos7() == PuzzlePosition.BOTTOMWEST &&
            currentState.getPos8() == PuzzlePosition.CENTERWEST &&
            currentState.getPosBlank() == PuzzlePosition.CENTERCENTER){
         
            System.out.print("Congragulations! You have successfully solved the problem! \n Exiting program now. \n \n");
            return true;
        }
        else
            return false;
    }
    

}
