/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrew
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MainClass {

  public static void main(String[] args) {
    Timer timer = new Timer(1000, new MyTimerActionListener());

    timer.start();
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
    }
    timer.stop();
  }

}

class MyTimerActionListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {

    System.out.println("asdf");

  }
}