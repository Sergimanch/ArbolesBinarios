
class ArbolBinario {
 Nodo raiz;
 
 public ArbolBinario() {
     this.raiz = null;
 }
 
 // Método para insertar nodos en el árbol
 public void insertarNodo(int valor) {
     raiz = insertarRecursivo(raiz, valor);
 }
 
 private Nodo insertarRecursivo(Nodo nodo, int valor) {
     if (nodo == null) {
         return new Nodo(valor);
     }
     
     if (valor < nodo.dato) {
         nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
     } else if (valor > nodo.dato) {
         nodo.derecho = insertarRecursivo(nodo.derecho, valor);
     }
     
     return nodo;
 }
 
 // Método público para recorrido POSTORDEN
 public void recorridoPostorden() {
     System.out.print("Recorrido Postorden: ");
     postorden(raiz);
     System.out.println();
 }
 
 // Método recursivo privado para postorden
 private void postorden(Nodo nodo) {
     if (nodo == null) {
         return;
     }
     
     // 1. Recorrer subárbol izquierdo
     postorden(nodo.izquierdo);
     
     // 2. Recorrer subárbol derecho
     postorden(nodo.derecho);
     
     // 3. Visitar el nodo raíz
     System.out.print(nodo.dato + " ");
 }
 public void recorridoPreorden() {
	 System.out.print("Recorrido Preorden: ");
	 preorden(raiz);
	 System.out.println();
	 
 }
 private void preorden(Nodo nodo) {
	 if(nodo == null) {
		 return;
	 }
	 System.out.print(nodo.dato + " ");
	 preorden(nodo.izquierdo);
	 
	 preorden(nodo.derecho);
	 
 }
 public void recorridoInorden() {
	 System.out.print("Recorrido Inorden: ");
	 inorden(raiz);
	 System.out.println();
	 }
 private void inorden(Nodo nodo) {
	 if(nodo == null) {
		 return;
	 }
	 inorden(nodo.izquierdo);
	 System.out.print(nodo.dato + " ");
	 inorden(nodo.derecho);
	 
 }
 
 
}