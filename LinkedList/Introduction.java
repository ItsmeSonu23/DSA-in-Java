import java.nio.file.WatchEvent;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }

}

public class Introduction {

    private static void printHead(Node headNode) {
        if (headNode == null)
            return;
        Node head = headNode;
        System.out.println(head.data);
    }

    private static void printTail(Node headNode) {
        if (headNode == null)
            return;
        Node head = headNode;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    private static Node createNode(int[] arr) {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }

    private static int printSize(Node headNode){
        if(headNode==null)return 0;
        Node head = headNode;
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }   
        return count;
    }

    private static void printLL(Node headNode){
        if(headNode==null)return;
        Node head = headNode;
        while(head!=null){
            System.out.print(head.data+" -> ");
            head = head.next;
        }   
        System.out.println("");
    }

    private static Node deleteHead(Node headNode){
        if(headNode==null)return null;
        headNode = headNode.next;
        return headNode;
    }

    private static Node deleteTail(Node head){
        if(head==null)return null;
        Node temp = head;
        while(temp.next.next!=null){
            temp =  temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node removeKthNode(Node head,int k){
        if(head==null)return head;
        if(k==1) return deleteHead(head);
        Node temp = head;
        int cnt = 0;
        Node prev = null;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node insertHead(Node head, int val){
        return new Node(val,head);
    }

    private static Node insertTail(Node head, int val){
        if(head==null){
            return new Node(val);
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        Node newNode  = new Node(val);
        temp.next = newNode;
        return head;
    }

    private static Node insertKthNode(Node head, int val, int k){
        if(head==null){
            if(k==1){
                return new Node(val);
            }else{
                return head;
            }
        }
        Node temp = head;
        int cnt = 0;
        while(temp!=null){
            cnt++;
            if(cnt==k-1){
                Node newNode = new Node(val,temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 40, 50 };
        Node y = createNode(arr);
        printHead(y);
        printTail(y);
        System.out.println(printSize(y));
        printLL(y);
        y = deleteHead(y);
        printLL(y);
        y = deleteTail(y);
        printLL(y);
        y = removeKthNode(y, 2);
        printLL(y);
        y = insertHead(y, 100);
        printLL(y);
        y = insertTail(y, 200);
        printLL(y);
        y = insertKthNode(y, 300, 5);
        printLL(y);
    }
}
