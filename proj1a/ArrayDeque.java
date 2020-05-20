public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst = 4;      // Next position of place addFirst
    private int nextLast = 5;       // Next position to place addLast

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
    }

    private void resize(int capacity) {
        T[] newArray= (T []) new Object[capacity];
        int start = plusOne(nextFirst);
        int end = minusOne(nextLast);

        if (start < end) {
            System.arraycopy(items, start, newArray, start, size);
        } else {
            int lengthSecondHalf = items.length - start;
            System.arraycopy(items, 0, newArray, 0, end + 1);   // Copy the first half
            System.arraycopy(items, start, newArray, capacity - lengthSecondHalf, lengthSecondHalf);
        }

        items = newArray;
    }

    private void capacityCheck() {
        if (size == items.length - 2) {
            resize(items.length * 2);
        }
    }

    private void efficiencyCheck() {
        if (size < items.length / 4) {
            resize(items.length / 2);
        }
    }

    private int minusOne(int i) {
        i--;
        if (i < 0) {
            i = items.length - 1;
        }
        return i;
    }

    private int plusOne(int i) {
        i++;
        if (i == items.length) {
            i = 0;
        }
        return i;
    }

    public void addFirst(T item) {
        capacityCheck();
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        capacityCheck();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int start = plusOne(nextFirst);
        while (start != nextLast) {
            System.out.print(items[start] + " ");
            start = plusOne(start);
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        efficiencyCheck();
        int fP = plusOne(nextFirst);
        T first = items[fP];
        items[fP] = null;
        size = size - 1;
        nextFirst = fP;
        return first;
    }

    public T removeLast() {
        if (isEmpty()) return null;
        nextLast = minusOne(nextLast);
        T temp = items[nextLast];
        items[nextLast] = null;
        size--;
        efficiencyCheck();
        return temp;
    }

    public T get(int index) {
        if (!isExist(index)) {
            return null;
        }
        if (nextFirst < nextLast) {
            return items[nextFirst + index];
        } else {
            return items[nextFirst + index - items.length];
        }
    }

    private boolean isExist(int i) {
        if (i < size) {
            return true;
        }
        return  false;
    }
}
