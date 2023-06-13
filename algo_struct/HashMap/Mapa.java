package org.example;


public class Mapa<K, V> {
    Node<K, V>[] nodes = new Node[16];

    public V put(K key, V value) {

        V result = null;
        Node<K, V> inputNode = new Node<>(key, value);
        Integer hash16 = inputNode.key.hashCode() % 16;
        if (nodes[hash16] != null) {
            Node<K, V> currentNode = nodes[hash16];
            while (currentNode != null) {
                if (currentNode.key == key) {
                    result = currentNode.value;
                    currentNode.value = value;
                    return result;
                }
                currentNode = currentNode.nextnode;
            }
            inputNode.nextnode = nodes[hash16];
        }
        nodes[hash16] = inputNode;
        return result;
    }

    public V get(K key) {
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                return currentNode.value;
            }
            currentNode = currentNode.nextnode;
        }
        return null;
    }


    public V remove(K key) {
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        Node<K, V> previousNode = null;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                V tmp = currentNode.value;
                if (previousNode == null)
                    nodes[index] = currentNode.nextnode;
                else if (currentNode.nextnode == null)
                    previousNode.nextnode = null;
                else
                    previousNode.nextnode = currentNode.nextnode;
                return tmp;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextnode;
        }
        return null;
    }

    public V replays(K key, V value) {
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                currentNode.value = value;
                return currentNode.value;
            }
            currentNode = currentNode.nextnode;
        }
        return null;
    }

    public int size(){
        int result = 0;
        for (int i = 0; i < 16; i++){
            Node<K, V> currentNode = nodes[i];
            while (currentNode != null){
                result ++;
                currentNode = currentNode.nextnode;
            }
        }
        return result;
    }

    public boolean containsKey(K key){
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                return true;
            }
            currentNode = currentNode.nextnode;
        }
        return false;
    }

    public boolean containsValue(V value){
        for (int i = 0; i < 16; i++){
            Node<K, V> currentNode = nodes[i];
            if (currentNode != null && currentNode.value == value){
                return true;
            }
        }
        return false;
    }
}