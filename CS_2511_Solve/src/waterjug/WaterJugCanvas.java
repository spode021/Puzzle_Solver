/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package waterjug;

import framework.Canvas;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Timer;
/**
 *
 * @author andrew
 */
public class WaterJugCanvas extends Canvas{

    /**
     * Creates a water jug canvas from a water jug state
     * @param newState
     */
    public WaterJugCanvas(WaterJugState newState) {
        super(newState);
        currState = newState;
         setPreferredSize(new Dimension(300, 300));
        roundRect = new RoundRectangle2D.Double(5, 5, 290, 290, 50, 50);
    
        //xJug
        xJug = new GeneralPath();
        
        xJug.moveTo(120, 75);
        xJug.lineTo(120, 225);
        xJug.lineTo(30, 225);
        xJug.lineTo(30, 75);
        
        //yJug
        yJug = new GeneralPath();
        
        yJug.moveTo(175, 25);
        yJug.lineTo(175, 225);
        yJug.lineTo(265, 225);
        yJug.lineTo(265, 25);
    
        xRectHeight = 0.0;
        xRectYVal = 225.0;
        xRect = new Rectangle2D.Double(30, 225, 90, 0);
        
        yRectHeight = 0.0;
        yRectYVal = 225.0;
        yRect = new Rectangle2D.Double(175, 225, 90, 0);
        ActionEvent e;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
    
        g2.setColor(new Color(238, 213, 183));
        g2.draw(roundRect);
        g2.fill(roundRect);
    
        g2.setColor(Color.BLUE);
        g2.draw(xRect);
        g2.draw(yRect);
        g2.fill(xRect);
        g2.fill(yRect);
    
        g2.setStroke(new BasicStroke(3.0f));
        g2.setColor(Color.BLACK);
        g2.draw(xJug);
        g2.draw(yJug);
    
        g2.setColor(new Color(139, 119, 101));
        g2.setFont(new Font("Sanserrif", Font.BOLD, 22));
        g2.drawString("X (" +xJugLvl + ")", 55, 255);
        g2.drawString("Y (" + yJugLvl +")", 200, 255);
    
    
    }
    
    /**
     *
     */
    @Override
    public void render(){
    //WaterJugState tempState = (WaterJugState) super.getCurrentState();
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                WaterJugState tempState = (WaterJugState) getCurrentState();
      
                xJugLvl = tempState.getXJugLevel();
                yJugLvl = tempState.getYJugLevel();
                if(xRectHeight > tempState.getXJugLevel() * 50){
                    xRectYVal++;
                    xRectHeight--;
                    xRect.setRect(30, xRectYVal, 90, xRectHeight);
           
                }
                if(xRectHeight < tempState.getXJugLevel() * 50){
                    xRectYVal--;
                    xRectHeight++;
                    xRect.setRect(30, xRectYVal, 90, xRectHeight);
       
          
            
                }
                if(yRectHeight < tempState.getYJugLevel() * 50){
                    yRectYVal--;
                    yRectHeight++;
                    yRect.setRect(175, yRectYVal, 90, yRectHeight);
            
                }
                if(yRectHeight > tempState.getYJugLevel() * 50){
                    yRectYVal++;
                    yRectHeight--;
                    yRect.setRect(175, yRectYVal, 90, yRectHeight);
                }
     
                repaint();
            }
    
    
    
        });
        timer.start();
    }
        
    //variables
    int xJugLvl;
    int yJugLvl;
    WaterJugState currState;
    RoundRectangle2D.Double roundRect;
    Rectangle2D.Double xRect;
    Double xRectHeight;
    Double yRectHeight;
    Double xRectYVal;
    Double yRectYVal;
    Rectangle2D.Double yRect;
    GeneralPath xJug;
    GeneralPath yJug;
    Timer timer;
}

