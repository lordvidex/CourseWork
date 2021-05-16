package dev.druid.classwork.classwork17;

import dev.druid.classwork.classwork15.Node;

/**
 * Created by IntelliJ IDEA
 * Date: 12.04.2021
 * Time: 2:48 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class SearchTree {
    private Node<Integer> root;
    private int count;

    public int size() {
        return count;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public SearchTree() {
        this.root = null;
    }

    public boolean add(int value) {
        // first item
        if (root == null) {
            root = new Node<>();
            root.value = value;
            count++;
            return true;
        }

        // other items
        if (add(root, value)) {
            count++;
            return true;
        } else {
            return false;
        }
    }

    private boolean add(Node<Integer> node, int value) {
        if (node.value == null) {
            node.value = value;
            return true;
        } else if (value == node.value) {
            return false;
        } else if (value < node.value) {
            if (node.left == null) node.left = new Node<>();
            return add(node.left, value);
        } else {
            if (node.right == null) node.right = new Node<>();
            return add(node.right, value);
        }
    }

    public boolean find(int value) {
        return find(root, value);
    }

    private boolean find(Node<Integer> node, int value) {
        if (node == null) return false;
        else if (node.value == value) {
            return true;
        } else if (value < node.value) {
            return find(node.left, value);
        } else {
            return find(node.right, value);
        }
    }

    public boolean remove(int value) {
        return remove(root, value);
    }

    private boolean remove(Node<Integer> node, int value) {
        // finding the node that needs to be removed
        Node<Integer> oldNode;

        // find the node
        while (node != null && node.value != value) {
            if (value < node.value) {
                node.parent = node;
                node = node.left;
                node.parentLeft = true;

            } else {
                node.parent = node;
                node = node.right;
                node.parentLeft = false;
            }
        }
        // it was not found
        if (node == null) return false;
        oldNode = node;

        // node has one right child
        if (node.right != null) {
            node = node.right;
            // find the left-most
            while (node.left != null) {
                node.parent = node;
                node = node.left;
            }
            // if it has a right child
            if (node.right != null) {
                oldNode.value = node.value;
                node.parent.left = node.right;
            } else {
                oldNode.value = node.value;
                node.parent.left = null;
            }

        } else if (node.left != null) {
            // node has one left child
            node.value = node.left.value;
            node.left = node.left.left;
            node.right = node.left.right;

        } else {
            // it is a leaf node
            if (node.parentLeft) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }

        }
        return true;
    }


}
