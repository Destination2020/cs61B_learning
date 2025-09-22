import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private Node sentinel;
    private int size = 0;

    private class Node {

        private T data;
        private Node next;
        private Node prev;

        private Node(T data) {
            this.data = data;
        }
    }

    public LinkedListDeque61B() {
        this.sentinel = new Node(null);
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x);
        Node oldFirst = this.sentinel.next;

        //renew nodes near newly inserted node
        newNode.prev = this.sentinel;
        newNode.next = oldFirst;
        oldFirst.prev = newNode;
        this.sentinel.next = newNode;

        //renew the length of deque
        size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x);
        Node oldLast = this.sentinel.prev;

        //renew nodes near newly inserted node
        newNode.prev = oldLast;
        newNode.next = this.sentinel;
        this.sentinel.prev = newNode;
        oldLast.next = newNode;

        size++;
    }

    @Override
    public List<T> toList() {
        List<T> newList = new ArrayList<>();
        for (Node current = this.sentinel.next; current != this.sentinel; current = current.next) {
            newList.add(current.data);
        }
        return newList;
    }

    @Override
    public boolean isEmpty() {
        if (this.sentinel.next == this.sentinel) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
    @Override
    public T removeFirst() {
        if (this.sentinel.next == this.sentinel) {
            return null;
        } else {
            Node first = this.sentinel.next;
            Node newFirst = first.next;
            this.sentinel.next = first.next;
            newFirst.prev = this.sentinel;

            size--;

            return first.data;
        }
    }

    @Override
    public T removeLast() {
        if (this.sentinel.prev == this.sentinel) {
            return null;
        } else {
            Node last = this.sentinel.prev;
            Node newLast = last.prev;
            last.prev.next = last.next;
            last.next.prev = newLast;

            size--;

            return last.data;
        }
    }

    @Override
    public T get(int index) {
        if (index <= 0 || index > size) {
            return null;
        } else {
            Node current = this.sentinel;
            while(index > 0) {
                current = current.next;
                index--;
            }

            return current.data;
        }
    }

    @Override
    public T getRecursive(int index) {
        if (index <= 0 || index > size) {
            return null;
        }
        return recursiveData(this.sentinel, index);
    }

    private T recursiveData(Node current, int index) {
        if (index == 0) {
            return current.data;
        }
        return recursiveData(current.next, index - 1);
    }
}


