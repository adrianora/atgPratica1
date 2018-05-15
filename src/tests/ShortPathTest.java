package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import auxiliares.ShortPath;
import graph.p1.Graph;
import graph.p1.GraphImpl;
import graph.p1.Vertex;

public class ShortPathTest<T> {
	
	Graph<Integer> graph;
	ShortPath<T> sp;
	
	String path = "src/tests/entradaText.txt";
	
	@Before
	public void setUp() throws IOException {
		defaultConstructors();
		graph.readWeightedGraph(path);
		
		sp = new ShortPath(this.graph.getVertices());
	}
	
	private void defaultConstructors() {
		graph = new GraphImpl<>();
	}
	
	@Test
	public void test1() {
		
		Vertex vertex1 =  this.graph.getVertices().get(0);		
		Vertex vertex2 =  this.graph.getVertices().get(3);		
		Vertex vertex3 =  this.graph.getVertices().get(4);		
		Vertex vertex4 =  this.graph.getVertices().get(2);		
		Vertex vertex5 =  this.graph.getVertices().get(1);
		
		assertEquals(3, this.sp.shortPath(vertex1, 5).split(" ").length);
		assertEquals(2,  this.sp.shortPath(vertex2, 5).split(" ").length);
		assertEquals(2,  this.sp.shortPath(vertex3, 5).split(" ").length);
		assertEquals(1,  this.sp.shortPath(vertex4, 5).split(" ").length);
		assertEquals(2,  this.sp.shortPath(vertex5, 5).split(" ").length);
	}
	
	@Test
	public void test2() {
		
		Vertex vertex1 =  this.graph.getVertices().get(0);		
		Vertex vertex2 =  this.graph.getVertices().get(3);		
		Vertex vertex3 =  this.graph.getVertices().get(4);		
		Vertex vertex4 =  this.graph.getVertices().get(2);		
		Vertex vertex5 =  this.graph.getVertices().get(1);
		
		this.graph.shortestPath(vertex1, vertex4);
		System.out.println();
		this.graph.shortestPath(vertex5, vertex4);
		System.out.println();
		this.graph.shortestPath(vertex1, vertex3);
		
		
		
	}
}
