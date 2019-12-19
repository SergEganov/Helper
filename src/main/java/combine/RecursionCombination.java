package combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.baeldung.com/java-combinations-algorithm

public class RecursionCombination {
    public static void main(String[] args) {
        RecursionCombination generator = new RecursionCombination();
        //n - количество элементов, r - длина комбинации
        List<int[]> combinations = generator.generate(10, 4);
        for (int[] combination : combinations) {
            System.out.println(Arrays.toString(combination));
        }
        System.out.printf("generated %d combinations of %d items from %d ", combinations.size(),10, 4);

    }


    private void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        /*Когда количество элементов в наборе велико, скажем, больше,
        чем максимальная глубина стека вызовов,
        мы переполняем стек и получаем StackOverflowError.
        */
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }
    private void helper2(List<int[]> combinations, int data[], int start, int end, int index) {
        /*
        Таким образом, этот подход может работать для больших входных данных до тех пор,
        пока количество выбираемых элементов меньше максимальной глубины стека вызовов.
         */
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else {
            int max = Math.min(end, end + 1 - data.length + index);
            for (int i = start; i <= max; i++) {
                data[index] = i;
                helper(combinations, data, i + 1, end, index + 1);
            }
        }
    }

    public List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1, 0);
        return combinations;
    }
}
