import java.io.File;

public class Merge implements Comparable<File>{

    File file;

    public Merge(File file) {
        this.file = file;
    }

    public Merge() {}

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

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi );

        for(int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo; int j = mid+1;

        for(int k = lo; k <= hi; k++) {

            if(i > mid)                     a[k] = aux[j++];
            else if(j > hi) a[k] =          aux[i++];
            else if(less(aux[i], aux[j]))   a[k] = aux[i++];
            else                            a[k] = aux[j++];

        }

        assert isSorted(a, lo, hi);


    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if(lo + 2 >= hi) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        if(less(a[mid], a[mid+1])) return;
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }
}
