package pset3;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.*;

public class GraphGenerator {
    public CFG createCFG(String className) throws ClassNotFoundException {
        CFG cfg = new CFG();
        JavaClass jc = Repository.lookupClass(className);
        ClassGen cg = new ClassGen(jc);
        ConstantPoolGen cpg = cg.getConstantPool();

        for (Method m: cg.getMethods()) {
            MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
            InstructionList il = mg.getInstructionList();
            InstructionHandle[] handles = il.getInstructionHandles();
            for (InstructionHandle ih: handles) {
                int position = ih.getPosition();
                cfg.addNode(position, m, jc);
                Instruction inst = ih.getInstruction();
                InstructionHandle inst_hdl_nxt = ih.getNext();

                // your code goes here
                // need to add edges
                    // figure out if it's a branching instruction or not
                if(inst instanceof BranchInstruction){
                    // if it is, figure out where it's going and make an edge
                    BranchInstruction br_inst = (BranchInstruction) inst;
                    InstructionHandle inst_hdl = br_inst.getTarget();
                    int pos2 = inst_hdl.getPosition();
                    cfg.addEdge(position, m, jc, pos2, m, jc);
                }

                    // if it's not a branch instruction, make sure there's something next and it's not the final bytecode instruction for the method
                if((inst_hdl_nxt != null) && (!inst.toString().contains("return")) && (!inst.toString().contains("goto"))){
                    int pos2 = inst_hdl_nxt.getPosition();
                    cfg.addEdge(position, m, jc, pos2, m, jc);
                }
            }
        }
        return cfg;
    }
    public CFG createCFGWithMethodInvocation(String className) throws ClassNotFoundException {
        // your code goes here
    }

    public static void main(String[] a) throws ClassNotFoundException {
        GraphGenerator gg = new GraphGenerator();
        gg.createCFG("pset3.C"); // example invocation of createCFG
        gg.createCFGWithMethodInvocation("pset3.D"); // example invocation of createCFGWithMethodInovcation
    }
}