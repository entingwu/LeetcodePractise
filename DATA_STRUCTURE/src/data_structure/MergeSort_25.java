package data_structure;

class DataArray{
	private long[] array;
	private int nElems;//数组个数
	public DataArray(int max){
		array = new long[max];
		nElems = 0;
	}
	public void insert(long value){
		array[nElems] = value;
		nElems++;
	}
	public void display(){
		for(int i=0;i<nElems;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public void mergeSort(){
		long[] newArray = new long[nElems];
		recMergeSort(newArray,0,nElems-1);
	}
	
	private void recMergeSort(long[] newArray,int lowerBound,int upperBound){
		if(lowerBound == upperBound){//基值情况
			return;
		}else{
			int mid = (lowerBound+upperBound)/2;
			recMergeSort(newArray,lowerBound,mid);//递归前半部分排序处理
			recMergeSort(newArray,mid+1,upperBound);//递归前半部分排序处理
			merge(newArray,lowerBound,mid+1,upperBound);
		}
	}
	
	public void merge(long[] newArray,int lowPtr,int highPtr,int upperBound){//合并
		int i=0;//记录有多少个元素排好
		int lowerBound = lowPtr;//初始开始位置
		int mid = highPtr-1;//前半部分中间位置
		int n = upperBound-lowerBound+1;//归并元素个数
		
		while(lowPtr<=mid && highPtr<=upperBound){//分两段
			if(array[lowPtr]<array[highPtr]){
				newArray[i++] = array[lowPtr++];
			}else{
				newArray[i++] = array[highPtr++];
			}
		}
		
		while(lowPtr <= mid){//前半部剩余
			newArray[i++] = array[lowPtr++];
		}
		while(highPtr <= upperBound){//后半部剩余
			newArray[i++] = array[highPtr++];
		}
		
		for(i=0;i<n;i++){//把排序好的临时数组放入原数组
			array[lowerBound+i] = newArray[i];
		}
	}
	
}

public class MergeSort_25 {
	public static void main(String[] args) {
		int maxSize = 100;
		DataArray array = new DataArray(maxSize);
		array.insert(64);  array.insert(21);  array.insert(33);
		array.insert(70);  array.insert(12);  array.insert(85);
		array.insert(44);  array.insert(3);  array.insert(99);
		array.insert(0);  array.insert(108);  array.insert(36);
		array.display();
		array.mergeSort();
		array.display();
		
	}
}
