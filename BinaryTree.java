package edu.mtc.egr283.project08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
	private BTNode<T> root;

	/**
	 * Default Constructor
	 */
	public BinaryTree() {
		this.setRoot(null);
	}// Ending bracket of constructor

	/**
	 * Constructor
	 * @param BTNode<T> newRoot
	 */
	public BinaryTree(BTNode<T> newRoot) {
		this.setRoot(newRoot);
	}// Ending bracket of constructor

	/**
	 * Returns root node
	 * @return
	 */
	public BTNode<T> getRoot() {
		return this.root;
	}// Ending bracket of method getRoot

	/**
	 * Adds a node in the Binary Tree
	 * @param newNode
	 */
	public void addNode(BTNode<T> newNode) {
		this.addRecursive(newNode, this.getRoot());
	}//Ending Bracket of Method
	
	/**
	 * Removes a node in the Binary Tree
	 * @param removeNode
	 */
	public void removeNode(BTNode<T> removeNode) {
		if(removeNode != null) {
			if(removeNode==this.getRoot()) {
				this.setRoot(null);
				return;
			}//Ending bracket of if statement.
			Stack<BTNode> nodeStack = new Stack<BTNode>();
			nodeStack.push(root);
			while (nodeStack.empty() == false) {
				BTNode<T> mynode = nodeStack.peek();
				nodeStack.pop();
				if (mynode.getRight() != null) {
					if(mynode.getRight()==removeNode) {
						mynode.setRight(null);
						return;
					}//Ending bracket of if statement.
					nodeStack.push(mynode.getRight());
				}if (mynode.getLeft() != null) {
					if(mynode.getLeft()==removeNode) {
						mynode.setLeft(null);
						return;
					}//Ending bracket of if statement.
					nodeStack.push(mynode.getLeft());
				}//Ending bracket of if statement.
			}//Ending Bracket of a While Loop
		}//Ending bracket of if statement.
	}//Ending Bracket of Method

	/**
	 * Returns a string starting from a specified root node
	 * @param your root node
	 * @return preorder String
	 */
	public String preorder(BTNode<T> node) {
		return this.preOrderTraversal(node);
	}// Ending bracket of method preOrderTraversal

	/**
	 * Returns a string starting from a specified root node
	 * @param your root node
	 * @return inorder String
	 */
	public String inorder(BTNode<T> node) {
		return this.inOrderTraversal(node);
	}// Ending bracket of method preOrderTraversal
	
	/**
	 * Returns a string starting from a specified root node
	 * @param your root node
	 * @return postorder String
	 */
	public String postorder(BTNode<T> node) {
		return this.postOrderTraversal(node);
	}// Ending bracket of method preOrderTraversal
	
	/**
	 * Returns a string starting from a specified root node
	 * @param your root node
	 * @return levelorder String
	 */
	public String levelorder(BTNode<T> node) {
		return this.levelOrderTraversal(node);
	}// Ending bracket of method preOrderTraversal
	
	/**
	 *Normal toString method
	 *Uses levelorder for to String
	 */
	public String toString() {
		return this.levelorder(this.getRoot());
	}//ending bracket of method
	
	//private methods below
	
	/**
	 * Sets the Root Node
	 * @param newRoot
	 */
	private void setRoot(BTNode<T> newRoot) {
		this.root = newRoot;
	}// Ending bracket of method setRoot
	
	/**
	 * adds a node using recursion
	 * @param newNode the new Node
	 * @param rootNode the starting node to add below
	 */
	private void addRecursive(BTNode<T> newNode, BTNode<T> rootNode) {
		if(rootNode==null) {
			rootNode = newNode;
		}else if(newNode.compareTo(rootNode)<0) {
			this.addRecursive(newNode, rootNode.getRight());
		} else if(newNode.compareTo(rootNode)>=0) {
			this.addRecursive(newNode, rootNode.getLeft());
		}//Ending bracket of if statement.
	}//Ending Bracket of Method
	
	/**
	 * preOrder Recursion-private method
	 * @param BTNode<T> node
	 * @return String of preOrder
	 */
	private String preOrderTraversal(BTNode<T> node) {
		StringBuffer sb = new StringBuffer();
		if(node != null) {
			sb.append(node.toString());
			sb.append(" ");
			sb.append(this.preOrderTraversal(node.getLeft()));
			sb.append(this.preOrderTraversal(node.getRight()));
		}//Ending bracket of if statement.
		return sb.toString();
	}// Ending bracket of method preOrderTraversal

	/**
	 * levelOrder traversal-private method
	 * @param BTNode<T> node
	 * @return String of levelOrder
	 */
	private String levelOrderTraversal(BTNode<T> rootNode) {
		StringBuffer sb = new StringBuffer();
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(rootNode);
		while(!queue.isEmpty()) {
			BTNode<T> tempNode=queue.poll();
			sb.append(tempNode.toString());
			sb.append(" ");
			System.out.println(tempNode.toString());
			if(tempNode.getLeft()!=null) {
				queue.add(tempNode.getLeft());
			}if(tempNode.getRight()!=null) {
				queue.add(tempNode.getRight());
			}//Ending bracket of if statement.
		}//Ending Bracket of a While Loop
		return sb.toString();
	}//Ending Bracket of Method

	/**
	 * inOrder Recursion-private method
	 * @param BTNode<T> node
	 * @return String of inOrder
	 */
	private String inOrderTraversal(BTNode<T> node) {
		StringBuffer sb = new StringBuffer();
		if(node != null) {
			sb.append(this.inOrderTraversal(node.getLeft()));
			sb.append(node.toString());
			sb.append(" ");
			sb.append(this.inOrderTraversal(node.getRight()));
		}//Ending bracket of if statement.
		return sb.toString();
	}//Ending Bracket of Method

	/**
	 * postOrder Recursion-private method
	 * @param BTNode<T> node
	 * @return String of postOrder
	 */
	private String postOrderTraversal(BTNode<T> node) {
		StringBuffer sb = new StringBuffer();
		if(node != null) {
			sb.append(this.postOrderTraversal(node.getLeft()));
			sb.append(this.postOrderTraversal(node.getRight()));
			sb.append(node.toString());
			sb.append(" ");
		}//Ending bracket of if statement.
		return sb.toString();
	}//Ending Bracket of Method

	
	
	//EVERYTHING BELOW HERE IS UNUSED (Just for my enjoyment) lol
	
	/**
	 * adds a node using iteration
	 * @param newNode the new Node
	 * @param rootNode the starting node to add below
	 */
	private void addIterative(BTNode<T> newNode, BTNode<T> rootNode) {
		boolean isDone=false;
		BTNode<T> tempNode=rootNode;
		if(tempNode==null) {
			tempNode= newNode;
			return;
		} //Ending bracket of if statement.
		do {
			if(newNode.compareTo(tempNode)<0 && tempNode.getRight()!=null) {
				tempNode=tempNode.getRight();
			}else if(newNode.compareTo(tempNode)>=0 && tempNode.getLeft()!=null) {
				tempNode=tempNode.getLeft();
			}else if(newNode.compareTo(tempNode)<0 && tempNode.getRight()==null) {
				tempNode.setRight(newNode);
				break;
			}else if(newNode.compareTo(tempNode)>=0 && tempNode.getLeft()==null) {
				tempNode.setRight(newNode);
				break;
			}//Ending bracket of if statement.
		}while(!isDone);
	}//Ending Bracket of Method

	/**
	 * inOrder Iteration-private method
	 * @param BTNode<T> node
	 * @return String of inOrder
	 */
	private String inOrderIterative(BTNode<T> node) {
		StringBuffer sb = new StringBuffer();
		if(node != null) {
			Stack<BTNode> s = new Stack<BTNode>();
			while (node != null || s.size() > 0){
				while (node !=  null){
					s.push(node);
					node = node.getLeft();
				}//Ending Bracket of a While Loop
				node = s.pop();
				sb.append(node.toString());
				sb.append(" ");
				node = node.getRight();
			}//Ending Bracket of a While Loop
		}//Ending bracket of if statement.
		return sb.toString();
	}//Ending Bracket of Method

	/**
	 * Pre Order Iteration-private method
	 * @param BTNode<T> node
	 * @return String of preOrder
	 */
	private String preOrderIterative(BTNode<T> node) {
		StringBuffer sb = new StringBuffer();
		if(node != null) {
			Stack<BTNode> nodeStack = new Stack<BTNode>();
			nodeStack.push(node);
			while (nodeStack.empty() == false) {
				BTNode<T> mynode = nodeStack.peek();
				sb.append(mynode.toString());
				sb.append(" ");
				nodeStack.pop();
				if (mynode.getRight() != null) {
					nodeStack.push(mynode.getRight());
				}if (mynode.getLeft() != null) {
					nodeStack.push(mynode.getLeft());
				}//Ending bracket of if statement.
			}//Ending Bracket of a While Loop
		}//Ending bracket of if statement.
		return sb.toString();
	}//Ending Bracket of Method

	/**
	 * Post Order Iteration-private method
	 * @param BTNode<T> node
	 * @return String of postOrder
	 */
	private String postOrderIterative(BTNode<T> node){
		StringBuffer sb = new StringBuffer();
		Stack<BTNode> s1 = new Stack<BTNode>();
		Stack<BTNode> s2 = new Stack<BTNode>();
		if(node != null) {
			s1.push(node);
			while (!s1.isEmpty()) {
				BTNode<T> temp = s1.pop();
				s2.push(temp);
				if (temp.getLeft() != null)
					s1.push(temp.getLeft());
				if (temp.getRight() != null)
					s1.push(temp.getRight());
			} while (!s2.isEmpty()) {
				BTNode<T> temp = s2.pop();
				sb.append(temp.toString());
				sb.append(" ");
			}//Ending Bracket of a While Loop
		}//Ending bracket of if statement.
		return sb.toString();
	}//Ending Bracket of Method

}// Ending bracket of class BinaryTree