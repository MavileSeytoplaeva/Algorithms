import java.util.*;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayListIntegers arrayListIntegers = new ArrayListIntegers();
        long start = System.currentTimeMillis();
        binarySort(generateArray());
        System.out.println(System.currentTimeMillis() - start);

    }

    public static Integer[] generateArray() {
        Integer[] integerArray = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            integerArray[i] = random.nextInt(1, 10);
        }
        return integerArray;
    }

    public static Integer[] arraySort(Integer[] integers) {;
        Arrays.sort(integers);
        return integers;
    }

    public static Object[] collectionSort(Integer[] integers) {
        Integer[] generated2 = Arrays.copyOf(integers, integers.length);
        List<Integer> list = new ArrayList<>(List.of(generated2));
        Collections.sort(list);
        return list.toArray();
    }
    public static Integer[] binarySort(Integer[] integers) {
        binarySort(integers);
        return integers;
    }

}