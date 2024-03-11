/*
 * Written by Michelle Clark
 */
public class MinHeap <T extends Comparable<T>>
{
    private T[] heap;
    public static final int DEF_SIZE = 128;
    private int lastIndex;//first null element
    public MinHeap()
    {
        init(DEF_SIZE);
    }
    public MinHeap(int size)
    {
        init(size);
    }
    private void init(int size)
    {
        if(size>0)
        {
            heap = (T[])(new Comparable[size]);
            lastIndex = 0;//first null element is the root
        }
        else
            init(DEF_SIZE);
    }
    public void add(T aData)
    {
        if(lastIndex >= heap.length)
            return;
        heap[lastIndex] = aData;//assign last null element to data
        bubbleUp();
        lastIndex++;
    }
    private void bubbleUp()
    {
        int index = lastIndex;
        T tempChild = heap[index];
        T tempParent = heap[(index-1)/2];
        while(index > 0 && heap[((index-1)/2)].compareTo(heap[index])>0)//parent is greater than child must swap
        {
            //just like max but change sign
            T temp = heap[(index-1)/2];
            heap[(index-1)/2] = heap[index];
            heap[index] = temp;
            index = (index-1)/2;
        }
    }
    public T remove()
    {
        if(lastIndex == 0)
            return null;//empty tree
        T ret = heap[0];
        heap[0] = heap[lastIndex-1];//lastIndex is first null element
        heap[lastIndex-1]=null;
        lastIndex--;
        bubbleDown();
        return ret;
    }
    private void bubbleDown()
    {
        int index = 0;
        while(index*2+1 < lastIndex)
        {
            int smallIndex = index*2+1;
            if(index*2+2 < lastIndex && heap[index*2+1].compareTo(heap[index*2+2])>0)
                smallIndex = index*2+2;
            if(heap[index].compareTo(heap[smallIndex])>0)
            {
                T temp = heap[index];
                heap[index] = heap[smallIndex];
                heap[smallIndex] = temp;
            }
            else //parent was smaller than smallest child
                break;
            index = smallIndex;
        }
    }
    public void print()
    {
        for(T h : heap)
        {
            if(h==null)
                break;
            System.out.println(h);
        }
    }
    public void heapSort()
    {
        T[] copy = (T[])(new Comparable[heap.length]);
        for(int i=0;i<copy.length;i++)
        {
            copy[i]=heap[i];
        }
        heapSort(copy);
    }
    public void heapSort(T[] array)
    {
        if(array==null)
            return;
        MinHeap<T> mHeap = new MinHeap<T>(array.length);
        for(int i=0;i<array.length;i++)
            mHeap.add(array[i]);
        for(int i=0;i<array.length;i++)
            array[i]=mHeap.remove();
        print(array);
    }
    public void print(T[] array)
    {
        System.out.println("User has thus far rolled in order...");
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
    } 
    public void reset()
    {
        for(int i=0;i<heap.length;i++)
        {
            remove();
        }
    }
    public boolean hasMore()
    {
        if(heap[0]!=null)
            return true;
        else
            return false;
    }
}
