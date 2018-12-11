import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size, tail;
    private Node<Item>[] array = (Node<Item>[]) new Node[1];

    private class Node<Item> {
        Item item;
        Node(Item item) {
            this.item = item;
        }
    }

    public RandomizedQueue()                 // construct an empty randomized queue
    {
        size = 0;
        tail = 0;
    }
    public boolean isEmpty()                 // is the randomized queue empty?
    {
        return size == 0;
    }
    public int size()                        // return the number of items on the randomized queue
    {
        return size;
    }
    public void enqueue(Item item)           // add the item
    {
        if (item == null) throw new IllegalArgumentException();
        // array is full double the size
        if (size == array.length ) addCapacity(array.length * 2 + 1);
        array[size] = new Node(item);
        tail = size++;
    }

    private void addCapacity(int cap) {
        Node<Item>[] newArray = (Node<Item>[]) new Node[cap];
        int index = 0;
        for (int i = 0; i < size; i ++) {
            // this check for decreasing size with non consecutive elements.
            newArray[index++] = array[i];
        }
        array = newArray;
    }
    public Item dequeue()                    // remove and return a random item
    {
        if (isEmpty()) throw new NoSuchElementException();
        if (size > 0 && size < array.length/4) addCapacity(array.length/2 -1);
        // if sampled return the sample
        int ran = StdRandom.uniform(size);
        // save the items in the random index position
        Item item;
        item = array[ran].item;
        // replace the tail item with random index item
        array[ran] = array[tail];
        array[tail] = null;

        tail--;
        size--;
        return item;
    }
    public Item sample()                     // return a random item (but do not remove it)
    {
        if (isEmpty()) throw new NoSuchElementException();
        // weve already called sample, show the same item;
        //if (sample != -1) return array[sample].item;
        // pick new sample
        int ran = StdRandom.uniform(size);
        Item item = array[ran].item;
        return item;
    }
    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
        return new RandomQueueIter();
    }

    private class RandomQueueIter implements Iterator<Item> {

        private Node<Item>[] iterable;
        private int size = size();

        public  RandomQueueIter() {
            iterable = (Node<Item>[]) new Node[size];
            for(int i = 0; i < size; i++){
                iterable[i] = array[i];
            }
        }

        @Override
        public Item next() {
            if (size == 0) throw new NoSuchElementException();

            int ran = StdRandom.uniform(this.size);
            Item item = this.iterable[ran].item;
            Node temp = this.iterable[this.size-1];
            this.iterable[this.size-1]  = this.iterable[ran];
            this.iterable[ran] = temp;
            this.size--;

            return item;
        }

        @Override
        public boolean hasNext() {
            return  this.size != 0;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public static void main(String[] args)   // unit testing (optional)
    {}
}
