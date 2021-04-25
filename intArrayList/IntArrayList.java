package homeTask1;

import java.util.Arrays;

public class IntArrayList implements IntList {
    private int[] arr = new int[10];
    private int size = 0;

    @Override
    public void add(int element) {
        //если нужно добавить больше элементов, чем размер массива, то создаём новый массив
        if (size >= arr.length) {
            int newSize = arr.length * 3 / 2 + 1;
            int[] newArr = new int[newSize];
            //переписать все элементы старого массива в новый
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size] = element;
        size++;
    }

    @Override
    //Inserts the specified element at the specified position in this list (optional operation).
    public boolean add(int index, int element) {
        int newLength = arr.length;
        if (size >= arr.length) {
            newLength = arr.length * 3 / 2 + 1;
        }
        int[] newArr = new int[newLength];
        int var;
        for (int i = 0; i < arr.length + 1; i++) {
            if (i < index) {
                newArr[i] = arr[i];
            } else if (i == index) {
                newArr[i] = element;
            } else {
                newArr[i] = arr[i - 1];
            }
        }
        arr = newArr;
        size++;
        return true;
    }

    //Removes all of the elements from this list (optional operation).
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = 0;
        }
        size = 0;
    }

    //Returns the element at the specified position in this list.
    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public boolean isEmpty() {
        if (size != 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (index >= size){
            return false;
        } else {
            int[] newArr = new int[size - 1];
            for (int i = 0, j = 0; i < size; i++) {
                if (i != index) {
                    newArr[j] = arr[i];
                    j++;
                }
            }
            arr = newArr;
            size--;
            return true;
        }
    }

    @Override
    public boolean removeByValue(int value) {
        boolean result = false;
        int count = 0;
        for(int i = 0; i < size; i++) {
            if(arr[i] == value){
                result = true;
                count ++;
            }
        }
        if(result){
            int[] newArr = new int[size-count];
            int j = 0;
            for(int i = 0; i < size && j < newArr.length; i++){
                if(arr[i] != value){
                    newArr[j] = arr[i];
                    j++;
                }
            }
            size -= count;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean set(int index, int element) {
        arr[index] = element;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    //Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList sublist = new IntArrayList();
        int newSize = size;
        for(int i = fromIndex; i < toIndex; i++) {
            sublist.add(arr[i]);
        }
        size = newSize;
        return sublist;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
