import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class DequeTest {
    @Test
    public void testAddRemove() {
        // empty deque
        Deque<String> deque = new Deque<String>();
        Assert.assertEquals(deque.size(), 0);

        // add one item to front
        deque.addFirst("first");
        Assert.assertEquals(deque.size(), 1);

        deque.addFirst("two");
        Assert.assertEquals(deque.size(), 2);

        deque.addLast("back1");
        Assert.assertEquals(deque.size(), 3);

        deque.addLast("back2");
        Assert.assertEquals(deque.size(), 4);

        deque.addLast("back3");
        Assert.assertEquals(deque.size(), 5);


        Assert.assertEquals(deque.removeFirst(), "two");
        Assert.assertEquals(deque.size(), 4);

        Assert.assertEquals(deque.removeFirst(), "first");
        Assert.assertEquals(deque.size(), 3);

        Assert.assertEquals(deque.removeLast(), "back3");
        Assert.assertEquals(deque.size(), 2);

        Assert.assertEquals(deque.removeLast(), "back2");
        Assert.assertEquals(deque.size(), 1);

        Assert.assertEquals(deque.removeLast(), "back1");
        Assert.assertEquals(deque.size(), 0);
    }

    @Test
    public void testIssize() {

        Deque<String> deque = new Deque<String>();
        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void testIterator() {

        Deque<Integer> deque = new Deque<Integer>();

        Iterator<Integer> iter = deque.iterator();

        Assert.assertEquals(iter.hasNext(), false);

        deque.addFirst(1);
//        deque.addFirst(1);
        deque.removeLast();
//        deque.removeLast();

        iter = deque.iterator();
//        StdOut.println(iter.next());
        Assert.assertEquals(iter.hasNext(), false);



    }

    @Test
    public void testAddLast() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);

        deque.removeLast();
        Assert.assertEquals(deque.size(), 1);

        Iterator<Integer> iter = deque.iterator();
        int k = 0;
        while(iter.hasNext()) {
            StdOut.println(iter.next());
            k++;
        }
        Assert.assertEquals(deque.size(), 1);
        Assert.assertEquals(k, 1);

    }

    @Test
    public void twoIterator() {


    }

    @Test
    public void iterator() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.addLast(6);
        deque.addFirst(7);


        StdOut.println("removing last" +deque.removeLast());

        Iterator<Integer> iter = deque.iterator();
        int k = 0;
        while(iter.hasNext()) {
            StdOut.println(iter.next());
            k++;
        }
        Assert.assertEquals(deque.size(), 6);
        Assert.assertEquals(k, 6);
        deque.addFirst(7);
        deque.removeLast();

        int i = 0;

        iter = deque.iterator();
        while(iter.hasNext()) {
            iter.next();
            i++;
        }
        Assert.assertEquals(deque.size(), 6);
        Assert.assertEquals(i, 6);

    }

}
