/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watch;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author Experimentos
 */
public class WatchDisplay extends JPanel{
    private Point[] points = new Point[3];
    
    public void paint (Point[] points){
        this.points = points;
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(), getHeight());
        g.setColor(Color.WHITE);
        //g.drawOval(15, 5, 360, 360);
        g.fillOval(15, 5, 360, 360);
        g.setColor(Color.BLACK);
        int width=1;
        int ox = getWidth() / 2;
        int oy = getHeight() / 2;
        for (Point punto : points){
            g2(g).setStroke(new BasicStroke(width));
            width +=2;
            g2(g).drawLine(ox, oy, (ox-punto.x), oy-punto.y);
        }
        
    }
    
    private Graphics2D g2 (Graphics g){
        return (Graphics2D) g;
    }


    
}
