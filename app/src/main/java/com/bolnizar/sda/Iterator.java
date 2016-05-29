package com.bolnizar.sda;

/**
 * Created by Paul on 5/28/2016.
 */
public class Iterator {
    private Dictionary mDictionary;
    private Node[] mDictionaryNodes;
    private Node[] mNodes;

    private int mIndex;

    public Iterator(Dictionary dictionary, Node[] dictionaryNodes) {
        mDictionary = dictionary;
        mDictionaryNodes = dictionaryNodes;
    }

    /* initialize this iterator */
    public void initialize() {
        mNodes = new Node[mDictionary.size()];
        int index = 0;
        for (Node mNode : mDictionaryNodes) {
            Node currentNode = mNode;
            do {
                if (currentNode != null) {
                    mNodes[index++] = currentNode;
                    currentNode = currentNode.next;
                }
            } while (currentNode != null);
        }
        reset();
    }

    /* returns the first element from the iterator*/
    public Node first() {
        if (mNodes == null || mNodes.length == 0) {
            return null;
        }
        return mNodes[0];

    }

    /* returns true if the iterator has a valid current element */
    public boolean valid() {
        if (mNodes != null && mIndex < mNodes.length) {
            return true;
        }
        return false;
    }

    /* moves the iterator one step */
    public void next() {
        mIndex++;
    }

    /* returns the current element from the iterator */
    public Node current() {
        if (valid()) {
            return mNodes[mIndex];
        }
        return null;
    }

    /* move cursor back to start*/
    public void reset() {
        mIndex = 0;
    }


}
