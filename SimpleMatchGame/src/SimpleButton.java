/*
 * Written by MM Clark
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
 
class SimpleButton extends JPanel implements ActionListener 
{
    private MathFallingObjs roller = new MathFallingObjs();
    private int windowWidth = 600;
    private int rollingWidth = 500;
    private JFrame startScreen;
    private JFrame fate;
   
    private JFrame results;
    private JButton start;
    private JButton end;
    private JButton roll;
    private JButton getSmallest;
    private JButton rollerText;
    private JPanel res;
    private JButton answers;
    private JButton legacy;
    private JButton replay;
    private JFrame loading;
    private JPanel load;
    private JButton waiting;
    private JPanel fatePanel;
    private JButton getNewFate;
    
    protected MinHeap<Integer> m = new MinHeap<Integer>();
    public void run()
    {
        startScreen = new JFrame();
        start = new JButton("Start");
        end = new JButton("Exit");
        roll = new JButton("Roll your fate.");
        getSmallest = new JButton("Get your fate");
        replay = new JButton("Replay?");
        replay.setText("Replay?");
        rollerText = new JButton("Rolling your fate");
        rollerText.setText("Rolling your fate");
        getNewFate = new JButton("Try for better fate");
        getNewFate.setText("Try again for better luck...");
     
        start.addActionListener(this);
        end.addActionListener(this);
        roll.addActionListener(this);
        getSmallest.addActionListener(this);
        rollerText.addActionListener(this);
        replay.addActionListener(this);
        getNewFate.addActionListener(this);

        startScreen.setLayout(new GridBagLayout());
        startScreen.add(start);
        startScreen.add(end);
        startScreen.getRootPane().setDefaultButton(start); 
        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startScreen.setSize(400,400);
        startScreen.setLocationRelativeTo(null);
        startScreen.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==start)
        {
            darkenStart();
            JOptionPane.showMessageDialog(null,"You are about to embark on a remarkable journey\nthat will change you forever...\nAre you ready?");
            startScreen.setVisible(false);
            try {
                takeFate();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if(e.getSource()==end)
        {
            startScreen.setVisible(false);
            System.exit(0);
        }
        if(e.getSource()==roll)
        {
            int valueRolled = -1;
            try {
                updateLoad();
                valueRolled = rollScreen(valueRolled);
                Thread.sleep(1000);
                loading.setVisible(false);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            m.add(valueRolled);
            
            try {
                backupUI();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if(e.getSource()==getSmallest)
        {
            JOptionPane.showMessageDialog(null, "Getting your results...");
            showResults();
        }
        if(e.getSource()==getNewFate)
        {
            updateResults();
        }
        if(e.getSource()==replay)
        {
            reset();
        }
    }
    public void darkenStart()
    {
        startScreen.remove(start);
        startScreen.remove(end);
        startScreen.getContentPane().setBackground(Color.BLACK);
        startScreen.repaint();
    }
    public void takeFate() throws InterruptedException
    {
        fate = new JFrame("Roll Your Fate....");
        backupUI();
    }
    public void backupUI() throws InterruptedException
    {
        fate.setLayout(new GridBagLayout());
        fate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fate.setSize(windowWidth,windowWidth);
        fate.getContentPane().setBackground(Color.black);
        fatePanel=new JPanel();
        fatePanel.setBackground(Color.black);
        fate.setLocationRelativeTo(null);
        fatePanel.add(roll);
        fatePanel.add(getSmallest);
        fate.add(fatePanel);
        fate.repaint();
        fate.setVisible(true);
    }
    public void updateLoad()
    {
        fate.setVisible(false);
        loading = new JFrame();
        load = new JPanel();
        load.setBackground(Color.black);
        waiting = new JButton("wait");
        waiting.setText("Rolling....");
        load.add(waiting);
        loading.add(waiting);
        loading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loading.setSize(rollingWidth,rollingWidth);
        loading.setVisible(true);
    }
    public int rollScreen(int val) throws InterruptedException
    {
        val = roll(val);
        
        return val;
    }
    public int roll(int val) throws InterruptedException
    {
        val = roller.generateRandomNumber();
        
        return val;
    } 
    public void showResults()
    {
        fate.setVisible(false);
        results = new JFrame();
        results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        results.setSize(windowWidth,windowWidth);
        res = new JPanel();
        res.setBackground(Color.BLACK);
        answers = new JButton("answersss");
        int lowestRolled = m.remove();
        answers.setText("Lowest rolled: "+lowestRolled);
        legacy = new JButton("how you'll live...");
        String fate = roller.genFate(lowestRolled);
        legacy.setText("Your fate: "+fate);
        
        res.add(answers);
        res.add(legacy);
        res.add(replay);
        res.add(getNewFate);
        res.add(end);
        results.add(res);
        results.setVisible(true);
    }
    public void updateResults()
    {
        if(m.hasMore())
        {
            int nextLowestRolled = m.remove();
            answers.setText("Next lowest rolled: "+nextLowestRolled);
            String fate = roller.genFate(nextLowestRolled);
            legacy.setText("Your fate: "+fate);
            res.repaint();
            results.repaint();
        }
        else
        {
            legacy.setText("Your fate is sealed, your rolls have been used.");
            res.remove(getNewFate);
            res.repaint();
            results.repaint();
        }
    }
    public void reset()
    {
        results.setVisible(false);
        m.reset();
        run();
    }
}