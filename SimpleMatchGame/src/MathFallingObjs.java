/*
 * Written by MM Clark
 */

import java.util.Random;

public class MathFallingObjs 
{
    private int highBound = 6;
    private int lowBound = 1;
    public enum Fates
    {
        SUCCESSFUL,
        OKAY,
        STRUGGLING,
        INTERMEDIATE,
        MAYBE,
        NOANSWER
    }
    public int generateRandomNumber()
    {
        int randNum=(int)((Math.random()*highBound)+lowBound);
        //TODO:random gen for game
        return randNum;
    }
    public String genFate(int in)
    {
        String ret = new String();
        int[]gen = new int[in];
        scramble(gen);
        ret=getRandomFate(gen);
        return ret;
    }
    public void scramble(int[] in)
    {
        for(int i=0;i<in.length;i++)
        {
            int randomInt = (int)(Math.random()*highBound);
            in[i]=randomInt;
        }
    }
    public String getRandomFate(int[] in)
    {
        int randomIdx = (int)(Math.random()*in.length);
        int randomFate = in[randomIdx];
        String ret="none";
        //max length of in would be 6 making the highest idx 5
        switch(randomFate)
        {
            case 0:
                ret="Very successful";
                break;
            case 1:
                ret="Successful";
                break;
            case 2:
                ret="meh";
                break;
            case 3:
                ret="uh oh...";
                break;
            case 4:
                ret="dismal";
                break;
            case 5:
                ret="UNKNOWN";
                break;
            case 6:
                ret="unstable";
                break;
            default:
                ret="oh no we messed up";
                break;
        }
        return ret;
    }
}
