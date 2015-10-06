package framework;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew Spoden
 */
public abstract class Canvas extends JComponent {
    
    //constructor
    public Canvas(State newState){
        currentState = newState;
    }
    //Methods
    
    //Mutator
    public void setCurrentState(State s){
        currentState = s;
    }
    //Accessor
    public State getCurrentState(){
        return currentState;
    }
    
    //Overrides paint component
    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g){   
        super.paintComponent(g);   
        }  
    
    /**
     *
     */
    public void render(){
        
    }
    //Variables
    State currentState = null;
    State previousState = null;
}
