package homeTask1;

import java.util.Arrays;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private static class Entry {
        int value;
        Entry previous;
        Entry next;

        public Entry(int value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Entry first = null;
    private Entry last = null;

    //IntList methods
    @Override
    public boolean add(int index, int element) {
        Entry newEntry = new Entry(element);
        Entry tmp = first;
        if (index == 0) {
            first.previous = newEntry;
            newEntry.next = first;
            first = newEntry;
            size++;
        } else if (index == size - 1) {
            last.next = newEntry;
            newEntry.previous = last;
            last = newEntry;
            size++;
        } else {
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            newEntry.next = tmp;
            newEntry.previous = tmp.previous;
            tmp.previous.next = newEntry;
            tmp.previous = newEntry;
            size++;
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public int get(int index) {
        Entry tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void checkIndex(int index){
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        Entry tmp = first;
        if (index == 0) {
            first = first.next;
            first.previous = null;
        } else if (index == size - 1) {
            last = last.previous;
            last.next = null;
        } else {
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            tmp.previous.next = tmp.next;
            tmp.next.previous = tmp.previous;
        }
        size--;
        return false;
    }

    @Override
    public boolean removeByValue(int value) {
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            if (tmp.value == value) {
                remove(i);
                i--;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public boolean set(int index, int element) {
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                tmp.value = element;
                return false;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        Entry tmp = first;
        IntList subList = new IntLinkedList();
        for (int i = 0; i <= toIndex; i++) {
            if (i >= fromIndex) {
                subList.add(tmp.value);
            }
            tmp = tmp.next;
        }
        return subList;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];

        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            result[i] = tmp.value;
            tmp = tmp.next;
        }
        return result;
    }

    public String toString() {
        return Arrays.toString(toArray());
    }
    //IntQueue methods
    @Override
    public void add(int element) {
        Entry newEntry = new Entry(element);
        if (size == 0) {
            first = newEntry;
            last = newEntry;
        } else {
            last.next = newEntry;
            newEntry.previous = last;
            last = newEntry;
        }
        size++;
    }

    @Override
    public int remove() {
        Entry tmp = first;
        first = first.next;
        size--;
        return tmp.value;
    }

    @Override
    public int element() {
        return first.value;
    }

    //IntStack methods
    @Override
    public boolean push(int value) {
        add(0, value);
        return false;
    }

    private Entry getEntry(int index){
        Entry tmp = first;
        for(int i = 0; i < size; i++){
            tmp = tmp.next;
        }
        return tmp;
    }
    @Override
    public int pop() {
        Entry tmp = getEntry(0);
        int element = tmp.value;
        remove(0);
        return element;
    }

    // @Override
    public int peek() {
        return first.value;
    }
}
