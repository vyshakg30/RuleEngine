package com.example.ruleenginedemo.data.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.example.ruleenginedemo.data.ConditionType;
import com.example.ruleenginedemo.data.RuleCondition;

public class SentenceNode implements GraphNode {

	String name;
	boolean isLeaf;
	HashMap<List<String>, SentenceNode> connections;
	ConditionType type;

	public SentenceNode() {
		connections = new HashMap<>();
		type = ConditionType.UNKNOWN;
	}

	public SentenceNode(String name) {
		this.name = name;
		connections = new HashMap<>();
		type = ConditionType.UNKNOWN;
	}

	public SentenceNode(String name, ConditionType type) {
		super();
		this.name = name;
		this.type = type;
		connections = new HashMap<>();
	}

	public SentenceNode(ConditionType type) {
		super();
		this.type = type;
		connections = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public HashMap<List<String>, SentenceNode> getConnections() {
		return connections;
	}

	public void setConnections(HashMap<List<String>, SentenceNode> connections) {
		this.connections = connections;
	}

	public void addChild(String[] edgeValues, SentenceNode child) {
		connections.put(Arrays.asList(edgeValues), child);

	}

	public void addPath(String[] edgeValues, SentenceNode child) {
		connections.put(Arrays.asList(edgeValues), child);

	}

	public ConditionType getType() {
		return type;
	}

	public void setType(ConditionType type) {
		this.type = type;
	}

	public RuleCondition formRule(String value, String sourceID) {
		return null;
	}

}
