// Name: Akaash Chikarmane
// UTEID: avc536
// Assignment: Software Testing (EE 360T) - Problem Set #1
// Problem: 1.3 Testing repOk()

package pset1;

import static org.junit.Assert.*;
import org.junit.Test;
import pset1.SLList.Node;

public class SLListRepOkTester {
    @Test public void t0() {
        SLList l = new SLList();
        assertTrue(l.repOk());
    }

    // Testing acyclic data structures w/ 1 element
    // Doesn't really matter what elem value is so go with default
    @Test public void t1() {
        SLList l = new SLList();
        Node n1 = new Node();
        // your code goes here
        n1.next = l.header;
        l.header = n1;
        assertTrue(l.repOk());
    }
    // Testing cyclical data structure w/ 1 element
    // Doesn't really matter what elem value is so go with default
    @Test public void t2(){
        SLList l = new SLList();
        Node n1 = new Node();
        // your code goes here
        n1.next = n1;
        l.header = n1;
        assertFalse(l.repOk());
    }
    // Testing acyclical data structure w/ 2 elements
    // Doesn't really matter what elem value is so go with default
    @Test public void t3(){
        SLList l = new SLList();
        Node n1 = new Node();
        Node n2 = new Node();
        // your code goes here
        n1.next = null;
        n2.next = n1;
        l.header = n2;
        assertTrue(l.repOk());
    }
    // Testing cyclical data structure w/ 2 elements
    // Doesn't really matter what elem value is so go with default
    @Test public void t4(){
        SLList l = new SLList();
        Node n1 = new Node();
        Node n2 = new Node();
        // your code goes here
        n1.next = n2;
        n2.next = n1;
        l.header = n2;
        assertFalse(l.repOk());
    }
}