/*
 * Written by MM Clark
 */

import java.util.Random;

public class Hoare 
{
    public void quickSortHoare(int[] arr)
    {
        int lo=0;
        int hi=arr.length-1;
        quickSortHoare(arr,lo,hi);
    }
    public void quickSortHoare(int[]arr,int lo,int hi)
    {
        if(lo<hi)
        {
            int pivotIdx = generateRandomPivot(lo,hi);
            int pivotVal = arr[pivotIdx];
            //swap pivot element with last element
            swap(arr,pivotIdx,hi);
            int i = lo - 1;
            for(int j=lo;j<hi;j++)
            {
                if(arr[j]<pivotVal)
                {
                    i++;
                    swap(arr,i,j);
                }
            }
            //swap pivot element back to its final position
            swap(arr, i+1, hi);
            //recursively sort the left and right subarrays
            quickSortHoare(arr, lo, i);
            quickSortHoare(arr,i+2,hi);
        }
    }
    public int generateRandomPivot(int lo, int hi)
    {
        Random random = new Random();
        return random.nextInt(hi-lo+1)+lo;
    }
    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
