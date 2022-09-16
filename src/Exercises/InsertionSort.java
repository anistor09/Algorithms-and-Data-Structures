package Exercises;

public class InsertionSort {
    /**
     * @param elements
     *     - array of integers to be sorted.
     */
    public static void insertionSort(int[] elements) {
        // TODO
        for(int i=1;i<elements.length;i++)
        {
            if(elements[i]<elements[i-1])
            {
                int k = i-1;
                int nr = elements[i];

                for(int j=i-1;j>=0;j--)
                    if(nr<elements[j])
                    {
                        elements[j+1]= elements[j];
                        k=j;
                    }
                    else
                        j=-1;

                elements[k]= nr;

            }
        }
    }
}
