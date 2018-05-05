package arquivo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import grafos_p1.Edge;
import grafos_p1.EdgeImpl;
import grafos_p1.Vertex;
import grafos_p1.VertexImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Tests<T> {

	ManipuladorDeArquivo<T> leitor;
	
	List<Edge<T>> edges = new ArrayList<>();
	List<Vertex<T>> vertexs = new ArrayList<>();
	String path = "/home/obi-wan/atg/test/entradaText.txt";
	
	@Before
	public void setUp() throws IOException {
		
		leitor = new ManipuladorDeArquivo<>();
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
		
		Edge<T> edge1 = new EdgeImpl<>();
		edge1.setFrom(vertex1);
		edge1.setTo(vertex2);
		vertex1.addEdge(edge1);
		
		Edge<T> edge2 = new EdgeImpl<>();
		edge2.setFrom(vertex2);
		edge2.setTo(vertex5);
		vertex2.addEdge(edge2);
		
		Edge<T> edge3 = new EdgeImpl<>();
		edge3.setFrom(vertex5);
		edge3.setTo(vertex3);
		vertex5.addEdge(edge3);
		
		Edge<T> edge4 = new EdgeImpl<>();
		edge4.setFrom(vertex4);
		edge4.setTo(vertex5);
		vertex4.addEdge(edge4);
		
		Edge<T> edge5 = new EdgeImpl<>();
		edge5.setFrom(vertex1);
		edge5.setTo(vertex5);
		vertex1.addEdge(edge5);
		
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
		
		
		leitor.reader(path, true);
	}
	
	@Test
	public void test() {
		
		assertEquals(this.edges.size(), leitor.edges.size());
		assertEquals(this.vertexs.size(), leitor.vertexs.size());
		
		assertEquals(this.vertexs.get(0).getData(), leitor.vertexs.get(0).getData());
		assertEquals(this.vertexs.get(1).getData(), leitor.vertexs.get(1).getData());
		assertEquals(this.vertexs.get(2).getData(), leitor.vertexs.get(2).getData());
		assertEquals(this.vertexs.get(3).getData(), leitor.vertexs.get(3).getData());
		assertEquals(this.vertexs.get(4).getData(), leitor.vertexs.get(4).getData());
	
		assertEquals(this.edges.get(0).getWeight(), leitor.edges.get(0).getWeight());
		assertEquals(this.edges.get(1).getWeight(), leitor.edges.get(1).getWeight());
		assertEquals(this.edges.get(2).getWeight(), leitor.edges.get(2).getWeight());
		assertEquals(this.edges.get(3).getWeight(), leitor.edges.get(3).getWeight());
		assertEquals(this.edges.get(4).getWeight(), leitor.edges.get(4).getWeight());
	
	}
	
	
	
}