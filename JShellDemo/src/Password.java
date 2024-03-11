import java.util.*;
public class Password 
{
    public static int genRandNum()
    {
        int rand = new Random().nextInt(100)+1;
        return rand;
    }
    public static void runProg()
    {
        int numGuesses = 0;
        int rand = genRandNum();
        
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Guess the number");
        int guess = keyboard.nextInt();
        while(guess!=rand)
        {
            System.out.println("Try again");
            if(guess>rand)
                System.out.println("Lower");
            else if(guess<rand)
                System.out.println("Higher");
            guess = keyboard.nextInt();
            numGuesses++;
        }
        System.out.println("Good job!");
    }
    public static void main(String[] args) throws Exception 
    {
        boolean run = true;
        while(run)
        {
            runProg();
        }
    }
}
