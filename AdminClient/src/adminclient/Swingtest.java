/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Olli
 */
public class Swingtest {
    
    public static void main(String args[]){
        JFrame f = new JFrame("Hello World");
        JPanel panel1 = new JPanel( new BorderLayout() );
        JPanel panel2 = new JPanel( new BorderLayout() );
        JButton button1 = new JButton("OK");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserFrame nf = new UserFrame();
                nf.setVisible(true);
            }
        });
        
        panel1.add( button1 );
        panel1.setBackground(Color.RED);
        panel1.setPreferredSize( new Dimension( 100, 0 ) );
        panel2.setBackground(Color.GREEN);
        panel2.setPreferredSize( new Dimension( 40, 50 ) );
        
        f.add(panel1,BorderLayout.WEST);
        f.add(panel2,BorderLayout.CENTER); 
        f.setSize( 300, 200 );
        f.setVisible(true);
    }
}
