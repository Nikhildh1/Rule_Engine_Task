package com.example;

import java.util.HashMap;
import java.util.Map;

public class RuleStorage {
    private Map<String, ASTNode> ruleStore = new HashMap<>();

    public void saveRule(String ruleName, ASTNode rule) {
        ruleStore.put(ruleName, rule);
    }

    public ASTNode getRule(String ruleName) {
        return ruleStore.get(ruleName);
    }
}
