package TEN180607;


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
    
    public int numberOfLeaves(Node<E> localRoot, int count) {
        if (localRoot == null)
            return count;
        if (localRoot.left == null && localRoot.right == null)
            return count + 1;
        count = numberOfLeaves(localRoot.left, count);
        return numberOfLeaves(localRoot.right, count);
    }

    public int numberOfLeaves() {
        if (root == null)
            return 0;
        return numberOfLeaves(root, 0);
    }

    public E max(Node<E> localRoot) {
        if (localRoot.right != null)
            return max(localRoot.right);
        return localRoot.data;
    }
    
    public E max() {
        if (root == null)
            return null;
        return max(root);
    }
    
    private E max;
    private E secondMax;
    public void secondMax(Node<E> localRoot) {
        if (localRoot == null)
            return;
        if (max == null) {
            max = localRoot.data;
        }
        else if (localRoot.data.compareTo(max) > 0) {
            secondMax = max;
            max = localRoot.data;
        } 
        else if (secondMax == null) {
            secondMax = localRoot.data;
        }
        else if (localRoot.data.compareTo(secondMax) > 0) {
            secondMax = localRoot.data;
        }
        secondMax(localRoot.left);
        secondMax(localRoot.right);
    }
    
    public E secondMax() {
        if (root == null)
            return null;
        if (root.right == null && root.left == null)
            return null;
        max = null;
        secondMax = null;
        secondMax(root);
        return secondMax;
    }
    
}
