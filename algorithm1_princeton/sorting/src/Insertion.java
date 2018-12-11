import java.io.File;

public class Insertion implements Comparable<File> {

    File file;

    public Insertion(File file) {
        this.file = file;
    }

    @Override
    public int compareTo(File o) {
        if (this.file.length()  < o.length()) return -1;
        return 0;
    }

    public static void sort(Comparable[] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                   swap(j, j-1, a );
                } else break;
            }
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        int n = a.length;

        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo; j--) {
                if (less(a[j], a[j-1])) {
                    swap(j, j-1, a );
                } else break;
            }
        }
    }

    public static void swap(int i, int j, Comparable[] a) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }
}


