package Exercises;

import java.util.LinkedList;
import java.util.Queue;

public class BucketSort {
    @SuppressWarnings("unchecked")
    public static Queue<Integer>[] fillBuckets(int[] array) {
        if(array.length==0)
            return new Queue[0];
        // TODO
        int vmin = array[0];
        // TODO
        int vmax = array[0];
        for(int i=1;i<array.length;i++)
        {
            if(vmin>array[i])
            {
                vmin=array[i];

            }
            if(vmax<array[i])
            {
                vmax=array[i];
            }
        }

        Queue<Integer>[] buckets =  new Queue[vmax - vmin + 1];
        for(int i=0;i<buckets.length;i++)
        {
            buckets[i] = new LinkedList<Integer>();
        }

        // TODO
        for(int x:array)
        {
            buckets[x-vmin].offer(x);
        }
        return buckets;
    }

    public static int[] readBuckets(Queue<Integer>[] buckets) {
        int size=0;
        for(int i=0;i<buckets.length;i++)
            if(buckets[i]!=null)
                size+=buckets[i].size();
        int[] v=new int[size];
        int k=0;
        for(int i=0;i<buckets.length;i++)
            if(buckets[i]!=null)
                while(buckets[i].size()>0)
                    v[k++]=buckets[i].poll();
        return v;
    }
}
