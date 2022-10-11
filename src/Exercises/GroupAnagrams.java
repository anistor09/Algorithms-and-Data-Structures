import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> stringMap = new HashMap();
        for(String s : strs){
            int[] letters = new int[26];

            for(int i= 0 ; i< s.length(); i++){
                char c = s.charAt(i);
                int value = c - '0';
                letters[value - 49]++;

            }

            StringBuilder sb = new StringBuilder();
            for(int j=0; j<26;j++)
            {   if(letters[j]>9){
                sb.append(" ");
                sb.append(letters[j]);
                sb.append(" ");
            }
            else {
                sb.append(letters[j]);
            }}

            String key = sb.toString();
            List<String> values = new ArrayList();

            if(stringMap.containsKey(key))
            {
                values = stringMap.get(key);
            }
            values.add(s);
            stringMap.put(key, values);

        }
        List<List<String>> res = new ArrayList();

        for(String s : stringMap.keySet()){
            res.add(stringMap.get(s));

        }
        return res;

    }
}