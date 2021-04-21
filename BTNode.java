package edu.mtc.egr283.project08;

/**
 * BTNode program
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/28/2021
 * @version 1.00 04.20.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class BTNode<T extends Comparable<T>> {

	private T data;
	private BTNode<T> left;
	private BTNode<T> right;

	/**
	 * Default Constructor
	 */
	public BTNode() {
		this(null);
	}// Ending bracket of default "no-args" constructor

	/**
	 * Constructor
	 * @param newData
	 */
	public BTNode(T newData) {
		this(newData, null, null);
	}// Ending bracket of constructor

	/**
	 * Constructor
	 * @param newData
	 * @param newLeft
	 * @param newRight
	 */
	public BTNode(T newData, BTNode<T> newLeft, BTNode<T> newRight) {
		this.setData(newData);
		this.setLeft(newLeft);
		this.setRight(newRight);
	}// Ending bracket of constructor

	/**
	 * returns int
	 * @param otherNode
	 * @return int -1, 1, 0 
	 */
	public int compareTo(BTNode<T> otherNode) {
		return this.getData().compareTo(otherNode.getData());
	}// Ending bracket of method compareTo

	/**
	 *toString method
	 */
	@Override
	public String toString() {
		return this.data.toString();
	}// Ending bracket of method toString

	/**
	 * gets the node data
	 * @return Node data T
	 */
	public T getData() {
		return this.data;
	}// Ending bracket of method getData

	/**
	 * sets the node data
	 * @param newData
	 */
	public void setData(T newData) {
		this.data = newData;
	}// Ending bracket of method setData

	/**
	 * gets the left node
	 * @return BTNode
	 */
	public BTNode<T> getLeft() {
		return this.left;
	}// Ending bracket of method getLeft

	/**
	 * sets the left node
	 * @param newLeft
	 */
	public void setLeft(BTNode<T> newLeft) {
		this.left = newLeft;
	}// Ending bracket of method setLeft

	/**
	 * gets the right node
	 * @return BTNode
	 */
	public BTNode<T> getRight() {
		return this.right;
	}// Ending bracket of method getRight

	/**
	 * Sets the right node
	 * @param newRight
	 */
	public void setRight(BTNode<T> newRight) {
		this.right = newRight;
	}// Ending bracket of method setRight

}// Ending bracket of class BTNode