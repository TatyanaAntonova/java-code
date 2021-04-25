package homeTask1;

public interface IntQueue {
    void add(int value);

    int remove(); // return first in Queue and remove it

    int element(); // return first in Queue, but not remove it
}
