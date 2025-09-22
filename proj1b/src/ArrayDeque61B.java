import java.util.ArrayList;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private T[] deque;
    private int size;
    private int head;
    private int tail;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 8;

    public ArrayDeque61B() {
        deque =  (T[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    private void resize(int capacityNew) {
        T[] newDeque =  (T[]) new Object[capacityNew];
        int sequence = head;
        for (int i = 0; i < this.size; i++) {
            newDeque[i] = deque[sequence];
            sequence = (sequence + 1) % capacity;
        }
        deque = newDeque;
        capacity = capacityNew;
        head = 0;
        tail = size;
    }


    @Override
    public void addFirst(T x) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        head = (head - 1 + deque.length) %  deque.length;
        deque[head] = x;
        size++;
    }

    @Override
    public void addLast(T x) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        deque[this.tail] = x;
        this.tail = (this.tail + 1) % capacity;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        int sequence = head;
        for (int i = 0; i < size; i++){
            list.add(deque[sequence]);
            sequence = (sequence + 1) % capacity;
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size != 0) {
            T item = deque[head];
            deque[head] = null;
            head = (head + 1) % capacity;
            size--;
            if (size < capacity / 2 && capacity > DEFAULT_CAPACITY) {
                resize(capacity / 2);
            }
            return item;
        } else {
            return null;
        }
    }

    @Override
    public T removeLast() {
        if (size != 0) {
            tail = (tail - 1 + capacity) % capacity;
            T item = deque[tail];
            deque[tail] = null;
            size--;
            if (size < capacity / 2 && capacity > DEFAULT_CAPACITY) {
                resize(capacity / 2);
            }
            return item;
        } else {
            return null;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            return deque[(head + index) % capacity];
        }
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            return recurisive(head, index);
        }
    }
    private T recurisive(int temporary, int index) {
        if (index == 0) {
            return deque[temporary];
        } else {
            return recurisive((temporary + 1) % deque.length, index - 1);
        }
    }
}
