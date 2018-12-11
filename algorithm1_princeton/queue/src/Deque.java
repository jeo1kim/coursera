import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Throw a java.lang.IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
 * Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.
 * Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
 * Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;
        Node(Item item) {
            this.item = item;
        }
    }

    public Deque()                           // construct an empty deque
    {
        last = null;
        first = last;
        size = 0;
    }
    public boolean isEmpty()                 // is the deque empty?
    {
        return size == 0;
    }
    public int size()                        // return the number of items on the deque
    {
        return size;
    }
    public void addFirst(Item item)          // add the item to the front
    {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node node = new Node(item);
        if (first == null) {
            first = node;
            last = first;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
            //first.next = oldFirst;
            //oldFirst.prev = first;
//            if(oldFirst == last) { first.next = last; last.prev = first; }
//            else {first.next = oldFirst; oldFirst.prev = first; }
        }
        size++;
    }
    public void addLast(Item item)           // add the item to the end
    {
        if (item == null) {
            throw new IllegalArgumentException();
        }


        Node node = new Node(item);
        if(last == null) {
            last = node;
            first = last;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
            //last.prev = oldLast;
            //oldLast.next = last;
        }
        size++;
    }
    public Item removeFirst()                // remove and return the item from the front
    {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;

        first = first.next;
        if (first == null) last = null;
        else first.prev = null;
        size--;
        return item;
    }
    public Item removeLast()                 // remove and return the item from the end
    {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;

        last = last.prev;
        if(last == null) first = null;
        else last.next = null;
        size--;
        return item;
    }


    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args)   // unit testing (optional)
    {}
}
