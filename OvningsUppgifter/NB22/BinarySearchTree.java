/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB22;

/**
 *
 * @author Jacob
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E> {

        private E data;
        private Node<E> left, right;

        private Node(E d) {
            data = d;
            left = right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            //same
            System.out.println("already exist!");
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<E>(data);
                return true;
            } else {
                return add(data, node.left);
            }

        } else {
            if (node.right == null) {
                node.right = new Node<E>(data);
                return true;
            } else {
                return add(data, node.right);
            }
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<E>(data);
            return true;
        } else {
            return add(data, root);
        }
    }

    private E find(E target, Node<E> node) {
        if (node == null) {
            return null;
        }
        if (target.compareTo(node.data) == 0) {
            return node.data;
        }
        if (target.compareTo(node.data) < 0) {
            return find(target, node.left);
        }
        return find(target, node.right);
    }

    public E find(E target) {
        return find(target, root);
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(": ").append(node.toString());
            inOrder(node.right, sb);
        }
    }

    private void postOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(": ").append(node.toString());
        }
    }

    private void preOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            sb.append(": ").append(node.toString());
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }

    public String postString() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString();
    }

    public String preString() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public String toString() {
        System.out.println("root: " + root.toString());
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }
}
