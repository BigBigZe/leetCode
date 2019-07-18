package chapter4.AVLTree;

public class AVLTree<AnyType> {
	public int height(AVLNode<AnyType> t) {
		/*
		 * return -1, because if t is not null with no child,
		 * the height is 0,so null should be low two the height of its.
		 */
		
		return t==null?-1:t.height;
	}
	
	
	/**
	 * insert into a subtree
	 * @param x the item to insert
	 * @param t the node that roots the subtree
	 * @return the new root of the subtree
	 */
	public AVLNode<AnyType> insert(AnyType x, AVLNode<AnyType> t){
		if(t==null)return new AVLNode<AnyType>(x);
		
		int compareRes = t.compareTo(x);
		
		if(compareRes>0) t.right = insert(x, t.right);
		else if(compareRes<0) t.left = insert(x, t.left);
		else ;
		return balance(t);
	}



	public AVLNode<AnyType> balance(AVLNode<AnyType> t) {
		// TODO Auto-generated method stub
		if(t==null) return null;
		
		if(height(t.left)-height(t.right)>1) 
			if(height(t.left.left)>=height(t.left.right))
				t = rotateWithLeftChild(t);
			else
				t = doubleWithLeftChild(t);
		else if(height(t.right)-height(t.left)>1)
			if(height(t.right.right)>=height(t.right.left))
				t = rotateWithRightChild(t);
			else 
				t = doubleWithRightChild(t);
		
		t.height = Math.max(height(t.left), height(t.right))+1;
		
		return t;
	}


	private AVLNode<AnyType> doubleWithRightChild(AVLNode<AnyType> k3) {
		k3.right = rotateWithLeftChild(k3.right);
		return rotateWithRightChild(k3);
	}


	private AVLNode<AnyType> rotateWithRightChild(AVLNode<AnyType> k2) {
		AVLNode<AnyType> k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = Math.max(height(k2.left), height(k2.right))+1;
		k1.height = Math.max(height(k1.left), k2.height)+1;
		return k1;
	}


	private AVLNode<AnyType> rotateWithLeftChild(AVLNode<AnyType> k2) {
		// TODO Auto-generated method stub
		AVLNode<AnyType> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right))+1;
		k1.height = Math.max(height(k1.left), k2.height)+1;
		return k1;
	}

	//双旋转实际上就是旋转了两次单旋
	private AVLNode<AnyType> doubleWithLeftChild(AVLNode<AnyType> k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	
}
