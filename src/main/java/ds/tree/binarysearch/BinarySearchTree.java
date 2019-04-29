/**
 * 
 */
package ds.tree.binarysearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pawankumar Kulkarni
 *
 */
public class BinarySearchTree {
	Node root;
	
	public boolean insert(int value) {
		boolean success = false;
		if(root == null) {
			root = new Node(value);
			success = true;
		} else {
			Node current = root;
			while(current != null && !success) {
				if(value < current.val) {
					if(current.leftChild == null) {
						current.leftChild = new Node(value);
						success = true;
					} else {
						current = current.leftChild;
					}
				} else if(value > current.val) {
					if(current.rightChild == null) {
						current.rightChild = new Node(value);
						success = true;
					} else {
						current = current.rightChild;
					}
				} else {
					current = null;
				}
			}
		}
		return success;
	}
	
	public boolean delete(int value) {
		boolean success = false;
		if(root != null) {
			Node current = root;
			Node parent = root;
			while(current != null && !success) {
				if(value < current.val) {
					parent = current;
					current = current.leftChild;
				} else if(value > current.val) {
					parent = current;
					current = current.rightChild;
				} else {
					success = true;
					delete(parent, current);
				}
			}
		}
		return success;
	}
	
	private void delete(Node parent, Node node) {
		if(node.leftChild == null && node.rightChild == null) {
			if(parent.val > node.val) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}	
		} else if(node.leftChild == null && node.rightChild != null) {
			if(parent.val > node.val) {
				parent.leftChild = node.rightChild;
			} else {
				parent.rightChild = node.rightChild;
			}
		} else if(node.rightChild == null) {
			if(parent.val > node.val) {
				parent.leftChild = node.leftChild;
			} else {
				parent.rightChild = node.leftChild;
			}
		} else {
			Node current = node.rightChild;
			Node prev = node;
			while(current.leftChild != null) {
				prev = current;
				current = current.leftChild;
			}
			node.val = current.val;
			delete(prev, current);
		}
	}
	
	public boolean find(int value) {
		boolean found = false;
		if(root != null) {
			Node current = root;
			while(current != null && !found) {
				if(value < current.val) {
					current = current.leftChild;
				} else if(value > current.val) {
					current = current.rightChild;
				} else {
					found = true;
				}
			}
		}
		return found;
	}
	
	public void print() {
		if(root != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(null);
			int count=10;
			for(int i=0;i<count;i++)
				System.out.print("\t");
			count--;
			Node node = null, prev;
			while(!queue.isEmpty()) {
				prev = node;
				node = queue.remove();
				if(node == null) {
					if(prev != null) {
						System.out.println("");
						for(int i=0;i<count;i++)
							System.out.print("\t");
						count--;
						queue.add(null);
					}
				} else { 
					System.out.print(node.val + "\t\t");
					if(node.leftChild != null)
						queue.add(node.leftChild);
					if(node.rightChild != null)
						queue.add(node.rightChild);
				}
			}
		}		
	}

}
