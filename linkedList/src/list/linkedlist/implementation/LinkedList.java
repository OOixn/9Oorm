package list.linkedlist.implementation;

import java.util.ListIterator;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    private class Node{
        private Object data;
        private Node next;
        public Node(Object input){
            this.data = input;
            this.next = null;
        }
        // 디버깅이나 테스트 용도로 데이터 값이 무엇인지 알기 위해
        public String toString(){
            return String.valueOf(this.data);
        }
    }
    public void addFirst(Object input){
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if(head.next == null){
            tail =  head;
        }
    }
    public void addLast(Object input){
        Node newNode = new Node(input);
        // tail을 사용하기 위해, size 가 0일 경우 data가 없으므로 tail을 사용할 수 없게 된다.
        if (size == 0){
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    // 인덱스의 위치의 값을 가져오는 방법
    Node node(int index) {
        Node x = head;
        for(int i = 0; i < index; i ++){
            x = x.next;
        }
        return x;
    }
    // 특정한 위치에 값을 넣는 방법 인텍스1에 15를 넣고 싶을때 add(1, 15); 기존에 1번에 있던 친구는 2번으로 밀려난다.
    public void add(int k, Object input){
        if (k == 0){
            addFirst(input);
        } else {
            Node temp1 = node(k-1);
            Node temp2 = temp1.next;
            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            if(newNode.next == null){
                tail = newNode;
            }
        }
    }

    // 모든 값을 문자로 출력해주기 위함.
    public String toString(){
        if(head == null){
            return "[]";
        } else {
          Node temp = head;
          String str = "[";

          while (temp.next != null){
              str += temp.data + ", ";
              temp = temp.next;
          }
          str += temp.data;
          return str + "]";
        }
    }

    public Object removeFirst() {
        Node temp = head;
        head = head.next;
        Object returnData = temp.data;
        temp = null;
        size --;
        return returnData ;
    }

    public Object remove(int k){
        if(k == 0){
            return removeFirst();
        }
        Node temp = node(k-1);
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;
        Object returnData = todoDeleted.data;
        if(todoDeleted == tail){
            tail = temp;
            }
        todoDeleted = null;
        size--;
        return returnData;
    }

    public Object removeLast(){
        return remove(size -1);
    }

    public int size(){
        return size;
    }

    public Object get(int k){
        Node temp = node(k);
        return temp.data;
    }

    public int indexOf(Object data){
        Node temp = head;
        int index = 0;
        while(temp.data != data){
            temp = temp.next;
            index++;
            if(temp == null){
                return -1;
            }
        }
        return index;
    }

    public ListIterator listIterator(){
        return new ListIterator();
    }

    public class ListIterator{
        private Node next;
        private Node lastReturned;
        private int nextIndex;

        ListIterator(){
            next = head;
        }
        public Object next (){
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }
        public boolean hasNext(){
            return nextIndex < size();
        }

        public void add(Object input){
            Node newNode = new Node(input);

            if(lastReturned == null){
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }

            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove(){
            if(nextIndex == 0){
                throw new IllegalStateException();
            }
            LinkedList.this.remove(nextIndex-1);
            nextIndex--;
        }
    }
}
