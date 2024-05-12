import LList.Node;

public class DeleteMiddleNode {

    public static void main(String[] args) {
        int[] input = new int[]{3,4,5,6,7};
        Node lList = LLOperation.createLinkedList(input);
        Node middle = LLOperation.getNode(lList, 5);
        System.out.println("Middle:" + middle.data);
        LLOperation.printLList(lList);
        deleteMiddleNode(middle);
        LLOperation.printLList(lList);
    }

    public static void deleteMiddleNode(Node middle){
        if( middle.next == null) {
            System.out.println("Error the node is Last node.");
        }
        Node current = middle;
        while(current.next!=null && current.next.next!=null){
            current.data = current.next.data;
            current.next = current.next.next;
        }

    }






}