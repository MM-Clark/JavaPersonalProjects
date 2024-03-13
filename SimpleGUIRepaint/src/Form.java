/*
 * Written by MM Clark
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class Form extends JFrame implements KeyListener
{
    //private JPanel contentPane
    private static Car car1;

    //launch the application
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run()
            {
                try
                {
                    Form frame = new Form();
                    frame.setVisible(true);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    //Create frame
    public Form()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,700,500);
        getContentPane().setLayout(null);
        car1 = new Car(350,380);
        
        addKeyListener(this);

        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
            
        car1.setBounds(0,0,700,500);
        car1.setBackground(new Color(255,255,255));
        getContentPane().add(car1);

        //isSafe();
    }
    public static void isSafe()
    {
        boolean safe=true;
        while(safe)
        {
            safe=car1.isSafe();
        }
        JOptionPane.showMessageDialog(null, "YOU HIT AN INVISIBLE POTHOLE");
        System.exit(0);
    }
    @Override
    public void keyTyped(KeyEvent e) 
    {
        
    }
    @Override
    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_LEFT)
        {
            car1.moveLeft();
            car1.repaint();
            repaint();//without this you can make a path!
        }
        if(key==KeyEvent.VK_RIGHT)
        {
            car1.moveRight();
            car1.repaint();
            repaint();
        }
        if(key==KeyEvent.VK_UP)
        {
            car1.moveUp();
            car1.repaint();
            repaint();
        }
        if(key==KeyEvent.VK_DOWN)
        {
            car1.moveDown();
            car1.repaint();
            repaint();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) 
    {
        
    }

}
