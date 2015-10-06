/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle;


import framework.GUI;
import javax.swing.JFrame;

/**
 * A class to test your GUI class on the water jug problem.
 * @author tcolburn
 */
public class PuzzleGUI extends JFrame {
    
    public PuzzleGUI() {
        add(new GUI(new PuzzleProblem(), new PuzzleCanvas(new PuzzleState(PuzzlePosition.CENTERWEST,PuzzlePosition.TOPWEST,PuzzlePosition.TOPEAST, PuzzlePosition.CENTEREAST, PuzzlePosition.BOTTOMEAST, PuzzlePosition.CENTERCENTER, PuzzlePosition.BOTTOMWEST, PuzzlePosition.TOPCENTER, PuzzlePosition.BOTTOMCENTER))));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    /**
     * This method launches the gui.
     * @param args ignored
     */
    public static void main(String[] args) {
        new PuzzleGUI();
    }
    
}