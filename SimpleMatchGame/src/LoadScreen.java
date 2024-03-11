/*
 * Written by MM Clark
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoadScreen extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.drawLine(10,25,200,255);

        g.setColor(Color.RED);
        g.drawRect(10,95,200,30);

        g.setColor(Color.BLUE);
        g.drawOval(10,140,200,30);

        g.setColor(Color.MAGENTA);
        g.fill3DRect(10,200,200,30,true);
    }
}
