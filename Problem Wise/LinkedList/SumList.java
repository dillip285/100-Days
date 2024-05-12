
import LList.Node;


public class SumList {

    public static void main(String[] args) {

        Node root1 = LLOperation.createLinkedList(new int[]{7,1,6});
        Node root2 = LLOperation.createLinkedList(new int[]{5,9,4});
        System.out.println("......Input linked list......");
        LLOperation.printLList(root1);
        LLOperation.printLList(root2);
        LLOperation.printLList(addList(root1,root2));


    }
    public static Node addList(Node node1, Node node2) {
        Node result = new Node(0);
        Node current = result;
        int carry = 0;

        while (node1 != null || node2 != null || carry != 0) {
            int sum = carry;
            if (node1 != null) {
                sum += node1.data;
                node1 = node1.next;
            }
            if (node2 != null) {
                sum += node2.data;
                node2 = node2.next;
            }
            carry = sum / 10;
            sum = sum % 10;

            current.next = new Node(sum);
            current = current.next;
        }

        return result.next;
    }

}




