import LList.Node;


public class PartitionLL {

    public static void main(String[] args) {
        int[] input = new int[]{3, 5,8,5,10,2,1};
        Node root = LLOperation.createLinkedList(input);
        System.out.println("List Before");
        LLOperation.printLList(root);
        Node output = partition(root, 5);
        System.out.println("List After");
        LLOperation.printLList(output);
    }

    public static Node partition(Node node, int n){
        Node head = node; //3 -> 3
        Node tail = node; //3 > 5
        int i =1;
        while(node != null){
            Node next = node.next; // 5
            System.out.println(i++ + ":"+ node.data);
            if ( node.data < n){
                node.next = head;
                head = node;

            }else{
                tail.next = node;
                tail = node;
            }
            node = next;

        }
        tail.next = null;
        return head;

    }
}