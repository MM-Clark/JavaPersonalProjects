/*
 * Written by Michelle Clark
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Car extends JPanel
{
    private int x;
    private int y;
    private final int ARRAY_SIZE=10;
    private int[] arr=new int[ARRAY_SIZE];

    public Car(int x,int y)
    {
        this.x=x;
        this.y=y;
        generate();
    }

    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(x,y,20,20);
    }

    public void moveRight()
    {
        if(x<=640)
            x=x+20;
        else
            x=x-20;
        System.out.println(x);
    }

    public void moveLeft()
    {
        if(x>=20)
            x=x-20;
        else
            x=x+20;
        System.out.println(x);
    }

    public void moveUp()
    {
        if(y>=20)
            y=y-20;
        else
            y=y+20;
        System.out.println(y);
    }

    public void moveDown()
    {
        if(y<=420)
            y=y+20;
        else
            y=y-20;
        System.out.println(y);
    }

    public void generate()
    {
        for(int i=0;i<arr.length;i++)
        {
            int rand=(int)Math.random()*440;
            arr[i]=rand;
        }
    }

    public boolean isSafe()
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==x||arr[i]==y)
                return false;
        }
        return true;
    }
}
