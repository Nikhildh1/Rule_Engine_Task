package com.example;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class RuleEngineTest {

    @Test
    public void testCreateRule() {
        RuleParser parser = new RuleParser();
        ASTNode ast = parser.createRule("age > 30 AND department = 'Sales'");
        assertNotNull(ast);
    }

    @Test
    public void testCombineRules() {
        RuleParser parser = new RuleParser();
        String[] rules = {"age > 30", "salary > 50000"};
        ASTNode combinedAST = parser.combineRules(rules);
        assertNotNull(combinedAST);
    }

    @Test
    public void testEvaluateRule() {
        RuleParser parser = new RuleParser();
        RuleEvaluator evaluator = new RuleEvaluator();
        RuleStorage storage = new RuleStorage();

        String rule = "age > 30 AND salary > 50000";
        ASTNode ast = parser.createRule(rule);
        storage.saveRule("testRule", ast);

        Map<String, Object> data = new HashMap<>();
        data.put("age", 35);
        data.put("salary", 60000);

        boolean result = evaluator.evaluateRule(storage.getRule("testRule"), data);
        assertTrue(result);
    }
}
