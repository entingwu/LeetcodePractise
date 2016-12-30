package data_structure;
import java.io.*;

class DataItem{
	private int iData;
	public DataItem(int id){
		iData = id;
	}
	public int getKey(){
		return iData;
	}
}

class HashTable{//hashTable is an array of DataItem
	private DataItem[] hashArray;//基于数组
	private int arraySize;//大小
	private DataItem nonItem;//当前搜索项，删除项
	public HashTable(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);//删除替换项
	}
	/*DISPLAY*/
	public void displayTable(){
		System.out.print("Table: ");
		for(int i=0;i<arraySize;i++){
			if(hashArray[i]!=null){
				System.out.print(hashArray[i].getKey()+" ");
			}else{
				System.out.print("** ");
			}
		}
		System.out.println();
	}
	/*HASH FUNCTION*/
	public int hashFunc(int key){
		return key%arraySize;
	}
	/*INSERT*/
	public void insert(DataItem item){
		int key = item.getKey();
		int hashVal = hashFunc(key);//哈希化得到数组下标
		while(hashArray[hashVal]!=null && hashArray[hashVal].getKey()==-1){
			hashVal++;
			hashVal = hashVal%arraySize;
		}
		hashArray[hashVal] = item;
	}
	/*DELETE*/
	public DataItem delete(int key){
		int hashVal = hashFunc(key);//数组下标
		while(hashArray[hashVal]!=null){
			if(hashArray[hashVal].getKey()==key){
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}else{
				hashVal++;
				hashVal = hashVal%arraySize;
			}
		}
		return null;//NOT FOUND
	}
	/*FIND*/
	public DataItem find(int key){
		int hashVal = hashFunc(key);
		while(hashArray[hashVal]!=null){
			if(hashArray[hashVal].getKey()==key){
				return hashArray[hashVal];
			}else{
				hashVal++;
				hashVal = hashVal%arraySize;
			}
		}
		return null;
	}
}

public class HashMap_32 {
	public static void main(String[] args) throws IOException{
		System.out.print("Enter size of hashTable:");
		int size = getInt();
		System.out.print("Enter initial number of items: ");
		int n = getInt();//哈希表中数值量
		int keysPerCell = 10;
		int aKey = 0;
		HashTable hash = new HashTable(size);
		for(int i=0;i<n;i++){
			aKey = (int)(Math.random()*keysPerCell*size);
			hash.insert(new DataItem(aKey));
		}
		
		/*TEST*/
		while(true){
			System.out.print("Enter first letter of show,insert,delete or find:");
			char choice = getChar();
			switch(choice){
				case 's':
					hash.displayTable();
			        break;
				case 'i':
					System.out.print("Enter key value to insert:");
					hash.insert(new DataItem(getInt()));
					break;
				case 'd':
					System.out.print("Enter key value to delete:");
					DataItem del = hash.delete(getInt());
					if(del!=null){
						System.out.println("Deleted "+del.getKey());
					}else{
						System.out.println("Can not delete.");
					}
					break;
				case 'f':
					System.out.print("Enter key value to find:");
					DataItem found = hash.find(getInt());
					if(found!=null){
						System.out.println("Find "+found.getKey());
					}else{
						System.out.println("Can not find.");
					}
					break;
				default:
					System.out.println("Invalid Input\n");
			}
		}
	}
	public static int getInt() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return Integer.parseInt(br.readLine());
	}
	public static char getChar() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine().charAt(0);
	}
}
