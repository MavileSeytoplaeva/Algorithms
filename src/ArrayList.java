import exceptions.IndexNotNullException;
import exceptions.StringNorFoundException;

import java.util.Arrays;

public class ArrayList implements StringList{
    private int size;
    private String[] stringArray;

    public ArrayList() {
    }

    public ArrayList(int size) {
        this.stringArray = new String[size];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
//        for (int i = 0; i < stringArray.length; i++) {
//            if (stringArray[i] == null) {
//                stringArray[i] = item;
//                return item + i + Arrays.toString(stringArray);
//            }
//        }
        stringArray[size++] = item;
        return item;
//        throw new IndexOutOfBoundsException();
    }

    @Override
    public String add(int index, String item) {
        if (index == size) {
            stringArray[size++] = item;
            return item;
        }
        System.arraycopy(stringArray, index, stringArray, index+1, size-index);
        stringArray[index] = item;
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
        return "";
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        stringArray[index] = item;
        return item + Arrays.toString(stringArray);
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);

        if (index == -1) {
            throw new NullPointerException();
        }

        System.arraycopy(stringArray, index+1, stringArray, index,size-index);
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

        System.arraycopy(stringArray, index+1, stringArray, index,size-index);
        size--;
        return stringArray[index];
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
        if (item == null) {
            throw new NullPointerException();
        }
        for (String s : stringArray) {
            if (s.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = stringArray.length-1; i > 0; i--) {
            if (stringArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > stringArray.length) {
            throw new IndexOutOfBoundsException();
        }
        return stringArray[index];
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
        return Arrays.copyOf(stringArray, size);
    }
}
