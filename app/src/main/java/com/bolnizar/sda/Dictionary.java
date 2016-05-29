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
        return key.hashCode() % HASH_SIZE;
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
        return 0;
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
        mIterator = new Iterator(this);
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
        dictionary.add("paul", "www.paul.com");
        dictionary.add("raul","www.asd.com");
        dictionary.add("sau","www.12.com");
        dictionary.add("a","www.smek.com");
        dictionary.add("s","www.sdsd.com");
        dictionary.add("a","www.2902.com");
        dictionary.add("sau","www.1aa69.com");

    }
}
