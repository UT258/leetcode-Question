class MyHashSet {
    private class Node{
        int key;
        Node next;

        Node(int key){
            this.key = key;
            this.next = null;
        }
    }

    private final Node[] set;
    private final int SIZE = 1000;

    public MyHashSet() {
        set = new Node[SIZE];
    }

    private int getIndex(int key){
        return key % SIZE;
    }
    
    public void add(int key) {
        int index = getIndex(key);
        Node head = set[index];

        Node curr = head;
        while(curr != null){
            if(curr.key == key){
                return;
            }
            curr = curr.next;
        }

        Node newNode = new Node(key);
        newNode.next = head;
        set[index] = newNode;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        Node curr = set[index];
        Node prev = null;
        while(curr != null){
            if(curr.key == key){
                if(prev == null){
                    set[index] = curr.next;
                }else{
                    prev.next = curr.next;
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int index = getIndex(key);
        Node curr = set[index];
        while(curr != null){
            if(curr.key == key){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}