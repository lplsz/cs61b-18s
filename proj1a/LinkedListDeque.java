public class LinkedListDeque<T> {
    private int size;
    private IntNode sentinel;

    private class IntNode {
        private T item;
        private IntNode prev;
        private IntNode next;

        private IntNode(T i, IntNode p, IntNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode( null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        IntNode newNode = new IntNode(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        IntNode newNode = new IntNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode curr = sentinel.next;
        while (curr != sentinel) {
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
    }

    public T removeFirst() {
        if (this.isEmpty() == true) return null;
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return temp;
    }

    public T removeLast() {
        if (this.isEmpty() == true) return null;
        T temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return temp;
    }

    public T get(int index) {
        IntNode curr = sentinel.next;
        while (index > 0) {
            if (curr == sentinel) {
                return null;
            }
            curr = curr.next;
            index--;
        }
        return curr.item;
    }

    public T getRecursive(int index) {
        if (index == 0) {
            return sentinel.next.item;
        }
        return gethelper(index, sentinel.next);
    }

    private T gethelper(int index, IntNode p) {
        if (index == 0) {
            return p.item;
        }
        return gethelper(index - 1, p.next);
    }
}
