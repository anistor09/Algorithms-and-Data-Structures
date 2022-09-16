package Exercises;

import java.util.ArrayList;
import java.util.List;

public class RadixSortLSD {
    /**
     * Sorts a list of Dutch mobile phone numbers using LSD radix sort.
     *
     * @param phoneNumbers
     *     The list of phone numbers to sort.
     * @return The sorted list of phone numbers.
     * @throws NullPointerException
     *     If `phoneNumbers` equals `null`.
     */
    static List<String> radixSortLSD(List<String> phoneNumbers) {
        // TODO
        if(phoneNumbers==null)
            throw new NullPointerException();
        if(phoneNumbers.isEmpty())
            return phoneNumbers;
        return radixSortLSDHelper(phoneNumbers,phoneNumbers.get(0).length()-1);
    }
    static List<String> radixSortLSDHelper(List<String> phoneNumbers,int value) {
        // TODO
        List<List<String>> buckets = new ArrayList();
        List<String> result = new ArrayList();
        if(value==1)
            return phoneNumbers;
        for(int i=0;i<10;i++)
            buckets.add(new ArrayList());

        for(String phone:phoneNumbers)
        {
            int index=(int)phone.charAt(value)-(int)'0';
            buckets.get(index).add(phone);
        }
        for(int i=0;i<10;i++)
        {   List<String> current = buckets.get(i);
            while(!current.isEmpty())
            {
                result.add(current.remove(0));
            }
        }
        return radixSortLSDHelper(result,value-1);
    }
}
