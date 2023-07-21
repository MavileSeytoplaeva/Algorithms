import exceptions.IndexNotNullException;
import exceptions.StringNorFoundException;

import java.util.Arrays;

public class ArrayList implements StringList{
    private int size;
    private String[] stringArray;

    public ArrayList() {
    }

    public ArrayList(int size) {
        this.size = size;
        this.stringArray = new String[size];
    }

    @Override
    public String add(String item) {
        int numSize = 0;
        if (item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == null) {
                numSize++;
                stringArray[i] = item;
                return item + i + Arrays.toString(stringArray);
            }
//            if (numSize == stringArray.length-1) {
//                String[] newArrayString = Arrays.copyOf(stringArray, stringArray.length + 5);
//          }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (index > stringArray.length) {
            throw new IndexOutOfBoundsException();
        }
        if (stringArray[index] == null) {
            stringArray[index] = item;
            return item + Arrays.toString(stringArray);
        } else {
            for (int i = index; i < stringArray.length-1; i++) {
                stringArray[i + 1] = stringArray[i];
            }
            stringArray[index] = item;
            return stringArray[index] + Arrays.toString(stringArray);
        }

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
        if (item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < stringArray.length-1; i++) {
            if (stringArray[i].equals(item)) {
                stringArray[stringArray.length-1] = null;
                stringArray[i] = stringArray[i+1];
                return Arrays.toString(stringArray);
            }
        }
        throw new StringNorFoundException();
    }

    @Override
    public String remove(int index) {
        for (int i = 0; i <= stringArray.length; i++) {
            if (i == index) {
                stringArray[i] = stringArray[i+1];
                stringArray[stringArray.length-1] = null;
                return Arrays.toString(stringArray);
            }
        }
        throw new StringNorFoundException();
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
        for (int i = 0; i < stringArray.length; i++) {
            if (i == index) {
                return stringArray[i];
            }
        }
        return "";
    }

    @Override
    public boolean equals(StringList otherList) {
        return stringArray.equals(otherList);
    }

    @Override
    public int size() {
        return stringArray.length;
    }

    @Override
    public boolean isEmpty() {
        return stringArray.length == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(stringArray, null);
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringArray, stringArray.length);
    }
}
