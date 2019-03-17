// Name: Akaash Chikarmane
// UTEID: avc536
// Assignment: Software Testing (EE 360T) - Problem Set #1
// Problem: 2.2 Testing hashCode()

package pset1;

import static org.junit.Assert.*;
import org.junit.Test;

public class HashCodeTester {
    /*
     * P5: If two objects are equal according to the equals(Object)
     * method, then calling the hashCode method on each of
     * the two objects must produce the same integer result.
     */
// your test methods go here
    // Testing Object's hashCode()
    @Test public void t5_1(){
        Object o1 = new Object();
        Object o2 = new Object();
        //Object o2 = o1;
        assertTrue(o1.equals(o2) && (o1.hashCode() == o2.hashCode()));
    }
    @Test public void t5_2(){
        int testNum0 = (int) Math.random();
        Object o1 = new Object();
        C c2 = new C(testNum0);
        //C c2 = (C) o1;
        assertFalse(o1.equals(c2) && (o1.hashCode() == c2.hashCode()));
    }
    @Test public void t5_3(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        Object o1 = new Object();
        D d2 = new D(testNum0, testNum1);
        //D d2 = (D) o1;
        assertFalse(o1.equals(d2) && (o1.hashCode() == d2.hashCode()));
    }

    // Testing C's hashCode()
    @Test public void c_p5_1(){
        int testNum0 = (int) Math.random();
        C c1 = new C(testNum0);
        Object o2 = new Object();
        //Object o2 = (Object) c1;
        assertFalse(c1.equals(o2) && (c1.hashCode() == o2.hashCode()));
    }
    @Test public void c_p5_2(){
        int testNum0 = (int) Math.random();
        C c1 = new C(testNum0);
        C c2 = new C(testNum0);
        assertTrue(c1.equals(c2) && (c1.hashCode() == c2.hashCode()));
    }
    @Test public void c_p5_3(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        C c1 = new C(testNum0);
        D d2 = new D(testNum0, testNum1);
        assertFalse(c1.equals(d2) && (c1.hashCode() == d2.hashCode()));
    }

    // Testing D's hashCode()
    @Test public void d_p5_1(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        D d1 = new D(testNum0, testNum1);
        Object o2 = new Object();
        assertFalse(d1.equals(o2) && (d1.hashCode() == o2.hashCode()));
    }
    @Test public void d_p5_2(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        D d1 = new D(testNum0, testNum1);
        C c2 = new C(testNum0);
        assertFalse(d1.equals(c2) && (d1.hashCode() == c2.hashCode()));
    }
    @Test public void d_p5_3(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        D d1 = new D(testNum0, testNum1);
        D d2 = new D(testNum0, testNum1);
        assertTrue(d1.equals(d2) && (d1.hashCode() == d2.hashCode()));
    }
}