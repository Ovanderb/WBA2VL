package adminclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

/**
 *
 * @author Olli van der Bürie
 * @version 1.0
 */
public class AdminClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame mainwindow = new JFrame("VMaNS - Video Management and Notification System");
        mainwindow.setSize(800, 600);
        
        
        JMenuBar bar = new JMenuBar();
        JMenu menu_datei = new JMenu("Datei");
        JMenu menu_bearbeiten = new JMenu("Bearbeiten");
        
        JPanel content_container = new JPanel(new BorderLayout());
        JPanel selection_container = new JPanel(new BorderLayout());
        JPanel status_container = new JPanel(new BorderLayout());
        
        //TODO Hier weiter testen
        content_container.setBackground(Color.red);
        //content_container.setPreferredSize(new Dimension(100,50));
        selection_container.setBackground(Color.blue);
        selection_container.setPreferredSize(new Dimension(250,0));
        status_container.setBackground(Color.green);
        status_container.setPreferredSize(new Dimension(0,50));
        
        /*
         * Menüitems fürs Dateimenü initiieren
         */
        JMenuItem item_lokal_open = new JMenuItem("Lokal öffnen");
        item_lokal_open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("lokal oefnnen");
            }
        });
                
        JMenuItem item_load_http = new JMenuItem("Laden");
        item_load_http.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("loadhttp");
            }
        });
        
        JSeparator menu_datei_sep = new JSeparator();
        
        JMenuItem item_beenden = new JMenuItem("Beenden");
        item_beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        /*
         * Menüitems fürs Bearbeitenmenü initiieren
         */
        JMenuItem item_kopieren = new JMenuItem("Kopieren");
        item_kopieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("kopieren");
            }
        });
        
        JMenuItem item_ausschneiden = new JMenuItem("Ausschneiden");
        item_ausschneiden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ausschneiden");
            }
        });
        
        JMenuItem item_einfuegen = new JMenuItem("Einfügen");
        item_einfuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Einfügen");
            }
        });        
        
        /*
         * Alles zusammenadden
         */
        menu_datei.add(item_lokal_open);
        menu_datei.add(item_load_http);
        menu_datei.add(menu_datei_sep);
        menu_datei.add(item_beenden);
        bar.add(menu_datei);
        
        menu_bearbeiten.add(item_kopieren);
        menu_bearbeiten.add(item_ausschneiden);
        menu_bearbeiten.add(item_einfuegen);
        bar.add(menu_bearbeiten);
        
        mainwindow.setJMenuBar(bar);
        mainwindow.add(content_container,BorderLayout.CENTER);
        mainwindow.add(selection_container,BorderLayout.WEST);
        mainwindow.add(status_container,BorderLayout.PAGE_END);
        mainwindow.setVisible(true);
        
        /*
         * Window Listener für den X Button
         */
        WindowListener mainWindowListener = new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        mainwindow.addWindowListener(mainWindowListener);
    }
}
