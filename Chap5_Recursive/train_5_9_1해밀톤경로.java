package Chap5_Recursive;

import java.util.Stack;

class Graph {
    private int numVertex; // 노드 숫자
    private int[][] graph; // Adjacency matrix
    private int[] path; // 해밀턴 경로를 배열로 저장
    Stack<Integer> stack = new Stack<>();

    Graph(int[][] graph) {
        this.numVertex = graph.length;
        this.graph = graph;
        this.path = new int[numVertex];
        
        // 미방문 경로는 -1로 초기화
        for (int i = 0; i < numVertex; i++) {
            path[i] = -1;
        }
    }

    boolean findPath(int start) {
    	int p = start;//시작노드
        path[p] = 0;
        stack.push(p); // 노드 p부터 시작

        int pos = 1;

        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();
            System.out.println("node=" + currentVertex);

            if (pos == numVertex+1) {
            	int count = 0;
            	int num = 0;
          		System.out.print("0->");
            	while(count <6) {
            		System.out.print(path[num] + "->");
            		num = path[num];
            		count++;
            	}
            	System.out.println();
            	System.out.println("경로 찾다");
            	return true;
            }
            
            boolean foundNext = false;
            for (int i = path[currentVertex]+1; i < numVertex; i++) {
                if(pos == numVertex) {
             	   if(graph[stack.peek()][0] == 1) {
             		   stack.remove(0);
             	   } else {
             		   break;
             	   }
                }
            	if(isSafe(currentVertex,i)) {
            		stack.push(i);
            		path[currentVertex] = i;
            		pos++;
            		foundNext =true;
            		break;
            	}     	
            }
              
            if (!foundNext) {
               path[currentVertex] = -1;
               stack.pop();
               pos--;
               }
            }
        System.out.println("해밀턴 경로 없다.");
        return false;
    }

    boolean isSafe(int currentNode, int nextNode) {
    	if((graph[currentNode][nextNode] == 1) && (stack.search(nextNode) == -1)) 
    		return true;
    	return false;
    }

    void showPath() {
        System.out.println("해밀턴 경로:");
        for (int i = 0; i < numVertex; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]); // 해밀턴 경로
    }
}
public class train_5_9_1해밀톤경로 {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 1},
            {0, 0, 1, 0, 1, 0}
        };
        
        Graph g = new Graph(graph);
        g.findPath(0);

        
        
    }
}