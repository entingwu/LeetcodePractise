package data_structure;
import java.util.*;
import java.io.*;

/*BINARY SEARCH TREE*/

/*NODE*/
class Node{
	public int iData;
	public double dData;
	public Node LeftChild;
	public Node RightChild;
	public void displayNode(){
		System.out.print("{"+iData+","+dData+"}");
	}
}
/*TREE*/
class Tree{
	private Node root;
	public Tree(){
		root = null;
	}
	/*I. INSERT*/
	public void insert(int id,double dd){
		/*初始化*/
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		
		/*插入:1.根节点为空 2.往下查找*/
		if(root == null){root = newNode;}
		else{
			Node current = root;//查找
			Node parent = root;//用来存值
			while(true){
				parent = current;//parent为current的父节点
				if(id<current.iData){//LEFT
					current = current.LeftChild;
					if(current==null){
						parent.LeftChild = newNode;
						return;
					}
				}else{//RIGHT
					current = current.RightChild;
					if(current==null){
						parent.RightChild = newNode;
						return;
					}
				}
			}
		}
	}
	/*II. DELETE*/
	public boolean delete(int key){
		/*初始化*/
		Node parent = root;
		Node current = root;
		boolean isLeftChild = true;//删除节点是否其父节点的左节点
		
		/*查找*/
		while(current.iData!=key){
			parent = current;
			if(key<current.iData){
				current = current.LeftChild;
				isLeftChild = true;
			}else{
				current = current.RightChild;
				isLeftChild = false;
			}
			//NOT FOUND
			if(current == null){
				return false;
			}
		}//FOUND
		
		/*删除*/
		/*1.叶子节点*/
		if(current.LeftChild==null && current.RightChild==null){
			if(current == root){
				root = null;
			}else{
				if(isLeftChild==true){//删除节点为父节点的左子节点
					parent.LeftChild = null;
				}else{//isLeftChild==false
					parent.RightChild = null;
				}
			} 	
		/*2.删除节点只有左子节点*/	
		}else if(current.RightChild == null){
			if(current == root){
				root = current.LeftChild;//升上去
			}else{
				if(isLeftChild==true){//删除节点为父节点的左子节点
					parent.LeftChild = current.LeftChild;
				}else{//isLeftChild==false
					parent.RightChild = current.RightChild;
				}
			}	
		/*3.删除节点只有右子节点*/	
		}else if(current.LeftChild == null){
			if(current == root){
				root = current.RightChild;
			}else{
				if(isLeftChild==true){//删除节点为父节点的左子节点
					parent.LeftChild = current.RightChild;
				}else{//isLeftChild==false
					parent.RightChild = current.RightChild;
				}
			}
	    /*4.删除节点有两个子节点*/	
		}else{
			Node successor = getSuccessor(current);//继承者
			if(current == root){
				root = successor;
			}else{
				if(isLeftChild==true){//删除节点为父节点的左子节点
					parent.LeftChild = successor;
				}else{
					parent.RightChild = successor;
				}//successor.RightChild已处理
			}
			successor.LeftChild = current.LeftChild;
		}
		return true;
	}
	/*II. 寻找继承者*/
	private Node getSuccessor(Node delNode){
		Node successorParent = delNode;//继承者的父节点
		Node successor = delNode;//继承者
		Node currentN = delNode.RightChild;//从右开始搜索
		while(currentN!=null){
			successorParent = successor;
			successor = currentN;
			currentN = currentN.LeftChild;
		}//FOUND
		if(successor!=delNode.RightChild){//继承者为继承者父节点的左子节点,即不为右子树中最小值
			successorParent.LeftChild = successor.RightChild;
			successor.RightChild = delNode.RightChild;
		}
		return successor;
	}
	/*III. FIND*/
	public Node find(int key){
		Node current = root;
		while(current.iData!=key){
			if(key<current.iData){
				current = current.LeftChild;
			}else{
				current = current.RightChild;
			}
			if(current==null){
				return null;//NOT FOUND
			}
		}
		return current;//FOUND
	}
	/*IV. TRAVERSE*/
	public void traverse(int traverseType){
		switch(traverseType){
			case 1: 
					System.out.println("\nPreOrder traversal: ");
					preOrder(root); 
					break;
			case 2:
					System.out.println("\nInOrder traversal: ");
					inOrder(root);
					break;
			case 3:
					System.out.println("\nPostOrder traversal: ");
					postOrder(root);
					break;
			default:
					System.out.println("\nWrong Input");
		}
		System.out.println();
	} 
	/*中左右*/
	private void preOrder(Node localRoot){
		if(localRoot!=null){
			System.out.print(localRoot.iData+" ");
			preOrder(localRoot.LeftChild);
			preOrder(localRoot.RightChild);
		}
	}
	/*左中右*/
	private void inOrder(Node localRoot){
		if(localRoot!=null){
			inOrder(localRoot.LeftChild);
			System.out.print(localRoot.iData+" ");
			inOrder(localRoot.RightChild);
		}
	}
	/*右左中*/
	private void postOrder(Node localRoot){
		if(localRoot!=null){
			postOrder(localRoot.RightChild);
			postOrder(localRoot.LeftChild);
			System.out.print(localRoot.iData+" ");
		}
	}
	
	/*DISPLAY*/
	public void displayTree(){
		Stack globalStack = new Stack();//全局栈
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("................................................................");
		while(!isRowEmpty){
			Stack localStack = new Stack();//本地栈
			isRowEmpty = true;
			for(int i=0;i<nBlanks;i++){
				System.out.print(" ");;//左边32个空格
			}
			while(!globalStack.isEmpty()){//globalStack非空
				Node temp = (Node)globalStack.pop();
				if(temp!=null){
					System.out.print(temp.iData);
					localStack.push(temp.LeftChild);
					localStack.push(temp.RightChild);
					if(temp.LeftChild!=null||temp.RightChild!=null){
						isRowEmpty = false;
					}
				}else{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int i=0;i<nBlanks*2-2;i++){
					System.out.print(" ");
				}
			}//while end
			System.out.println();
			nBlanks/=2;
			while(!localStack.isEmpty()){
				globalStack.push(localStack.pop());
			}
		}//while end
		System.out.println("................................................................");
	}
}
/*TEST*/
public class BinaryTree_29 {
	public static void main(String[] args) throws IOException{
		Tree tree = new Tree();
		tree.insert(50, 1.5);	tree.insert(25, 1.2);	tree.insert(75, 1.7);	tree.insert(12, 1.5);
		tree.insert(37, 1.2);	tree.insert(43, 1.7);	tree.insert(30, 1.5);	tree.insert(33, 1.2);
		tree.insert(87, 1.7);	tree.insert(93, 1.5);	tree.insert(97, 1.5);
		int value = 0;
		while(true){
			System.out.print("Enter first letter of show,insert,find,delete or traverse: ");
			char choice = getChar();
			switch(choice){
				case's'://SHOW
					tree.displayTree();
					break;
				case'i'://INSERT
					System.out.println("Enter value to insert: ");
					value = getInt();
					tree.insert(value, value/100+0.9);
					break;
				case'f'://FIND
					System.out.print("Enter value to find: ");
					value = getInt();
					Node found = tree.find(value);
					if(found!=null){
						System.out.print("FOUND:");
						found.displayNode();
						System.out.println();
					}else{
						System.out.println("Could not find"+value+"\n");
					}
					break;
				case'd'://DELETE
					System.out.print("Enter value to delete:");
					value = getInt();
					boolean didDelete = tree.delete(value);
					if(didDelete){
						System.out.println("Deleted"+value+"\n");
					}else{
						System.out.println("Could not Deleted"+value+"\n");
					}
					break;
				case't'://TRAVERSE
					System.out.println("Enter type 1,2,3: ");
					value = getInt();
					tree.traverse(value);
					break;
				default:
					System.out.println("Invalid entry\n");
			}
		}
	}
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
	public static char getChar() throws IOException{
		return getString().charAt(0);
	}
	public static int getInt() throws IOException{
		return Integer.parseInt(getString());
	}
}
