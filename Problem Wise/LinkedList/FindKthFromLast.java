
import LList.Node;


public class FindKthFromLast{

    public static class Counter{
        public int count=0;
    }

    public static void main(String[] args) {
        int k = 3;
        Node root = LLOperation.createLinkedList(new int[]{1,2,3,4,5,6});
        System.out.println("......Input linked list......");
        LLOperation.printLList(root);
        System.out.println(String.format("%d node from last is : %d ", k, kthNodeFromLast(root,new Counter(),k).data));

    }

    public static Node kthNodeFromLast(Node root, Counter counter, int k){

        if(root.next == null){
            counter.count = 1;
            return root;
        }
        Node result = kthNodeFromLast(root.next, counter,k);
        counter.count ++;
        if(counter.count == k){
            return root;
        }
        return result;
    }
}