package _07WorkShop._01Lab;

import java.util.function.Consumer;

public class SmartArray {
    private int[] data;

    private static final int INITIAL_CAPACITY = 4;
    private int size;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    private int[] grow() {
        int[] newData = new int[size * 2];
        System.arraycopy(data, 0, newData, 0, size);

        return newData;
    }

    private int[] shrink() {
        int newLength = data.length / 2;

        int[] newData = new int[newLength];

        System.arraycopy(data, 0, newData, 0, size);

        return newData;
    }

    public void add(int element) {
        if(size == data.length) {
            data = grow();
        }

        data[size++] = element;

//        if(size > 0) {
//            int[] newData = new int[size + 1];
//            System.arraycopy(data, 0, newData, 0, size);
//        }
//
//        size++;
    }

    public void add(int index, int element) {
        checkIndex(index);

        data = grow();

        int lastElement = data[size - 1];
        for (int i = size - 1; i > index; i--) {
            data[i] = data[i - 1];
        }

        add(lastElement);
        data[index] = element;
    }

    public int remove(int index) {
        checkIndex(index);

        int elementToRemove = get(index);

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = 0;

        size--;

        if(size == data.length / 2) {
            data = shrink();
        }

        return elementToRemove;
    }

    public boolean contains(int element) {
        for (int e : data) {
            if(e == element) {
                return true;
            }
        }
        return false;
    }

    public int get(int index) {
        checkIndex(index);

        return data[index];
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    public int size() {
        return size;
    }

    public void forEach(Consumer<Integer> predicate) {
        for (int i = 0; i < size; i++) {
            int element = data[i];
            predicate.accept(element);
        }
    }
}
