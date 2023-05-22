class Node {
    private int key;
    private Node left;
    private Node right;
    private Node parent;
    public Node() { }



    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;

    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return key +" " ;

    }
}