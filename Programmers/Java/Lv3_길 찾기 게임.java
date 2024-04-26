import java.util.*;

class Solution {
    
    static int idx;
    static int[][] answer;
    static Node[] node;
    
    public int[][] solution(int[][] nodeinfo) {
        
        answer = new int[2][nodeinfo.length];
        node = new Node[nodeinfo.length];
        
        // 노드 정보 입력 받기
        for(int i=0; i<nodeinfo.length; i++){
            node[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }
        
        // y 좌표 - 내림차순, x 좌표 - 오름차순
        Arrays.sort(node);
        
        // 트리 만들기
        Node root = node[0];
        for(int i=1; i<nodeinfo.length; i++){
            makeTree(root, node[i]);
        }
        
        // 트리 순회
        preOrder(root);
        idx = 0;
        postOrder(root);
        
        return answer;
    }
    
    private static class Node implements Comparable<Node> {
        int num, x, y;
        Node left, right;
        
        public Node(int num, int x, int y, Node left, Node right){
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
        
        @Override
        public int compareTo(Node o){
            if(this.y == o.y){
                return this.x-o.x;
            }
            return o.y-this.y;
        }
    }
    
    private static void makeTree(Node p, Node c) {
        if(p.x > c.x){ // 왼쪽 서브 트리
            if(p.left == null) p.left = c;
            else makeTree(p.left, c);
        } else { // 오른쪽 서브 트리
            if(p.right == null) p.right = c;
            else makeTree(p.right, c);
        }
    }
    
    private static void preOrder(Node root){
        if(root != null){
            answer[0][idx++] = root.num;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    private static void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            answer[1][idx++] = root.num;
        }
    }
}