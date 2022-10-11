import java.util.HashMap;
import java.util.Map;

public class TwoNumbers {

    public static void main(String[] args){
        System.out.println(twoSum(new int[]{3,2,4},6));

    }
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> searchIntegers = new HashMap<Integer, Integer>();

        for(int i=0 ; i< nums.length; i++)
        {
            searchIntegers.put(nums[i],i);
        }

        for(int i=0; i< nums.length; i++){
            int left = target - nums[i];
            if(searchIntegers.containsKey(left)){
                return new int[]{i,searchIntegers.get(left)};
            }
        }


        return new int[2];
    }

}
