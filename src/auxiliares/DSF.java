package auxiliares;
import grafos_p1.*;

public class DSF {
	
	public static final byte branco = 0;
	public static byte cinza = 1;
	public static byte preto = 2;
	
	private int d[ ] , t [ ] , antecessor [ ] ;
	private Graph graph;
	
	public DSF (Graph grafo ) {
		this.graph = grafo ; 
		int numberVertex = grafo.getVertexNumber();
		d = new int [numberVertex] ; t = new int [numberVertex] ; antecessor = new int [numberVertex];
	}
	
	private int visitaDfs ( int u, int tempo, int cor [ ] ) {
		return tempo;
	}

}
