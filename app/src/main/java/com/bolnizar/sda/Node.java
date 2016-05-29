package com.bolnizar.sda;

/**
 * Created by Paul on 5/29/2016.
 */
public class Node {
    public String key;
    public String value;
    public Node next;

    public Node() {
    }

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
