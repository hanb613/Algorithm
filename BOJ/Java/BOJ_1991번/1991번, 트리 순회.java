import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static Node node;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		node = new Node('A', null, null);
		
		char a, b, c;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			a = st.nextToken().charAt(0);
			b = st.nextToken().charAt(0);
			c = st.nextToken().charAt(0);
			
			insert(node, a, b, c);
		}
		
		preOrder(node);
		System.out.println();
		
		inOrder(node);
		System.out.println();
		
		postOrder(node);
	}
	
	private static void insert(Node node, char a, char b, char c) {
		if(node.root == a) {
			if(b=='.') node.left=null;
			else node.left=new Node(b, null, null);
			
			if(c=='.') node.right=null;
			else node.right=new Node(c, null, null);
		} else {
			if(node.left!=null) insert(node.left, a, b, c);
			if(node.right!=null) insert(node.right, a, b, c);
		}
	}
	
	private static void preOrder(Node node) {
		if(node==null) return;
		
		System.out.print(node.root);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void inOrder(Node node) {
		if(node==null) return;
		
		inOrder(node.left);
		System.out.print(node.root);
		inOrder(node.right);
	}
	
	private static void postOrder(Node node) {
		if(node==null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.root);
	}
	
	private static class Node{
		char root;
		Node left, right;
		
		public Node(char root, Node left, Node right) {
			this.root = root;
			this.left = left;
			this.right = right;
		}
	}
}