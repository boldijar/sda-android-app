package com.bolnizar.sda;

/**
 * Created by Paul on 5/28/2016.
 */
public class Dictionary {
    enum Order {
        ASCENDING,
        DESCENDING
    }

    private static final int HASH_SIZE = 7;

    private Order mOrder;
    private Iterator mIterator;
    private Node[] mNodes;

    private int dispersionPosition(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += 25 * key.charAt(i);
        }
        return Math.abs(hash % HASH_SIZE);
    }

    /**
     * Sets the order of the dictionary
     */
    public void create(Order order) {
        mOrder = order;
        mNodes = new Node[HASH_SIZE];
    }

    /**
     * ads a new key-value pair
     */
    public void add(String key, String url) {
        int position = dispersionPosition(key);
        Node currentNode = mNodes[position];

        if (currentNode == null) {
            /* add first element in the current position*/
            currentNode = new Node(key, url);
            mNodes[position] = currentNode;
            return;
        }
        while (currentNode.next != null) {
            /* go deeper until we found our last node */
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(key, url);
    }

    /**
     * deletes the value with the choosen key from the dictionary
     */
    public void delete(String key) {
        int position = dispersionPosition(key);
        Node currentNode = mNodes[position];
        if (currentNode == null) {
            /* no node with this key */
            return;
        }
        /* check if first node is the one that we want to delete */
        if (key.equals(currentNode.key)) {
            mNodes[position] = currentNode.next;
            return;
        }
        do {
            Node lastNode = currentNode;
            currentNode = currentNode.next;
            if (key.equals(currentNode.key)) {
                // found element, change reference from last, to current next node
                lastNode.next = currentNode.next;
                return;
            }
        } while (currentNode != null);
    }

    /**
     * searches for the value with the choosen key
     */
    public String find(String key) {
        return null;
    }

    /*
     returns the size of the dictionary
     */
    public int size() {
        int count = 0;
        for (Node mNode : mNodes) {
            Node currentNode = mNode;
            do {
                if (currentNode != null) {
                    count++;
                    currentNode = currentNode.next;
                }
            } while (currentNode != null);
        }
        return count;
    }

    /*
     returns true if list is void, false otherwise
     */
    public boolean isVoid() {
        return size() == 0;
    }

    /*
     creates the iterator for this dictionary
    */
    public void createIterator() {
        mIterator = new Iterator(this, mNodes);
    }

    /*
     returns the iterator of this dictionary
     */
    public Iterator getIterator() {
        return mIterator;
    }

    /*
        delets the iterator
         */
    public void disposeIterator() {
        mIterator = null;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.create(Order.ASCENDING);
        dictionary.add("a", "www.1234.com");
        dictionary.add("b", "www.paul.com");
        dictionary.add("c", "www.asd.com");
        dictionary.add("d", "www.12.com");
        dictionary.add("e", "www.smek.com");
        dictionary.add("f", "www.sdsd.com");
        dictionary.add("g", "www.2902.com");
        dictionary.add("h", "www.barosan.com");
        dictionary.add("ab", "www.barosan.com");
        dictionary.add("cd", "www.barosan.com");
        dictionary.add("ef", "www.barosan.com");
        dictionary.add("abc", "www.barosan.com");
        dictionary.add("def", "www.barosan.com");
        dictionary.add("smecherie", "www.barosan.com");
        dictionary.add("zgi", "www.barosan.com");
        dictionary.add("kmw", "www.barosan.com");
        dictionary.add("wek", "www.barosan.com");

        test(dictionary.size(), 17);

        dictionary.delete("def");
        test(dictionary.size(), 16);

        dictionary.delete("h");
        dictionary.delete("abc");

        test(dictionary.size(), 14);

        dictionary.createIterator();
        Iterator iterator = dictionary.getIterator();
        iterator.initialize();

        while (iterator.valid()) {
            System.out.println(iterator.current());
            iterator.next();
        }
    }

    private static void test(int a, int b) {
        if (a != b) {
            throw new RuntimeException(String.format("Expected %d, actual %d", a, b));
        }
    }
}
