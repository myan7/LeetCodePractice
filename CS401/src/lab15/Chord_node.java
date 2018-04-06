package lab15;
/*
 * @author:Jingting Chen
 * @cwid:A20344697
 * @date:5/7/2016
 */
public class Chord_node implements Comparable<Chord_node> {
	
	private static int m = 8;
	
	Chord_node successor;
	Chord_node predecessor;
	Chord_node[] finger_table;
	boolean fingerTableRight;
	int node_index;
	String node_name;
	
	//constructor
	public Chord_node(int node_index1, String node_name1) {
		node_index = node_index1;
		node_name = node_name1;
	}
	
	//accessor
	public Chord_node getFingerNode(int index) {
		return finger_table[index];
	}
	
	public int getFingerTableSize() {
		return finger_table.length;
	}
	
	public Chord_node getSuccessor() {
		return successor;
	}

	public Chord_node getPredecessor() {
		return predecessor;
	}

	public int getNode_index() {
		return node_index;
	}

	public String getNode_name() {
		return node_name;
	}
	
	//mutator
	public void setFingerTable(Chord_node[] fingerTable) {
		this.finger_table = fingerTable;
	}
	
	public void setSuccessor(Chord_node successor) {
		this.successor = successor;
	}
	
	public void setPredecessor(Chord_node predecessor) {
		this.predecessor = predecessor;
	}
	
	//FingerTable
	public boolean isFingerTableRight() {
		return fingerTableRight;
	}


	public void setFingerTableRight(boolean fingerTableRight1) {
		fingerTableRight = fingerTableRight1;
	}
	
	public String toString() {
		return node_name;
	}
	
	//compareTo
	public int compareTo(Chord_node chord) {
		if (node_index < chord.node_index) {
			return -1;
		}
		else if (node_index > chord.node_index) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
