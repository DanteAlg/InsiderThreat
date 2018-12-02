package src.models.services;
/**
 * @author Andrecio Costa / Dante Alighieri
 *
 */
import src.models.daos.*;

import java.util.ArrayList;

import java.sql.SQLException;

import src.models.*;

public class BuildForest {
	String startTime;
	String endTime;
	boolean userTree;
	ArrayList<Node> forest;
	ArrayList<Device> devices;
	ArrayList<Http> https;
	ArrayList<Logon> logons;

	public BuildForest(String start_at, String end_at, boolean ut) {
		startTime = start_at;
		endTime = end_at;
		userTree = ut;
		forest = new ArrayList<Node>();
	}

	/**
	 * Recupera os objetos de todas as atividades num periodo te tempo
	 * @return forest
	 */
	public ArrayList<Node> run() {
		
		DeviceDAO dDAO = new DeviceDAO();
		HttpDAO hDAO = new HttpDAO();
		LogonDAO lDAO = new LogonDAO();

		try {
			devices = dDAO.betweenDates(startTime, endTime);
			https = hDAO.betweenDates(startTime, endTime);
			logons = lDAO.betweenDates(startTime, endTime);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		buildUserNodes();

		return forest;
	}

	/**
	 * Percorrer cada objeto e procurar no banco o usuário
	 * Adicionar o usuário num nó
	 * No nó deste usuário adicionar a data
	 */
	private void buildUserNodes() {
		
		for (Device d : devices)
			setBuildNode("Device", d);
		for (Http h : https)
			setBuildNode("Http", h);
		for (Logon l : logons)
			setBuildNode("Logon", l);

	}

	private void setBuildNode(String kind, Activity a) {
		ArrayList<String> branch = new ArrayList<String>();
		branch.add(a.getDate());
		branch.add(a.getPcId());
		branch.add(kind);
		branch.add(a.getActivity());

		for (Node n : forest) {
			if (n.getKey() == a.getUserId()) {
				n.addNodeInChain(branch);

				return;
			}
		}

		Node node = new Node(a.getUserId());
		node.addNodeInChain(branch);
		forest.add(node);
	}
}
