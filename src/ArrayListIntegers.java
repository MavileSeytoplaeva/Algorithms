import java.util.*;
import java.util.ArrayList;

import static java.util.Arrays.*;

public class ArrayListIntegers implements StringList {
    private int size;
    private Integer[] integerArray;

    public ArrayListIntegers() {
    }

    public ArrayListIntegers(int size) {
        this.integerArray = new Integer[size];
    }

    private Integer[] generateArray() {
        Integer[] integerArray = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            integerArray[i] = random.nextInt(1,10);
        }
        return integerArray;
    }

    private Integer[] arraySort(Integer[] integers) {;
        Arrays.sort(integers);
        return integers;
    }

    private Object[] collectionSort(Integer[] integers) {
        Integer[] generated2 = Arrays.copyOf(integers, integers.length);
        List<Integer> list = new ArrayList<>(List.of(generated2));
        Collections.sort(list);
        return list.toArray();
    }

    private Integer[] binarySort(Integer[] integers) {
        binarySort(integers);
        return integers;
    }


    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Integer numItem = Integer.parseInt(item);
//        for (int i = 0; i < stringArray.length; i++) {
//            if (stringArray[i] == null) {
//                stringArray[i] = item;
//                return item + i + Arrays.toString(stringArray);
//            }
//        }
        integerArray[size++] = numItem;
        return item;
//        throw new IndexOutOfBoundsException();
    }

    @Override
    public String add(int index, String item) {
        Integer numItem = Integer.parseInt(item);
        if (index == size) {
            integerArray[size++] = numItem;
            return item;
        }
        System.arraycopy(integerArray, index, integerArray, index + 1, size - index);
        integerArray[index] = numItem;
        size++;
//        if (item == null) {
//            throw new NullPointerException();
//        }
//        if (index > stringArray.length) {
//            throw new IndexOutOfBoundsException();
//        }
//        if (stringArray[index] == null) {
//            stringArray[index] = item;
//            return item + Arrays.toString(stringArray);
//        } else {
//            for (int i = index; i < stringArray.length-1; i++) {
//                stringArray[i + 1] = stringArray[i];
//            }
//            stringArray[index] = item;
//            return stringArray[index] + Arrays.toString(stringArray);
//        }
        return String.valueOf(numItem);
    }

    @Override
    public String set(int index, String item) {
        Integer numItem = Integer.parseInt(item);
        integerArray[index] = numItem;
        return item + Arrays.toString(integerArray);
    }

    @Override
    public String remove(String item) {
        Integer numItem = Integer.parseInt(item);
        int index = indexOf(item);

        if (index == -1) {
            throw new NullPointerException();
        }

        System.arraycopy(integerArray, index + 1, integerArray, index, size - index);
        size--;
        return item;
//        if (item == null) {
//            throw new NullPointerException();
//        }
//        for (int i = 0; i < stringArray.length-1; i++) {
//            if (stringArray[i].equals(item)) {
//                stringArray[stringArray.length-1] = null;
//                stringArray[i] = stringArray[i+1];
//                return Arrays.toString(stringArray);
//            }
//        }
//        throw new StringNorFoundException();
    }

    @Override
    public String remove(int index) {
        if (index == -1) {
            throw new NullPointerException();
        }

        System.arraycopy(integerArray, index + 1, integerArray, index, size - index);
        size--;
        return String.valueOf(integerArray[index]);
//        return item;
//        for (int i = 0; i <= stringArray.length; i++) {
//            if (i == index) {
//                stringArray[i] = stringArray[i+1];
//                stringArray[stringArray.length-1] = null;
//                return Arrays.toString(stringArray);
//            }
//        }
//        throw new StringNorFoundException();
    }

    @Override
    public boolean contains(String item) {
        Integer numItem = Integer.parseInt(item);
        for (Integer s : integerArray) {
            if (s.equals(numItem)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        Integer numItem = Integer.parseInt(item);
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i].equals(numItem)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        Integer numItem = Integer.parseInt(item);
        for (int i = integerArray.length - 1; i > 0; i--) {
            if (integerArray[i].equals(numItem)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > integerArray.length) {
            throw new IndexOutOfBoundsException();
        }
        return String.valueOf(integerArray[index]);
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return new String[]{Arrays.toString(copyOf(integerArray, size))};
    }
}