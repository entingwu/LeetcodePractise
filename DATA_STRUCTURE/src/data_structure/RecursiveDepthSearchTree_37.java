package data_structure;
import java.util.*;
import java.util.HashSet;

/*RECURSIVE*/

class GraphNode{
	public ArrayList<GraphNode> adjNodes = new ArrayList<GraphNode>();
	int value;
}
class GraphRe{
	public HashSet<GraphNode> hasVisited = new HashSet<GraphNode>();
	
	public void depthFirstSearch(GraphNode root){
		System.out.print(root.value+" ");
		hasVisited.add(root);
		for(GraphNode n : root.adjNodes){//root的adjNodes
			if(!hasVisited.contains(n)){
				depthFirstSearch(n);
			}
		}
	}
	public void breathFirstSearch(GraphNode root){
		hasVisited.clear();
		Queue queue = new LinkedList();
		hasVisited.add(root);
		queue.offer(root);
		
		while(!queue.isEmpty()){
			GraphNode node = (GraphNode)queue.poll();
			System.out.print(node.value+" ");
			for(GraphNode n : node.adjNodes){
				if(!hasVisited.contains(n)){
					hasVisited.add(n);
					queue.offer(n);
				}
			}
		}
	}
}

public class RecursiveDepthSearchTree_37 {

	public static void main(String[] args) {
		GraphNode n1 = new GraphNode();	n1.value = 1;
		GraphNode n2 = new GraphNode(); n2.value = 2;
		GraphNode n3 = new GraphNode();	n3.value = 3;
		GraphNode n4 = new GraphNode(); n4.value = 4;
		GraphNode n5 = new GraphNode(); n5.value = 5;
		n1.adjNodes.add(n2);
		n1.adjNodes.add(n3);
		n1.adjNodes.add(n4);
		n4.adjNodes.add(n5);
		GraphRe gr = new GraphRe();
		gr.depthFirstSearch(n1);
		System.out.println();
		gr.breathFirstSearch(n1);
	}

}
