package com.example;

import java.util.HashMap;
import java.util.Map;

public class RuleEngine {
    public static void main(String[] args) {
        RuleParser parser = new RuleParser();
        RuleEvaluator evaluator = new RuleEvaluator();
        RuleStorage storage = new RuleStorage();


        String rule1 = "((age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing')) AND (salary > 50000 OR experience > 5)";
        String rule2 = "((age > 30 AND department = 'Marketing')) AND (salary > 20000 OR experience > 5)";


        ASTNode ast1 = parser.createRule(rule1);
        ASTNode ast2 = parser.createRule(rule2);
        storage.saveRule("rule1", ast1);
        storage.saveRule("rule2", ast2);

        ASTNode combinedAST = parser.combineRules(new String[]{rule1, rule2});
        storage.saveRule("combined", combinedAST);

        Map<String, Object> data = new HashMap<>();
        data.put("age", 35);
        data.put("department", "Sales");
        data.put("salary", 60000);
        data.put("experience", 3);

        boolean result = evaluator.evaluateRule(storage.getRule("combined"), data);
        System.out.println("Eligibility: " + result);
    }
}
