package edu.mtc.egr283.project08;

import java.util.Random;

/**
 * Binary Tree Driver
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/28/2021
 * @version 1.02 04.20.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */

public class BinaryTreeDriver {

	public static void main(String[] args) {
		//Testing constructors
		BTNode<Integer> one = new BTNode<Integer>(1);
		BTNode<Integer> two = new BTNode<Integer>(2);
		BTNode<Integer> three = new BTNode<Integer>(3);
		BTNode<Integer> four = new BTNode<Integer>(4);
		BTNode<Integer> five = new BTNode<Integer>(5);
		BTNode<Integer> six = new BTNode<Integer>(6);
		BTNode<Integer> seven = new BTNode<Integer>(7);
		BTNode<Integer> eight = new BTNode<Integer>(8);
		BTNode<Integer> nine = new BTNode<Integer>(9);		
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		bt = new BinaryTree<Integer>(one);
		
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		six.setLeft(eight);
		six.setRight(nine);

		System.out.println(bt.toString());
		System.out.println("PreOrder "+bt.preorder(one));
		bt.removeNode(nine);
		System.out.println("InOrder "+bt.inorder(one));
		bt.removeNode(eight);
		System.out.println("PostOrder "+bt.postorder(one));
		bt.removeNode(seven);
		System.out.println("LevelOrder "+bt.levelorder(one));
		seven = new BTNode<Integer>(7,nine,eight);
		bt.addNode(seven);
		System.out.println("toString \n"+bt.toString());
		
		System.out.println("\nTesting toString() method");
		Random random = new Random();
		BTNode<Integer>[] arr = new BTNode[50];	
		
		arr[0]=new BTNode<Integer>((1000));
		bt = new BinaryTree<Integer>(arr[0]);
		for(int i=1; i<50; i++) {
			arr[i]=new BTNode<Integer>((random.nextInt(2000)));
			bt.addNode(arr[i]);
		}//edn of for
		System.out.println(bt.toString());
		
		
	}// Ending bracket of method main
}// Ending bracket of class BinaryTreeDriver

	
	
	
	
	
	
	
	
	
	