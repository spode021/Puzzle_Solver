/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle;

import framework.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Andrew Spoden
 */
public class PuzzleCanvas extends Canvas{
    
    
    public PuzzleCanvas(PuzzleState newState){
        super(newState);
        setPreferredSize(new Dimension(290,290));
        mainRect = new Rectangle2D.Double(5, 5, 280, 280);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        PuzzleState tempState = (PuzzleState) getCurrentState();
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(mainRect);
        g2.setColor(Color.BLUE);

        rectPosition = tempState.getPos1();
        drawBox(g2, 1, rectPosition);
        
        rectPosition = tempState.getPos2();
        drawBox(g2, 2, rectPosition);
        
        rectPosition = tempState.getPos3();
        drawBox(g2, 3, rectPosition);
        
        rectPosition = tempState.getPos4();
        drawBox(g2, 4, rectPosition);
        
        rectPosition = tempState.getPos5();
        drawBox(g2, 5, rectPosition);
        
        rectPosition = tempState.getPos6();
        drawBox(g2, 6, rectPosition);
        
        rectPosition = tempState.getPos7();
        drawBox(g2, 7, rectPosition);
        
        rectPosition = tempState.getPos8();
        drawBox(g2, 8, rectPosition);
        
        rectPosition = tempState.getPosBlank();
        drawBox(g2, 0, rectPosition);
        
    }
    
    @Override
    public void render(){
       repaint(); 
    }
    
    public void drawBox(Graphics2D g, Integer boxNumber, PuzzlePosition position){
        
        g.setFont(new Font("sansserif", Font.BOLD,18));
        g.setColor(Color.BLUE);
        if(position == PuzzlePosition.TOPWEST){
            if(boxNumber != 0){
               
                g.fillRect(5, 5, 90, 90);
                g.setColor(Color.BLACK);
                g.drawString(boxNumber.toString(), 45, 45);
        
            }
        }
        else if(position == PuzzlePosition.TOPCENTER){
            if(boxNumber != 0){
              
                g.fillRect(100, 5, 90, 90);
                g.setColor(Color.BLACK);
                g.drawString(boxNumber.toString(), 135, 45);
        
            }
        }
        else if(position == PuzzlePosition.TOPEAST){
            if(boxNumber != 0){
               
                g.fillRect(195, 5, 90, 90);
                g.setColor(Color.BLACK);
                g.drawString(boxNumber.toString(), 225, 45);
            }
        }
        else if(position == PuzzlePosition.CENTERWEST){
            if(boxNumber != 0){
               
                g.fillRect(5, 100, 90, 90);
                g.setColor(Color.BLACK);
                g.drawString(boxNumber.toString(), 50, 140);
        
            }
        }
        else if(position == PuzzlePosition.CENTERCENTER){
            if(boxNumber != 0){
                g.fillRect(100, 100, 90, 90);
                g.setColor(Color.BLACK);
                g.drawString(boxNumber.toString(), 145, 140);
            }
            
        }
        else if(position == PuzzlePosition.CENTEREAST){
            if(boxNumber != 0){
               g.fillRect(195, 100, 90, 90);
               g.setColor(Color.BLACK);
               g.drawString(boxNumber.toString(), 240, 140);
            }
        }
        else if(position == PuzzlePosition.BOTTOMWEST){
            if(boxNumber != 0){
                g.fillRect(5, 195, 90, 90);
                g.setColor(Color.BLACK);
                g.drawString(boxNumber.toString(), 5, 235);
                
        
            }
        }
        else if(position == PuzzlePosition.BOTTOMCENTER){
            if(boxNumber != 0){
                g.fillRect(100, 195, 90, 90);
                g.setColor(Color.BLACK);
                g.drawString(boxNumber.toString(), 145, 235);
            }
        }
        else if(position == PuzzlePosition.BOTTOMEAST)
            if(boxNumber != 0){
                g.fillRect(195, 195, 90, 90);
                g.setColor(Color.BLACK);
                g.drawString(boxNumber.toString(), 240, 235);
            }
                
    }
    //variables
    private Rectangle2D.Double mainRect;
    PuzzlePosition rectPosition;
            
}
