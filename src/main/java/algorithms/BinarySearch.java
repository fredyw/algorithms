package algorithms;

import java.util.List;

public class BinarySearch {
    public static <T extends Comparable<T>> int search(List<T> list, T item) {
        return recurseSearch(list, item, 0, list.size());
    }

    private static <T extends Comparable<T>> int recurseSearch(List<T> list, T item,
                                                               int lo, int hi) {
        int mi = (lo + hi) / 2;
        int idx = mi;
        if (hi <= lo) {
            return -1;
        }
        if (item.compareTo(list.get(mi)) < 0) {
            idx = recurseSearch(list, item, lo, mi);
        } else if (item.compareTo(list.get(mi)) > 0) {
            idx = recurseSearch(list, item, mi + 1, hi);
        }
        return idx;
    }
}
