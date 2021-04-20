package edu.mtc.egr283.project08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
	static BTNode<String> one = new BTNode<String>("1");
	static BTNode<String> two = new BTNode<String>("2");
	static BTNode<String> three = new BTNode<String>("3");
	static BTNode<String> four = new BTNode<String>("4");
	static BTNode<String> five = new BTNode<String>("5");
	static BTNode<String> six = new BTNode<String>("6");
	static BTNode<String> seven = new BTNode<String>("7");
	static BTNode<String> eight = new BTNode<String>("8");
	static BTNode<String> nine = new BTNode<String>("9");

	static BinaryTree<String> bt = new BinaryTree<String>(one);

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
	 * @param newRoot
	 */
	private void setRoot(BTNode<T> newRoot) {
		this.root = newRoot;
	}// Ending bracket of method setRoot

	/**
	 * @return
	 */
	public BTNode<T> getRoot() {
		return this.root;
	}// Ending bracket of method getRoot

	/**
	 * @param nod
	 */
	public void remove(BTNode<T> nod) {
		if(nod != null) {
			if(nod==this.getRoot()) {
				this.setRoot(null);
				return;
			}//Ending bracket of if statement.
			Stack<BTNode> nodeStack = new Stack<BTNode>();
			nodeStack.push(root);
			while (nodeStack.empty() == false) {
				BTNode<T> mynode = nodeStack.peek();
				nodeStack.pop();
				if (mynode.getRight() != null) {
					if(mynode.getRight()==nod) {
						mynode.setRight(null);
						return;
					}//Ending bracket of if statement.
					nodeStack.push(mynode.getRight());
				}if (mynode.getLeft() != null) {
					if(mynode.getLeft()==nod) {
						mynode.setLeft(null);
						return;
					}//Ending bracket of if statement.
					nodeStack.push(mynode.getLeft());
				}//Ending bracket of if statement.
			}//Ending Bracket of a While Loop
		}//Ending bracket of if statement.
	}
	
	/**
	 * @return
	 */
	public String preorder() {
		return this.preOrderTraversal(this.root);
	}// Ending bracket of method preOrderTraversalFromRoot

	/**
	 * @param node
	 * @return
	 */
	public String preorder(BTNode<T> node) {
		return this.preOrderTraversal(node);
	}// Ending bracket of method preOrderTraversal

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

	
	public static void main(String[] args) {
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		four.setLeft(eight);
		four.setRight(nine);

		long start1,end1,diff1,diff2 = 0;

		System.out.println(bt.levelOrderTraversal(bt.getRoot()));
		bt.remove(four);
		System.out.println(bt.levelOrderTraversal(bt.getRoot()));

		/*Testing fastest method for printing a whole tree.(preorderIterative seems to be fastest.*/
		//		for(int i=0; i<10000000; i++) {
		//		start1 = System.nanoTime();
		//		bt.preOrderTraversal(one);
		//		end1 = System.nanoTime();
		//		diff1 = end1-start1;
		//		if(i>1) {
		//			diff2+=diff1;
		//		}
		//		}System.out.println((diff2/9999999));
		//		diff2 = 0;
		//		for(int i=0; i<10000000; i++) {
		//		start1 = System.nanoTime();
		//		bt.levelOrderTraversal(one);
		//		end1 = System.nanoTime();
		//		diff1 = end1-start1;
		//		if(i>1) {
		//			diff2+=diff1;
		//		}
		//		}System.out.println((diff2/9999999));
		//		diff2 = 0;
		//		for(int i=0; i<10000000; i++) {
		//		start1 = System.nanoTime();
		//		bt.inOrderTraversal(one);
		//		end1 = System.nanoTime();
		//		diff1 = end1-start1;
		//		if(i>1) {
		//			diff2+=diff1;
		//		}
		//		}System.out.println((diff2/9999999));
		//		diff2 = 0;
		//		for(int i=0; i<10000000; i++) {
		//		start1 = System.nanoTime();
		//		bt.postOrderTraversal(one);
		//		end1 = System.nanoTime();
		//		diff1 = end1-start1;
		//		if(i>1) {
		//			diff2+=diff1;
		//		}
		//		}System.out.println((diff2/9999999));
		//		diff2 = 0;
		//		for(int i=0; i<10000000; i++) {
		//		start1 = System.nanoTime();
		//		bt.inOrderIterative(one);
		//		end1 = System.nanoTime();
		//		diff1 = end1-start1;
		//		if(i>1) {
		//			diff2+=diff1;
		//		}
		//		}System.out.println((diff2/9999999));
		//		diff2 = 0;
		//		for(int i=0; i<10000000; i++) {
		//		start1 = System.nanoTime();
		//		bt.preOrderIterative(one);
		//		end1 = System.nanoTime();
		//		diff1 = end1-start1;
		//		if(i>1) {
		//			diff2+=diff1;
		//		}
		//		}System.out.println((diff2/9999999));
		//		diff2 = 0;
		//		for(int i=0; i<10000000; i++) {
		//		start1 = System.nanoTime();
		//		bt.postOrderIterative(one);
		//		end1 = System.nanoTime();
		//		diff1 = end1-start1;
		//		if(i>1) {
		//			diff2+=diff1;
		//		}
		//		}System.out.println((diff2/9999999));
		//		diff2 = 0;
		//		for(int i=0; i<10000000; i++) {
		//		start1 = System.nanoTime();
		//		bt.postOrderIterative2(one);
		//		end1 = System.nanoTime();
		//		diff1 = end1-start1;
		//		if(i>1) {
		//			diff2+=diff1;
		//		}
		//		}System.out.println((diff2/9999999));
		//		
		//System.out.println("\n"+bt.preorder());
	}// Ending bracket of method main

}// Ending bracket of class BinaryTree