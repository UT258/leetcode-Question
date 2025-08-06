class MyHashSet {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node[] hashTable;
    private int size;

    public MyHashSet() {
        this.hashTable = new Node[16];
    }

    /**
    * Worst-case time complexity: O(k), where k is the number of nodes in a bucket (due to collisions).
    * Amortized time complexity: O(1) for add/remove/contains when hashTable are well-distributed.
    */
    public void add(int key) {
        if (getLoadFactor() >= 0.75) {
            resize();   // copy the map over to a new one
        }

        // check if node already exists in map
        if (contains(key)) return;

        // get key's index
        int index = getIndex(key);

        // insert new node at beginning of bucket at index
        Node newNode = new Node(key);
        newNode.next = hashTable[index];
        hashTable[index] = newNode;

        size++;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (hashTable[index] == null) return;        // key does not exist

        Node cur = hashTable[index];
        // key is the first in the bucket
        if (cur.val == key) {
            hashTable[index] = cur.next;
            size--;
            return;
        }

        // find prev to the key that needs to be removed
        while (cur != null && cur.next != null) {
            if (cur.next.val == key) {
                cur.next = cur.next.next;
                size--;
                return;
            }
            cur = cur.next;
        }

        // key does not exist
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        Node cur = hashTable[index];
        while (cur != null) {
            if (cur.val == key) return true;
            cur = cur.next;
        }

        return false;
    }

    private int getIndex(int key) {
        return hashKey(key) % hashTable.length;
    }

    private int hashKey(int key) {
        return Math.abs(Integer.hashCode(key));
    }

    private double getLoadFactor() {
        return (double) size / hashTable.length;      // resize occurs at >= 0.75
    }

    private void resize() {
        int newSize = hashTable.length * 2;
        Node[] newHashTable = new Node[newSize];     // new map will be twice the size
        for (Node head : hashTable) {
            while (head != null) {
                Node next = head.next;
                int newIndex = hashKey(head.val) % newSize;
                head.next = newHashTable[newIndex];         // in case of a collision, we insert node at the head
                newHashTable[newIndex] = head;
                head = next;
            }
        }
        hashTable = newHashTable;     // re-assign old hash table to new hash table
    }
}