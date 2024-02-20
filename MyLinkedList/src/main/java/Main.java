public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList<>();

        myLinkedList.add("김");
        myLinkedList.add("이");
        myLinkedList.add("박");
        myLinkedList.add("최");

        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(3));

        myLinkedList.delete(2);

        for (Object item: myLinkedList) {
            System.out.println(item);
        }

        MyQueue<String> queue = new MyQueue<>();

        queue.enqueue("김");
        queue.enqueue("나");
        queue.enqueue("박");
        queue.enqueue("이");

        String  item = queue.dequeue();
        System.out.println("item = " + item);

        String peekItem = queue.peek();
        System.out.println("peekItem = " + peekItem);

    }
}
