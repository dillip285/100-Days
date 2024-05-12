
import LList.LLOperation;
import LList.Node;
import java.util.*;




public class LoopDetection {

    public static void main(String[] args) {
        Node root = LLOperation.createCyclicLinkedList(new int[]{1,2,3,4,5,6,7,8,9,10}, 4);
//        LLOperation.printLList(root);
        System.out.println(giveLoopIntersection(root));
    }

    public static Node giveLoopIntersection(Node root){
        if( root ==null && root.next ==null){
            System.out.println("Linked list is not valid.");
            return null;
        }
        Node head = root;
        Node slow = root.next;
        Node fast = root.next.next;
        Node collide = null;
        while(slow!=null && fast!=null){
            if(slow.data == fast.data){
                collide = slow;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        while(head!=null && collide!=null){
            if(head.data == collide.data ){
                return head;
            }
            head = head.next;
            collide = collide.next;
        }
        return null;

    }
}