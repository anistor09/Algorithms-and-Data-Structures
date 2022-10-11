public class TriangularSumOfArray {
    public int triangularSum(int[] nums) {
        long res=0;

        int n = nums.length-1;
        int k = 0;

        for(int i=0;i<nums.length;i++){
            long coef =1;

            if(i==0 || i==n)
            {coef = 1;}
            else {
                coef = (coef * (n-i))/(i+1);
            }

            res = res +nums[i]* coef ;


        }
        return (int)res%10;

    }
}
