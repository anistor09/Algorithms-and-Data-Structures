import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations  {
    String phoneDigits="";
    Map<Integer, String> phone;

    {
        phone = Map.of(2, "abc", 3, "def", 4, "ghi", 5, "jkl", 6, "mno", 7, "pqrs", 8, "tuv", 9, "wxyz");
    }

    List<String> combinations = new ArrayList();
    public List<String> letterCombinations(String digits) {
        phoneDigits = digits;

        if(digits.length()==0){
            return combinations;
        }
        backTrack(0,new StringBuilder());

        return combinations;

    }

    public void backTrack(int index,StringBuilder sb){

        if(sb.length() == phoneDigits.length())
        {
            combinations.add(sb.toString());
            return;
        }
        char stringKey = phoneDigits.charAt(index);

        int key = Character.getNumericValue(stringKey);

        String options = phone.get(key);

        for(int i=0; i < options.length() ;i++) {
            sb.append(options.charAt(i));
            backTrack(index+1,sb);
            sb.deleteCharAt(index);
        }

    }
}

