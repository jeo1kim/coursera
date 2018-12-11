import java.io.File;
import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Integer[] array = new Integer[] { 5,4,1,6,7,2,3};

        File directory = new File(args[0]);
        File[] files = directory.listFiles();

//        Shuffle.sort(array);
//        Merge.sort(array);
        MergeBu.sort(array);
        for (int i = 0; i < array.length; i++) {
            StdOut.println(array[i]);
        }
    }
}
