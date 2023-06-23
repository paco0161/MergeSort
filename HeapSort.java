public class HeapSort {

    private static void sort(Comparable[] a) {
        int N = a.length;

        // construct max heap
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }

        // relocate the maximum
        while (N > 1) {
            swap(a, 1, N--);
            sink(a, 1, N);
        }

    }

    private static void sink(Comparable[] a, int k, int length) {
        while (2 * k <= length) {
            int j = 2 * k;
            if (j < length && less(a, j, j + 1)) j++;

            if (less(a, k, j)) swap(a, k, j);

            k = j;
        }
    }

    private static void swap(Comparable[] a, int x, int y) {
        Comparable temp = a[x - 1];
        a[x - 1] = a[y - 1];
        a[y - 1] = temp;
    }

    private static boolean less(Comparable[] a, int x, int y) {
        return a[x - 1].compareTo(a[y - 1]) < 0;
    }

    public static void main(String[] args) {
        String[] example = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(example);

        for (String s : example) {
            System.out.print(s + " ");
        }
    }
}
