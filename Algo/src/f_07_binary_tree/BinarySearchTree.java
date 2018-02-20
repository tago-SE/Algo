package f_07_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author tiago
 */
public class BinarySearchTree<E extends Comparable<E>> {
    
    private Node<E> root;
    private E deletedReturn;
    
    private static class Node<E>{
        private E e;
        private Node<E> left, right;
        
        private Node(E item){
            this.e = item;
            this.left = right = null;
        }
        
        public Node(E item, Node<E> left, Node<E> right) {
            this.e = item;
            this.left = left;
            this.right = right;
        }
        
        @Override
        public String toString(){
            return e.toString();
        }
    }
    
    private boolean add(E item, Node<E> node) {
        int comp = item.compareTo(node.e);
       
        if (comp == 0) return false; 
        if (comp < 0) {
            if (node.left == null) {
                node.left = new Node(item);
                return true;
            } else 
                return add(item, node.left);
        } else {
            if (node.right == null) {
                node.right = new Node(item);
                return true;
            } else 
                return add(item, node.right);
        }
    } 
    public boolean add(E item) {
        if (item == null) return false;
        if (root == null) {
            root = new Node(item);
            return true;
        }
        else return add(item, root);  
    }
    
    private Node<E> findNodeParent(Node<E> root, Node<E> parent, E target) {
        if (root == null)
            return null;
        int comp = target.compareTo(root.e);
        if (comp == 0) 
            return parent;
        else if (comp < 0) 
            return findNodeParent(root.left, root, target);
        else 
            return findNodeParent(root.right, root, target);
    }
    
    
    private E deleteReturn;
    private Node<E> delete(Node<E> localRoot, E target) {
        if (localRoot == null) {
            deletedReturn = null;
            return null;
        }
        int comp = target.compareTo(localRoot.e);
        if (comp < 0) {
            localRoot.left = delete(localRoot.left, target);
            return localRoot;
        } 
        else if (comp > 0) {
            localRoot.right = delete(localRoot.right, target);
            return localRoot;
        } 
        else {
            // Item is at local root
            deletedReturn = localRoot.e;
            /* Node has one Child */
            if (localRoot.left == null)          
                return localRoot.right;
            else if (localRoot.right == null)  
                return localRoot.left;
            /* Node has two children */
            Node<E> nodeToMove = root.right;
            Node<E> parentNodeToMove = root;
            if (nodeToMove.left == null) {
                nodeToMove.left = root.left;
                return nodeToMove;
            } 
            while (nodeToMove.left != null) {
                parentNodeToMove = nodeToMove;
                nodeToMove = nodeToMove.left;
            }
            parentNodeToMove.left = nodeToMove.right;
            root.e = nodeToMove.e; 
            return root;
        }    
    }
    public E delete(E target){
        root = delete(root, target); 
        return deleteReturn;
    }
    
    private int numberOfLeaves(Node<E> root, int leaves) {
        if (root == null)
            return leaves;
        
        if (root.left == null && root.right == null)
            return leaves + 1;
        leaves = numberOfLeaves(root.left, leaves);
        return numberOfLeaves(root.right, leaves);
    }
        
    public int numberOfLeaves() {
        if (root == null || (root.left == null && root.right == null)) 
            return 0;
        return numberOfLeaves(root, 0);
    }
    
    private int numberOfNodes(Node<E> root, int count) {
        if (root == null) 
            return count;
        count = numberOfNodes(root.left, count);
        count = numberOfNodes(root.right, count);
        return count + 1;
    }
    
    public int numberOfNodes() {
        return numberOfNodes(root, 0);
    }
    
    private E findLargestChild(Node<E> root, E curLargest) {
        if (root == null)
            return curLargest;
        if (root.right != null)
            return findLargestChild(root.right, root.right.e);
        return root.e;
    }
    public E findLargestChild() {
        if (root == null)
            return null;
        return findLargestChild(root, root.e);
    }
    
    private int numberOfNodesWith2Children(Node<E> root, int count) {
        if (root == null)
            return count;
        count = numberOfNodesWith2Children(root.left, count);
        count = numberOfNodesWith2Children(root.right, count);
        if (root.left != null && root.right != null)
            count += 1;
        return count;
    }
    
    public int numberOfNodesWith2Children() {
        if (root == null) return 0;
        return numberOfNodesWith2Children(root, 0);
    }
    
    private int treeHeight(Node<E> root, int height) {
        if (root == null)
            return height;
        int a = treeHeight(root.left, height + 1);
        int b = treeHeight(root.right, height + 1);
        return a > b? a: b;
    }
    
    public int treeHeight() {
        if (root == null) return 0;
        return treeHeight(root, 0);
    }
    
    
    private E find(Node<E> root, E target) {
        if (root == null)
            return null;
        int comp = target.compareTo(root.e);
        if (comp == 0) 
            return root.e;
        else if (comp < 0) 
            return find(root.left, target);
        else 
            return find(root.right, target);
    }
    
    public boolean contains(E target) {
        return find(root, target) != null;
    }
    
    public E find(E target) {
        return find(root, target);
    }
    
    private void preOrder(Node<E> node, StringBuilder sb) {
        if(node == null) return;                    // if tree is empty return
        sb.append(": ").append(node.toString());    // visit node
        preOrder(node.left, sb);                    // traverse left sub-tree
        preOrder(node.right, sb);                   // traverse left sub-tree
    }
    
    private void inOrder(Node<E> node, StringBuilder sb) {
        if(node == null) return;  
        inOrder(node.left, sb);                     // traverse left sub-tree
        sb.append(": ").append(node.toString());    // visit node
        inOrder(node.right, sb);                    // traverse right subttree
    }
    
    private void postOrder(Node<E> node, StringBuilder sb) {
        if(node == null) return;  
        inOrder(node.left, sb);                     // traverse left sub-tree
        inOrder(node.right, sb);                    // traverse right subttree
        sb.append(": ").append(node.toString());    // visit node
    }
    
    private void printTree(StringBuilder sb, Node<E> node,Queue<Node<E>> qNodes, Queue<Integer> qLevel, int nodeL){
        sb.append(node).append(" ");
        if(node != null) {   
            qNodes.offer(node.left);
            qLevel.offer(nodeL+1);
            qNodes.offer(node.right);
            qLevel.offer(nodeL+1);
        }
        while(!qNodes.isEmpty()) {
            if(qLevel.poll() > nodeL){
                sb.append("\n");
                nodeL++;
            }
            printTree(sb, qNodes.poll(), qNodes, qLevel, nodeL);
        }
    }
    
    public String printTree() {
        Queue<Node<E>> qNodes = new LinkedList<>();
        Queue<Integer> qLevel = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        printTree(sb, root, qNodes, qLevel, 1);
        return sb.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }
    
}
