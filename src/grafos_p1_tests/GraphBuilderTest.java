package grafos_p1_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import grafos_p1.Edge;
import grafos_p1.EdgeImpl;
import grafos_p1.GraphBuilderImpl;
import grafos_p1.Vertex;
import grafos_p1.VertexImpl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GraphBuilderTest<T> {

	GraphBuilderImpl<T> reader;
	
	List<Edge<T>> edges = new ArrayList<>();
	List<Vertex<T>> vertexs = new ArrayList<>();
	String path = "/home/obi-wan/atg/test/entradaText.txt";
	
	@Before
	public void setUp() throws IOException {
		
		reader = new GraphBuilderImpl<>();
		Vertex<T> vertex1 = new VertexImpl<>();
		vertex1.setData((T) "1");
		
		Vertex<T> vertex2 = new VertexImpl<>();
		vertex2.setData((T) "2");
		
		Vertex<T> vertex3 = new VertexImpl<>();
		vertex3.setData((T) "3");
		
		Vertex<T> vertex4 = new VertexImpl<>();
		vertex4.setData((T) "4");
		
		Vertex<T> vertex5 = new VertexImpl<>();
		vertex5.setData((T) "5");
		
		Edge<T> edge1 = new EdgeImpl<>(vertex2, (float) 0.1);

		Edge<T> edge2 = new EdgeImpl<>(vertex5, (float) 0.2);
		
		Edge<T> edge3 = new EdgeImpl<>(vertex3, (float) 5);
		
		Edge<T> edge4 = new EdgeImpl<>(vertex5, (float) 2.3);

		Edge<T> edge5 = new EdgeImpl<>(vertex5, (float) 1);

		
		vertexs.add(vertex1);
		vertexs.add(vertex2);
		vertexs.add(vertex5);
		vertexs.add(vertex3);
		vertexs.add(vertex4);
		
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		edges.add(edge5);
		
		
		reader.readWeightedGraph(path);
	}
	
	@Test
	public void testConstrution() {
		
		assertEquals(this.vertexs.size(), reader.getVertices().size());
		
		assertEquals(this.vertexs.get(0).getData(), reader.getVertices().get(0).getData());
		assertEquals(this.vertexs.get(1).getData(), reader.getVertices().get(1).getData());
		assertEquals(this.vertexs.get(2).getData(), reader.getVertices().get(2).getData());
		assertEquals(this.vertexs.get(3).getData(), reader.getVertices().get(3).getData());
		assertEquals(this.vertexs.get(4).getData(), reader.getVertices().get(4).getData());
	
		
		assertEquals(this.edges.get(0).getWeight(), reader.getVertices().get(0).getEdges().get(0).getWeight(), 0.1);
		assertEquals(this.edges.get(1).getWeight(), reader.getVertices().get(1).getEdges().get(0).getWeight(), 0.2);
		assertEquals(this.edges.get(2).getWeight(), reader.getVertices().get(2).getEdges().get(0).getWeight(), 5.0);
		assertEquals(this.edges.get(4).getWeight(), reader.getVertices().get(4).getEdges().get(0).getWeight(), 2.3);
		assertEquals(this.edges.get(0).getWeight(), reader.getVertices().get(0).getEdges().get(1).getWeight(), 1.0);
	
	}
	
	@Test
	public void testDoubleBond() {
		
		Vertex<T> vertex2 = reader.getVertices().get(1);
		Edge<T> b1 = vertex2.getEdges().get(0); 
		Vertex<T> vertex1 = reader.getVertices().get(0);
		
		Vertex<T> vertex5 = reader.getVertices().get(2);
		Edge<T> b2 = vertex5.getEdges().get(0); 
		
		Vertex<T> vertex3 = reader.getVertices().get(3);
		Edge<T> b3 = vertex3.getEdges().get(0);
		
		Vertex<T> vertex4 = reader.getVertices().get(4);
		Edge<T> b4 = vertex5.getEdges().get(2);
		
		Edge<T> b5 = vertex5.getEdges().get(3);
		
		
		assertEquals(2, vertex1.getNumberOfEdges());
		assertEquals(2, vertex2.getNumberOfEdges());
		assertEquals(1, vertex3.getNumberOfEdges());
		assertEquals(1, vertex4.getNumberOfEdges());
		assertEquals(4, vertex5.getNumberOfEdges());
		
		assertEquals(vertex1.getData(), b1.getTo().getData());
		assertEquals(vertex2.getData(), b2.getTo().getData());
		assertEquals(vertex5.getData(), b3.getTo().getData());
		assertEquals(vertex4.getData(), b4.getTo().getData());
		assertEquals(vertex1.getData(), b5.getTo().getData());
	
	}	
}