package linkedListTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import linkedList.LinkedList;

/**
 * Classe de testes para uma lista duplamente encadeada
 * @author Jonatha Kennedy
 *
 */
class LinkedListTest {
	LinkedList ll1;
	LinkedList ll2;
	@BeforeEach
	void setUp() throws Exception {
		ll1 = new LinkedList();
		ll2 = new LinkedList();
		ll2.addLast(85);
	}

	@Test
	void testIsEmpty() {
		assertTrue(ll1.isEmpty());
		assertFalse(ll2.isEmpty());
	}

	@Test
	void testAddLast() {
		ll1.addLast(75);
		assertEquals("75 ", ll1.toString());
		ll2.addLast(73);
		assertEquals("85 73 ", ll2.toString());
	}

	@Test
	void testSoma() {
		assertEquals(0, ll1.soma());
		assertEquals(85, ll2.soma());
		ll2.addLast(3);
		assertEquals(88, ll2.soma());
		ll2.addLast(100);
		assertEquals(188, ll2.soma());
	}

	@Test
	void testIsSorted() {
		assertTrue(ll1.isSorted());
		assertTrue(ll2.isSorted());
		ll1.addLast(88);
		assertTrue(ll1.isSorted());
		ll1.addLast(70);
		assertFalse(ll1.isSorted());
		ll2.addLast(88);
		assertTrue(ll2.isSorted());
		ll2.addLast(89);
		assertTrue(ll2.isSorted());
		ll2.addLast(90);
		assertTrue(ll2.isSorted());
		ll2.addLast(120);
		assertTrue(ll2.isSorted());
		
		ll2.addLast(110);
		assertFalse(ll2.isSorted());
	}

	@Test
	void testAdd() {
		ll2.add(1, 8);
		assertEquals("85 8 ", ll2.toString());
		ll1.add(0, 30);
		assertEquals("30 ", ll1.toString());
		ll1.addLast(50);
		ll1.addLast(10);
		ll1.addLast(60);
		ll1.addLast(70);
		assertEquals(5, ll1.size());
		assertEquals("30 50 10 60 70 ", ll1.toString());
		ll1.add(5, 55);
		assertEquals(6, ll1.size());
		assertEquals("30 50 10 60 70 55 ", ll1.toString());
		ll1.add(3, 79);
		assertEquals(7, ll1.size());
		assertEquals("30 50 10 79 60 70 55 ", ll1.toString());
		ll1.add(4, 45);
		assertEquals(8, ll1.size());
		assertEquals("30 50 10 79 45 60 70 55 ", ll1.toString());
		ll1.add(9, 100);
		assertEquals(8, ll1.size());
		assertEquals("30 50 10 79 45 60 70 55 ", ll1.toString());
		ll1.add(-9, 100);
		assertEquals(8, ll1.size());
		assertEquals("30 50 10 79 45 60 70 55 ", ll1.toString());
		ll1.add(0, 300);
		assertEquals("300 30 50 10 79 45 60 70 55 ", ll1.toString());
	}

	@Test
	void testRemove() {
		assertEquals(1, ll2.size());
		
		ll2.remove(0);
		assertTrue(ll2.isEmpty());
		assertEquals(0, ll2.size());
		
		ll2.remove(0);
		assertTrue(ll2.isEmpty());
		assertEquals(0, ll2.size());
		
		ll2.addLast(80);
		ll2.addLast(70);
		ll2.addLast(50);
		assertEquals(3, ll2.size());
		ll2.addLast(60);
		assertEquals(4, ll2.size());
		ll2.addLast(88);
		
		ll2.remove(0);
		assertEquals("70 50 60 88 ", ll2.toString());
		assertEquals(4, ll2.size());
		
		ll2.remove(3);
		assertEquals("70 50 60 ", ll2.toString());
		assertEquals(3, ll2.size());
		
		ll2.remove(1);
		assertEquals("70 60 ", ll2.toString());
		assertEquals(2, ll2.size());
		
	}
}
