package dev.druid.classwork.classwork15;

/**
 * Created by itisLaptop on 07.04.2021.
 */
public class Tree {

    private Node<Integer> root;

    public Tree(int n) {
        this(new Node<>());
        makeBalancedTreeOn(root, n);
    }

    public Tree() {
        this.root = null;
    }
    public Tree(Node<Integer> root){
        this.root = root;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void printTree() {
        printNode(root, 0);
    }


    public static void printNode(Node<Integer> n, int space) {

        if (n.left != null) {
            printNode(n.left, space + 1);
        }

        for (int i = 1; i <= space; i++) {
            System.out.print(" ");
        }
        System.out.println(n.value);

        if (n.right != null) {
            printNode(n.right, space + 1);
        }
    }

    private void makeBalancedTreeOn(Node<Integer> root, int n) {
        root.value = n;
        if (n > 1) {
            int nl = n / 2;
            root.left = new Node<Integer>();
            makeBalancedTreeOn(root.left, nl);
            int nr = n - nl - 1;
            if (nr == 0) {
                root.right = null;
            } else {
                root.right = new Node<Integer>();
                makeBalancedTreeOn(root.right, nr);
            }
        }


    }


}
