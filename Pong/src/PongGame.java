/*
 * Written by M.M. Clark
 */
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.JPanel;

public class PongGame extends JPanel implements MouseMotionListener{
	
	static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
	
	/**
     * Updates and draws all the graphics on the screen
     */
    public void paintComponent(Graphics g){

        //draw the background, set color to BLACK and fill in a rectangle
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        
        //draw the ball
        gameBall.paint(g);
      
        //draw the paddles
        userPaddle.paint(g);
        pcPaddle.paint(g);
        
        //update score
        g.setColor(Color.YELLOW);
        //the drawString method needs a String to print, and a location to print it at.
        g.drawString("Score - User [ " + userScore + " ]   PC [ " + pcScore + " ]", 250, 20   );
    }
    
    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;
    
    private int userScore, pcScore;
    
    private int userMouseY;
    private int bounceCount; 
    
    public PongGame(){

        gameBall = new Ball(300, 200, 3, 3, 3, Color.GREEN, 10);
        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.CYAN);
        
        userMouseY = 0;
        userScore = 0;pcScore = 0;
        bounceCount = 0; 
        
      //listen for motion events on this object
        addMouseMotionListener(this);
    }
    
    /**
     * Called once each frame to handle essential game operations
     */
    public void gameLogic(){

        //move the ball one frame
        gameBall.moveBall();

        //edge check/bounce
        
        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);
        
        userPaddle.moveTowards(userMouseY);
        pcPaddle.moveTowards(gameBall.getY());
        
      //check if ball collides with either paddle
        if(pcPaddle.checkCollision(gameBall) || userPaddle.checkCollision(gameBall)){
            //reverse ball if they collide
            gameBall.reverseX();
            //increase the bounce count
            bounceCount++;
        }

        //after 5 bounces
        if (bounceCount == 4){
            //reset counter
            bounceCount = 0;
            //increase ball speed
            gameBall.increaseSpeed();
        }
        
        //check if someone lost
        if(gameBall.getX() < 0){
            //player has lost
            pcScore++;
            reset();
        }
        else if(gameBall.getX() > WINDOW_WIDTH){
            //pc has lost
            userScore++;
            reset();
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    	userMouseY = e.getY();
    }
    /**
     * resets the game to start a new round
     */
    public void reset(){

        //pause for a second
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setCx(3);
        gameBall.setCy(3);
        gameBall.setSpeed(3);
        bounceCount = 0;

    }

}
