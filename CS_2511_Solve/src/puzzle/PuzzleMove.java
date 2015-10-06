/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle;

import framework.Move;
import framework.State;

/**
 *
 * @author Andrew Spoden
 */
public class PuzzleMove extends Move {
    
    public PuzzleMove(String moveName){
        super(moveName);
        
        switch(moveName)
        {
            case "Move Block 1":
                move = moveName;
                break;
            case "Move Block 2":
                move = moveName;
                break;
            case "Move Block 3":
                move = moveName;
                break;
            case "Move Block 4":
                move = moveName;
                break;
            case "Move Block 5":
                move = moveName;
                break;
            case "Move Block 6":
                move = moveName;
                break;
            case "Move Block 7":
                move = moveName;
                break;
            case "Move Block 8":
                move = moveName;
                break;
            default:
                move = "ERROR";
                throw new IllegalArgumentException("Invalid Entry: " + moveName);
        }
    }
    
    public State doMove(State otherState){
        
        PuzzleState state = (PuzzleState) otherState;
        PuzzleState newPuzzle = null;
        
        Boolean canMove = false;
        
        switch(getMoveName()){
           
            case "Move Block 1":
                //TOPWEST
                if((state.getPos1() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.TOPCENTER)||
                        (state.getPos1() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST)||
                //TOPCENTER
                        (state.getPos1() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos1() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos1() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                //TOPEAST
                        (state.getPos1() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos1() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                //CENTERWEST
                        (state.getPos1() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos1() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos1() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                //CENTERCENTER
                        (state.getPos1() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos1() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos1() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                        (state.getPos1() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //CENTEREAST        
                        (state.getPos1() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos1() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos1() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMWEST
                        (state.getPos1() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos1() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //BOTTOMCENTER
                        (state.getPos1() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                        (state.getPos1() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos1() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMEAST
                        (state.getPos1() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                        (state.getPos1() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST)){
                
                        PuzzlePosition temp = state.getPos1();
                        PuzzlePosition newPos1 = state.getPosBlank();
                        PuzzlePosition newPosBlank = temp;
                        
                        newPuzzle = new PuzzleState(newPos1, state.getPos2(), 
                                                    state.getPos3(), state.getPos4(), 
                                                    state.getPos5(), state.getPos6(),
                                                    state.getPos7(), state.getPos8(),
                                                    newPosBlank);
                           
        
                        canMove = true;
                
            }
            
            break;
                
            case "Move Block 2":
                    //TOPWEST
                if((state.getPos2() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.TOPCENTER)||
                        (state.getPos2() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST)||
                //TOPCENTER
                        (state.getPos2() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos2() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos2() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                //TOPEAST
                        (state.getPos2() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos2() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                //CENTERWEST
                        (state.getPos2() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos2() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos2() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                //CENTERCENTER
                        (state.getPos2() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos2() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos2() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                        (state.getPos2() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //CENTEREAST        
                        (state.getPos2() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos2() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos2() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMWEST
                        (state.getPos2() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos2() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //BOTTOMCENTER
                        (state.getPos2() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                        (state.getPos2() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos2() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMEAST
                        (state.getPos2() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                        (state.getPos2() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST)){
                
                        PuzzlePosition temp = state.getPos2();
                        PuzzlePosition newPos2 = state.getPosBlank();
                        PuzzlePosition newPosBlank = temp;
                        
                        newPuzzle = new PuzzleState(state.getPos1(), newPos2, 
                                                    state.getPos3(), state.getPos4(), 
                                                    state.getPos5(), state.getPos6(),
                                                    state.getPos7(), state.getPos8(),
                                                    newPosBlank);
                           
        
                        canMove = true;
                }     
            break;
                
            case "Move Block 3":
                                   //TOPWEST
                if((state.getPos3() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.TOPCENTER)||
                        (state.getPos3() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST)||
                //TOPCENTER
                        (state.getPos3() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos3() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos3() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                //TOPEAST
                        (state.getPos3() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos3() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                //CENTERWEST
                        (state.getPos3() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos3() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos3() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                //CENTERCENTER
                        (state.getPos3() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos3() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos3() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                        (state.getPos3() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //CENTEREAST        
                        (state.getPos3() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos3() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos3() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMWEST
                        (state.getPos3() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos3() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //BOTTOMCENTER
                        (state.getPos3() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                        (state.getPos3() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos3() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMEAST
                        (state.getPos3() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                        (state.getPos3() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST)){
                
                        PuzzlePosition temp = state.getPos3();
                        PuzzlePosition newPos3 = state.getPosBlank();
                        PuzzlePosition newPosBlank = temp;
                        
                        newPuzzle = new PuzzleState(state.getPos1(), state.getPos2(), 
                                                    newPos3, state.getPos4(), 
                                                    state.getPos5(), state.getPos6(),
                                                    state.getPos7(), state.getPos8(),
                                                    newPosBlank);
                           
        
                        canMove = true;
                }     
            break;
               
            case "Move Block 4":
                                               //TOPWEST
                if((state.getPos4() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.TOPCENTER)||
                        (state.getPos4() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST)||
                //TOPCENTER
                        (state.getPos4() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos4() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos4() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                //TOPEAST
                        (state.getPos4() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos4() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                //CENTERWEST
                        (state.getPos4() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos4() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos4() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                //CENTERCENTER
                        (state.getPos4() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos4() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos4() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                        (state.getPos4() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //CENTEREAST        
                        (state.getPos4() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos4() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos4() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMWEST
                        (state.getPos4() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos4() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //BOTTOMCENTER
                        (state.getPos4() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                        (state.getPos4() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos4() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMEAST
                        (state.getPos4() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                        (state.getPos4() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST)){
                
                        PuzzlePosition temp = state.getPos4();
                        PuzzlePosition newPos4 = state.getPosBlank();
                        PuzzlePosition newPosBlank = temp;
                        
                        newPuzzle = new PuzzleState(state.getPos1(), state.getPos2(), 
                                                    state.getPos3(), newPos4, 
                                                    state.getPos5(), state.getPos6(),
                                                    state.getPos7(), state.getPos8(),
                                                    newPosBlank);
                           
        
                        canMove = true;
                }     
            break;
                
            case "Move Block 5":
                //TOPWEST
                if((state.getPos5() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.TOPCENTER)||
                        (state.getPos5() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST)||
                //TOPCENTER
                        (state.getPos5() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos5() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos5() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                //TOPEAST
                        (state.getPos5() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos5() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                //CENTERWEST
                        (state.getPos5() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos5() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos5() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                //CENTERCENTER
                        (state.getPos5() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos5() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos5() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                        (state.getPos5() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //CENTEREAST        
                        (state.getPos5() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos5() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos5() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMWEST
                        (state.getPos5() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos5() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //BOTTOMCENTER
                        (state.getPos5() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                        (state.getPos5() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos5() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMEAST
                        (state.getPos5() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                        (state.getPos5() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST)){
                
                        PuzzlePosition temp = state.getPos5();
                        PuzzlePosition newPos5 = state.getPosBlank();
                        PuzzlePosition newPosBlank = temp;
                        
                        newPuzzle = new PuzzleState(state.getPos1(), state.getPos2(), 
                                                    state.getPos3(), state.getPos4(), 
                                                    newPos5, state.getPos6(),
                                                    state.getPos7(), state.getPos8(),
                                                    newPosBlank);
                           
        
                        canMove = true;
                }     
            break; 
                
            case "Move Block 6":
                //TOPWEST
                if((state.getPos6() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.TOPCENTER)||
                        (state.getPos6() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST)||
                //TOPCENTER
                        (state.getPos6() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos6() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos6() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                //TOPEAST
                        (state.getPos6() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos6() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                //CENTERWEST
                        (state.getPos6() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos6() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos6() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                //CENTERCENTER
                        (state.getPos6() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos6() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos6() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                        (state.getPos6() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //CENTEREAST        
                        (state.getPos6() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos6() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos6() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMWEST
                        (state.getPos6() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos6() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //BOTTOMCENTER
                        (state.getPos6() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                        (state.getPos6() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos6() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMEAST
                        (state.getPos6() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                        (state.getPos6() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST)){
                
                        PuzzlePosition temp = state.getPos6();
                        PuzzlePosition newPos6 = state.getPosBlank();
                        PuzzlePosition newPosBlank = temp;
                        
                        newPuzzle = new PuzzleState(state.getPos1(), state.getPos2(), 
                                                    state.getPos3(), state.getPos4(), 
                                                    state.getPos5(), newPos6,
                                                    state.getPos7(), state.getPos8(),
                                                    newPosBlank);
                           
        
                        canMove = true;
                }     
            break; 
                
            case "Move Block 7":
                //TOPWEST
                if((state.getPos7() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.TOPCENTER)||
                        (state.getPos7() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST)||
                //TOPCENTER
                        (state.getPos7() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos7() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos7() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                //TOPEAST
                        (state.getPos7() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos7() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                //CENTERWEST
                        (state.getPos7() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos7() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos7() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                //CENTERCENTER
                        (state.getPos7() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos7() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos7() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                        (state.getPos7() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //CENTEREAST        
                        (state.getPos7() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos7() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos7() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMWEST
                        (state.getPos7() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos7() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //BOTTOMCENTER
                        (state.getPos7() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                        (state.getPos7() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos7() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMEAST
                        (state.getPos7() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                        (state.getPos7() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST)){
                
                        PuzzlePosition temp = state.getPos7();
                        PuzzlePosition newPos7 = state.getPosBlank();
                        PuzzlePosition newPosBlank = temp;
                        
                        newPuzzle = new PuzzleState(state.getPos1(), state.getPos2(), 
                                                    state.getPos3(), state.getPos4(), 
                                                    state.getPos5(), state.getPos6(),
                                                    newPos7, state.getPos8(),
                                                    newPosBlank);
                           
        
                        canMove = true;
                }     
            break;
                
            case "Move Block 8":
                //TOPWEST
                if((state.getPos8() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.TOPCENTER)||
                        (state.getPos8() == PuzzlePosition.TOPWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST)||
                //TOPCENTER
                        (state.getPos8() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos8() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos8() == PuzzlePosition.TOPCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                //TOPEAST
                        (state.getPos8() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos8() == PuzzlePosition.TOPEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                //CENTERWEST
                        (state.getPos8() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.TOPWEST) ||
                        (state.getPos8() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos8() == PuzzlePosition.CENTERWEST && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                //CENTERCENTER
                        (state.getPos8() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos8() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.TOPCENTER) ||
                        (state.getPos8() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.CENTEREAST) ||
                        (state.getPos8() == PuzzlePosition.CENTERCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //CENTEREAST        
                        (state.getPos8() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos8() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.TOPEAST) ||
                        (state.getPos8() == PuzzlePosition.CENTEREAST && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMWEST
                        (state.getPos8() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.CENTERWEST) ||
                        (state.getPos8() == PuzzlePosition.BOTTOMWEST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                //BOTTOMCENTER
                        (state.getPos8() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMWEST) ||
                        (state.getPos8() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.CENTERCENTER) ||
                        (state.getPos8() == PuzzlePosition.BOTTOMCENTER && state.getPosBlank() == PuzzlePosition.BOTTOMEAST) ||
                //BOTTOMEAST
                        (state.getPos8() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.BOTTOMCENTER) ||
                        (state.getPos8() == PuzzlePosition.BOTTOMEAST && state.getPosBlank() == PuzzlePosition.CENTEREAST)){
                
                        PuzzlePosition temp = state.getPos8();
                        PuzzlePosition newPos8 = state.getPosBlank();
                        PuzzlePosition newPosBlank = temp;
                        
                        newPuzzle = new PuzzleState(state.getPos1(), state.getPos2(), 
                                                    state.getPos3(), state.getPos4(), 
                                                    state.getPos5(), state.getPos6(),
                                                    state.getPos7(), newPos8,
                                                    newPosBlank);
                           
        
                        canMove = true;
                }     
            break;
                
            default:
                canMove = false;
        }
        if(canMove == true)
            return newPuzzle;
        else
            return null;
    }
    
    //Private variables
    private String move;
}
