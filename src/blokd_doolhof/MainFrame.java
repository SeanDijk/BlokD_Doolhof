
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 * @author Sean
 */
public class MainFrame extends JFrame{

    Speelveld level = new Speelveld();
    JPanel stappenteller = new JPanel();
    JLabel stappen;
    JLabel aantalStappen;
    public MainFrame()
    {
        setLayout(new BorderLayout());
        add(level, BorderLayout.CENTER);
        makeStappenteller();     
        addKeyListener(key);   
        setAutoRequestFocus(rootPaneCheckingEnabled);
    }

    
    public void makeStappenteller()
    {
        stappen = new JLabel("Aantal stappen: ");
        aantalStappen = new JLabel(""+ Speler.aantalStappen);
        stappenteller.add(stappen);
        stappenteller.add(aantalStappen);

        add(stappenteller, BorderLayout.SOUTH);
    }
    
    
    KeyListener key = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            String key = Character.toString(e.getKeyChar());
            
            if("w".equals(key))
            {
                level.speler.move("up");
                aantalStappen.setText(Integer.toString(Speler.aantalStappen));
            }
            if("a".equals(key))
            {
                level.speler.move("left");
                aantalStappen.setText(Integer.toString(Speler.aantalStappen));
            }
            if("s".equals(key))
            {
                level.speler.move("down");
                aantalStappen.setText(Integer.toString(Speler.aantalStappen));
            }
            if("d".equals(key))
            {
                level.speler.move("right");
                aantalStappen.setText(Integer.toString(Speler.aantalStappen));
            }
            if(" ".equals(key))
            {
                level.speler.usePickup(level.speler.huidigveld);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    };
}
    
    