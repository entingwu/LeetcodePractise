package data_structure;

import java.util.*;
/*NODE*/
class Node_h{
	private int iData;
	public Node_h(int key){
		iData = key;
	}
	public int getKey(){
		return iData;
	}
	/*priority*/
	public void setKey(int id){
		iData = id;
	}
}

/*HEAP*/
class Heap{
	private Node_h[] heapArray;//底层结构数组
	private int maxSize;
	private int currentSize;//当前数量
	public Heap(int size){
		maxSize = size;
		currentSize = 0;
		heapArray = new Node_h[maxSize];
	}
	public boolean isEmpty(){
		return currentSize==0;
	}
	/*INSERT*/
	public boolean insert(int key){
		if(currentSize==maxSize){
			return false;
		}else{
			Node_h newNode = new Node_h(key);
			heapArray[currentSize] = newNode;
			trickleUp(currentSize);//把新节点进行比较向上调整
			currentSize++;
			return true;
		}
	}
	/*TrickleUp向上调整*/
	public void trickleUp(int curIndex){
		int parIndex = (curIndex-1)/2;
		Node_h temp = heapArray[curIndex]; 
		while(heapArray[curIndex].getKey()>heapArray[parIndex].getKey()
			&& curIndex>0){
			//heapArray[parIndex] = temp;//拿到下标即可，没必要做
			heapArray[curIndex] = heapArray[parIndex];
			curIndex = parIndex;
			parIndex = (curIndex-1)/2;
		}
		heapArray[curIndex] = temp;//curIndex已变成parent
	}
	/*REMOVE删除最大值*/
	public Node_h remove(){
		Node_h root = heapArray[0];
		heapArray[0] = heapArray[currentSize-1];//拿最后一个数据放root
		currentSize--;
		trickleDown(0);
		return root;
	}
	/*TrickleDown向下调整*/
	public void trickleDown(int upIndex){
		Node_h top = heapArray[upIndex];//top
		int largeChild = 0;//大的子节点位置
		int leftChild,rightChild = 0;
		while(upIndex<currentSize/2){//未找到最后一层
			/*找到子节点最大值*/
			leftChild = upIndex*2+1;
			rightChild = leftChild+1;
			if(heapArray[leftChild].getKey()<heapArray[rightChild].getKey()
			   &&rightChild<currentSize){
				largeChild = rightChild;
			}else{
				largeChild = leftChild;}
			/*找到位置调换*/
			if(heapArray[upIndex].getKey()>=heapArray[largeChild].getKey()){
				break;
			}else{
			   heapArray[upIndex] = heapArray[largeChild];
			   /*下标调整*/
				upIndex = largeChild;
			}
		}
		heapArray[largeChild] = top;//?
	}
	/*CHANGE*/
	public boolean change(int index,int newValue){
		if(index<0 || index>=currentSize){//无效位置
			return false;
		}
		int oldValue = heapArray[index].getKey();
		heapArray[index].setKey(newValue);
		if(oldValue<newValue){
			trickleUp(index);//向上调整
		}else{
			trickleDown(index);
		}
		return true;
	}
	/*DISPLAY*/
	public void displayHeap(){
		System.out.println("HeapArray:");
		for(int i=0;i<currentSize;i++){
			if(heapArray[i]!=null){
				System.out.print(heapArray[i].getKey()+" ");
			}else{
				System.out.print("-- ");
			}
		}
		System.out.println();
		/*树状方式显示*/
		int nBlanks = 32;
		int itemsPerRow = 1;//每层个数，初始时第一层只有一个元素
		int column = 0;//层数n
		int j=0;//打印元素个数
		String dots = "...................................";
		System.out.println(dots+dots);
		while(currentSize>0){
			if(column==0){
				for(int i=0;i<nBlanks;i++){System.out.print(' ');}
			}
			System.out.print(heapArray[j].getKey());//元素
			if(++j==currentSize){break;}//打印完成
			if(++column==itemsPerRow){//这层数据打印完成
				nBlanks/=2;
				itemsPerRow*=2;
				column=0;
				System.out.println();
			}else{
				for(int i=0;i<nBlanks*2-2;i++){
					System.out.print(' ');
				}
			}
		}
		System.out.println();
	}
	
}


public class Heap_35 {

	public static void main(String[] args) {
		

	}

}
