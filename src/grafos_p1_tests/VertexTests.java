package grafos_p1_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import grafos_p1.Vertex;
import grafos_p1.VertexImpl;

public class VertexTests {
	
	public Vertex<Integer> vertice;
	
	@Before
	public void setUp() {
		vertice = new VertexImpl<>();		
	}
	
	@Test
	public void verticeIsEmpty() {
		Assert.assertEquals(false, this.vertice.isEmpty());
	}

}
