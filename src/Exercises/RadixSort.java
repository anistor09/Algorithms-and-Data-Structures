package Exercises;
import java.util.*;
public class RadixSort {



        /**
         * Sorts a list of words using MSD radix sort.
         *
         * @param words
         *     The list of words to sort.
         * @return The sorted list of words.
         * @throws NullPointerException
         *     If `words` equals `null`.
         */
        static List<String> radixSortMSD(List<String> words) {
            // TODO
            if(words==null)
                throw new NullPointerException();

            return radixSortMSDHelper(words,0);
        }
        static List<String> radixSortMSDHelper(List<String> words,int pos)
        {
            List<List<String>> buckets = new ArrayList();
            List<String> result = new ArrayList();
            if(words.size()<2)
                return words;
            for(int i=0;i<27;i++)
            {
                buckets.add(new ArrayList());
            }
            for(String word:words)
            {
                if(pos<word.length())
                {
                    int index=(int)word.charAt(pos)-(int)'a';
                    buckets.get(index).add(word);
                }
                else
                {
                    result.add(word);
                }
            }
            for(List<String> bucket:buckets)
            {
                result.addAll(radixSortMSDHelper(bucket,pos+1));
            }
            return result;
        }

    }




