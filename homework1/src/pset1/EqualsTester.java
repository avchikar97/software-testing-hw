// Name: Akaash Chikarmane
// UTEID: avc536
// Assignment: Software Testing (EE 360T) - Problem Set #1
// Problem: 2.1 Testing equals()

package pset1;
import static org.junit.Assert.*;
import org.junit.Test;
public class EqualsTester {
    /*
     * P1: For any non-null reference value x, x.equals(null) should return false.
     */
    @Test public void t0() {
        assertFalse(new Object().equals(null));
    }
// your test methods for P1 go here
    @Test public void c_p1(){
        assertFalse(new C(1).equals(null));
    }
    @Test public void d_p1(){
        assertFalse(new D(1, 2).equals(null));
    }
    /*
     * P2: It is reflexive: for any non-null reference value x, x.equals(x)
     * should return true.
     */
// your test methods for P2 go here
    @Test public void t2(){
        Object o = new Object();
        assertTrue(o.equals(o));
    }
    @Test public void c_p2(){
        int testNum0 = (int) Math.random();
        C c = new C(testNum0);
        assertTrue(c.equals(c));
    }
    @Test public void d_p2(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        D d = new D(testNum0, testNum1);
        assertTrue(d.equals(d));
    }
    /*
     * P3: It is symmetric: for any non-null reference values x and y, x.equals(y)
     * should return true if and only if y.equals(x) returns true.
     */
// your test methods for P3 go here
    @Test public void t3_1(){
        Object o1 = new Object();
        Object o2 = new Object();
        assertTrue(o1.equals(o2) && o2.equals(o1));
    }
    @Test public void t3_2(){
        int testNum0 = (int) Math.random();
        Object o1 = new Object();
        C c2 = new C(testNum0);
        //C c2 = (C) o1;
        assertFalse(c2.equals(o1) && o1.equals(c2));
    }
    @Test public void t3_3(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        Object o1 = new Object();
        D d2 = new D(testNum0, testNum1);
        //D d2 = (D) o1;
        assertFalse(d2.equals(o1) && o1.equals(d2));
    }
    @Test public void c_p3_1(){
        int testNum0 = (int) Math.random();
        C c1 = new C(testNum0);
        Object o2 = new Object();
        assertFalse(c1.equals(o2) && o2.equals(c1));
    }

    @Test public void c_p3_2(){
        int testNum0 = (int) Math.random();
        C c1 = new C(testNum0);
        C c2 = new C(testNum0);
        assertTrue(c1.equals(c2) && c2.equals(c1));
    }
    @Test public void c_p3_3(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        C c1 = new C(testNum0);
        D d2 = new D(testNum0, testNum1);
        assertFalse(c1.equals(d2) && d2.equals(c1));
    }
    @Test public void d_p3_1(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        D d1 = new D(testNum0, testNum1);
        Object o2 = new Object();
        assertFalse(d1.equals(o2) && o2.equals(d1));
    }

    @Test public void d_p3_2(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        D d1 = new D(testNum0, testNum1);
        C c2 = new C(testNum0);
        assertFalse(d1.equals(c2) && c2.equals(d1));
    }
    @Test public void d_p3_3(){
        int testNum0 = (int) Math.random();
        int testNum1 = (int) Math.random();
        D d1 = new D(testNum0, testNum1);
        D d2 = new D(testNum0, testNum1);
        assertTrue(d1.equals(d2) && d2.equals(d1));
    }
    /*
     * P4: It is transitive: for any non-null reference values x, y, and z,
     * if x.equals(y) returns true and y.equals(z) returns true, then
     * x.equals(z) should return true.
     */
// you do not need to write tests for P4
}