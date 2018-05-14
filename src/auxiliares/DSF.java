package auxiliares;
import java.util.List;

import graph.p1.*;

public class DSF<T> {
	
	private List<Vertex<T>> vertices;
	int matriz[][];
	int size;
	
	public DSF(List<Vertex<T>> newVertices) {
		
		this.vertices = newVertices;
		size = this.vertices.size();
		matriz = new int[size][2];
	}
	
	public int[][] getMatriz(){
		
		return this.matriz;
	}
	
	public void depthSearch(Vertex<T> vertex) {
		
		this.depthSearch(vertex, null, 0);
	}
	
	public String printGeneratingTree(){
		
		String result = "";
		
		for (int i = 0; i < this.size; i++) {
				
				int father = this.matriz[i][0];
				int level = this.matriz[i][1];
				
				if (father == 0) {
				
					result += ((i + 1)+" - "+level+" -"+"\n");
				}
				else { 
					
					result += ((i + 1)+" - "+level+" "+father+"\n");
				
			}
		}
		
		return result;
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
}
