import java.util.Arrays;

public class MinimumNrOfKeyPResses {
    public int minimumKeypresses(String s) {
        int[] frequence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequence[s.charAt(i) - 'a']++;
        }

        Arrays.sort(frequence);

        int sum = 0, k = 1, l=0;


        for (int i = frequence.length - 1; i >= 0; i--) {
            if (frequence[i] == 0)
                break;

            sum = sum + frequence[i] * k;
            l++;
            if (l % 9  == 0 && i != 0)
                k++;
        }
        return sum;

    }
}
