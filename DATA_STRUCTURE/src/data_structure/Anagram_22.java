package data_structure;
/*Anagram变位字*/
import java.io.*;
public class Anagram_22 {
	static int size = 0;//字符个数，变换方式种类
	static int count = 0;//变位字个数，罗列
	static char[] arrchar = new char[100];//字符数组
	public static void main(String[] args) throws IOException{
		System.out.print("Enter a word: ");
		String input = getString();
		char [] charArray = input.toCharArray();
		permutate(charArray, 0);
	}
	/*WAY 01*/
	public static void permutate(char [] A, int i ){
		 if(i == A.length) {  
			 System.out.print(A);
			 System.out.print(" ");
		 }
		 for(int pos = i; pos < A.length; ++pos){
			 swap(A, i , pos);
			 permutate(A, i+1);
			 swap(A, i, pos);
		 }
	}
	public static void swap(char [] A, int i , int j){
		char tmp = A[i];
		A[i] = A[j]; 
		A[j] = tmp; 
	}
	
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
	public static char[] getChar(String s) throws IOException{
		for(int i=0;i<s.length();i++){
			arrchar[i] = s.charAt(i);
		}
		return arrchar;
	}
	/*WAY 02*/
	//变位
	public static void doAnagram(int size){
		if(size == 1){
			return;//quit
		}else{
			for(int i=0;i<size;i++){
				doAnagram(size-1);
				if(size == 2){
					displayWord();
				}
				rotate(size);
			}
		}
	}
	//转动
	public static void rotate(int newSize){
		int i=0;
		int position = size-newSize;
		char temp = arrchar[position];
		for(i=position+1;i<size;i++){
			arrchar[i-1] = arrchar[i];
		}
		arrchar[i-1] = temp;
	}
	public static void displayWord(){
		if(count<99){ System.out.print(" ");}
		if(count<9){  System.out.print(" ");}
		System.out.print(++count+" ");
		
		for(int i=0;i<size;i++){
			System.out.print(arrchar[i]);
		}
		System.out.print(" ");
		System.out.flush();
		if(count%6==0){ System.out.println();}
	}
	
	

}
