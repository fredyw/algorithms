package algorithms;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class SegmentTree<T> {
    private final T[] tree;
    private final int arrayLength;
    private final BiFunction<T, T, T> func;
    private final Supplier<T> supplier;

    public SegmentTree(T[] array, BiFunction<T, T, T> func, Supplier<T> supplier) {
        this.func = func;
        this.supplier = supplier;
        arrayLength = array.length;
        int x = (int) (Math.ceil(Math.log(array.length) / Math.log(2)));
        int maxSize = 2 * (int) Math.pow(2, x) - 1;
        tree = (T[]) new Object[maxSize];
        build(array, tree, 0, array.length - 1, 0);
    }

    // start -> start index of the array
    // end -> end index of the array
    // current -> index of the tree
    private T build(T[] array, T[] tree, int start, int end, int current) {
        if (start == end) {
            tree[current] = array[start];
            return tree[current];
        }
        int mid = (start + end) / 2;
        int left = (current * 2) + 1;
        int right = (current * 2) + 2;
        T leftResult = build(array, tree, start, mid, left);
        T rightResult = build(array, tree, mid + 1, end, right);
        tree[current] = func.apply(leftResult, rightResult);
        return tree[current];
    }

    public T execute(int start, int end) {
        return execute(start, end, tree, 0, arrayLength - 1, 0);
    }

    private T execute(int queryStart, int queryEnd, T[] tree, int start, int end, int current) {
        if (queryStart <= start && queryEnd >= end) {
            return tree[current];
        }
        if (queryEnd < start || end < queryStart) {
            return supplier.get();
        }
        int mid = (start + end) / 2;
        int left = (current * 2) + 1;
        int right = (current * 2) + 2;
        T leftResult = execute(queryStart, queryEnd, tree, start, mid, left);
        T rightResult = execute(queryStart, queryEnd, tree, mid + 1, end, right);
        return func.apply(leftResult, rightResult);
    }
}
