package org.example;
public class Node {
    private	int key;
    private String data;
    private	Node left, right;

    public	Node() {
        this(-1, "", null, null);
    }

    public Node(int key, String data, Node left, Node right){
        this.key = key;
        this.data = data;
        this.left = left;
        this.right = right;
    };

    public String getData() { return data;};
    public Node getLeft(){ return left;};
    public Node getRight(){ return right;};
    public int getKey(){ return key; };
    public void setData(String data) { this.data = data;};
    public void setKey(int key){ this.key = key; };
    public void setLeft(Node left){ this.left = left; };
    public void setRight(Node right){ this.right = right; };
}

