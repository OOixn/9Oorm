package list.linkedlist.implementation;

public class Main {
    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addFirst(30);
        numbers.addFirst(20);
        numbers.addFirst(10);
        numbers.addLast(400);
        numbers.add(1,15);
        numbers.removeFirst();
        System.out.println(numbers);
    }
}
