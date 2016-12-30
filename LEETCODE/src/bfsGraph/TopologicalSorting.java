package bfsGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopologicalSorting {
	
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		Map<DirectedGraphNode,Integer> map = new HashMap<DirectedGraphNode,Integer>();
		/* 1. Count inDegree */
		for(DirectedGraphNode node : graph) {
			for(DirectedGraphNode neighbor : node.neighbors) {
				if(map.containsKey(neighbor)) {
					int inDegree = map.get(neighbor);
					map.put(neighbor, inDegree + 1);
				}else {
					map.put(neighbor, 1);
				}
			}
		}
		/* 2. 把root和孤立点放入Queue */
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode node : graph) {
			if(!map.containsKey(node)) {
				queue.offer(node);
				result.add(node);
			}
		}
		
		/* 3. inDegree--, Put inDegree == 0 into Queue */
		while(!queue.isEmpty()) {
			DirectedGraphNode next = queue.poll();
			for(DirectedGraphNode ne : next.neighbors) {
				map.put(ne, map.get(ne) - 1);
				if(map.get(ne) == 0) {
					queue.offer(ne);
					result.add(ne);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {

	}

}
