package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RuleParser {
    public ASTNode createRule(String ruleString) {
        // Tokenize and parse the rule string into an AST
        String[] tokens = ruleString.split(" ");
        Stack<ASTNode> stack = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (token.equals("AND") || token.equals("OR")) {
                operators.push(token);
            } else if (token.matches("\\(|\\)")) {
                // Handle parentheses (not implemented in this simple example)
                continue;
            } else {
                // Handle operands (e.g., "age > 30")
                ASTNode node = parseOperand(token);
                if (!operators.isEmpty()) {
                    String op = operators.pop();
                    ASTNode operatorNode = new ASTNode("operator", stack.pop(), node, op);
                    stack.push(operatorNode);
                } else {
                    stack.push(node);
                }
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
    private ASTNode parseOperand(String token) {
        // For simplicity, assuming tokens are simple operands or comparisons
        return new ASTNode("operand", null, null, token);
    }
    public ASTNode combineRules(String[] ruleStrings) {
        if (ruleStrings == null || ruleStrings.length == 0) {
            return null;
        }

        List<ASTNode> astNodes = new ArrayList<>();
        for (String ruleString : ruleStrings) {
            ASTNode node = createRule(ruleString);
            if (node != null) {
                astNodes.add(node);
            }
        }

        if (astNodes.size() == 1) {
            return astNodes.get(0);
        }

        // Combine AST nodes with AND as the default operator
        ASTNode combinedRoot = new ASTNode("operator", astNodes.get(0), astNodes.get(1), "AND");

        for (int i = 2; i < astNodes.size(); i++) {
            combinedRoot = new ASTNode("operator", combinedRoot, astNodes.get(i), "AND");
        }

        return combinedRoot;
    }
}
