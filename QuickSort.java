import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    private static int partition(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;

        while (i < j) {
            while (less(a[++i], a[low])) {
                if (i == high) break;
            }

            while (less(a[low], a[--j])) {
                if (j == low) break;
            }

            if (i >= j) break;
            swap(a, i, j);
        }

        swap(a, low, j);
        return j;
    }

    private static void swap(Comparable[] a, int x, int y) {
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;

        int k = partition(a, low, high);
        sort(a, low, k - 1);
        sort(a, k + 1, high);
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        String[] example = {"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(example);

        for (String c : example) {
            System.out.println(c);
        }
    }
}
