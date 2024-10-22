/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
import java.util.ArrayList;

public class HashMap<K, V> {

    ArrayList<HashNode<K, V>> bucket = new ArrayList<>();
    int numberBuckets = 10;
    int size;

    public HashMap() {
        for (int i = 0; i < numberBuckets; i++) {
            bucket.add(null);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % numberBuckets;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = this.getBucketIndex(key);
        HashNode<K, V> head = this.bucket.get(index);
        if (head == null) {
            return null;
        }
        if (head.key.equals(key)) {
            V val = head.value;
            head = head.next;
            bucket.set(index, head);
            this.size--;
            return val;
        } else {
            HashNode<K, V> prev = null;
            while (head != null) {
                if (head.key.equals(key)) {
                    prev.next = head.next;
                    this.size--;
                    return head.value;
                }
                prev = head;
                head = head.next;

            }
            this.size--;
            return null;
        }

    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        HashNode<K, V> head = this.bucket.get(index);
        HashNode<K, V> toAdd = new HashNode();
        toAdd.key = key;
        toAdd.value = value;
        if (head == null) {
            this.bucket.set(index, toAdd);
            this.size++;
        } else {
            while (head != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    this.size++;
                    break;
                }
                head = head.next;
            }
            if (head == null) {
                head = bucket.get(index);
                toAdd.next = head;
                this.bucket.set(index, toAdd);
                this.size++;
            }
        }
        if ((1.0 * size) / this.numberBuckets > 0.7) {
            ArrayList<HashNode<K, V>> temp = this.bucket;
            this.bucket = new ArrayList<>();
            numberBuckets = 2 * numberBuckets;
            for(int i =0; i < numberBuckets; i++){
                this.bucket.add(null);
            }
            for(HashNode<K, V> headNode : temp) {
                while(headNode !=null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }

    }
}
