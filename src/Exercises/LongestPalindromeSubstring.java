public class LongestPalindromeSubstring {
    public static void main(String[] args){
        System.out.println(longestPalindrome("babad"));

    }

    public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        int[][] matrix = new int[rev.length()][rev.length()];
        int z=0;
        String res="";
        String subStr="";

        for(int i=0;i<s.length();i++)
            for(int j=0; j<rev.length();j++){
                if(s.charAt(i) == rev.charAt(j)){
                    if(i ==0 || j==0)
                    {
                        matrix[i][j]=1;
                    }
                    else{
                        matrix[i][j]=matrix[i-1][j-1]+1;
                    }

                    if(matrix[i][j]>z){

                        subStr = s.substring(i-matrix[i][j]+1,i+1);

                        if(isPalindrome(subStr))
                        {
                            z = matrix[i][j];
                            res = subStr;

                        }
                    }
                }
                else matrix[i][j]=0;

            }
        return res;

    }

    public static boolean isPalindrome( String s){
        for(int i =0;i< s.length() /2;i++){
            if(s.charAt(i)!= s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}
