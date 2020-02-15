//
import java.util.*;
    class ana_class{
	public static void main(String args[]){
	Stack<String> stack = new Stack<String>();
	stack.push("alt");
	printStack(stack);
	stack.push("orta");
	printStack(stack);
	stack.push("üst");
	printStack(stack);
	stack.pop();
	printStack(stack);
	stack.pop();
	printStack(stack);
	stack.pop();
	printStack(stack);
    }
    private static void printStack(Stack<String> s){
	if(s.isEmpty())	System.out.println("Stack Boş!");
	else System.out.printf("%s Stak Bilgileri\n",s);
    }
}

//
public class Stack {
    private int[] array;
    private int top;
    public Stack(int lenght){
      array = new int[lenght];
        top=-1;
    }
    public boolean empty(){
        return top==-1;
    }
    public void push(int a){
      array[top+1]=a;
        top++;
    }
    public int pop(){
        int a = array[top];
        top--;
        return a;
    }
    public int peek(){
        return array[top];
    }
    public void printStack(){
        for (int i = 0; i <= top; i++) {
           System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
      Stack y = new Stack(10);
        System.out.println("Stack boş mu? " + y.empty());
        y.push(1);
        y.printStack();
        y.push(2);
        y.printStack();
        y.push(3);
        y.printStack();
        y.push(5);
        y.printStack();
        y.push(8);
        y.printStack();
        System.out.println("Peek " + y.peek());
        System.out.println("Stack boş mu? " + y.empty());
        y.printStack();
        y.pop();
        y.printStack();
        y.pop();
        y.printStack();
        y.pop();
        y.printStack();
        y.pop();
        y.printStack();
        y.pop();
        y.printStack();
  
    }
}
