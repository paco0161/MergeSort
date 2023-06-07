import java.util.Arrays;

public class MergeSort {

    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        assert isSorted(a, low, mid);
        assert isSorted(a, mid + 1, high);

        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }

        assert isSorted(a, low, high);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);
        if (!less(a[mid + 1], a[mid])) return;
        merge(a, aux, low, mid, high);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Integer[] example = {9, 8, 1, 2, 6, 2, 6, 1, 8, 31, 7, 21};
        sort(example);
        System.out.println(Arrays.toString(example));
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static boolean isSorted(Comparable[] a, int low, int high) {
        for (int k = low + 1; k <= high; k++) {
            if (less(a[k], a[k - 1])) return false;
        }
        return true;
    }
}
