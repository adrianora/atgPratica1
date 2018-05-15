package tests;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import auxiliares.BFS;
import graph.p1.Graph;
import graph.p1.GraphImpl;
import graph.p1.Vertex;

public class TestBFS<T> {
	
	Graph<Integer> graph;
	BFS<T> bsf;
	Vertex<T> root;
	
	String path = "src/tests/entradaText.txt";

	
	@Before
	public void setUp() throws IOException {
		defaultConstructors();
		graph.readWeightedGraph(path);
		bsf = new BFS(graph.getVertices());
		
		root = (Vertex<T>) this.graph.getVertices().get(0);
		this.bsf.breadthSearch(root);
	}

	private void defaultConstructors() {
		graph = new GraphImpl<>();
	}
	
	@Test
	public void testFather() {
		
		int matriz[][] = this.bsf.getMatriz();
		
		assertEquals(0, matriz[0][0]);
		assertEquals(1, matriz[1][0]);
		assertEquals(5, matriz[2][0]);
		assertEquals(5, matriz[3][0]);
		assertEquals(1, matriz[4][0]);
	}
	
	@Test
	public void testLevel() {
		
		int matriz[][] = this.bsf.getMatriz();
		
		assertEquals(0, matriz[0][1]);
		assertEquals(1, matriz[1][1]);
		assertEquals(2, matriz[2][1]);
		assertEquals(2, matriz[3][1]);
		assertEquals(1, matriz[4][1]);
	}
	
	@Test
	public void generatingTreeRepresentation() {
		
		System.out.println(this.graph.BFS(path, 1));
	}
}
