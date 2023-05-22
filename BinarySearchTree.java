import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    //a подсчет количества вершин.

    //a count the number of vertices.
    public int getNumOfNodes(Node node) {
        if (node == null) return 0;
        return 1 + getNumOfNodes(node.getLeft()) + getNumOfNodes(node.getRight());

    }

    public int numOfNode() {
        return getNumOfNodes(root);
    }

    //b) нахождение высоты дерева
//b) finding the height of a tree
    public int getDepth(Node node) {
        if (node == null) return 0;
        int l = getDepth(node.getLeft());
        int r = getDepth(node.getRight());
        return Math.max(l, r) + 1;
    }

    //  c) проверта того, является ли дерево BST: для каждой вершины ключи в левом поддерева меньше,
    //c) Checking if the tree is BST: for each vertex, the keys in the left subtree are less,
    // those in the right subtree are greater
    public boolean isBST(Node node, int low, int high) {
        if (node == null) return true;
        if (node.getKey() <= low || node.getKey() >= high) {
            return false;
        }
        return isBST(node.getLeft(), low, node.getKey()) && isBST(node.getRight(), node.getKey(), high);


    }

    //d) поиск по ключу
//d) search by key
    public Node searchByKey(Node node, int key) {
        if (node == null || node.getKey() == key) {
            return node;
        }
        if (key < node.getKey()) {
            return searchByKey(node.getLeft(), key);
        }
        return searchByKey(node.getRight(), key);
    }

    //e) поиск максимального элемента в дереве
//e) finding the maximum element in a tree
    public Node getMax(Node node) {
        while (node.getRight() != null)
            node = node.getRight();
        return node;

    }

    //f) поиск минимального элемента в дереве
//f) finding the minimum element in a tree
    public Node getMin(Node node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;

    }

    //j) чтение данных для дерева из текстового файла
    //j)reading tree data from a text file
    public void readFormFile(String path) {
        try (Scanner scanner = new Scanner(new File(path))) {
            int n = scanner.nextInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node();
            }
            for (int i = 0; i < n; i++) {
                nodes[i].setKey(scanner.nextInt());
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                if (left != 0) {
                    nodes[i].setLeft(nodes[left - 1]);
                    nodes[left - 1].setParent(nodes[i]);
                }
                if (right != 0) {
                    nodes[i].setRight(nodes[right - 1]);
                    nodes[right - 1].setParent(nodes[i]);
                }

            }
            root = nodes[0];

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }
    }

    //g) для заданного элемента поиск следующего элемента
    //g) for a given element, search for the next element
    public Node getNextNode(Node root, int target) {
        Node prev = null;
        while (root != null) {
            if (root.getKey() == target) {
                if (root.getRight() != null) {
                    Node node = root.getRight();
                    while (node.getLeft() != null) {
                        node = node.getLeft();
                    }
                    return node;
                } else {
                    return prev;
                }
            } else if (root.getKey() > target) {
                prev = root;
                root = root.getLeft();

            } else {
                root = root.getRight();
            }
        }
        return null;
    }

    //h) удаление элемента по ключу
    //h) deleting an element by key
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.getKey()) {
            root.setLeft(deleteRec(root.getLeft(), key));
        } else if (key > root.getKey()) {
            root.setRight(deleteRec(root.getRight(), key));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            Node successor = findMinRecusive(root.getRight());
            root.setKey(successor.getKey());
            root.setRight(deleteRec(root.getRight(), successor.getKey()));
        }
        return root;
    }

    private Node findMinRecusive(Node root) {
        if (root.getLeft() == null) {
            return root;
        }
        return findMinRecusive(root.getLeft());
    }

    //i) вставка элемента
//i) element insertion
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key, null, null);
        }
        if (key < root.getKey()) {
            root.setLeft(insertRec(root.getLeft(), key));
        } else if (key > root.getKey()) {
            root.setRight(insertRec(root.getRight(), key));
        }
        return root;
    }

    //k
    public void deleteVertices(int [] keys) {
        for (int key : keys) {
             root = deleteVertices(root,key);
        }
    }

    private Node deleteVertices(Node root, int key) {
        return root;
    }

     private int countVer(Node node) {
        return  countVerticesRecursive(root);
    }
    private int countVerticesRecursive(Node node) {
        if (node == null) {
            return 0;
        }

        int leftCount = countVerticesRecursive(node.getLeft());
        int rightCount = countVerticesRecursive(node.getRight());

        return leftCount + rightCount + 1;
    }
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
