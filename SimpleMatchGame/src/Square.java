/*
 * Written by MM Clark
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class Square 
{
    private int squareXLocation;
    private int squareSize;
    private int squareYLocation = -squareSize;
    private int fallSpeed = 1;
    private Random rand = new Random();
    public int generateRandomXLocation(int windowWidth, int windowHeight)
    {
        return squareXLocation = rand.nextInt(windowWidth);
    }
    public int generateRandomSquareSize()
    {
        return squareSize = rand.nextInt(50);
    }
    public int generateRandomFallSpeed()
    {
        return fallSpeed = rand.ints(1,1,10).findFirst().getAsInt();
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.CYAN);
        g.fillRect(squareXLocation,squareYLocation,squareSize,squareSize);
    }
    public Square(int windowWidth, int windowHeight)
    {
        generateRandomXLocation(windowWidth,windowHeight);
        generateRandomSquareSize();
        generateRandomFallSpeed();
    }
    public void update(int windowHeight)
    {
        if(squareYLocation>=windowHeight)
        {
            generateRandomXLocation(windowHeight,windowHeight);
            generateRandomFallSpeed();
            generateRandomSquareSize();
            squareYLocation=-squareSize;
        }
        if(squareYLocation<=windowHeight)
        {
            squareYLocation+=fallSpeed;
        }
    }
}
