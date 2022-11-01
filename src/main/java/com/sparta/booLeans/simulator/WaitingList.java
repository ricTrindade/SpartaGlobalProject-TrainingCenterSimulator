package com.sparta.booLeans.simulator;

import java.util.Queue;

public class WaitingList<E>  {

    private static WaitingList<Integer> waitingList = new WaitingList<>();

    private Node<E> head;
    private Node<E> tail;

    private WaitingList() {}

    public E poll() {
        if (head == null) {
            return null;
        }

        Node<E> oldHead = head;
        head = head.getTail();
        return oldHead.getElement();
    }

    public E peek() {
        if (head == null) {
            return null;
        }
        return head.getElement();
    }

    public void add(E... elements) {
        for (E element: elements) {
            Node<E> newTail = new Node<>(element);
            if (head == null) {
                head = newTail;
            } else {
                tail.setTail(newTail);
            }
            tail = newTail;
        }
    }

    public int getSize() {
        if (head == null) {
            return 0;
        }
        Node<E> node = head;
        int size = 0;
        while(node != null) {
            size++;
            node = node.getTail();
        }
        return size;
    }

    public static WaitingList<Integer> getWaitingList() {
        return waitingList;
    }
}
