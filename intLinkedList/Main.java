package homeTask1;

public class Main {
    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(2);

        System.out.println(list);

        list.add(2, 25);
        System.out.println(list);

        list.set(0, 5);

        System.out.println(list.removeByValue(2));
        System.out.println(list);

        list.push(40);
        System.out.println(list);

        System.out.println(list.subList(0, 1));
        System.out.println(list);
    }
}
