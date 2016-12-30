package data_structure;

/*Partition*/
class ArrayPartition{
	private long[] array;
	private int nElems;
	public ArrayPartition(int maxSize){
		array = new long[maxSize];
		nElems = 0;
	}
	public void insert(long value){
		array[nElems++] = value;
	}
	public int size(){
		return nElems;
	}
	public void display(){
		System.out.print("Array: ");
		for(int i=0;i<nElems;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	/*Partition : 按特征值pivot进行比较*/
	public int partitionArray(int left,int right,long pivot){
		int leftPtr = left-1;
		int rightPtr = right+1;
		long temp = 0;
		while(true){
			//从左向右找大于特定值的数据，循环结束代表找到一个大于特定值的数据
			while(leftPtr<right && array[++leftPtr]<pivot);
			//从右向左找到小于特定值的数据，循环结束代表找到一个小于特定值的数据
			while(rightPtr>left && array[--rightPtr]>pivot);
			if(leftPtr>=rightPtr){break;}
			else{swap(leftPtr,rightPtr);
			}
		}
		return leftPtr;
	}
	public void swap(int dex1,int dex2){
		long temp = array[dex1];
		array[dex1] = array[dex2];
		array[dex2] = temp;
	}
}

public class QuickSort_28 {
	public static void main(String[] args) {
		int maxSize = 16;
		ArrayPartition array = new ArrayPartition(maxSize);
		long range = 199;
		for(int i=0;i<maxSize;i++){
			array.insert((int)(Math.random()*range));
		}
		array.display();
		
		long pivot = range/2;
		int parIndex = array.partitionArray(0, array.size()-1, pivot);
		System.out.print("Pivot is: "+pivot);
		System.out.println(",Partition is at index : "+parIndex);
		array.display();
		
	}
}
