import java.io.File;

public class Shell implements Comparable<File> {

    File file;

    public Shell(File file) {
        this.file = file;
    }

    @Override
    public int compareTo(File o) {
        if (this.file.length() < o.length()) return -1;
        return 0;
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;

        while(h < n/3) h = 3*h + 1;

        while(h >= 1) {
            for(int i = h; i < n; i++) {
                for(int j = i; j >= h && less(a[j], a[j-h]); j-=h) {
                    swap(a, j, j-h);
                }
            }
            h = h/3;
        }

    }
    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }


}
