import java.io.File;
import edu.princeton.cs.algs4.StdRandom;

public class Shuffle implements Comparable<File> {
    File file;

    public Shuffle(File file) {
        this.file = file;
    }

    @Override
    public int compareTo(File o) {
        if (this.file.length() < o.length()) return -1;
        return 0;
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static void sort(Comparable[] a) {

        int n = a.length;

        for(int i = 0; i < n; i++) {
            int ran = StdRandom.uniform(i+1);
            swap(a, i, ran);
        }
    }
}
