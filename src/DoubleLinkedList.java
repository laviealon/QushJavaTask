/**
 * Represents a doubly linked list of integers.
 *
 * @author Alon Lavie, copyright (c) 2022
 */
public class DoubleLinkedList {
    private Node first, last;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
    }

    public DoubleLinkedList(int i) {
        this.first = new Node(i);
        this.last = this.first;
    }

    /**
     * @return the first node in this list
     */
    public int getFirstInt() {
        return first.val;
    }

    /**
     * @return the last node in this list
     */
    public int getLastInt() {
        return last.val;
    }

    /**
     * Adds an integer to the front (the beginning) of the dll.
     *
     * @param i: the integer to be added
     */
    public void pushFront(int i) {
        Node newNode = new Node(i);
        if (this.isEmpty()) {
            this.last = newNode;
        } else {
            newNode.next = this.first;
            this.first.prev = newNode;
        }
        this.first = newNode;
    }

    /**
     * Adds an integer to the back (the end) of the dll.
     *
     * @param i: the integer to be added
     */
    public void pushBack(int i) {
        Node newNode = new Node(i);
        if (this.isEmpty()) {
            this.first = newNode;
        } else {
            newNode.prev = this.last;
            this.last.next = newNode;
        }
        this.last = newNode;
    }

    /**
     * Delete <del> from this dll. If <del> is not in this dll, do nothing.
     *
     * @param del: the node to be deleted.
     */
    public void deleteNode(Node del) {
        if (this.isEmpty()) {
            return;
        }

        if (this.first == del) {
             this.first = del.next;
        }

        if (del.next != null) {
            del.next.prev = del.prev;
        }

        if (del.prev != null) {
            del.prev.next = del.next;
        }
    }

    /**
     * @return True if empty, False if not.
     */
    private Boolean isEmpty() {
        return this.first == null;
    }


    /**
     * Represents a node in a doubly linked list.
     */
    public static class Node {
        private final int val;
        private Node prev, next;

        public Node(int i) {
            this.val = i;
            this.next = null;
            this.prev = null;
        }
    }

}


