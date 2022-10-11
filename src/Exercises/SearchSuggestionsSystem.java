import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        StringBuilder sb = new StringBuilder();
        List<List<String>> res = new ArrayList();

        for(int i=0;i< searchWord.length(); i++){
            sb.append(searchWord.charAt(i));
            String currentSW = sb.toString();

            List<String> currentList = new ArrayList();
            int lastFoundIndex = 0;

            for(int j=0; j<3 ; j++){
                if(lastFoundIndex!=-1)
                {
                    int foundIndex = binarySearch(products,currentSW,lastFoundIndex,products.length-1);
                    lastFoundIndex = foundIndex;

                    if(foundIndex!=-1){
                        currentList.add(products[foundIndex]);
                    }
                }
            }

            res.add(currentList);

        }
        return res;

    }
    public int binarySearch(String[] products, String currentSW, int start, int end){

        if(start>end || start<0 || end> products.length-1)
            return -1;
        int mid = (start + end)/2;
        boolean found = true;
        for(int i=0; i<currentSW.length(); i++){
            if(i<products[mid].length() && products[mid].charAt(i)!=currentSW.charAt(i))
                found = false;
        }
        if(found == true)
        {
            return mid;
        }
        else{
            if(products[mid].compareTo(currentSW)<0)
            {
                return binarySearch(products,currentSW,mid+1,end);}
            else{
                return binarySearch(products,currentSW,start,mid-1);
            }

        }
    }
}
