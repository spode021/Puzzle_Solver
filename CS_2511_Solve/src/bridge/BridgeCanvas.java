package bridge;

import framework.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrew
 */
public class BridgeCanvas extends Canvas{

    public BridgeCanvas(BridgeState newState) {
        super(newState);
   
        setPreferredSize(new Dimension(300, 300));
        roundRect = new RoundRectangle2D.Double(5, 5, 290, 290, 50, 50);
    
        bridge = new GeneralPath();
        middleX = 145.0;
        middleY = 145.0;
        //set the lines for the bridge
        bridge.moveTo(middleX - 50, middleY - 30);
        bridge.lineTo(middleX - 40, middleY - 25);
        bridge.lineTo(middleX + 40, middleY - 25);
        bridge.lineTo(middleX + 50, middleY - 30);
        bridge.lineTo(middleX + 50, middleY + 30);
        bridge.lineTo(middleX + 45, middleY + 25);
        bridge.lineTo(middleX - 45, middleY + 25);
        bridge.lineTo(middleX - 50, middleY + 30);
        bridge.closePath();
        
        river = new GeneralPath();
        
        //set lines for river
        river.moveTo(190, 5);
        river.curveTo(140, 130, 190, 225, 150, 295);
        river.lineTo(100, 295);
        river.curveTo(145, 225, 95, 130, 145, 5);
        river.closePath();
        
  
    }
    
   
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        BridgeState tempState = (BridgeState) getCurrentState();
        Graphics2D g2 = (Graphics2D) g;
        
        g2.draw(roundRect);
        //green
        g2.setColor(new Color(34,139,34));
        g2.fill(roundRect);
        
          g2.setColor(Color.BLUE);
          g2.draw(river);
          g2.fill(river);
        //brown
        g2.setColor(new Color(160,82,45));
     
        g2.draw(bridge);
        g2.fill(bridge);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Sanserrif", Font.BOLD, 24));
        //P1
        if(tempState.getP1Position() == Position.EAST)
            g2.drawString("P1", pXEast, 45);
        else
            g2.drawString("P1", pXWest, 45);
        
        //P2
        if(tempState.getP2Position() == Position.EAST)
            g2.drawString("P2", pXEast, 95);
        else
            g2.drawString("P2", pXWest, 95);
        
        //flashlight
        if(tempState.getFlashlightPosition() == Position.EAST)
            g2.drawString("f", pXEast, 145);
        else
            g2.drawString("f", pXWest, 145);
        
        //P5
        if(tempState.getP5Position() == Position.EAST)
            g2.drawString("P5", pXEast, 195);
        else
            g2.drawString("P5", pXWest, 195);
        
        //P10
        if(tempState.getP10Position() == Position.EAST)
            g2.drawString("P10", pXEast, 245);
        else
            g2.drawString("P10", pXWest, 245);
        
        //time
        g2.setColor(Color.WHITE);
        String time = "" + tempState.getTimeSoFar();
        g2.drawString(time + " min", 115, 150);
        
        
    }
    
    @Override
    public void render(){   
    repaint();   
    }
    
    //Variables
    BridgeState currState;
    Shape roundRect;
    Arc2D.Double arcLeft;
    Arc2D.Double arcRight;
    GeneralPath bridge;
    GeneralPath river;
    Double middleX;
    Double middleY;
    int pXEast = 250;
    int pXWest = 50;
    
    Point p2;
    Point p5;
    Point p10;
    Point flashlight;
}
