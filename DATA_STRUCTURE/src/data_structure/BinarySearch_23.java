package data_structure;

class OrderArray{
	private long[] array;
	private int nElement;
	public OrderArray(int max){
		array = new long[max];
		nElement = 0;
	}
	public int size(){
		return nElement;
	}
	/*查找*/
	public int find(long searchKey){
		return recFind(searchKey,0,nElement-1);
	}
	/*二分查找*/
	private int recFind(long searchKey,int lowerBound,int upperBound){
		int Midpos = (lowerBound+upperBound)/2;
		if(searchKey==array[Midpos]){
			return Midpos;//找到
		}else if(lowerBound>upperBound){
			return nElement;//没找到
		}else{
			if(searchKey<array[Midpos]){//查找数据小于中间数据，左侧找
				return recFind(searchKey,lowerBound,Midpos-1);//递归
			}else{//查找数据大于中间值，右边找
				return recFind(searchKey,Midpos+1,upperBound);
			}
		} 
	}
	/*有序插入*/
	public void insert(long value){
		int i;
		for(i=0;i<nElement;i++){
			if(array[i]>value){break;}//找到插入位置
		}
		for(int j=nElement;j>i;j--){//挪位
			array[j] = array[j-1];
		}
		array[i] = value;
		nElement++;//插入增加一个
	}
	/*显示*/
	public void display(){
		for(int i=0;i<nElement;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}

public class BinarySearch_23 {
	public static void main(String[] args) {
		int maxSize = 100;
		OrderArray array = new OrderArray(maxSize);
		array.insert(72);
		array.insert(90);
		array.insert(45);
		array.insert(126);
		array.insert(54);
		array.insert(99);
		array.insert(144);
		array.insert(27);
		array.insert(135);
		array.insert(81);
		array.insert(108);
		array.insert(9);
		array.insert(117);
		array.insert(63);
		array.insert(36);
		array.display();
		
		int searchKey = 9;
		if(array.find(searchKey)!=array.size()){
			System.out.println("FOUND "+searchKey);
		}else{
			System.out.println("CAN NOT FOUND "+searchKey);
		}
	}
}
