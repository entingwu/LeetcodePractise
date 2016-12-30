package data_structure;

class VertexTo{
	public char label;
	public VertexTo(char lab){
		label = lab;
	}
}
class GraphTo{
	private final int MAX_VERTS = 20;
	private VertexTo[]  vertexList;//顶点数组
	private int nVerts;//当前顶点数量
	private char[] sortedArray;//存储排序结果
	private int[][] adjMatrix;//邻接矩阵
	public GraphTo(){
		vertexList = new VertexTo[MAX_VERTS];
		nVerts = 0;
		sortedArray = new char[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		for(int i=0;i<MAX_VERTS;i++){
			for(int j=0;j<MAX_VERTS;j++){
				adjMatrix[i][j] = 0;
			}
		}
	}
	public void addVertex(char lab){//加点
		vertexList[nVerts++] = new VertexTo(lab);
	}
	public void addEdge(int start,int end){//加边
		adjMatrix[start][end] = 1;
	}
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	/*TopologicalSort*/
	public void topo(){
		int origin_nVerts = nVerts;//需排序顶点个数
		//顶点删完为止
		while(nVerts>0){
			int currentVertex = noSuccessors();
			if(currentVertex == -1){//找不到没有后继顶点的顶点 
				System.out.println("Error: Graph has cycles");
				return;//退出方法
			}else{
				//从数组后面往前放，最后放到下标为0中
				sortedArray[nVerts-1] = vertexList[currentVertex].label;
				deleteVertex(currentVertex);//从图中删除当前顶点
			}
		}
		System.out.print("Topologically Sorted Order: ");
		for(int i=0;i<origin_nVerts;i++){
			System.out.print(sortedArray[i]+" ");
		}
		System.out.println();
	}
	//查找图中没有后继顶点的顶点
	public int noSuccessors(){
		boolean isEdge;//是否有边
		for(int row=0;row<nVerts;row++){
			isEdge = false;
			for(int col=0;col<nVerts;col++){
				if(adjMatrix[row][col]>0){
					isEdge = true;
					break;
				}
			}
			if(!isEdge){//没边false
				return row;
			}
		}
		return -1;//没有找到没有后继顶点的顶点
	}
	//删除找到顶点
	public void deleteVertex(int delVert){//第几个顶点
		/*删除一个顶点，该顶点对应的行和列都需要删除
		 *1.若删除的是最后一个，则不需要处理二维数组，只需要删除顶点数量即可
	     *2.若删除的是中间的，要处理邻接矩阵，重新排序*/
		if(delVert!=nVerts-1){//要删顶点不是最后一个
			for(int i=delVert;i<nVerts-1;i++){
				//删除顶点后面元素向前移动
				vertexList[i] = vertexList[i+1];
			}
			for(int row = delVert;row<nVerts-1;row++){
				//把邻接矩阵中删除行后面各行向上移动
				moveRowUp(row,nVerts);
			}
			for(int col = delVert;col<nVerts-1;col++){
				//把邻接矩阵中删除列后面各列向左移动
				moveColLeft(col,nVerts-1);
			}
		}
		nVerts--;
	}
	private void moveRowUp(int row,int length){//哪一行，多少行
		for(int col=0;col<length;col++){
			//逐行扫描移上去
			adjMatrix[row][col] = adjMatrix[row+1][col];
		}
	}
	private void moveColLeft(int col,int length){
		for(int row=0;row<length;row++){
			//逐列扫描往左移
			adjMatrix[row][col] = adjMatrix[row][col+1];
		}
	}
}

public class TopologicalSort_39 {
	public static void main(String[] args) {
		GraphTo graph = new GraphTo();
		graph.addVertex('A');graph.addVertex('B');graph.addVertex('C');
		graph.addVertex('D');graph.addVertex('E');graph.addVertex('F');
		graph.addVertex('G');graph.addVertex('H');
		graph.addEdge(0, 3);//AD
		graph.addEdge(0, 4);//AE
		graph.addEdge(1, 4);//BE
		graph.addEdge(2, 5);//CF
		graph.addEdge(3, 6);//DG
		graph.addEdge(4, 6);//EG
		graph.addEdge(5, 7);//FH
		graph.addEdge(6, 7);//GH
		//有向图的拓扑排序
		graph.topo();

	}
}
