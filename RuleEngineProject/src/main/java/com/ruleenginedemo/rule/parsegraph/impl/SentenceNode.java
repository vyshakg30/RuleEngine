package com.ruleenginedemo.rule.parsegraph.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.ruleenginedemo.rule.data.RuleCondition;
import com.ruleenginedemo.rule.parsegraph.GraphNode;

public class SentenceNode implements GraphNode {

	String name;
	HashMap<List<String>, SentenceNode> connections;

	public SentenceNode() {
		super();
		initialize();
	}

	public SentenceNode(String name) {
		super();
		this.name = name;
		initialize();
	}

	private void initialize() {
		connections = new HashMap<>();
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

	@Override
	public RuleCondition formRuleCondition(String value, String sourceID) {
		return null;
	}

	public SentenceNode getNextNode(String edgeValue) {

		for (List<String> edge : connections.keySet())
			if (edge.contains(edgeValue))
				return connections.get(edge);

		return this;
	};

}
