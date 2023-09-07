package co.edu.uptc.presenter;

import co.edu.uptc.model.AVLTree;

public class Presenter {
	
	private AVLTree tree;
	
	public Presenter() {
		tree = new AVLTree();

		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);

		System.out.println("Preorder del arbol:");
		tree.preOrder(tree.root);
		tree.root = tree.deleteNode(tree.root, 20);
		System.out.println("\nPreorder del arbol despues de la eliminacion:");
		tree.preOrder(tree.root);
	}
	
	public static void main(String[] args) {
		new Presenter();
	}
}
