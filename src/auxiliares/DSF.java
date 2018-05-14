package auxiliares;
import java.util.List;

import graph.p1.*;

public class DSF<T> {
	
	private List<Vertex<T>> vertices;
	int matriz[][];
	int size;
	
	public DSF(List<Vertex<T>> vertices) {
		
		this.vertices = vertices;
		size = this.vertices.size();
		matriz = new int[size][2];
	}
	
	public int[][] getMatriz(){
		
		return this.matriz;
	}
	
	
	public <T> void depthSearch(Vertex<T> vertex) {
		
		Vertex<T> thisGraphVertex = this.getObjectVertexOnGraph(vertex);
		
		this.depthSearch(thisGraphVertex, null, 0);
	}
	
	public void printGeneratingTree(){
		
		for (int i = 0; i < this.size; i++) {
			
			for(int j = 0; j < 2; j++) {
				
				int father = this.matriz[i][0];
				int level = this.matriz[i][1];
				
				if (father == 0) {
				
					System.out.println((i + 1)+"-"+level+" -");
				}
				else { 
					
					System.out.println((i + 1)+"-"+level+" "+father);
				}
			}
		}
	}
	
	private <T> void depthSearch(Vertex<T> vertex, Vertex<T> father, int level) {
		
		vertex.setTrueMark();
		
		if(vertex.getNumberOfEdges() > 0) {
			
			for(Edge<T> edge : vertex.getEdges()) {
				
				if(!(edge.getTo().isMarked())){
					
					this.depthSearch(edge.getTo(), vertex, level + 1);
				}
			}
		}
		
		if (father == null) {
			
			this.matriz[vertex.getData() - 1][0] = 0;
		}
		else {
			
			this.matriz[vertex.getData() - 1][0] = father.getData();
		}
	
		this.matriz[vertex.getData() - 1][1] = level;
	}
	
	private <T> Vertex<T> getObjectVertexOnGraph(Vertex<T> vertex) {
		
		Vertex<T> result = null;
		
		if (this.vertices.contains(vertex)) {
			
			int indexOfVertex = this.vertices.indexOf(vertex);
			
			if (indexOfVertex != -1) {
			
				result = (Vertex<T>) this.vertices.get(indexOfVertex);
			}
		}
		return result;
	}

}
