public class LinkedList {

    private static Node insertDataInLL(int[] arr){
        Node head = null;
        Node tail = null;
        for (int i = 0;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            if(head==null){
                head = temp;
                tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }

    private static void printLL(Node head){
        if(head==null) return ;
        Node  temp = head;
        while(temp.next != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        int arr[]= {1,2,3,4,5};

        Node node = insertDataInLL(arr);
        printLL(node);
    }   
}
