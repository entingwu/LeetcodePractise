package data_structure;

class ArrayIns1{
	private long[] array;
	public int nElems;
	public ArrayIns1(int maxSize){
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
		int size = right-left+1;//需要比较个数
		/*1.基值*/
		if(size<10)
			insertionSort(left,right);//小划分使用插入排序
		//if(size<=3){
		//	manualSort(left,right);//手工排序：小数据量 
		//}
		else{ /*数据量大于三个时，使用递归*/
			//取分割点:区域数组三者取中值
			long median = medianOf3(left,right);
			//中值作为划分基准点
			int partition = partition(left,right,median);
			/*递归： 前半部分再划分*/
			recQuickSort(left,partition-1);
			/*递归： 后半部分再划分*/
			recQuickSort(partition+1,right);
		}
	}
	/*小数据量：插入排序*/
	public void insertionSort(int left,int right){
		int in,out;
		for(out = left+1;out<right;out++){
			long temp = array[out];
			in = out;
			while(in>left && array[in-1]>temp){
				array[in] = array[in-1];
			    in--;
			}
			array[in] = temp;
		}
	}
	/*三项数据取一*/
	public long medianOf3(int left,int right){
		int mid = (left+right)/2;
		if(array[left] > array[mid]){ swap(left,mid); }
		if(array[left] > array[right]){ swap(left,right); }
		if(array[mid] > array[right]){ swap(mid,right); }
		swap(mid,right-1);
		return array[right-1];//返回中间值mid
	}
	public void manualSort(int left,int right){//手工排序：小数据量 
		int size = right-left+1;//需要排序的元素个数
		if(size <= 1){return;}
		if(size == 2){
			if(array[left] > array[right]){//第1，2比较
				swap(left,right);
				return;
			}
		}else{//三个元素
			/*第1，2比较*/
			if(array[left] > array[right-1]){//right-1 == left+1
				swap(left,right-1);
			}
			/*第1，3比较*/
			if(array[left] > array[right]){
				swap(left,right);
			}
			/*第2，3比较*/
			if(array[right-1] > array[right]){
				swap(right,right);
			}
		}
	}
	
	/*PARTITION*/
	public int partition(int left,int right,long pivot){
		int leftPtr = left;
		int rightPtr = right-1;
		while(true){
			while(array[++leftPtr] < pivot);
			while(array[--rightPtr] > pivot);//大于中间值就交换
			if(leftPtr >= rightPtr){break;}
			else{ swap(leftPtr,rightPtr);}
		}
		swap(leftPtr,right-1);//让值更均匀，重新找特征值
		return leftPtr;
	}
	public void swap(int dex1,int dex2){//SWAP
		long temp = array[dex1];
		array[dex1] = array[dex2];
		array[dex2] = temp;
	}
}

public class QuickSort_28_2 {
	public static void main(String[] args) {
		int maxSize = 16;
		int range = 99;
		ArrayIns1 array = new ArrayIns1(maxSize);
		for(int i=0;i<maxSize;i++){
			long n = (int)(Math.random()*range);
			array.insert(n);
		}
		array.display();
		array.quickSort();//三项数据取中划分快速排序
		array.display();
		
	}
}
