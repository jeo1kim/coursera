import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Permutation {

    public static void main(String[] args) {

        int k = Integer.parseInt(args[0]);


        RandomizedQueue<String> randQ = new RandomizedQueue<String>();

        while(!StdIn.isEmpty()) {
            String a = StdIn.readString();
            randQ.enqueue(a);

        }

        Iterator<String> iter = randQ.iterator();
        while(iter.hasNext() && k > 0) {
            StdOut.println(iter.next());
            k--;
        }



    }
}
