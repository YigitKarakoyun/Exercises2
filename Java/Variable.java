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

//
import java.util.Scanner;
class apples{
    public static void main(String args[]){
	Scanner bucky = new Scanner(System.in);
	System.out.println(bucky.nextLine());
    }
}

//
import java.util.Scanner;
class apples{
    public static void main(String args[]){
	Scanner bucky = new Scanner(System.in);
	System.out.println(bucky.nextLine());
	double fnum,snum,answer;
	System.out.println("Enter first num: ");
	fnum = bucky.nextDouble();
	System.out.println("Enter Secand num: ");
	snum = bucky.nextDouble();
	answer = fnum + snum;
	System.out.println(answer);
    }
}
