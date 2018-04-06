package lab15;
/*
 * @author:Jingting Chen
 * @cwid:A20344697
 * @date:5/7/2016
 */

import java.util.*;
import java.io.*;

public class ChordApp {

	
	private static int sumRed; 
	private static int sumInter;
	private static List<Chord_node> nodes= new ArrayList<Chord_node>();
	private Random random=new Random();
	private static final int m = 8;
	private static final int maxKeyIndex = 255;
	private static final String termination = "000000";
	
	public static void main(String[] args) throws Exception {
		ChordApp o1 = new ChordApp();
		o1.beginchord();
	}
	
	public static void beginchord() throws Exception{
		loadAndDeploy();
	
		Scanner sc = new Scanner(System.in);
		
		File reader=new File("src/Lab15/inputfile.txt");
		Scanner input=new Scanner(reader);
		while (true) {
			String s=input.nextLine();
			
			String[] parts=s.split(",");
			int index=Integer.parseInt(parts[1].substring(2));
			try {
				String doc_ID = parts[0];
				
				if (doc_ID.equals(termination)) {
					
					int avgReds = (int)sumRed/sumInter;
					
					System.out.println("Average redirections: " + avgReds);
					
					break;
				}
				System.out.print("Document ID: "+parts[0]+", ");
				int k=0;
				
				Chord_node startnode;
				//look for startnode in network
				while(true){
					if(index!=(nodes.get(k).getNode_index())){
						k++;
					}else{
						startnode=nodes.get(k);
						
						break;
					}
				}
				lookforDoc(doc_ID,startnode);
				
				sumInter++;
				System.out.println();
				
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
			}
		}
		sc.close();
	}
	
	private void printFinger(Chord_node node){

		int size1=node.getFingerTableSize();
		
		for (int i=0;i<= size1-1;i++){
			System.out.println(node.getFingerNode(i).getNode_name());
			
			
		}
	}
	
	private static void lookforDoc(String txtID,Chord_node node) {
		int key = h(txtID);
		System.out.print("Hash: K" + key+", ");
		
		System.out.println("Starting node: " + node.getNode_name());
		
		
		int num_redirections = 0;
		int nodeIndex1, nodeIndex2 = 0;
		String name1 = "" , name2 = "";
		//start to print..
		System.out.print(node.getNode_name());
		while (true) {
			num_redirections++;
			
			nodeIndex1 = node.getNode_index();
			nodeIndex2 = node.getSuccessor().getNode_index();
			
			boolean find = lookforInNodes(key, node, node.getSuccessor());
			if (find) {
				name1 = node.getNode_name();
				name2 = node.getSuccessor().getNode_name();
				
				System.out.println( " -> " + name2);
				
				System.out.println("Redirections: " + num_redirections);
				
				sumRed += num_redirections;
				
				return;
			}
			
			boolean redirected = false;
			for (int i = 0;  i < node.getFingerTableSize()-1; i++) {
				
				nodeIndex1 = node.getFingerNode(i).getNode_index();
				nodeIndex2 = node.getFingerNode(i+1).getNode_index();
				
				if (nodeIndex2 < nodeIndex1) {
					if (key > nodeIndex1 || key <= nodeIndex2) {
						
						redirected = true;
					}
				} else {
					if (key > nodeIndex1 && key <= nodeIndex2) {
						
						redirected = true;
					}
				}
				
				if (redirected) {
					
						System.out.print( " -> "
								+ node.getFingerNode(i).getNode_name());
						node = node.getFingerNode(i);
					
					break;
				}
			}
			if (!redirected) {
				Chord_node finalFingerNode = node.getFingerNode(node.getFingerTableSize()-1);
				
					System.out.print( " -> "
							+ finalFingerNode.getNode_name());
					node = finalFingerNode;
			}
		}
	}

	private static boolean lookforInNodes(int key, Chord_node node1, Chord_node node2) {
		
		boolean find = false;
		int node_index1 = node1.getNode_index();
		int node_index2 = node2.getNode_index();
		if (node_index2 < node_index1) {
			if (key > node_index1 || key <= node_index2) {
				find = true;
			}
		} else {
			if (key > node_index1 && key <= node_index2) {
				find = true;
			}
		}
		return find;
	}

	
	public static void loadAndDeploy() throws Exception {
		//read the nodes file and load all nodes
		File afile = new File("src/Lab15/node.txt");
		
		receiveNodesfromTxt(afile);
		int nodeSize = nodes.size();
		//sort these nodes
		Collections.sort(nodes);
		//successor and predecessor
		for (int i = 0; i < nodes.size(); i++) {
			
			Chord_node chord_node = nodes.get(i);
			
			Chord_node successor = nodes.get((i+1)%nodeSize);
			chord_node.setSuccessor(successor);
			
			Chord_node predecessor = nodes.get((i+nodeSize-1)%nodeSize);
			chord_node.setPredecessor(predecessor);
			
		}
		
		//create finger table
		Chord_node node = nodes.get(0);//getRandomNode(); 
		
		Chord_node startNode;
		
		ArrayList<Chord_node> fingerList = new ArrayList<>();
		Hashtable<String, Chord_node> hashFingerNodes = new Hashtable<>();
		while (!node.isFingerTableRight()) {
			
			fingerList.clear();
			hashFingerNodes.clear();
			
			startNode = node;//.getSuccessor();
			for (int j = 0; j < m; j++) {
				int key = node.getNode_index() + (int)Math.pow(2, j);
				Chord_node finger_successor = getSuccessor(node, key);
				
				if (!hashFingerNodes.containsKey(finger_successor.getNode_name())) {
					hashFingerNodes.put(finger_successor.getNode_name(), finger_successor);
					fingerList.add(finger_successor);
				}
				
				startNode = finger_successor;
			}
			Chord_node[] fingerTable = new Chord_node[fingerList.size()];
			
			
			fingerList.toArray(fingerTable);
			node.setFingerTable(fingerTable);
			
			
			node.setFingerTableRight(true);
			node = node.getSuccessor();
		}
		
	}
	
	private static Chord_node getSuccessor(Chord_node startNode, int key) {
			
			Chord_node node = startNode;
			int startKey=startNode.getNode_index();
			int key1, key2;
			boolean over1;
			int modKey;
			over1 = (key>maxKeyIndex);
			if (over1) {modKey = key % (maxKeyIndex + 1);}
			else {modKey=key;}
			while (true) {
				key1 = node.getPredecessor().getNode_index();
				key2 = node.getNode_index();
				if (key2<key1){
					if (key1<modKey){
						return node;
					}
				}
				if (over1){
					
					if ((key2>=modKey)&&(key2<startKey)){return node;}
					
				}
				else{
					if (key2>=modKey) {return node;}
					
					
				}
				node = node.getSuccessor();
				
			}
		}
	
	
	private static void receiveNodesfromTxt(File file) throws Exception {
		if(!file.exists()){
			throw new Exception("File not found");
		}
		String l = "";
		BufferedReader br = null;
		Chord_node node = null;
		String node_name;
		int node_index;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((l = br.readLine()) != null){
				node_index = h(l.trim());
				node_name = "N" + node_index;
				node = new Chord_node(node_index, node_name);
				nodes.add(node);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
	}
	
	private Chord_node getRandomNode() {
		return nodes.get(getRandom(nodes.size()));
	}
	
	public int getRandom(int range){
		if(random != null){
			return Math.abs(random.nextInt()%range);
		}
		return (Math.abs(new Random().nextInt())%range);
	}
	
   public static int h(String s)  {
	      long h = 0;
	      int len = s.length();

	      for (int i = 0; i < len; i++)  {
	        h = 31 * h + s.charAt(i);
	      }
	      return (int) Math.abs(h % 256); 
	   }
	
}
