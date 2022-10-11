public class MinSwaps {
    public int minSwaps(String s) {
        char[] stringChar = s.toCharArray();

        int[] nrValues = new int[2];

        for(int i= 1; i<stringChar.length; i++){
            if(stringChar[i] == stringChar[i-1]){
                stringChar[i] = (char)(1-(stringChar[i]-'0')+'0');
                nrValues[stringChar[i]-'0']++;
            }
        }

        if(nrValues[0]!=nrValues[1])
        {
            return -1;
        }
        else
        {
            return nrValues[0];
        }

    }
}
