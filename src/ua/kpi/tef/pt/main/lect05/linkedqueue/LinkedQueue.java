package ua.kpi.tef.pt.main.lect05.linkedqueue;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 *
 * @param <T> a generic parameter
 */
public class LinkedQueue<T> implements Queue<T> {

    private Node<T> firstNode;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> next) {
            this.next = next;
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
    }


    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        if(size == 0) {
            firstNode = new Node<>();
            firstNode.setValue(element);
        } else {
            Node<T> tempNode = getNode(size - 1);
            tempNode.setNext(new Node<>());
            tempNode = tempNode.getNext();
            tempNode.setValue(element);
        }
        size++;
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        T result;
        try {
            result = getNode(0).getValue();
            if (size == 1) {
                firstNode = null;
            } else {
                Node<T> tempNode = getNode(0);
                firstNode = tempNode.getNext();
            }
            size--;
        } catch (IndexOutOfBoundsException e) {
            result = null;
        }
        return result;
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    private Node<T> getNode(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> tempNode = firstNode;
        for (int i = 0; i < index; i++){
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }
}
