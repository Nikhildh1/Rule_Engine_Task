package com.example;

public class ASTNode {
    private String type;
    private ASTNode left;
    private ASTNode right;
    private String value;

    public ASTNode(String type, ASTNode left, ASTNode right, String value) {
        this.type = type;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ASTNode getLeft() {
        return left;
    }

    public void setLeft(ASTNode left) {
        this.left = left;
    }

    public ASTNode getRight() {
        return right;
    }

    public void setRight(ASTNode right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
