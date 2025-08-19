public class DLNode{
    public int data;
    public DLNode next;
    public DLNode prev;

    DLNode(int data1,DLNode next1, DLNode prev1){
        this.data = data1;
        this.next = next1;
        this.prev = prev1;
    }

    DLNode(int data1){
        this.data = data1;
        this.next = null;
        this.prev = null;
    }
}