package bfsGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) { return null; }
		/* QUEUE */
		ArrayList<UndirectedGraphNode> oldNodes = new ArrayList<UndirectedGraphNode>();
		int start = 0;
		/* HASHMAP */
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		oldNodes.add(node);
		map.put(node, new UndirectedGraphNode(node.label));//A->A'
		
		/* 1. CLONE NODES */
		while(start < oldNodes.size()) {//queue不为空， 与level order一样
			UndirectedGraphNode head = oldNodes.get(start);//以一个node为起点
			start++;
			for(int i = 0; i < head.neighbors.size(); i++) {//将node的未访问的邻接节点都放入hashmap和arraylist中
				UndirectedGraphNode nextNode = head.neighbors.get(i); 
				if(!map.containsKey(nextNode)) {
					map.put(nextNode, new UndirectedGraphNode(nextNode.label));
					oldNodes.add(nextNode);
				}
			}	
		}
		
		/* 2. CLONE EDGES */
		for(int i = 0; i < oldNodes.size(); i++) {
			UndirectedGraphNode oldN = oldNodes.get(i);
			UndirectedGraphNode newN = map.get(oldN);
			for(int j = 0; j < oldN.neighbors.size(); j++) {
				UndirectedGraphNode oldNeighbor = oldN.neighbors.get(j);
				newN.neighbors.add(map.get(oldNeighbor));
			}
			
		}
		
		return map.get(node);
	}
	
	public static void main(String[] args) {
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node3 = new UndirectedGraphNode(3);
		UndirectedGraphNode node4 = new UndirectedGraphNode(4);
		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
		node2.neighbors.add(node1);
		node2.neighbors.add(node4);
		node3.neighbors.add(node1);
		node3.neighbors.add(node4);
		node4.neighbors.add(node2);
		node4.neighbors.add(node3);
		
		CloneGraph cg = new CloneGraph();
		UndirectedGraphNode newNode1 = cg.cloneGraph(node1);
		
		
	}

}
