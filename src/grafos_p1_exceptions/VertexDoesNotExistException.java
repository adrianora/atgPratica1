package grafos_p1_exceptions;

public class VertexDoesNotExistException extends Exception {

	private static final long serialVersionUID = -6252206721341068729L;
	
	public VertexDoesNotExistException() {
		super("O vertice nao existe neste grafo");
	}
	
}
