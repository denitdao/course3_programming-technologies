package ua.kpi.tef.pt.lect05.stack;

import ua.kpi.tef.pt.lect05.stack.exception.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

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

    @Override
    public void push(T element) {
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

    @Override
    public T pop() {
        T result;
        try {
            if(size == 1) {
                result = getNode(0).getValue();
                firstNode = null;
            } else {
                result = getNode(size - 1).getValue();
                getNode(size - 2).setNext(null);
            }
            size--;
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
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
