package com.example.ruleenginedemo.rule.impl;

import java.util.List;
import java.util.Set;

import com.example.ruleenginedemo.data.RuleCondition;
import com.example.ruleenginedemo.data.StringHelper;
import com.example.ruleenginedemo.data.graph.LowerLimitHandleNode;
import com.example.ruleenginedemo.data.graph.NegativeAffirmitiveNode;
import com.example.ruleenginedemo.data.graph.PostiveAffirmitiveNode;
import com.example.ruleenginedemo.data.graph.SentenceNode;
import com.example.ruleenginedemo.data.graph.UpperLimitHandleNode;
import com.example.ruleenginedemo.rule.ParseGraph;

public class SentenceParseGraph implements ParseGraph {

	SentenceNode rootNode;

	public SentenceParseGraph() {
		constructTree();

	}

	private void constructTree() {

		rootNode = new SentenceNode("signalid");

		SentenceNode positiveAffirmitiveNode = new PostiveAffirmitiveNode();
		SentenceNode negativeAffirmitiveNode = new NegativeAffirmitiveNode();

		// level 1
		rootNode.addChild(StringHelper.POSITIVEWORDS, positiveAffirmitiveNode);
		rootNode.addChild(StringHelper.NEGATIVEWORDS, negativeAffirmitiveNode);

		// level 2
		SentenceNode lowerLimitHandleNode = new LowerLimitHandleNode();
		SentenceNode upperLimitHandleNode = new UpperLimitHandleNode();

		positiveAffirmitiveNode.addChild(StringHelper.UPPERLIMITWORDS, upperLimitHandleNode);
		positiveAffirmitiveNode.addChild(StringHelper.LOWERLIMITWORDS, lowerLimitHandleNode);

		negativeAffirmitiveNode.addPath(StringHelper.UPPERLIMITWORDS, lowerLimitHandleNode);
		negativeAffirmitiveNode.addPath(StringHelper.LOWERLIMITWORDS, upperLimitHandleNode);

		// cross path
		positiveAffirmitiveNode.addPath(StringHelper.NEGATIVEWORDS, negativeAffirmitiveNode);
		negativeAffirmitiveNode.addPath(StringHelper.NEGATIVEWORDS, positiveAffirmitiveNode);

		negativeAffirmitiveNode.addPath(StringHelper.TRICKYWORDS, rootNode);

	}

	public RuleCondition getRuleCondition(String ruleSentence) {
		return getRuleCondition(ruleSentence.split(StringHelper.SPLITLITERALS));
	}

	public RuleCondition getRuleCondition(String[] ruleSentenceTokens) {

		SentenceNode currentNode = rootNode;

		if (!StringHelper.isAlphaNumeric(ruleSentenceTokens[0]))
			return null;

		// Traverse Graph to find final node
		Set<List<String>> connectionSet = currentNode.getConnections().keySet();
		for (String ruleSentenceToken : ruleSentenceTokens)
			for (List<String> edge : connectionSet)
				if (edge.contains(ruleSentenceToken)) {
					currentNode = currentNode.getConnections().get(edge);
					connectionSet = currentNode.getConnections().keySet();
				}
		// End of Traversal

		int lastIndex = ruleSentenceTokens.length;
		String value = ruleSentenceTokens[lastIndex - 1];
		String sourceID = ruleSentenceTokens[0];

		return currentNode.formRule(value, sourceID);

	}

}
