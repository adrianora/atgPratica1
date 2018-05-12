package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graph.p1.Vertex;
import graph.p1.VertexImpl;

public class VertexTests {
	
	public Vertex<Integer> vertice;
	
	@Before
	public void setUp() {
		vertice = new VertexImpl<>();
	}
	
	@Test
	public void verticeIsEmpty() {
		Assert.assertEquals(true, this.vertice.isEmpty());
	}

}
