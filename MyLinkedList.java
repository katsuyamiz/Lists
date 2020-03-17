package collections.list;

// Doubly-Linked list
public class MyLinkedList<E> {
    private int size;
    private Node head, tail;

    private static class Node<E> {
        E data;
        Node next;
        Node prev;
        Node(E data/** Node next, Node prev*/) {
            this.data = data;
            //this.next = next;
           // this.prev = prev;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(E data) {
        // TODO
        return false;
    }

    public void add(E data) {
        // TODO
        Node temp = new Node(data);
        if (head == null){
            head = temp;
            tail = head;
        }else{
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }

    public void add(int i, E data) {
        // TODO
        Node<E> temp = new Node<E>(data);
        if (i < 0 || i > size)
            throw  new IllegalArgumentException();
        else if (i == size){
            add(data);
        }else{
            Node current = head;
            for (int j = 0; j < i; j ++ ){
                current = current.next;
            }
            Node previous = current.prev;
            previous.next = temp;
            temp.prev = previous;
            temp.next = current;
        }



    }

    public E remove(int i) {
        // TODO
        if (i < 0 || i>= size){
            throw new IndexOutOfBoundsException();
        }else if (i == 0){
            head = head.next;
            head.prev = null;
            size++;
        }else if(i == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size++;
        }else{
                Node current = head;
                for (int j =0; j < i; j++){
                    current = current.next;
                }
                Node previous = current.prev;
                Node next = current.next;
                previous.next = current.next;
                next.prev = previous;
                size++;
            }
        return null;
    }

    public E get(int i) {
        // TODO
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }else{
            Node current = head;
            for (int j = 0; j < i; j++){
                current = current.next;
            }
             return (E) current.data;   
            }

    }

    public E set(int i, E newData) {
        // TODO
        // should return the previous data
        return null;
    }

    @Override
    public String toString() {
        // TODO
        // ex) "Obj0"=="Obj1"==null
        return super.toString();
    }
}
