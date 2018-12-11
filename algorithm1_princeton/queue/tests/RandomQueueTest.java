import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;


public class RandomQueueTest {

    @Test
    public void testAddRemove() {
        RandomizedQueue<Integer> randQ = new RandomizedQueue<Integer>();

        randQ.enqueue(1);
        Assert.assertEquals(randQ.size(), 1);

        randQ.enqueue(2);
        Assert.assertEquals(randQ.size(), 2);

        int i = randQ.sample();
        int d = randQ.dequeue();
        Assert.assertEquals(d, i);

        randQ.dequeue();
        Assert.assertEquals(randQ.size(), 0);

    }

    @Test
    public void testIterator() {
        RandomizedQueue<Integer> randQ = new RandomizedQueue<Integer>();

        Iterator<Integer> iter = randQ.iterator();

        Assert.assertEquals(iter.hasNext(), false);

    }

    @Test
    public void testTwoIterator() {
        RandomizedQueue<Integer> randQ = new RandomizedQueue<Integer>();

        randQ.enqueue(1);
        randQ.enqueue(2);
        randQ.enqueue(3);
        randQ.enqueue(4);

        Iterator<Integer> iter = randQ.iterator();

        while(iter.hasNext()) {
            StdOut.println("outer "+iter.next());

            Iterator<Integer> iter2 = randQ.iterator();
            while(iter2.hasNext()) {
                iter2.next();
                //StdOut.println("inner "+iter2.next());
            }
            StdOut.println("end");
        }

        Assert.assertEquals(iter.hasNext(), false);



    }

    @Test
    public void randomTest() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(26);
        rq.enqueue(16);
        rq.enqueue(43);
        rq.enqueue(40);
        rq.enqueue(5);
        rq.enqueue(28);
        rq.enqueue(47);
        rq.dequeue();
    }
}
