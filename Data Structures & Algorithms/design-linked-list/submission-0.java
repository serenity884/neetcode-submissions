class MyLinkedList {
    private class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    private Node dummy;  // dummy.next is the real head
    private int size;

    public MyLinkedList() {
        dummy = new Node(-1);
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node curr = dummy.next;
        for(int i=0; i<index; i++){
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = dummy.next;
        dummy.next = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index = 0;

        Node curr = dummy;
        for(int i=0; i<index; i++){
            curr = curr.next;
        }
        Node newNode = new Node(val);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;

        Node curr = dummy;
        for(int i=0; i<index; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }
}
