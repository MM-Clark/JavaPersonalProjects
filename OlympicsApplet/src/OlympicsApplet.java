/*
 * Written by M.M.Clark
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class OlympicsApplet extends JPanel {
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawOval(30, 30, 30, 30);
		g.setColor(Color.YELLOW);
		g.drawOval(50, 45, 30, 30);
		g.setColor(Color.BLACK);
		g.drawOval(70,30,30,30);
		g.setColor(Color.GREEN);
		g.drawOval(90, 45, 30, 30);
		g.setColor(Color.RED);
		g.drawOval(110, 30, 30, 30);
	}
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Olympics Applet");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.add(new OlympicsApplet());
		frame.setVisible(true);
	}
}
