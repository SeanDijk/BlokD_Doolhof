/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * Abstracte superklasse voor velden.
 * @author Sean
 */
public abstract class Veld extends JComponent{
    Color kleur;
    Speler speler;
    SpelObject spelObject;
    Raket Raket;
    
    int coordsX;
    int coordsY;
    
    Veld buurLinks;
    Veld buurRechts;
    Veld buurBoven;
    Veld buurOnder;
    
    boolean walkable;
    
    String imagePath;
    
    public Veld()
    {
        kleur = Color.red;
        //Border border = new BevelBorder(1);
        setBackground(Color.green);
        //setBorder(border);
    }
    @Override
    public void paintComponent(Graphics g)
    {
                    
            g.setColor(kleur);            
      
            //Tekent het veld
            tekenObject(g);
            //g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
            
            //Tekent het spelobject op het veld
            if(spelObject != null && spelObject.disabled ==false)
            {
                add(spelObject);
                spelObject.paintComponent(g);
            }
            //Tekent de raket
            if(Raket != null && Raket.disabled == false)
            {
                add(Raket);
                Raket.paintComponent(g);
            }
            
            //Tekent de speler op het veld
            if(speler != null)
            {
                add(speler);
                speler.paintComponent(g);         
            }
             
    }
     public void tekenObject(Graphics g)
    {
        BufferedImage img = null;
        try {
             
                img = ImageIO.read(new File(imagePath));            
                g.drawImage(img, 0, 0, null);
            } 
        catch (IOException e) {
            }
    }
    //
    public Veld getBuur(String direction)
    {
        Veld veld = null;
        try{
            if("left".equals(direction))
                veld = Speelveld.velden[coordsY][coordsX-1];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            
        }
        try{
            if("right".equals(direction))
                veld = Speelveld.velden[coordsY][coordsX+1];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            
        }
        try{
            if("up".equals(direction))
               veld = Speelveld.velden[coordsY-1][coordsX];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            
        }
        try{
            if("down".equals(direction)) 
                veld = Speelveld.velden[coordsY+1][coordsX];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            
        }      

        return veld;
    }


    
    public boolean isWalkable()
    {        
        return walkable;
    }
    
    @Override
    public String toString()
    {
        return("X = " + coordsX +"  Y = " + coordsY);
    }

}
