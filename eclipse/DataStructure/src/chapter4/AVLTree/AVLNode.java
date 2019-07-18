package chapter4.AVLTree;

public class AVLNode<AnyType> implements Comparable<AnyType>{
	public AVLNode(AnyType theElement) {
		// TODO Auto-generated constructor stub
		this(theElement,null,null);
		
	}

	public AVLNode(AnyType theElement, AVLNode<AnyType> lt, AVLNode<AnyType> rt) {
		// TODO Auto-generated constructor stub
		this.element = theElement;
		this.left = lt;
		this.right = rt;
		this.height = 0;
	}
	
	AnyType element; // the data in the node
	AVLNode<AnyType> left; //left child
	AVLNode<AnyType> right; //right child
	int height;				//height
	
	@Override
	/*
	 * the rule of comparing two elements should be defined by urself
	 */
	public int compareTo(AnyType o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
