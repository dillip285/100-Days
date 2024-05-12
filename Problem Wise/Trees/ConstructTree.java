


public class ConstructTree {
    /*
              1
           2     3
        4     5    6
        pre: 124536
        post:452631
     */

    public static void main(String[] args) {
        int [] preOrder = new int[]{1,2,4,5,3,6};
        int [] postOrder = new int[]{4,5,2,6,3,1};
        getTree(preOrder,postOrder);


    }


    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int i) {
            this.data = i;
        }
    }



}