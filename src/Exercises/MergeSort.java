package Exercises;

import java.util.Arrays;

public class MergeSort {
    /**
     * @param elements
     *     Array of integers to be sorted.
     * @return
     *     New array of sorted integers.
     */
    public static int[] mergeSort(int[] elements) {
        // TODO
        if(elements== null)
            return null;
        if(elements.length<2)
            return elements;
        int mid = elements.length/2;
        int[] sub1 = Arrays.copyOfRange(elements,0,mid);
        int[] sub2 = Arrays.copyOfRange(elements,mid,elements.length );

        mergeSort(sub1);
        mergeSort(sub2);
        merge(sub1,sub2,elements);

        return elements;
    }
    public static  void merge(int[] sub1,int[] sub2, int[] elements)
    {
        int i=0;
        int j=0;
        int r=0;
        while(i<sub1.length && j<sub2.length)
        {
            if(sub1[i]<sub2[j])
                elements[r++]=sub1[i++];
            else elements[r++]= sub2[j++];
        }
        while(i<sub1.length)
            elements[r++]= sub1[i++];

        while(j<sub2.length)
            elements[r++]=sub2[j++];
    }
}
