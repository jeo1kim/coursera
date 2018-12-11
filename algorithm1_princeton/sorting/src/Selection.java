import java.io.File;

public class Selection implements Comparable<File>{


    File file;

    public Selection(File file) {
        this.file = file;
    }

    @Override
    public int compareTo(File o) {
        if (this.file.length() < o.length()) return -1;
        return 0;
    }


    public static void sort(Comparable[] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int min = i;
            for(int j = i+1; j < n; j++) {
                if(less(a[j], a[min])) min = j;

            }
            swap(a, i, min);
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
