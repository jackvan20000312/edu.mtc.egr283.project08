package edu.mtc.egr283.project08;

public class BinaryTreeDriver {
	
	public static void main(String[] args) {
		BTNode<String> one = new BTNode<String>("1");
		BTNode<String> two = new BTNode<String>("2");
		BTNode<String> three = new BTNode<String>("3");
		BTNode<String> four = new BTNode<String>("4");
		BTNode<String> five = new BTNode<String>("5");
		BTNode<String> six = new BTNode<String>("6");
		BTNode<String> seven = new BTNode<String>("7");
		BTNode<String> eight = new BTNode<String>("8");
		BTNode<String> nine = new BTNode<String>("9");
		
		BinaryTree<String> bt = new BinaryTree<String>(one);
		one.setLeft(two);
		one.setRight(five);
		two.setLeft(three);
		two.setRight(four);
		five.setLeft(six);
		five.setRight(nine);
		six.setLeft(seven);
		six.setRight(eight);
		
		System.out.println(bt.preorder());
		
	}// Ending bracket of method main
	
}// Ending bracket of class BinaryTreeDriver
