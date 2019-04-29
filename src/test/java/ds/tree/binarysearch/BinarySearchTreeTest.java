package ds.tree.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchTreeTest {
	
	private final BinarySearchTree binarySearchTree = new BinarySearchTree();
    
	@Test 
    public void testBinarySearchTree() {
    	
    	System.out.println("***********BINARY TREE*****************");
    	binarySearchTree.print();
    	System.out.println("****************************");
    	
    	binarySearchTree.insert(20);
    	binarySearchTree.insert(10);
    	binarySearchTree.insert(30);
    	binarySearchTree.insert(100);
    	binarySearchTree.insert(50);
    	binarySearchTree.insert(300);
    	binarySearchTree.insert(5);
    	binarySearchTree.insert(1);
    	binarySearchTree.insert(25);
    	binarySearchTree.insert(35);
    	
    	System.out.println("***********BINARY TREE*****************");
    	binarySearchTree.print();
    	System.out.println("****************************");
    	
    	Assert.assertTrue(binarySearchTree.find(100));
    	System.out.println("Found 100 in tree :" + binarySearchTree.find(100));
    	
    	Assert.assertTrue(binarySearchTree.find(300));
    	System.out.println("Found 500 in tree :" + binarySearchTree.find(500));
    	
    	Assert.assertTrue(binarySearchTree.find(20));
    	Assert.assertTrue(binarySearchTree.find(10));
    	Assert.assertTrue(binarySearchTree.find(30));
    	Assert.assertTrue(binarySearchTree.find(100));
    	Assert.assertTrue(binarySearchTree.find(50));
    	Assert.assertTrue(binarySearchTree.find(300));
    	Assert.assertTrue(binarySearchTree.find(5));
    	Assert.assertTrue(binarySearchTree.find(1));
    	Assert.assertTrue(binarySearchTree.find(25));
    	Assert.assertTrue(binarySearchTree.find(35));
    	
    	Assert.assertFalse(binarySearchTree.delete(500));
    	Assert.assertTrue(binarySearchTree.delete(20));
    	binarySearchTree.print();
	}
}
	
	