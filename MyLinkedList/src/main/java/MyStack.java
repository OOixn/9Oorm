public class MyStack<T> {

    public MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop(T item){

        if(list.isEmpty()){
            throw new IllegalStateException("stack이 비었다!!");
        }

        int lastIndex = list.size() -1;

        T top = list.get(lastIndex);
        list.delete(lastIndex);

        return top ;
    }

    public T peek() {

        if(list.isEmpty()){
            throw new IllegalStateException("stack이 비었다!!");
        }

        int lastIndex = list.size() -1;
        T top = list.get(lastIndex);

        return top;
    }
}
