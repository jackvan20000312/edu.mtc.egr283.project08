package edu.mtc.egr283.project08;

public class BTNode<T extends Comparable<T>> {

	private T data;
	private BTNode<T> left;
	private BTNode<T> right;

	public BTNode() {
		this(null);
	}// Ending bracket of default "no-args" constructor

	public BTNode(T newData) {
		this(newData, null, null);
	}// Ending bracket of constructor

	public BTNode(T newData, BTNode<T> newLeft, BTNode<T> newRight) {
		this.setData(newData);
		this.setLeft(newLeft);
		this.setRight(newRight);
	}// Ending bracket of constructor

	public int compareTo(BTNode<T> otherNode) {
		return this.getData().compareTo(otherNode.getData());
	}// Ending bracket of method compareTo

	@Override
	public String toString() {
		return this.data.toString();
	}// Ending bracket of method toString

	public T getData() {
		return this.data;
	}// Ending bracket of method getData

	public void setData(T newData) {
		this.data = newData;
	}// Ending bracket of method setData

	public BTNode<T> getLeft() {
		return this.left;
	}// Ending bracket of method getLeft

	public void setLeft(BTNode<T> newLeft) {
		this.left = newLeft;
	}// Ending bracket of method setLeft

	public BTNode<T> getRight() {
		return this.right;
	}// Ending bracket of method getRight

	public void setRight(BTNode<T> newRight) {
		this.right = newRight;
	}// Ending bracket of method setRight

}// Ending bracket of class BTNode