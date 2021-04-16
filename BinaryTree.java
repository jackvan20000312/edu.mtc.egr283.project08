package edu.mtc.egr283.project08;

public class BinaryTree<T extends Comparable<T>> {
	
	private BTNode<T> root;
	
	public BinaryTree() {
		this.setRoot(null);
	}// Ending bracket of constructor
	
	public BinaryTree(BTNode<T> newRoot) {
		this.setRoot(newRoot);
	}// Ending bracket of constructor
	
	private void setRoot(BTNode<T> newRoot) {
		this.root = newRoot;
	}// Ending bracket of method setRoot
	
	public BTNode<T> getRoot() {
		return this.root;
	}// Ending bracket of method getRoot
	
	private boolean containsNodeRecursive(BTNode<T> current, int value) {
	    if (current == null) {
	        return false;
	    } 
	    if (value == current.value) {
	        return true;
	    } 
	    return value < current.value
	      ? containsNodeRecursive(current.left, value)
	      : containsNodeRecursive(current.right, value);
	}
	
	public String preorder() {
		return this.internalPreOrder(this.root);
	}// Ending bracket of method preOrderTraversalFromRoot
	
	public String preorder(BTNode<T> node) {
		return this.internalPreOrder(node);
	}// Ending bracket of method preOrderTraversal
	
	private String internalPreOrder(BTNode<T> node) {
		StringBuffer sb = new StringBuffer();
		
		if(node != null) {
			sb.append(node.toString());
			sb.append(" ");
			sb.append(this.internalPreOrder(node.getLeft()));
			sb.append(this.internalPreOrder(node.getRight()));
		}// Ending bracket of if
		
		return sb.toString();
	}// Ending bracket of method internalPreOrder
	
	
	
	
	
	
}// Ending bracket of class BinaryTree
