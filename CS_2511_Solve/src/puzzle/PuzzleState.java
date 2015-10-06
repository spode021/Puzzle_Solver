package puzzle;

import framework.State;
import graph.SimpleVertex;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew Spoden
 */
public class PuzzleState extends SimpleVertex implements State {
    /**
     * 
     * @param p1 position of square 1
     * @param p2 position of square 2
     * @param p3 position of square 3
     * @param p4 position of square 4
     * @param p5 position of square 5
     * @param p6 position of square 6
     * @param p7 position of square 7
     * @param p8 position of square 8
     * @param blank position of blank square
     */
    public PuzzleState(PuzzlePosition p1, PuzzlePosition p2,
                       PuzzlePosition p3, PuzzlePosition p4, 
                       PuzzlePosition p5, PuzzlePosition p6, 
                       PuzzlePosition p7,PuzzlePosition p8, 
                       PuzzlePosition blank){
        pos1 = p1;
        pos2 = p2;
        pos3 = p3;
        pos4 = p4;
        pos5 = p5;
        pos6 = p6;
        pos7 = p7;
        pos8 = p8;
        posBlank = blank;
        
    }
    @Override
    public boolean equals(Object other){

        Boolean equal = false;
        PuzzleState state = (PuzzleState) other;

        if(this.getPos1() == state.getPos1() && 
           this.getPos2() == state.getPos2() && 
           this.getPos3() == state.getPos3() && 
           this.getPos4() == state.getPos4() && 
           this.getPos5() == state.getPos5() && 
           this.getPos6() == state.getPos6() && 
           this.getPos7() == state.getPos7() && 
           this.getPos8() == state.getPos8() && 
           this.getPosBlank() == state.getPosBlank())
                
            equal = true;
        
        return equal;
    }
    // public accessor methods.
    public PuzzlePosition getPos1(){
        return pos1;
    }
    
    public PuzzlePosition getPos2(){
        return pos2;
    }
    
    public PuzzlePosition getPos3(){
        return pos3;
    }
    
    public PuzzlePosition getPos4(){
        return pos4;
    }
    
    public PuzzlePosition getPos5(){
        return pos5;
    }
    
    public PuzzlePosition getPos6(){
        return pos6;
    }
    
    public PuzzlePosition getPos7(){
        return pos7;
    }
    
    public PuzzlePosition getPos8(){
        return pos8;
    }
    
    public PuzzlePosition getPosBlank(){
        return posBlank;
    }
    
        public String toString(){
       String stateString;
       
       stateString = pos1 + " " + pos2 + " " + pos3 + "\n"
                    + pos4 + " " + pos5 + " " + pos6 + "\n"
                    + pos7 + " " + pos8 + " " + posBlank + "\n\n";
       
       return stateString;
    }
    // private variables
    
    private PuzzlePosition pos1;
    private PuzzlePosition pos2;
    private PuzzlePosition pos3;
    private PuzzlePosition pos4;
    private PuzzlePosition pos5;
    private PuzzlePosition pos6;
    private PuzzlePosition pos7;
    private PuzzlePosition pos8;
    private PuzzlePosition posBlank;
}
