package co.edu.uptc.model;

public class TreeAVL {
	NodeAVL root;
	public void clearAll() {
		root = null;
	}
	/***************************************************************************/
	/****************************** INSERCION **********************************/
	/***************************************************************************/

	public void insertar(int key) {
		root = insertarAVL(root, key);
	}

	private NodeAVL insertarAVL(NodeAVL nodoActual, int key) {
		if (nodoActual == null) {
			return (new NodeAVL(key));
		}
		if (key < nodoActual.key) {
			nodoActual.left = insertarAVL(nodoActual.left, key);
		}if (key > nodoActual.key) {
			nodoActual.right = insertarAVL(nodoActual.right, key);
		} else {// Si la clave esta duplicada retorna el mismo nodo encontrado
			return nodoActual;
		}
		// Actualizacion de la altura
		nodoActual.altura = 1 + max(getAltura(nodoActual.left), getAltura(nodoActual.right));
		// Se obtiene el factor de equilibrio
		int fe = getFactorEquilibrio(nodoActual);
		// Caso Rotacion Simple a la derecha
		if (fe > 1 && key < nodoActual.left.key) {
			return rightRotate(nodoActual);
		}
		// Caso Rotacion Simple a la izquierda
		if (fe < -1 && key > nodoActual.right.key) {
			return leftRotate(nodoActual);
		}
		// Caso Rotacion Doble Izquierda Derecha
		if (fe > 1 && key > nodoActual.left.key) {
			nodoActual.left = leftRotate(nodoActual.left);
			return rightRotate(nodoActual);
		}
		// Caso Rotacion Doble Derecha Izquierda
		if (fe < -1 && key < nodoActual.right.key) {
			nodoActual.right = rightRotate(nodoActual.right);
			return leftRotate(nodoActual);
		}

		return nodoActual;
	}

	/***************************************************************************/
	/****************************** ROTACIONES *********************************/
	/***************************************************************************/
//    // Rotar hacia la derecha

	private NodeAVL rightRotate(NodeAVL nodoActual) {
		NodeAVL nuevaRaiz = nodoActual.left;
		NodeAVL temp = nuevaRaiz.right;

		// Se realiza la rotacion
		nuevaRaiz.right = nodoActual;
		nodoActual.left = temp;

		// Actualiza alturas
		nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
		nuevaRaiz.altura = max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right)) + 1;

		return nuevaRaiz;
	}

	// Rotar hacia la izquierda
	private NodeAVL leftRotate(NodeAVL nodoActual) {
		NodeAVL nuevaRaiz = nodoActual.right;
		NodeAVL temp = nuevaRaiz.left;
		// Se realiza la rotacion
		nuevaRaiz.left = nodoActual;
		nodoActual.right = temp;
		// Actualiza alturas
		nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
		nuevaRaiz.altura = max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right)) + 1;

		return nuevaRaiz;
	}

	/***************************************************************************/
	/******************************** MOSTRAR **********************************/
	/***************************************************************************/

	public void mostrarArbolAVL() {
		System.out.println("Arbol AVL");
		showTree(root, 0);
	}

	private void showTree(NodeAVL nodo, int depth) {
		if (nodo.right != null) {
			showTree(nodo.right, depth + 1);
		}
		for (int i = 0; i < depth; i++) {
			System.out.print("    ");
		}
		System.out.println("(" + nodo.key + ")");
		if (nodo.left != null) {
			showTree(nodo.left, depth + 1);
		}
	}

	/***************************************************************************/
	/****************************** AUXILIARES *********************************/
	/***************************************************************************/

	private int getAltura(NodeAVL nodoActual) {
		if (nodoActual == null) {
			return 0;
		}
		return nodoActual.altura;
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private int getFactorEquilibrio(NodeAVL nodoActual) {
		if (nodoActual == null) {
			return 0;
		}
		return getAltura(nodoActual.left) - getAltura(nodoActual.right);
	}

}