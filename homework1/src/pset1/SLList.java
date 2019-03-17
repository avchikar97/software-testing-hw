// Name: Akaash Chikarmane
// UTEID: avc536
// Assignment: Software Testing (EE 360T) - Problem Set #1
// Problem: 1.1 implementing add()

package pset1;
import java.util.HashSet;
import java.util.Set;


public class SLList {
    Node header;

    static class Node {
        boolean elem;
        Node next;

        Node(){
            elem = false;
            next = null;
        }

        Node(boolean el, Node nx){
            this.elem = el;
            this.next = nx;
        }
    }

    boolean repOk() {
        // postcondition: returns true iff <this> is an acyclic list, i.e.,
        // there is no path from a node to itself
        Set<Node> visited = new HashSet<Node>();
        Node n = header;
        while (n != null) {
            if (!visited.add(n)) {
                return false;
            }
            n = n.next;
        }
        return true;
    }
    void add(boolean e) {
        // precondition: this.repOk()
        // postcondition: adds <e> in a new node at the beginning of the
        // list; the rest of the list is unmodified
        // your code goes here
        Node toAdd = new Node(e, header);
        header = toAdd;
    }
}