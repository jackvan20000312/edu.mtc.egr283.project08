package edu.mtc.egr283.project08;

/**
 * Binary Tree Program
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/28/2021
 * @version 1.02 04.20.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.io.PrintStream;

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
		this.setRoot(this.addRecursive( newNode, this.getRoot()));
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
						if(mynode.getRight().getRight()!=null&&mynode.getRight().getLeft()!=null) {
							return;
						}else if(mynode.getRight().getRight()!=null) {
							mynode.setRight(mynode.getRight().getRight());
							return;
						}else if(mynode.getRight().getLeft()!=null) {
							mynode.setRight(mynode.getRight().getLeft());
							return;
						}else {
						mynode.setRight(null);
						return;
						}
					}//Ending bracket of if statement.
					nodeStack.push(mynode.getRight());
				}if (mynode.getLeft() != null) {
					if(mynode.getLeft()==removeNode) {
						if(mynode.getLeft().getRight()!=null&&mynode.getLeft().getLeft()!=null) {
							return;
						}else if(mynode.getLeft().getRight()!=null) {
							mynode.setLeft(mynode.getLeft().getRight());
							return;
						}else if(mynode.getLeft().getLeft()!=null) {
							mynode.setLeft(mynode.getLeft().getLeft());
							return;
						}else {
						mynode.setLeft(null);
						return;
						}
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
	 *Uses Print2D for to String
	 */
	public String toString() {
		return this.printTree2D();
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
	private BTNode<T> addRecursive(BTNode<T> newNode, BTNode<T> rootNode) {
		if(rootNode==null) {
			rootNode = newNode;
			return newNode;
		}else if(newNode.compareTo(rootNode)<0) {
			rootNode.setRight(this.addRecursive(newNode, rootNode.getRight()));
		} else if(newNode.compareTo(rootNode)>=0) {
			rootNode.setLeft(this.addRecursive(newNode, rootNode.getLeft()));
		}//Ending bracket of if statement.
		return rootNode;
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



	//EVERYTHING BELOW HERE IS NOT REQUIRED (Just for my enjoyment) 
	//may not have JavaDocs
	
	
	/**
	 * A cool tree 2d printer method I found online
	 * @param sb
	 * @param padding
	 * @param pointer
	 * @param node
	 * @param hasRightSibling
	 */
	public void traverseNodes(StringBuffer sb, String padding, String pointer, BTNode<T> node,  boolean hasRightSibling) {
		if (node != null) {
			sb.append("\n");
			sb.append(padding);
			sb.append(pointer);
			sb.append(node.getData().toString());

			StringBuffer paddingBuilder = new StringBuffer(padding);
			if (hasRightSibling) {
				paddingBuilder.append("|  ");
			} else {
				paddingBuilder.append("   ");
			}

			String paddingForBoth = paddingBuilder.toString();
			String pointerRight = "'--";
			String pointerLeft = (node.getRight() != null) ? "|--" : "'--";

			traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
			traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
		}
	}
	
	/**
	 *  A cool tree 2d printer method I found online
	 * @param root
	 * @return
	 */
	public String traversePreOrder(BTNode<T> root) {
		if (root == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(root.getData().toString());

		String pointerRight = "'--";
		String pointerLeft = (root.getRight() != null) ? "|--" : "'--";

		traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
		traverseNodes(sb, "", pointerRight, root.getRight(), false);

		return sb.toString();
	}

	/**
	 *  A cool tree 2d printer method I found online
	 * @return
	 */
	public String printTree2D() {
		return (traversePreOrder(this.getRoot()));
	}

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