/*
 * Written by MM Clark
 */
import java.util.Random;

public class Lomuto
{
    //easier to implement but slower
    public void quicksortLomuto(int[] arr)
    {
        int lo = 0;
        int hi = arr.length-1;
        quicksortLomuto(arr,lo,hi);
    }
    public void quicksortLomuto(int[] arr, int lo, int hi)
    {
        //takes last element as pivot, places pivot element
        //at correct pos in sorted arr, places all smaller 
        //(smaller than pivot) to left of pivot and all greater
        //elements to right of pivot
        if(lo<hi)
        {
            //pi is partitioning index, arr[p] is now at right place
            int pi = partition(arr,lo,hi);
            //separately sort element before partition and after partition
            quicksortLomuto(arr, lo, pi -1);
            quicksortLomuto(arr,pi+1,hi);
        }
    }
    //generate random pivot, swap pivot with end element and call partition func
    int partition(int arr[], int lo, int hi)
    {
        //generate random number in btwn low and high
        random(arr,lo,hi);
        int pivot = arr[hi];
    
        //index of smaller element
        int i = (lo-1);
        for(int j=lo;j<hi;j++)
        {
            //if current element is smaller than or equal to pivot
            if(arr[j]<pivot)
            {
                i++;
                //swap arr[i] and arr[j]
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[hi];
        arr[hi] = temp;
    
        return i+1;
    }
    public void random(int[] arr, int lo, int hi)
    {
        //helps calc random nums btwn low(inclusive) and high(inclusive)
        Random rand = new Random();
        int pivot = rand.nextInt(hi-lo)+lo;
        int temp1=arr[pivot];
        arr[pivot]=arr[hi];
        arr[hi]=temp1;
    }
    public void print(int[] arr)
    {
        int n = arr.length;
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}