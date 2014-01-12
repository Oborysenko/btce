import java.util.LinkedList;


public class Stack {
    private static LinkedList<Double> fifo;
    
    public void createNewStack() {
    	fifo = new LinkedList<Double>();
    }
    
    public void addInStack(double d) {
    	if (fifo.size() < GlobalSettings.maxValueInFifo) {
    		fifo.add(d);
    	} else {
    		fifo.removeFirst();
    		fifo.add(d);
    	}
    	
    }
    
    public static Double[] getStack () {
    	Double[] aaa =  new Double[fifo.size()];
    	fifo.toArray(aaa);
		return aaa;
    }
    
    public void removeLast() {
    	fifo.removeLast();
    }
    
    public void removeFirst() {
    	fifo.removeFirst();
    }

    
}
