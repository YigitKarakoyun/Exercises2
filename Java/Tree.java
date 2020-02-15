//
public class Tree{
    int number;
    Tree left, right;
    public Tree(int sayi, 
        Tree lefttree, 
        Tree righttree) {
        this.number = sayi;
        this.left = lefttree;
        this.right = righttree;
    }
    public static void print(Tree tree) {
        if (tree == null)return;
        print(tree.left);
        System.out.print(tree.number + " ");
        print(tree.right);
    }    
}
public class CreateTree {
    public static void main(String[] args) {
      Tree bes = new Tree(5, null, null);
      Tree dort = new Tree(4, null, null);
      Tree iki = new Tree(2, dort, bes);
      Tree uc = new Tree(3, null, null);
      Tree bir = new Tree(1, iki, uc);
      Tree.print(bir);
    }
}

//
public class BinaryTree {
    public static void print(Node n) {
        if (n == null) {
            System.out.println("");
            return;
        }
        System.out.print(n.number + " ");
        print(n.right);
        print(n.left);
    }
    public void addNode(Node child,Node parent) {
        if (parent.right == null) 
        {
          parent.right = child;
        } else if (parent.left == null) {
          parent.left = child;
        }
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        
        Node a4 = new Node(4, null, null);
        Node a5 = new Node(5, null, null);
        Node a6 = new Node(6, null, null);
        Node a7 = new Node(7, null, null);
        Node a2 = new Node(2, a4, a5);
        Node a3 = new Node(2, a6, a7);
        Node a1 = new Node(1, a2, a3);
      //  agacYapici.yazdir(a1);
        bt.addNode(new Node(8, null, null), a4);
        bt.addNode(new Node(9, null, null), a4);
        bt.print(a1);
    }
}
class Node{
  Node left, right;
    int number;
    public Node(int value, Node rightNode, Node leftNode){
        this.right = rightNode;
        this.left = leftNode;
        this.number = value;
    }
}

//
public class UcluAgac {
    public static void print(Tree t) {
        if (t == null) {
            return;
        }
        System.out.println(t.data);
        print(t.right);
        print(t.middle);
        print(t.left);
    }
    public void add(Tree child,
        Tree parent) {
        if (parent.right == null) {
          parent.right = child;
        } else if (parent.middle == null) {
          parent.middle = child;
        } else if (parent.left == null) {
          parent.left = child;
        }
    }
    public static void main(String[] args) {
      Tree a5 = new Tree(5, null, null, null);
      Tree a6 = new Tree(6, null, null, null);
      Tree a7 = new Tree(7, null, null, null);
      Tree a8 = new Tree(8, null, null, null);
      Tree a2 = new Tree(2, null, null, a5);
        Tree a3 = new Tree(3, a6, null, a7);
        Tree a4 = new Tree(4, a8, null, null);
        
        Tree a1 = new Tree(1, a2, a3, a4);
        UcluAgac.print(a1);
    }
}
class Tree {
  Tree right, middle, left;
    int data;
    public Tree(int data, Tree right,
        Tree middle, Tree left) {
        this.right = right;
        this.left = left;
        this.middle = middle;
        this.data = data;
    }
}
