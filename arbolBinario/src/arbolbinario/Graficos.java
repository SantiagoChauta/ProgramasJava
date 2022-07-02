/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author JANUS
 */
public class Graficos {
       
    public static void dibujarValor(Graphics g, int x, int y, String valor){
        g.drawString(valor, x-10, y+12);
    }
    
    public static void dibujarlineaDer(Graphics g, int x, int y,int xfinal, int yfinal){
        g.setColor(Color.white);
        g.drawLine(x, y+15, xfinal, yfinal);
    }
    
    public static void dibujarlineaIzq(Graphics g, int x, int y,int xfinal, int yfinal){
        g.setColor(Color.white);
        g.drawLine(x, y+15, xfinal, yfinal);
    }
    
}
