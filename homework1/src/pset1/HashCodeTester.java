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
        //Object o2 = new Object();
        Object o2 = o1;
        assertTrue(o1.equals(o2) && (o1.hashCode() == o2.hashCode()));
    }
    @Test public void t5_2(){
        Object o1 = new Object();
        //C c2 = new C(1);
        C c2 = (C) o1;
        assertFalse(o1.equals(c2) && (o1.hashCode() == c2.hashCode()));
    }
    @Test public void t5_3(){
        Object o1 = new Object();
        //D d2 = new D(1, 2);
        D d2 = (D) o1;
        assertFalse(o1.equals(d2) && (o1.hashCode() == d2.hashCode()));
    }

    // Testing C's hashCode()
    @Test public void c_p5_1(){
        C c1 = new C(1);
        Object o2 = new Object();
        assertFalse(c1.equals(o2) && (c1.hashCode() == o2.hashCode()));
    }
    @Test public void c_p5_2(){
        C c1 = new C(1);
        C c2 = new C(1);
        assertTrue(c1.equals(c2) && (c1.hashCode() == c2.hashCode()));
    }
    @Test public void c_p5_3(){
        C c1 = new C(1);
        D d2 = new D(1, 2);
        assertFalse(c1.equals(d2) && (c1.hashCode() == d2.hashCode()));
    }

    // Testing D's hashCode()
    @Test public void d_p5_1(){
        D d1 = new D(1, 2);
        Object o2 = new Object();
        assertFalse(d1.equals(o2) && (d1.hashCode() == o2.hashCode()));
    }
    @Test public void d_p5_2(){
        D d1 = new D(1, 2);
        C c2 = new C(1);
        assertFalse(d1.equals(c2) && (d1.hashCode() == c2.hashCode()));
    }
    @Test public void d_p5_3(){
        D d1 = new D(1, 2);
        D d2 = new D(1, 2);
        assertTrue(d1.equals(d2) && (d1.hashCode() == d2.hashCode()));
    }
}