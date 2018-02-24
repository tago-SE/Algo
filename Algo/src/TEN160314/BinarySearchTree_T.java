
package TEN160314;

/**
 *
 * @author tiago
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree_T<E extends Comparable<E>> {

    
    private int nrSingleParents(Node<E> localRoot, int count) {
        if (localRoot == null)
            return count;

        if ((localRoot.left != null && localRoot.right == null) || 
            (localRoot.right != null && localRoot.left == null)) {
            count += 1;
        }
        count = nrSingleParents(localRoot.left, count);
        return nrSingleParents(localRoot.right, count);
    }
    
    public int nrSingleParents() {
        return nrSingleParents(root, 0);
    }

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

    public BinarySearchTree_T() {
        root = null;
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(": ").append(node);
            inOrder(node.right, sb);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private void printTree(Node<E> node, Queue<Node<E>> q, Queue<Integer> level, int nodeL) {
        System.out.print(node + " ");
        if (node != null) {
            q.offer(node.left);
            level.offer(nodeL + 1);
            q.offer(node.right);
            level.offer(nodeL + 1);
        }
        while (!q.isEmpty()) {
            if (level.poll() > nodeL) {
                System.out.println();
                nodeL++;
            }
            printTree(q.poll(), q, level, nodeL);
        }
    }

    public void printTree() {
        Queue<Node<E>> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        printTree(root, q, level, 1);
        System.out.println();
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                return true;
            } else {
                return add(data, node.left);
            }
        } else if (node.right == null) {
            node.right = new Node<>(data);
            return true;
        } else {
            return add(data, node.right);
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<>(data);
            return true;
        } else {
            return add(data, root);
        }
    }

    public E find(E target) {
        return find(target, root);
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

}