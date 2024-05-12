package LList;

public class LLOperation {
    public static Node createLinkedList(int[] input) {
        Node head = null;
        Node current = null;
        for (int i : input) {
            if (head == null) {
                head = new Node(i);
                current = head;
                continue;
            }
            Node n = new Node(i);
            current.next = n;
            current = n;
        }
        return head;
    }

    public static Node createCyclicLinkedList(int[] input, int link) {
        Node head = null;
        Node current = null;
        Node cyclePoint = null;
        for (int i=0;i<input.length;i++) {
            if (head == null) {
                head = new Node(input[i]);
                current = head;
                continue;
            }
            Node n = new Node(input[i]);
            current.next = n;
            current = n;
            if(i==link-1){
                cyclePoint = n;
            }
        }
        current.next = cyclePoint;
        return head;
    }


    public static void addToEnd(Node node, Node toAdd){
        while(node!=null){
            if(node.next==null){
                node.next=toAdd;
                break;
            }
            node = node.next;
        }
    }

    public static void printLList(Node root){
        Node current = root;
        while(current.next!=null){
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.print(current.data+"\n");
    }


    public static Node getNode(Node root, int d){
        if ( root == null ) return null;
        if (root.data == d ) return root;
        Node current = root;
        while (current.next!=null){
            if (current.data == d ) return current;
            current = current.next;
        }
        return null;

    }
}