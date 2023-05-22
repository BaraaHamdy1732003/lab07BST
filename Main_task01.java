import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_task01 {
    public static void main(String[] args) {
        Node f= new Node(1,null,null);
        Node g= new Node(4,null,null);
        Node h= new Node(7,null,null);
        Node i= new Node(13,null,null);

        Node d= new Node(14,i,null);
        Node e= new Node(6,g,h);
        Node c= new Node(10,null,d);
        Node b= new Node(3,f,e);
        Node a= new Node(8,b,c);

        BinarySearchTree tree= new BinarySearchTree(a);
        //a
        System.out.println("поддереве = "+tree.getNumOfNodes(a));
        System.out.println("all is дерева = "+tree.numOfNode());
        //b
        System.out.println("высоты = "+tree.getDepth(a));
        //c
        System.out.println("This is tree = "+tree.isBST(a,Integer.MIN_VALUE,Integer.MAX_VALUE));
        //d
        System.out.println("поиск по ключу = "+tree.searchByKey(a,7));
        //e
        System.out.println("Max = "+tree.getMax(a));
        //f
        System.out.println("Min = "+tree.getMin(a));
        //j
        BinarySearchTree treeFormFile=new BinarySearchTree();
         treeFormFile.readFormFile( "src\\input.txt");
         System.out.println("vasot = "+treeFormFile.getDepth(treeFormFile.getRoot()));
        //g
        System.out.println("The next element = " +tree.getNextNode(a,4));

    }
}
