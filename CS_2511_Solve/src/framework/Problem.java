package framework;

import graph.DequeAdder;
import graph.Vertex;
import static java.lang.Integer.max;
import java.util.Deque;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 * This abstract class represents a problem in a problem solving domain.
 * Note that this class does not provide a constructor.
 * It provides getters and setters for the current state
 * of the problem, the list of moves for the problem, and the problem's
 * introduction string.
 * Extending classes need not have instance fields for these attributes, 
 * as they are inherited from this class.
 * Extending classes must set these values in their constructors using 
 * the setters (mutators) provided in this class.
 * Extending classes must also override the abstract <b>success</b> method.
 */
public abstract class Problem {

    /**
     * Determines whether the current state of this problem is a success.
     * Extending classes need to override this method.
     * @return whether the current state is a success
     */
    public abstract boolean success();

    /**
     * Gets the current state of the problem.
     * @return the current state
     */
    public State getCurrentState() {
        return currentState;
    }

    /**
     * Sets the current state of the problem.
     * @param currentState the current state
     */
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    /**
     * Gets an explanatory introduction string for the problem.
     * @return the introduction string
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * Sets the introduction string for this problem.
     * @param introduction the introduction string
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * Gets the list of moves for this problem.
     * @return the list of moves
     */
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * Sets the list of moves for this problem.
     * @param moves the list of moves
     */
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    
    public List<Vertex> expand(Vertex v) {
        List<Vertex> children = new LinkedList<Vertex>();
        for(Move move: getMoves()){
            State child = move.doMove((State) v);
            if((Vertex) child != null && !occursOnPath((Vertex) child, v)){
                
                ((Vertex)child).setDistance(v.getDistance() + 1);
                ((Vertex)child).setPredecessor(v);
                children.add((Vertex) child);
            }    
            
        }
        return children;
    }

    public boolean occursOnPath(Vertex v, Vertex ancestor) {
        while(ancestor != null){
            if(v.equals(ancestor))
                return true;
            else
                ancestor = ancestor.getPredecessor();
        }
        return false;
    }
       /**
     * The core search operation for this graph.
     * It uses a double-ended queue so that either breadth-first or
     * depth-first search can be performed depending on to which end of
     * the queue newly discovered vertices are added.
     * @param start The start vertex for the search
     * @param adder A purely functional object that adds to either the 
     * head or tail of a double-ended queue
     * @return vertex of final state.
     */
    public Vertex search(Vertex start, DequeAdder adder) {
        queueSize = 0;
        queueOps = 0;
        maxQueueSize = 0;
        minimalMoves = 0;
        if(st.empty() == false)
            st.clear();
        
        start.setDistance(0);
        start.setPredecessor(null);
        Deque<Vertex> deque = new LinkedList<Vertex>();
        deque.add(start);
        queueSize++;
        
        while ( !deque.isEmpty() ) {  
            Vertex u = deque.remove();
            queueSize--;
            queueOps++;
            setCurrentState((State) u);
            if(success()){
                maxQueueSize = max(queueSize, maxQueueSize);
                
                st.push(u);
                minimalMoves++;
                Vertex temp = u;
                
                while(temp.getPredecessor()!= null){
                    temp = temp.getPredecessor();
                    if(!temp.equals(start)){
                    
                        st.push(temp.getPredecessor());
                        minimalMoves++;
                    }
                }
                return u;
            }
            else{
                for(final Vertex v : expand(u)){
                    v.setPredecessor(u);
                    adder.add(v, deque);
                    queueSize++;
                    queueOps++;
                }
                
                
            }
            
        }
        JOptionPane.showMessageDialog(null, "No Solution Found!"); 
        return null;
    }
    
    /**
     * Performs a breadth-first search of this graph from a given starting
     * vertex.  For each vertex that is reachable from the start, this 
     * operation computes its distance from the start and its predecessor 
     * on the search path.
     * @param start The start vertex
     */
    public void breadthFirstSearch(Vertex start) {

        DequeAdder tailAdder = new DequeAdder() {
            @Override
            public void add(Vertex vertex, Deque<Vertex> deque) {
                deque.addLast(vertex);
            }
        };

        search(start, tailAdder);
    }
    
    /**
     * Performs a depth-first search of this graph from a given starting
     * vertex.  For each vertex that is reachable from the start, this 
     * operation computes its distance from the start and its predecessor 
     * on the search path.
     * @param start The start vertex
     */
    public void depthFirstSearch(Vertex start) {

        DequeAdder headAdder = new DequeAdder() {
            @Override
            public void add(Vertex vertex, Deque<Vertex> deque) {
                deque.addFirst(vertex);
            }
        };

       search(start, headAdder);
      
      
    }
    public void reset(){
        
    }
    
    public int getQueueOps(){
        return queueOps;
    }
    
    public int getQueueSize(){
        return queueSize;
    }
    public int getMaxQueueSize(){
        return maxQueueSize;
    }
    public int getMinimalMoves(){
        return minimalMoves;
    }
    
    public Stack getStack(){
        return st;
    }
    /**
     * The current state of this problem
     */
    private State currentState;

    /**
     * The explanatory string for this problem.
     */
    private String introduction;

    /**
     * The list of moves for this problem.
     */
    private List<Move> moves;
    
    State end;
    private int queueOps;
    private int queueSize;
    private int maxQueueSize;
    private int minimalMoves;
    Stack<Vertex> st = new Stack<Vertex>();
}
