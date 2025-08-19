public class DoubleLinkedList {

    private static DLNode createDLNode(int arr[]) {
        DLNode head = new DLNode(arr[0]);
        DLNode prev = head;
        for (int i = 1; i < arr.length; i++) {
            DLNode temp = new DLNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void printDLL(DLNode head) {
        if (head == null)
            return;
        DLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    private static DLNode deleteHead(DLNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DLNode prev = head;
        head = head.next;
        prev.next = null;
        return head;
    }

    private static DLNode deleteTail(DLNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        DLNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.prev.next = null;
        tail.prev = null;
        return head;
    }

    private static DLNode removeKthNode(DLNode head, int k) {
        if (head == null || head.next == null) {
            return null;
        }
        DLNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            temp = temp.next;
        }
        DLNode prev = temp.prev;
        DLNode next = temp.next;

        if (prev == null || next == null) {
            return null;
        } else if (prev == null) {
            return deleteHead(head);
        } else if (next == null) {
            return deleteTail(head);
        }
        prev.next = next;
        next.prev = prev;
        temp.next = null;
        temp.prev = null;
        return head;
    }

    private static void deleteDlNode(DLNode temp) {
        DLNode prev = temp.prev;
        DLNode next = temp.next;
        if (next == null) {
            prev.next = null;
            temp.prev = null;
            return;
        }
        prev.next = next;
        next.prev = prev;
        temp.next = null;
        temp.prev = null;

    }

    private static DLNode insertBeforeHead(DLNode head, int val) {
        if (head == null) {
            return new DLNode(val);
        }
        DLNode newHead = new DLNode(val, head, null);
        head.prev = newHead;
        return newHead;
    }

    private static DLNode insertBeforeTail(DLNode head, int val) {
        if (head == null) {
            return new DLNode(val);
        }
        if (head.next == null) {
            return insertBeforeHead(head, val);
        }
        DLNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        DLNode prev = tail.prev;
        DLNode newNode = new DLNode(val, tail, prev);
        prev.next = newNode;
        tail.prev = newNode;
        return head;
    }

    private static DLNode insertBeforeKthNode(DLNode head, int val, int k) {
        if (k == 1) {
            return insertBeforeHead(head, val);
        }
        DLNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                break;
            }

            temp = temp.next;
        }
        DLNode prev = temp.prev;
        DLNode newNode = new DLNode(val, temp, prev);
        prev.next = newNode;
        temp.prev = newNode;

        return head;
    }

    private static void insertBeforeNode(DLNode node , int val){
        DLNode prev = node.prev;
        DLNode newNode = new DLNode(val,node,prev);
        prev.next = newNode;
        node.prev = newNode;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        DLNode head = createDLNode(arr);

        // Deleteion of the Doubly Linked List
        // printDLL(head);
        // head = deleteHead(head);
        // printDLL(head);
        // head = deleteTail(head);
        // printDLL(head);
        // head = removeKthNode(head, 2);
        // printDLL(head);
        // deleteDlNode(head.next);
        // printDLL(head);

        // Insertion of the Doubly Linked List
        head = insertBeforeHead(head, 10);
        printDLL(head);
        head = insertBeforeTail(head, 20);
        printDLL(head);
        head = insertBeforeKthNode(head, 30, 3);
        printDLL(head);
        insertBeforeNode(head.next, 40);
        printDLL(head);
    }
}
