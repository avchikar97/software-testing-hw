// Author: Akaash Chikarmane

package pset3;
import java.util.*;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;

public class CFG {
    Set<Node> nodes = new HashSet<Node>();
    Map<Node, Set<Node>> edges = new HashMap<Node, Set<Node>>();
    public static class Node {
        int position;
        Method method;
        JavaClass clazz;

        Node(int p, Method m, JavaClass c) {
            position = p;
            method = m;
            clazz = c;
        }
        public Method getMethod() {
            return method;
        }

        public JavaClass getClazz() {
            return clazz;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Node)) return false;
            Node n = (Node)o;
            return (position == n.position) && method.equals(n.method) && clazz.equals(n.clazz);
        }

        public int hashCode() {
            return position + method.hashCode() + clazz.hashCode();
        }

        public String toString() {
            return clazz.getClassName() + '.' + method.getName() + method.getSignature() + ": " + position;
        }
    }

    public void addNode(int p, Method m, JavaClass c) {
        addNode(new Node(p, m, c));
    }

    private void addNode(Node n) {
        nodes.add(n);
        Set<Node> nbrs = edges.get(n);
        if (nbrs == null) {
            nbrs = new HashSet<Node>();
            edges.put(n, nbrs);
        }
    }

    public void addEdge(int p1, Method m1, JavaClass c1, int p2, Method m2, JavaClass c2) {
        Node n1 = new Node(p1, m1, c1);
        Node n2 = new Node(p2, m2, c2);
        addNode(n1);
        addNode(n2);
        Set<Node> nbrs = edges.get(n1);
        nbrs.add(n2);
        edges.put(n1, nbrs);
    }
    public void addEdge(int p1, int p2, Method m, JavaClass c) {
        addEdge(p1, m, c, p2, m, c);
    }
    public String toString() {
        return nodes.size() + " nodes\n" + "nodes: " + nodes + '\n' + "edges: " + edges;
    }
    public boolean isReachable(String methodFrom, String clazzFrom, String methodTo, String clazzTo) {
        // you will implement this method in Question 2.2

        if(methodFrom.equals(methodTo) && clazzFrom.equals(clazzTo)){
            return true;
        }

        ClassInfo ciFrom = new ClassInfo();
        ClassInfo ciTo = new ClassInfo();

        try {
            ciFrom.getInfo(clazzFrom);
            ciTo.getInfo(clazzTo);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false; // class does not exist
        }

        // basic check to make sure the possibility exists
        if((ciFrom.cg.containsMethod(methodFrom, null) == null) || (ciTo.cg.containsMethod(methodTo, null) == null)){
            return false; // methods don't exist in class
        }

        Queue<Node> checkQueue = new LinkedList<Node>();
        // set em up
        for(Node node : this.nodes){
            if(node.getMethod().getName().equals(methodFrom) && node.getClazz().getClassName().equals(clazzFrom)){
                checkQueue.add(node);
            }
        }
        // knock em down
        while(!checkQueue.isEmpty()){
            Node testNode = checkQueue.remove();
            if(testNode.getMethod().getName().equals(methodTo) && testNode.getClazz().getClassName().equals(clazzTo)){
                return true;// we did it
            }
            for(Node neighbor : edges.get(testNode)){// exhaustive search through all neighbors
                if(!checkQueue.contains(neighbor))// don't get stuck in loops (don't check the same node twice)
                    checkQueue.add(neighbor);
            }
        }

        return false;// didn't find it in queue
    }

    // little helper class to extract helpful information
    public static class ClassInfo{
        JavaClass jc = null;
        ClassGen cg = null;
        ConstantPoolGen cpg = null;
        Method[] methods = null;


        public void getInfo(String className) throws ClassNotFoundException{
            this.jc = Repository.lookupClass(className);
            this.cg = new ClassGen(jc);
            this.cpg = this.cg.getConstantPool();
            this.methods = cg.getMethods();
        }
    }
}