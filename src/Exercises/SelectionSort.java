package Exercises;

public class SelectionSort {
    /**
     * @param elements
     *     Array of integers to be sorted.
     */
    public static void selectionSort(int[] elements) {
        // TODO
        for(int i=0;i<elements.length-1;i++)
        {
            int min =i;
            for(int j=i+1;j<elements.length;j++)
            {
                if(elements[j]<elements[min])
                    min =j;
            }
            if(min!=i)
            {
                int temp = elements[i];
                elements[i]=elements[min];
                elements[min]=temp;
            }
        }
    }
}
