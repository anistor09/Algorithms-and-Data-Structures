package Exercises;

public class IndexSort {
    /**
     * Sorts the indices of the array based on the corresponding value in alphabetical order.
     * Returns null if the input array is null.
     *
     * Example: The array ["c","a","b"] will result in [1, 2, 0].
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] indexSort(String[] arr) {
        if(arr==null)
            return null;

        if(arr.length==0)
            return new int[arr.length];






        int[] indexes = new int[arr.length];
        for(int i=0;i<arr.length;i++ )
            indexes[i]=i;


        for(int i=1;i<arr.length;i++)
        {
            String current =arr[i];
            int index=i;
            int k = indexes[i];
            for(int j=i-1;j>=0;j--)
            {
                if(current.compareTo(arr[j])<0)
                {
                    index=j;
                    arr[j+1]=arr[j];
                    indexes[j+1]=indexes[j];


                }
            }
            arr[index]=current;
            indexes[index]=k;
        }
        // TODO


        return indexes;

    }

}
