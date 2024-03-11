/*
 * Written by M.M. Clark
 */
import java.awt.*; 

public class Ball {
	//declare instance variables
    private int x, y, cx, cy, speed, size;
    private Color color;
    static final int MAX_SPEED = 10;
	//ball constructor assigns values to instance variables
    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.color = color;
        this.size = size;
    }
    public void setX(int x) {
    	this.x = x;
    }
    public void setY(int y) {
    	this.y = y;
    }
    public void setCx(int cx) {
    	this.cx = cx;
    }
    public void setCy(int cy) {
    	this.cy = cy;
    }
    public void setSpeed(int speed) {
    	this.speed = speed;
    }
    public int getSize() {
    	return this.size;
    }
    
    public void paint(Graphics g){

        //set the brush color to the ball color
        g.setColor(color);

        //paint the ball at x, y with a width and height of the ball size
        g.fillOval(x, y, size, size);

    }
    
    public void moveBall(){
        x += cx;
        y += cy;
    }
    
    /**
     * Detect collision with screen borders and reverse direction
     * @param top - the y value of the top of the screen
     * @param bottom - the y value of the bottom of the screen
     */
    public void bounceOffEdges(int top, int bottom){

        //if the y value is at the bottom of the screen
        if (y > bottom - size){
            reverseY();
        }
        //if y value is at top of screen
        else if(y < top){
            reverseY();
        }

    }

    /**
     * Reverse's the ball's change in x value
     */
    public void reverseX(){
        cx *= -1;
    }

    /**
     * Reverse's the ball's change in y value
     */
    public void reverseY(){
        cy *= -1;
    }
    
    //getter in Ball class
  	public int getY(){
          return y;
    }
  	
  	public int getX(){
  	    return x;
  	}
  	
  	public void increaseSpeed(){
        //make sure current speed is less than max speed before incrementing
        if(speed < MAX_SPEED){
            //increase the speed by one
            speed ++;

            //update cy and cx with the new speed
            cx = (cx / Math.abs(cx)*speed);
            cy = (cy / Math.abs(cy)*speed);

        }

    }
}
