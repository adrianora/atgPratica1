package auxiliares;

import java.util.ArrayList;
import java.util.List;

import graph.p1.Edge;
import graph.p1.Vertex;

public class ShortPath<T> {

	private List<Vertex<T>> vertices;
	private List distances;
	private List<List> paths;
	
	public ShortPath(List<Vertex<T>> newVertices) {
		
		this.vertices =  newVertices;
		
	}
	
	public String shortPath(Vertex<T> root, Integer wantted) {
		
		this.paths = new ArrayList();
		this.distances = new ArrayList<>();
		List path = new ArrayList();
		
		if(root.getData() == wantted) {
			
			return wantted + " ";
		}else {
		
			this.findPaths(root, wantted, 0, path, 0);
			
			int indexPath = this.findShortestDistance();
			List shortestPath = this.paths.get(indexPath);
			
			String pathRepresentantion = this.printPath(shortestPath);
			
			return pathRepresentantion;
		}
	}
	
	private String printPath(List path) {
		
		String result = "";
		
		for(int i = 0; i < path.size(); i++) {
			
			result += path.get(i) + " ";
		}
		
		return result;
	}
	
	private int findShortestDistance() {
		
		int smaller = 0;
		double smallerNum = (double) this.distances.get(smaller);
		
		for(int i = 1; i < this.distances.size(); i++) {
			
			double e = (double) this.distances.get(i);
			
			if(e < smallerNum) {
				
				smaller = i;
				smallerNum = e;
			}
		}
		
		return smaller;
	}
	
	private List copy(List lista) {
		
		List newList = new ArrayList();
		
		for (int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i) != null) {
				
				newList.add(lista.get(i));
			}
		}
		
		return newList;
	}
	
	private void findPaths(Vertex<T> vertex, Integer wanted, double weigth, List path, int level) {

		if(vertex.getData() != wanted) {
			
			vertex.setTrueMark();
			path.add(vertex.getData());
			
			if(vertex.getEdges().size() != 0) {
				
				for(Edge<T> edge : vertex.getEdges()) {
;
					if(!edge.getTo().isMarked()) {
						
						this.findPaths(edge.getTo(), wanted, weigth + edge.getWeight(), path, level + 1);
					}
				}
			}
			vertex.setFalseMark();
			path.remove(level);
		}
		else {
			
			this.distances.add(weigth);
			List list = this.copy(path);
			list.add(vertex.getData());
			this.paths.add(list);
		}
	}
}
