import java.util.*;
import java.lang.*;


public class Traversal {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.left.left = new Node(20);
        root.left.left.left = new Node(15);
        root.left.left.right = new Node(7);
//        root.left = new Node(50);
//        root.left.left = new Node(55);
//        root.left.right = new Node(90);
//        root.right = new Node(7);
//        root.right.left = new Node(87);
//        root.right.right = new Node(2);
//        root.left.right.left = new Node(15);
//        root.left.right.right = new Node(10);
        System.out.println("-------In-order printing------");
        inOrder(root);
        System.out.println("\n-------In-order printing Ends------");
        System.out.println("-------Pre-order printing------");
        preOrder(root);
        System.out.println("\n-------Pre-order printing Ends------");
        System.out.println("-------Post-order printing------");
        postOrder(root);
        System.out.println("\n-------Post-order printing Ends------");

        System.out.println("-------Breadth First printing------");
        printBreadFist(root);
        System.out.println("\n-------Breadth First printing Ends------");

        System.out.println("-------Top view printing------");
        topViewOfTree(root);
        System.out.println("\n-------Top view printing Ends------");
        System.out.println("-------Bottom view printing------");
        bottomViewOfTree(root);
        System.out.println("\n-------Bottom view printing Ends------");
        System.out.println("-------Left view printing------");
        leftViewOfTree(root);
        System.out.println("\n-------Left view printing Ends------");
        System.out.println("-------Right view printing------");
        printRightView(root);
        System.out.println("\n-------Right view printing Ends------");

        System.out.println("-------In-order printing of tree constructed from pre and post order array------");
        int [] preOrder = new int[]{1,2,4,5,3,6};
        int [] postOrder = new int[]{4,5,2,6,3,1};
        Node costructedTree = getTree(preOrder, postOrder);
        inOrder(costructedTree);
        System.out.println("\n-------In-order printing of tree constructed from pre and post order array Ends------");

    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int i) {
            this.data = i;
        }
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void printBreadFist(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {

                queue.add(current.right);
            }

        }
    }

    public static void topViewOfTree(Node root) {
        printTopView(root, -1);
    }

    private static void printTopView(Node root, int pos) {
        if (root == null) return;
        if (pos == -1 || pos == 0) printTopView(root.left, 0);
        if (pos == 0 || pos == 1 || pos == -1) System.out.print(root.data + " ");
        if (pos == -1 || pos == 1) printTopView(root.right, 1);
    }

    public static int bottomViewOfTree(Node root) {
        if (root == null) return 1;
        if (bottomViewOfTree(root.left) == 1 || bottomViewOfTree(root.right) == 1) {
            System.out.print(root.data + " ");
            return 2;
        }
        return 2;
    }

    public static void leftViewOfTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean printNextNode = true;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                printNextNode = true;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                if (printNextNode) {
                    System.out.print(current.data + " ");
                    printNextNode = false;
                }
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
    }

    public static void printRightView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node last = null;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                System.out.println(last.data);
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            last = current;
        }

    }

    public static Node getTree(int[] preOrder, int[] postOrder){
        return constructTree(preOrder, 0, preOrder.length-1, postOrder, 0, postOrder.length-1);
    }

    public static Node constructTree(int[] preOrder, int preStart, int preEnd, int[] postOrder, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        Node root = new Node(preOrder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int index = indexOf(postOrder, preOrder[preStart + 1]);
        int leftSize = index - postStart + 1;
        root.left = constructTree(preOrder, preStart + 1, preStart + leftSize, postOrder, postStart, index);
        root.right = constructTree(preOrder, preStart + leftSize + 1, preEnd, postOrder, index + 1, postEnd - 1);
        return root;
    }

    public static int indexOf(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

}


