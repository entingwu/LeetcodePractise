package data_structure;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;

/*DepthFirstSearch*/
/*STACK*/
class StackG{
	private final int SIZE = 20;//数组大小常量
	private int[] stackArray;
	private int top;
	public StackG(){
		stackArray = new int[SIZE];
		top = -1;
	}
	public void push(int i){
		stackArray[++top] = i; 
	}
	public int pop(){
		return stackArray[top--];
	}
	public int peek(){
		return stackArray[top];
	}
	public boolean isEmpty(){
		return top == -1;//empty
	}
}

/*BreathFirstSearch*/
class QueueG{
	private final int SIZE = 20;
	private int[] queArray;
	private int front;
	private int rear;
	public QueueG(){
		queArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	public void insert(int i){
		if(rear == SIZE-1){
			rear = -1;//超容量时复位
		}
		queArray[++rear] = i;
	}
	public int remove(){
		int temp = queArray[front++];
		if(front == SIZE){
			front = 0;
		}
		return temp;
	}
	public boolean isEmpty(){
		return (rear+1 == front || front+SIZE-1 == rear);
	}
}

/*VERTEX*/
class Vertex{
	public char label;
	public boolean hasVisited;//是否访问
	public Vertex(char lab){
		label = lab;
		hasVisited = false;
	}
}
/*GRAPH*/
class Graph{
	private final int MAX_VERTS = 20;
	private int nVerts;//当前顶点数量
	private Vertex[] vertexList;//顶点数组
	private int[][] adjMatrix;//邻接数组
	private StackG graphStack;//DFS STACK
	private QueueG graphQueue;//bfs QUEUE
	
	public Graph(){
		nVerts = 0;
		vertexList = new Vertex[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		for(int i=0;i<MAX_VERTS;i++){//初始化邻接数组
			for(int j=0;j<MAX_VERTS;j++){
				adjMatrix[i][j] = 0;
			}
		}
		graphStack = new StackG();//栈
		graphQueue = new QueueG();//队列
	}
	//ADD_VERTEX
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	//ADD_EDGE
	public void addEdge(int start,int end){
		adjMatrix[start][end] = 1;//AB
		adjMatrix[end][start] = 1;//BA
	}
	//DISPLAY_VERTEX
	public void displayVertex(int v){//显示第几个顶点
		System.out.print(vertexList[v].label+" ");
	}
	/*DEPTH_FIRST_SEARCH*/
	/*STACK*/
	public void depthFirstSearch(){
		vertexList[0].hasVisited = true;//第一个顶点标识为已访问
		displayVertex(0);//display visited
		graphStack.push(0);//存入位置
		
		while(!graphStack.isEmpty()){//栈不为空，继续访问
			int nextV = getAdjUnvisitedVertex(graphStack.peek());//栈里弹出的顶点
			if(nextV == -1){//NOT FOUND
				graphStack.pop();
			}else{//FOUND
				vertexList[nextV].hasVisited = true;//标识
				displayVertex(nextV);
				graphStack.push(nextV);
			}
		}
		
		/*初始访问状态*/
		for(int i=0;i<nVerts;i++){
			vertexList[i].hasVisited = false;
		}
	}
	
	/*GET_ADJ_VERTEX_NOT_VISITED
	 * 获取指定顶点相邻接的一个未被访问过的顶点*/
	public int getAdjUnvisitedVertex(int v){
		for(int i=0;i<nVerts;i++){
			if(adjMatrix[v][i] == 1 && vertexList[i].hasVisited == false){
				return i;//找到一个与v顶点相邻接的未访问的顶点位置
			}
		}
		return -1;//NOT FOUND
	}
	
	/*BREATH_FIRST_SEARCH*/
	public void breathFirstSearch(){
		vertexList[0].hasVisited = true;//第一个顶点标识为访问过的
		displayVertex(0);//显示访问的顶点
		graphQueue.insert(0);//存入队列
		int nextV1,nextV2;
		
		while(!graphQueue.isEmpty()){
			nextV1 = graphQueue.remove();
			while((nextV2 = getAdjUnvisitedVertex(nextV1)) != -1){
				vertexList[nextV2].hasVisited = true;
				displayVertex(nextV2);
				graphQueue.insert(nextV2);
			}
		}
		
		for(int i=0;i<nVerts;i++){
			vertexList[i].hasVisited = false;
		}
	}
}

public class GraphTraverse_37 {
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A');	graph.addVertex('B');
		graph.addVertex('C');	graph.addVertex('D');
		graph.addVertex('E');
		graph.addEdge(0, 1);//AB	
		graph.addEdge(0, 2);//AC
		graph.addEdge(0, 3);//AB	
		graph.addEdge(0, 4);//AC
		graph.addEdge(1, 2);//BC	
		graph.addEdge(1, 3);//BD
		graph.addEdge(1, 4);//BE	
		graph.addEdge(2, 3);//CD	
		graph.addEdge(2, 4);//CE
		graph.addEdge(3, 4);//DE
		System.out.print("Visit: ");
		graph.depthFirstSearch();
		System.out.println();
		
		System.out.print("Visit: ");
		graph.breathFirstSearch();
		System.out.println();
	}
}
