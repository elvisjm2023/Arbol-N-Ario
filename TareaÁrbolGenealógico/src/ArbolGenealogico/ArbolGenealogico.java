package ArbolGenealogico;

import java.util.Scanner;

public class ArbolGenealogico {

  Nodo raiz;

  public ArbolGenealogico() {
	  raiz = new Nodo("Joaquín");
      
      Nodo omar = new Nodo("Omar");
      omar.hijos.add(new Nodo("Elvis"));
      omar.hijos.add(new Nodo("Anthonny"));
      omar.hijos.add(new Nodo("Jefferson"));
      omar.hijos.add(new Nodo("Joel"));
      omar.hijos.add(new Nodo("Angie"));
      
      Nodo rolando = new Nodo("Rolando");
      rolando.hijos.add(new Nodo("Edison"));
      rolando.hijos.add(new Nodo("Jonathan"));
      
      Nodo elias = new Nodo("Elías");
      
      Nodo melva = new Nodo("Melva");
      melva.hijos.add(new Nodo("Henrry"));
      melva.hijos.add(new Nodo("Deisy"));
      
      Nodo gissella = new Nodo("Gissella");
      gissella.hijos.add(new Nodo("Alexander"));
      gissella.hijos.add(new Nodo("Oscar"));
      
      raiz.hijos.add(omar);
      raiz.hijos.add(rolando);
      raiz.hijos.add(elias);
      raiz.hijos.add(melva);
      raiz.hijos.add(gissella);
  }
  
  
  public void insertarNodo(Nodo padre, Nodo hijo) {
	    if (raiz == null) {
	        raiz = hijo;
	    } else {
	        padre.hijos.add(hijo);
	    }
	}
  
  public void eliminarNodo(String nombre) {
	    Nodo nodoAEliminar = buscar(nombre);
	    if (nodoAEliminar == null) {
	        System.out.println("El nodo no existe en el árbol.");
	        return;
	    }
	    eliminarNodo(raiz, nodoAEliminar);
	}

	private void eliminarNodo(Nodo nodo, Nodo nodoAEliminar) {
	    if (nodo == null) return;
	    if (nodo.hijos.contains(nodoAEliminar)) {
	        nodo.hijos.remove(nodoAEliminar);
	        return;
	    }
	    for (Nodo hijo : nodo.hijos) {
	        eliminarNodo(hijo, nodoAEliminar);
	    }
	}

  public boolean arbolVacio() {
	  return raiz == null;
	  }

  public Nodo buscar(String nombre) {
	    return buscarDFS(raiz, nombre);
	}

	private Nodo buscarDFS(Nodo nodo, String nombre) {
	    if (nodo == null) {
	        return null;
	    }
	    if (nodo.nombre.equals(nombre)) {
	        return nodo;
	    }
	    for (Nodo hijo : nodo.hijos) {
	        Nodo resultado = buscarDFS(hijo, nombre);
	        if (resultado != null) {
	            return resultado;
	        }
	    }
	    return null;
	}


	public void preOrden(Nodo n) {
	    if (n != null) {
	        System.out.print(n.nombre + " ");
	        for (Nodo hijo : n.hijos) {
	            preOrden(hijo);
	        }
	    }
	}

	public void postOrden(Nodo n) {
	    if (n != null) {
	        for (Nodo hijo : n.hijos) {
	            postOrden(hijo);
	        }
	        System.out.print(n.nombre + " ");
	    }
	}

  
	public void mostrarArbol(Nodo n, int contador) {
	    if (n != null) {
	        for (int i = 0; i < contador; i++) {
	            System.out.print(" ");
	        }
	        System.out.println(n.nombre);
	        for (Nodo hijo : n.hijos) {
	            mostrarArbol(hijo, contador + 1);
	        }
	    }
	}

	public int altura(Nodo n) {
	    if (n == null) return 0;
	    int maxAltura = 0;
	    for (Nodo hijo : n.hijos) {
	        int alturaHijo = altura(hijo);
	        if (alturaHijo > maxAltura) {
	            maxAltura = alturaHijo;
	        }
	    }
	    return maxAltura + 1;
	}
}