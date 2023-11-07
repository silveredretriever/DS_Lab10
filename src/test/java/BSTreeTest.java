import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTreeTest {

	BSTree tree1;
	BSTree tree2;
	BSTree tree3;
	BSTree tree4;
	
	@BeforeEach
	void setUp() throws Exception {
		tree1 = new BSTree();
		tree2 = new BSTree();
		tree3 = new BSTree();
		tree4 = new BSTree();
	}

	@Test
	void testEmptyAndRootInsertRetrieve() {
		// Asserting that it's empty to begin with
		assertTrue(tree1.isEmpty());
		tree1.insert(6);
		// Asserting that it's not empty anymore
		assertFalse(tree1.isEmpty());
		// Checking that the value is at the root (depth 0)
		assertEquals(0, tree1.retrieveDepth(6));
	}
	
	@Test
	void testInsertRetrieve() {
		// Throwing in values
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(25);
		// Checking that 5 and 25 went to the right place
		assertEquals(1, tree1.retrieveDepth(5));
		assertEquals(1, tree1.retrieveDepth(25));
		// Retrieving something that's not there
		assertNull(tree1.retrieve(20));
		// Big line of values
		tree1.insert(23);
		tree1.insert(19);
		tree1.insert(18);
		assertEquals(4, tree1.retrieveDepth(18));
		// Checking that 24 goes to the right spot
		tree1.insert(24);
		assertEquals(3, tree1.retrieveDepth(24));
	}
	
	@Test
	void testCountSize() {
		// Empty tree testing
		assertEquals(0, tree1.getSize());
		assertNull(tree1.largest());
		// Throwing in values
		tree1.insert(10);
		// Just the root
		assertEquals(10, tree1.largest().intValue());
		// More values
		tree1.insert(5);
		tree1.insert(25);
		// Checking the amount of nodes
		assertEquals(3, tree1.getSize());
		// Check that largest is 25
		assertEquals(25, tree1.largest().intValue());
		// More values
		tree1.insert(27);
		tree1.insert(26);
		tree1.insert(6);
		tree1.insert(3);
		// Checking the amount of nodes
		assertEquals(7, tree1.getSize());
		// Check that largest is 27
		assertEquals(27, tree1.largest().intValue());
		
		//lets go deeper
		tree1.insert(30);
		tree1.insert(40);
		tree1.insert(99);
		tree1.insert(100);
		assertEquals(100, tree1.largest().intValue());
	}

	@Test
	void testToListSum() {
		// Throwing in values
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(25);
		tree1.insert(27);
		tree1.insert(6);
		tree1.insert(3);
		// Check toList
		List<Integer> tree1List = tree1.toList();
		List<Integer> checkList = new ArrayList<Integer>();
		checkList.add(3);
		checkList.add(5);
		checkList.add(6);
		checkList.add(10);
		checkList.add(25);
		checkList.add(27);
		assertTrue(tree1List.equals(checkList));
		// Check sum
		assertEquals(76, tree1.sum());
		// I don't wanna comment this
		tree1.insert(4);
		tree1List = tree1.toList();
		assertFalse(tree1List.equals(checkList));
		// Check sum
		assertEquals(80, tree1.sum());
		
		checkList.add(1, 4);
		tree1.insert(2);
		tree1List = tree1.toList();
		assertFalse(tree1List.equals(checkList));
		assertEquals(82, tree1.sum());
	}
	
	@Test
	void testTreeToTree() {
		assertTrue(tree1.myEquals(tree2));
		// Throwing in values
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(25);
		// Full compared to empty
		assertFalse(tree1.myEquals(tree2));
		// Empty compared to full
		assertFalse(tree2.myEquals(tree1));
		// Throwing in values (second tree)
		tree2.insert(10);
		tree2.insert(5);
		tree2.insert(25);
		// Asserting they're equal
		assertTrue(tree1.myEquals(tree2));
		tree1.insert(0);
		// Asserting they're not equal
		assertFalse(tree1.myEquals(tree2));
		tree2.insert(0);
		// Asserting they're equal
		assertTrue(tree1.myEquals(tree2));
		tree2.insert(8);
		assertFalse(tree1.myEquals(tree2));
		tree1.insert(9);
		assertFalse(tree1.myEquals(tree2));
	}
	
	@Test
	void testTreeToTreeTwo() {
		// Throwing in values
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(25);
		// Throwing in values (second tree)
		tree2.insert(5);
		tree2.insert(10);
		tree2.insert(25);
		// Not equal
		assertFalse(tree1.myEquals(tree2));
	}
	
	@Test
	void testTreeToTreeThree() {
		// Throwing in values
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(25);
		tree1.insert(26);
		// Throwing in values (second tree)
		tree2.insert(10);
		tree2.insert(5);
		tree2.insert(25);
		tree2.insert(27);
		tree2.insert(26);
		//
		assertFalse(tree1.myEquals(tree2));
		// Throwing in values
		tree3.insert(10);
		tree3.insert(5);
		tree3.insert(26);
		//
		assertFalse(tree1.myEquals(tree3));
		// Throwing in values (fourth tree)
		tree4.insert(10);
		tree4.insert(5);
		tree4.insert(25);
		tree4.insert(27);
		tree4.insert(26);
		tree4.insert(15);
		//
		assertFalse(tree1.myEquals(tree4));
		assertFalse(tree2.myEquals(tree4));
	}
}
