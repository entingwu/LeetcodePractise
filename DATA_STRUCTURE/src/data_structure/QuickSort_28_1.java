package data_structure;

class ArrayIns{
	private long[] array;
	public int nElems;
	public ArrayIns(int maxSize){
		array = new long[maxSize];
		nElems = 0;
	}
	public void insert(long value){
		array[nElems++] = value;
	}
	public void display(){
		System.out.print("Array : ");
		for(int i=0;i<nElems;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	/*QUICK SORT*/
	public void quickSort(){
		recQuickSort(0,nElems-1);
	}
	/*RECURSION + PARTITION*/
	public void recQuickSort(int left,int right){
		/*1.基值*/
		if(right-left<=0){ return; }
		else{
			long pivot = array[right];//取分割点:区域数组最后一个
			int partition = partition(left,right,pivot);
			/*递归： 前半部分再划分*/
			recQuickSort(left,partition-1);
			/*递归： 后半部分再划分*/
			recQuickSort(partition+1,right);
		}
	}
	/*PARTITION*/
	public int partition(int left,int right,long pivot){
		int leftPtr = left-1;
		int rightPtr = right;
		while(true){
			while(array[++leftPtr] < pivot);
			while(rightPtr>0 && array[--rightPtr] > pivot);
			if(leftPtr >= rightPtr){break;}
			else{ swap(leftPtr,rightPtr);}
		}
		swap(leftPtr,right);//让值更均匀，重新找特征值
		return leftPtr;
	}
	public void swap(int dex1,int dex2){//SWAP
		long temp = array[dex1];
		array[dex1] = array[dex2];
		array[dex2] = temp;
	}
}

public class QuickSort_28_1 {
	public static void main(String[] args) {
		int maxSize = 16;
		int range = 99;
		ArrayIns array = new ArrayIns(maxSize);
		for(int i=0;i<maxSize;i++){
			long n = (int)(Math.random()*range);
			array.insert(n);
		}
		array.display();
		array.quickSort();
		array.display();
		
	}
}
