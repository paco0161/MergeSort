import edu.princeton.cs.algs4.StdRandom;

public class ThreeWayQuickSort {

    // improves QuickSort in presence of duplicated keys

    private static void swap(Comparable[] a, int x, int y) {
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;

        int lowerBound = low, upperBound = high;
        int i = low;
        Comparable v = a[low]; // need to capture a[low] as pivot

        while (i <= upperBound) { // need to check i = upperBound case
            int compare = a[i].compareTo(v);

            if (compare < 0) {
                swap(a, lowerBound++, i++);
            } else if (compare > 0) {
                swap(a, i, upperBound--);
            } else {
                i++;
            }
        }

        sort(a, low, lowerBound - 1);
        sort(a, upperBound + 1, high);
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        String[] example = {"R", "W", "B", "W", "W", "R", "A", "B", "R", "R", "W", "B", "R"};
        sort(example);

        for (String c : example) {
            System.out.print(c + " ");
        }
    }
}
