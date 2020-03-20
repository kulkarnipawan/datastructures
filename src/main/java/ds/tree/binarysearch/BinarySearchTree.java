/**
 * 
 */
package ds.tree.binarysearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
		//Node is leaf node
		if(node.leftChild == null && node.rightChild == null) {
			if(parent.val > node.val) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}	
		} 
		//If node has no left child move the right child to its place
		else if(node.leftChild == null && node.rightChild != null) {
			if(parent.val > node.val) {
				parent.leftChild = node.rightChild;
			} else {
				parent.rightChild = node.rightChild;
			}
		} 
		//If node has no right child move the left child to its place
		else if(node.rightChild == null) {
			if(parent.val > node.val) {
				parent.leftChild = node.leftChild;
			} else {
				parent.rightChild = node.leftChild;
			}
		} 
		//Move leftmost child of right child to current node and call delete on that node.
		else {
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
	
	public List<Integer> getPreOrderList() {
		List<Integer> list = new ArrayList<>();
		traversePreOrder(root, list);
		return list;
	}
	
	private void traversePreOrder(Node node, List<Integer> list) {
		if(node == null) return;
		
		traversePreOrder(node.leftChild, list);
		list.add(node.val);
		traversePreOrder(node.rightChild, list);
	}
	
	public List<Integer> getInOrderList() {
		List<Integer> list = new ArrayList<>();
		traverseInOrder(root, list);
		return list;
	}
	
	private void traverseInOrder(Node node, List<Integer> list) {
		if(node == null) return;
		
		list.add(node.val);
		traverseInOrder(node.leftChild, list);
		traverseInOrder(node.rightChild, list);
	}

	public List<Integer> getPostOrderList() {
		List<Integer> list = new ArrayList<>();
		traversePostOrder(root, list);
		return list;
	}
	
	private void traversePostOrder(Node node, List<Integer> list) {
		if(node == null) return;
		
		traversePostOrder(node.rightChild, list);
		list.add(node.val);
		traversePostOrder(node.leftChild, list);
	}

}
