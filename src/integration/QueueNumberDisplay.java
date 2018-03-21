/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Controls the queue number display outside the garage..
 */
class QueueNumberDisplay {
    private static String HEADER = "Now Serving:";
    private int queueNumber = -1;
    private JLabel queueNumberLabel = new JLabel("", SwingConstants.CENTER);
    private JFrame frame = new JFrame(HEADER);

    /**
     * Connects to the queue number display and shows the number
     * <code>zero</code>.
     */
    QueueNumberDisplay() {
        nextNumber();
        contactDisplay();
    }

    /**
     * Increments the displayed number.
     */
    final void nextNumber() {
        queueNumberLabel.setText(Integer.toString(++queueNumber));
    }

    private void contactDisplay() {
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 30);
        queueNumberLabel.setFont(labelFont);
        frame.getContentPane().setBackground(Color.BLACK);
        queueNumberLabel.setForeground(Color.WHITE);
        frame.getContentPane().add(queueNumberLabel);
        frame.setBounds(600, 0, 200, 80);
        frame.setVisible(true);
    }
    
    public int getQueueNumber() {
        return queueNumber;
    }
    
    public void closeFrame() {
    		frame.dispose();
    }
}
