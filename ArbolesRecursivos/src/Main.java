public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Árbol en orden: ");
        tree.inorder();

        System.out.println("Buscar 40: " + tree.search(40));
        System.out.println("Buscar 90: " + tree.search(90));

        System.out.println("Eliminar 20 (hoja)");
        tree.delete(20);
        tree.inorder();

        System.out.println("Eliminar 30 (un hijo)");
        tree.delete(30);
        tree.inorder();

        System.out.println("Eliminar 50 (dos hijos)");
        tree.delete(50);
        tree.inorder();
    }
}


 class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }

}

class BST {
    Node root;

    // Método para insertar un nuevo nodo
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root; // no inserta duplicados
    }

    // Método para buscar un valor en el BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        return value < root.value
            ? searchRec(root.left, value)
            : searchRec(root.right, value);
    }

    // Método para eliminar un nodo del BST
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // Caso 1: nodo sin hijos
            if (root.left == null && root.right == null) {
                return null;
            }
            // Caso 2: un solo hijo
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Caso 3: dos hijos -> buscar el sucesor (mínimo del subárbol derecho)
            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    // Método auxiliar para imprimir el árbol en orden
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
}
