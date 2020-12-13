package ua.kpi.tef.pt.lect05.linkedlist;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}. In order to keep track on nodes, {@link LinkedList} keeps a reference to a head node.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {

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
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> List<T> of(T... elements) {
        LinkedList<T> tempList = new LinkedList<>();
        for (T element: elements ) {
            tempList.add(element);
        }
        return tempList;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param element element to add
     */
    @Override
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
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if(index == 0 && size == 0) {
            add(element);
        } else if (index == 0) {
            Node<T> tempNode = getNode(0);
            firstNode = new Node<>();
            firstNode.setValue(element);
            firstNode.setNext(tempNode);
            size++;
        } else {
            Node<T> tempNode = getNode(index - 1);
            Node<T> tempNextNode = tempNode.getNext();
            tempNode.setNext(new Node<>());
            tempNode = tempNode.getNext();
            tempNode.setValue(element);
            tempNode.setNext(tempNextNode);
            size++;
        }
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        getNode(index).setValue(element);
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        return getNode(index).getValue();
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {
        if(index == 0) {
            Node<T> tempNode = getNode(0);
            firstNode = tempNode.getNext();
        } else if(index == size) {
            Node<T> tempPrevNode = getNode(index - 1);
            tempPrevNode.setNext(null);
        } else {
            Node<T> tempPrevNode = getNode(index - 1);
            Node<T> tempNextNode = tempPrevNode.getNext().getNext();
            tempPrevNode.setNext(tempNextNode);
        }
        size--;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if(get(i) == element)
                return true;
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        while(size > 0) {
            remove(size);
        }
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
