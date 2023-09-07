package co.edu.uptc.model;

public class Node {
	
	public int key;
	public int height;
	public Node left;
	public Node right;

	Node(int key) {
		this.key = key;
		this.height = 1;
	}
}
