package combine;

import java.util.*;

public class BinaryCombination {
    public static List<Integer> generateCombination(int n) {
        String binary = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
        List<Integer> listOfIndexes = new ArrayList<>();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                listOfIndexes.add(i);
            }
        }
        return listOfIndexes;
    }
}
