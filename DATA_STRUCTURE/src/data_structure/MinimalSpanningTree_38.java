package data_structure;

class StackMST{
	private final int SIZE = 20;
	private int[] stackArray;
	private int top;
	public StackMST(){
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
		return top == -1;
	}
}

class VertexMST{
	public char label;
	public boolean hasVisited;
	public VertexMST(char l){
		label = l;
		hasVisited = false;
	}
}

class GraphMST{
	private final int MAX_VERTS = 20;
	private int nVerts;//当前顶点数目
	private VertexMST[] vertexList;
	private int[][] AdjMatrix;
	private StackMST graphStack;
	
	public GraphMST(){
		vertexList = new VertexMST[MAX_VERTS];
		nVerts = 0;
		AdjMatrix = new int[MAX_VERTS][MAX_VERTS];
		for(int i=0;i<MAX_VERTS;i++){
			for(int j=0;j<MAX_VERTS;j++){
				AdjMatrix[i][j] = 0;
			}
		}
		graphStack = new StackMST();
	}
	
	public void addVertex(char lab){
		vertexList[nVerts] = new VertexMST(lab);
		nVerts++;
	}
	public void addEdge(int start,int end){
		AdjMatrix[start][end] = 1;
		AdjMatrix[end][start] = 1;
	}
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	
	public void MinimalSpanningTree(){//最小生成树
		vertexList[0].hasVisited = true;
		graphStack.push(0);
		
		while(!graphStack.isEmpty()){
			int curV = graphStack.peek();
			int nextV = getAdjUnvisitedVertex(curV);
			if(nextV==-1){//没有找到邻接未访问顶点
				graphStack.pop();
			}else{
				vertexList[nextV].hasVisited = true;
				graphStack.push(nextV);
				displayVertex(curV);//当前点与起点形成一条边，打印出来
				displayVertex(nextV);
				System.out.print(" ");
			}
		}
		
		for(int i=0;i<nVerts;i++){
			vertexList[i].hasVisited = false;
		}
	}
	
	public int getAdjUnvisitedVertex(int v){
		for(int i=0;i<nVerts;i++){
			if(AdjMatrix[v][i]==1 && vertexList[i].hasVisited==false){
				return i;
			}
		}
		return -1;
	}
}

/*TEST*/
public class MinimalSpanningTree_38 {
	public static void main(String[] args) {
		GraphMST graph = new GraphMST();
		graph.addVertex('A');	graph.addVertex('B');	graph.addVertex('C');
		graph.addVertex('D');	graph.addVertex('E');	
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
		System.out.print("Minimal Spanning Tree: ");
		graph.MinimalSpanningTree();
		System.out.println();
	}
}
