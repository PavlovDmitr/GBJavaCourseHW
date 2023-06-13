package org.example;

public class Node <K, V>{
    K key;
    V value;
    Node<K, V> nextnode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}