package algorithms;

@SuppressWarnings("unchecked")
public class ResizingArray<T> {
    private T[] array;
    private int size;
    private int frontIdx;
    private int lastIdx;

    public ResizingArray(int size) {
        array = (T[]) new Object[size];
    }

    public void add(T item) {
        if (size == array.length) {
            array = (T[]) resize(array, size * 2);
        }
        size++;
        array[lastIdx++] = item;
    }

    public T removeFront() {
        if (size == 0) {
            return null;
        }
        if (size == array.length / 4) {
            array = (T[]) resize(array, array.length / 2);
        }
        size--;
        T item = array[frontIdx];
        array[frontIdx] = null;
        frontIdx++;
        return item;
    }

    public T removeBack() {
        if (size == 0) {
            return null;
        }
        if (size == array.length / 4) {
            array = (T[]) resize(array, array.length / 2);
        }
        size--;
        T item = array[lastIdx - 1];
        array[lastIdx - 1] = null;
        lastIdx--;
        return item;
    }

    private T[] resize(T[] a, int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        int j = 0;
        for (int i = frontIdx; i < lastIdx; i++) {
            newArray[j++] = a[i];
        }
        lastIdx = lastIdx - frontIdx;
        frontIdx = 0;
        return newArray;
    }
}
