
public class Main {
 public static void main(String[] args) {
     ArbolBinario arbol = new ArbolBinario();
     
     // Insertar valores en el árbol
     System.out.println("Insertando valores: 5, 2, 12, 1, 3, 9, 21, 19, 25");
     arbol.insertarNodo(5);
     arbol.insertarNodo(2);
     arbol.insertarNodo(12);
     arbol.insertarNodo(1);
     arbol.insertarNodo(3);
     arbol.insertarNodo(9);
     arbol.insertarNodo(21);
     arbol.insertarNodo(19);
     arbol.insertarNodo(25);
     
     System.out.println("\nRecorridos del árbol:");
 // Raíz -> Izquierda -> Derecha
// Izquierda -> Raíz -> Derecha
     arbol.recorridoPostorden();
     arbol.recorridoPreorden(); 
     arbol.recorridoInorden(); 
 }
}