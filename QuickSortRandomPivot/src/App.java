/*
 * Written by MM Clark
 */
public class App 
{
    private static Lomuto l = new Lomuto();
    private static Hoare h = new Hoare();
    public static void main(String[] args) throws Exception 
    {   
        int arr[] = {10,7,8,9,1,5};
        System.out.print("Unsort arr ");
        l.print(arr);
        System.out.print("Lomuto Sort arr ");
        l.quicksortLomuto(arr);
        l.print(arr);

        int arr2[] = {3,4,5,2,5,9,1};
        System.out.print("Unsort arr ");
        l.print(arr2);
        System.out.print("Hoare Sort arr ");
        h.quickSortHoare(arr2);
        l.print(arr2);
    }
    
}
