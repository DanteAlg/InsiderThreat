package src.models;

import java.util.ArrayList;

public class Node {
	private ArrayList<Node> childrens;
	private String key;
	
	// Inicializa o nó com uma string(id) na chave
	public Node(String content) {
		this.key = content;
		this.childrens = new ArrayList<Node>();
	}
	
	// Retorna a quantidade de nós filhos deste nó
	public int getChildrenLength() {
		return this.childrens.size();
	}

	public void addNodeInChain(ArrayList<String> chain_keys) {
		Node currentNode = this;
		Node newNode = null;
				
		for(String v : chain_keys) {
			newNode = currentNode.getNodo(v);
				
			if (newNode == null)
				currentNode.addNode(new Node(v));
			else
				currentNode = newNode;
		}
	}
	
	// Retorna o valor do ID do objeto que representa o nó
	public String getKey() {
		return this.key;
	}
	
	// Adiciona um novo nó
	public void addNode(Node node) {
		childrens.add(node);
	}
	
	public Node getNodo(String k) {
		for (Node v : childrens) 
			if (v.getKey() == k) return v; 
		
		return null;
	}
}
