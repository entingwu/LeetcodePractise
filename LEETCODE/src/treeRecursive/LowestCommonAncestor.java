package treeRecursive;

import java.util.ArrayList;

public class LowestCommonAncestor {
	
	class ParentTreeNode {
		public ParentTreeNode parent, left, right;
	}

	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
		ArrayList<ParentTreeNode> pathA = getNodeToRoot(A);
		ArrayList<ParentTreeNode> pathB = getNodeToRoot(B);
		ParentTreeNode lowestAncestor = null;
		int indexA = pathA.size() - 1;
		int indexB = pathB.size() - 1;
		while(indexA >= 0 && indexB >= 0) {
			if (pathA.get(indexA) != pathB.get(indexB)) {
				break;
			}
			lowestAncestor = pathA.get(indexA);
			indexA--;
			indexB--;
		}
		return lowestAncestor;
	}
	
	private ArrayList<ParentTreeNode> getNodeToRoot(ParentTreeNode node) {
		ArrayList<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
		while(node != null) {
			path.add(node);
			node = node.parent;
		}
		return path;
	}
	
	public static void main(String[] args) {
		

	}

}
