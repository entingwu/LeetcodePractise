package sortingMethod;

import java.util.LinkedList;

class NodeM{
	NodeM next;
	int value;
	public NodeM(int n){
		value = n;
		next = null;
	}
	public void displayNode(){
		System.out.print(value+" ");
	}
}

class LinkedListM{
	LinkedList<NodeM> listN;
	NodeM head;
	public LinkedListM(){
		listN = new LinkedList<NodeM>();
		head = null;
	}
	public void displayList(){
		
	}
}

public class MergeTwoArray {
	public static int[] merge(int[] A,int[] B){
		int[] list = new int[A.length+B.length];
		int i=0,j=0,k=0;
		while(i<A.length && j<B.length){
			if(A[i] == B[j]){
				list[k++] = A[i++];
				list[k++] = B[j++];
			}else if(A[i] < B[j]){
				list[k++] = A[i++];
			}else{
				list[k++] = B[j++];
			}
		}
		while(j < B.length) {
			list[k++] = B[j++];
		}
		while(i < A.length) {
			list[k++] = A[i++];
		}	
		return list;
	}
	
	public static void main(String[] args) {
		int[] A = {1,1,1};
		int[] B = {2,4};
		int[] list = merge(A,B);
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+" ");
		}
		
		LinkedList<NodeM> listA = new LinkedList<NodeM>();
		listA.add(new NodeM(1));
		listA.add(new NodeM(2));
		listA.add(new NodeM(3));
		listA.add(new NodeM(4));
		LinkedList<NodeM> listB = new LinkedList<NodeM>();
		listB.add(new NodeM(5));
		listB.add(new NodeM(6));
		listB.add(new NodeM(7));
		
		
	}

}
