package grafos_p1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;


public class GraphBuilderImpl<T> implements GraphBuilder<T>{
	
	
	public  List<Vertex<T>> vertexs = new ArrayList<>();
	public  List<Edge<T>> edges = new ArrayList<>();
	
	private  void reader(String path, boolean temPeso) throws IOException {
		
		FileReader file = new FileReader(path);
		BufferedReader buffRead = new BufferedReader(file);
		String line = buffRead.readLine();
		
		int cont = 1;
		
		while( line != null) {
			
			if( cont != 1) {
				
				String[] lineArray = line.split(" ");
				
				T data1 = (T) lineArray[0];
				T data2 = (T) lineArray[1];
				
				Vertex<T> vertex1 = getVertex(data1, vertexs);
				Vertex<T> vertex2 = getVertex(data2, vertexs);
				
				if( vertex1 == null) {
					
					 vertex1 = new VertexImpl<>();
					 vertex1.setData(data1);
				 }
				if( vertex2 == null) {
					
					vertex2 = new VertexImpl<>();
					vertex2.setData(data2);
				}
				
				Edge<T> edge = new EdgeImpl<>();
				
				edge.setFrom(vertex1);
				edge.setTo(vertex2);
				
				if(temPeso) {
					
					T weight = (T) lineArray[2];
					edge.setWeight(weight);
				}
				vertex1.addEdge(edge);
				
				if(!vertexs.contains(vertex1)) {
					this.vertexs.add(vertex1);
				}
				if(!vertexs.contains(vertex2)) {
					this.vertexs.add(vertex2);
				}
				this.edges.add(edge);	
			}
			
			line = buffRead.readLine();
			cont++;
		}
		file.close();
				
	}
	
	private Vertex<T> getVertex(T data, List<Vertex<T>> vertexs){
		
		for(Vertex<T> vertex : vertexs) {
			
			if(vertex.getData() !=null) {
			
				if (vertex.getData().equals(data)){
					
					return vertex;
				}
			}
		}
		return null;
	}

	@Override
	public void addVertex(Vertex<T> from, Vertex<T> to) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getVertexNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getEdgeNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getMeanEdge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String graphRepresentation(String graph, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String BFS(String graph, String vertice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DFS(String graph, String vertice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String SCC(String graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String shortestPath(String v1, String v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mst(String graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readGraph(String path) throws IOException {
		
		this.reader(path, false);
		
	}

	@Override
	public void readWeightedGraph(String path) throws IOException {
		
		this.reader(path, true);
		
	}
}
