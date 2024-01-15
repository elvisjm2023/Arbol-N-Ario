package ArbolGenealogico;

import java.util.Scanner;

public class Principal {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ArbolGenealogico arbol = new ArbolGenealogico();

    int opcion = 0;

    while (opcion != 10) {

      System.out.println("\nOpciones:");
      System.out.println("1. Añadir Nodo");
      System.out.println("2. Comprobar si está vacío");
      System.out.println("3. Buscar un nodo");
      System.out.println("4. Eliminar un nodo");
      System.out.println("5. Recorrido en orden"); 
      System.out.println("6. Recorrido preorden");
      System.out.println("7. Recorrido postorden");
      System.out.println("8. Mostrar árbol");
      System.out.println("9. Altura del árbol");
      System.out.println("10. Salir");

      System.out.print("\nIngrese opción: ");
      opcion = sc.nextInt();

      switch (opcion) {
      	case 1:
      		System.out.print("Ingrese el nombre del nodo (persona): ");
      		String nombre = sc.next();
      		System.out.print("Ingrese el nombre del padre de esta persona: ");
      		String nombrePadre = sc.next();
      		Nodo padre = arbol.buscar(nombrePadre);
      		if (padre != null) {
      			Nodo nuevo = new Nodo(nombre);
      			arbol.insertarNodo(padre, nuevo);
      			System.out.println("Nodo añadido exitosamente.");
      		} else {
      			System.out.println("No se encontró al padre. Asegúrate de que el nombre del padre esté en el árbol.");
      		}
    	  break;


        case 2:
          if (arbol.arbolVacio()) {
            System.out.println("El árbol está vacío");
          } else {
            System.out.println("El árbol no está vacío");
          }
          break;

        case 3:
          System.out.print("Ingrese nombre a buscar: ");
          String nombreBuscado = sc.next();
          Nodo encontrado = arbol.buscar(nombreBuscado);
          if (encontrado != null) {
            System.out.println("Nodo encontrado: " + encontrado.nombre);  
          } else {
            System.out.println("Nodo no encontrado");
          }
          break;

        case 4:
        	System.out.print("Ingrese el nombre del nodo a eliminar: ");
            String nombreAEliminar = sc.next();
            arbol.eliminarNodo(nombreAEliminar);

          break;

        case 5:
            System.out.println("La opción de 'Recorrido en orden' no se aplica a este tipo de árbol.");
          break;
        
        case 6:
          arbol.preOrden(arbol.raiz);
          break;

        case 7:
          arbol.postOrden(arbol.raiz);
          break;

        case 8:
          arbol.mostrarArbol(arbol.raiz, 0);
          break;

        case 9:
          System.out.println("Altura: " + arbol.altura(arbol.raiz));
          break;

        case 10:
          break;

        default:
          System.out.println("Opción inválida");
      }

    }

    sc.close();

  }

}