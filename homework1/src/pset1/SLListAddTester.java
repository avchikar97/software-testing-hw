// Name: Akaash Chikarmane
// UTEID: avc536
// Assignment: Software Testing (EE 360T) - Problem Set #1
// Problem: 1.2 Testing add()

package pset1;

import org.junit.Test;
import static org.junit.Assert.*;

public class SLListAddTester {
    @Test public void test0() {
        SLList l = new SLList();
        assertTrue(l.repOk());
        l.add(true);
        // write a sequence of assertTrue method invocations that
        // perform checks on the values for all the declared fields
        // of list and node objects reachable from l
        assertTrue(l.header != null);
        // your code goes here
        assertTrue(l.header.elem);
    }
    @Test public void test1() {
        SLList l = new SLList();
        assertTrue(l.repOk());
        l.add(true);
        assertTrue(l.repOk());
        l.add(false);
        assertTrue(l.repOk());
        // write a sequence of assertTrue method invocations that
        // perform checks on the values for all the declared fields
        // of list and node objects reachable from l
        assertTrue(l.header != null);
        // your code goes here
        assertFalse(l.header.elem);
        assertNotNull(l.header.next);
        assertTrue(l.header.next.elem);
        assertNull(l.header.next.next);
    }
}