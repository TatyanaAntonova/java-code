package homeTask1;

public class Main {

    public static void main(String[] args) {

        IntList myList = new IntArrayList();

        for (int i = 0; i < 8; i++) {
            myList.add(i);
        }
        System.out.println(myList.toString());

        myList.add(8,55);
        System.out.println(myList.toString());

        System.out.println(myList.get(2));

        myList.clear();
        System.out.println(myList.toString());

        System.out.println(myList.isEmpty());

        myList.add(5);
        myList.add(10);
        myList.add(10);
        myList.add(5);
        System.out.println(myList.toString());

        myList.set(1, 55);
        System.out.println(myList.toString());

        System.out.println("Size = " + myList.size());

        System.out.println(myList.subList(0,2).toString());

        myList.remove(2);
        System.out.println("remove method: Size = " + myList.size() + " arr = "+ myList.toString());

        myList.removeByValue(5);
        System.out.println("removeByValue method: Size = " + myList.size() + " arr = "+ myList.toString());
    }
}
