package com.student.sort.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
          public void run() {
              try {
                  Main main = new Main();
                  main.frame.setVisible(true);
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      });
  }

  /**
   * Create the application.
   */
  public Main() {
      initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
      frame = new JFrame();
      BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
      borderLayout.setVgap(102);
      borderLayout.setHgap(100);

      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
}
