package edu.mtc.egr283.project08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

	public void levelOrderTraversal(BTNode<T> rootNode) {
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(rootNode);
		
		while(!queue.isEmpty()) {
			
			BTNode<T> tempNode=queue.poll();
			System.out.print(tempNode.toString());
			
			if(tempNode.getLeft()!=null) {
				queue.add(tempNode.getLeft());
			}
			
			if(tempNode.getRight()!=null) {
				queue.add(tempNode.getRight());
			}
			
		}
	}
	
	public void inOrderTraversal(BTNode<T> node) {

	    //We will continue until null or empty node is found
	    if (node != null) {

	        //visit the left subtree until the leaf node
	        inOrderTraversal(node.getLeft());

	        //Print the node
	        System.out.println(node.toString());

	        //process the same step for the right node
	        inOrderTraversal(node.getRight());
	    }
	}
	
	public void preOrderTraversal(BTNode<T> node) {

	    //We will continue until null or empty node is found
	    if (node != null) {

	        //Print the node
	        System.out.println(node.toString());
	    	
	    	//visit the left subtree until the leaf node
	        preOrderTraversal(node.getLeft());

	        //process the same step for the right node
	        preOrderTraversal(node.getRight());
	    }
	}
	
	public void maints(BTNode<T> node) {
		// Base Case
        if (node == null) {
            return;
        }
 
        // Create an empty stack and push root to it
        Stack<BTNode> nodeStack = new Stack<BTNode>();
        nodeStack.push(root);
        while (nodeStack.empty() == false) {
            BTNode<T> mynode = nodeStack.peek();
            System.out.println(mynode.toString());
            nodeStack.pop();
            if (mynode.getRight() != null) {
                nodeStack.push(mynode.getRight());
            }
            if (mynode.getLeft() != null) {
                nodeStack.push(mynode.getLeft());
            }
        }
	}
	
	private void postOrderTraversal(BTNode<T> node) {

	    //We will continue until null or empty node is found
	    if (node != null) {

	    	//visit the left subtree until the leaf node
	        postOrderTraversal(node.getLeft());

	        //process the same step for the right node
	        postOrderTraversal(node.getRight());
	        
	      //Print the node
	        System.out.println(node.toString());
	    }
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
