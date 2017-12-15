package com.ruleenginedemo.rule.impl;

import com.ruleenginedemo.rule.ParseGraph;
import com.ruleenginedemo.rule.data.RuleCondition;
import com.ruleenginedemo.rule.data.StringHelper;
import com.ruleenginedemo.rule.parsegraph.impl.LowerLimitHandleNode;
import com.ruleenginedemo.rule.parsegraph.impl.NegativeAffirmitiveNode;
import com.ruleenginedemo.rule.parsegraph.impl.PostiveAffirmitiveNode;
import com.ruleenginedemo.rule.parsegraph.impl.SentenceNode;
import com.ruleenginedemo.rule.parsegraph.impl.UpperLimitHandleNode;

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

		if (!StringHelper.isAlphaNumeric(ruleSentenceTokens[0]))
			return null;

		SentenceNode currentNode = rootNode;

		for (String ruleSentenceToken : ruleSentenceTokens)
			currentNode = currentNode.getNextNode(ruleSentenceToken);

		int lastIndex = ruleSentenceTokens.length;
		String value = ruleSentenceTokens[lastIndex - 1];
		String sourceID = ruleSentenceTokens[0];

		return currentNode.formRuleCondition(value, sourceID);

	}

}
