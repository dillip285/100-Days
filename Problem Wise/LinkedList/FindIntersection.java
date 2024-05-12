import LList.LLOperation;
import LList.Node;
import java.util.*;


public class FindIntersection {
    public static void main(String[] args) {
        Node root1 = LLOperation.createLinkedList(new int[]{7,1,6});
        Node root2 = LLOperation.createLinkedList(new int[]{5,9,4});
        Node rootI = LLOperation.createLinkedList(new int[]{8,9,10});
        LLOperation.addToEnd(root1,rootI);
        LLOperation.addToEnd(root2,rootI);
        System.out.println("......Input linked list......");
        LLOperation.printLList(root1);
        LLOperation.printLList(root2);
        Node intSec = getIntersectionNode(root1,root2);
        if(intSec!=null){
            System.out.println("The above Linked lists are intersected at:" + intSec.data);
        }else{
            System.out.println("The above Linked lists are not intersected");
        }
    }

    public static Node getIntersectionNode(Node root1, Node root2){
        //
        int length1 = findLength(root1, 0);
        int length2 = findLength(root2,0);
        if(length2 == length1){
            return compare(root1, root2);
        } else if (length1<length2) {
            // find the diff and iterate the length2 that may time and then compare

            return compare(root1, iterate(root2,Math.abs(length1-length2)));
        }else{
            // find the diff and iterate the length1 that may time and then compare
            return compare(root2, iterate(root1,Math.abs(length1-length2)));
        }


    }
    public static Node iterate(Node node, int i){
        if(i==0){
            return node;
        }
        return iterate(node.next, i-1);
    }
    public static Node compare(Node one, Node two){
        boolean intersected = false;
        Node intersection = null;
        while(one!=null && two !=null){
            if(one.data == two.data){

                if(!intersected){
                    intersected = true;
                    intersection = one;
                }
            }else{
                intersected = false;
            }
            one=one.next;
            two=two.next;

        }
        return intersection;
    }

    public static int findLength(Node root, int count){
        if(root==null){
            return count;
        }
        return findLength(root.next, count+1);
    }
}