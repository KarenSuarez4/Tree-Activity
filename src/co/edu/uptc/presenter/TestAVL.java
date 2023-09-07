package co.edu.uptc.presenter;

import co.edu.uptc.model.TreeAVL;

public class TestAVL {

	public static void main(String[] args) {
		TreeAVL tree = new TreeAVL();
		tree.clearAll();
		tree.insertar(22);
		tree.insertar(15);
		tree.insertar(20);
		tree.insertar(33);
		tree.insertar(15);
	tree.mostrarArbolAVL();
	}

}
