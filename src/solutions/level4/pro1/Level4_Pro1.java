package solutions.level4.pro1;

import classes.FIFOQueueInt;
import java.util.Arrays;

public class Level4_Pro1 {

	public static void main(String[] args) {

		if(solution(new int[] {0, 1}, new int[] {4, 5}, new int[][] {{0, 0, 4, 6, 0, 0}, {0, 0, 5, 2, 0, 0}, {0, 0, 0, 0, 4, 4}, {0, 0, 0, 0, 6, 6}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}})
			== 16) {
			System.out.println("Test 1 passed !");
		} else System.out.println("Test 1 failed !");
		if(solution(new int[] {0}, new int[] {3}, new int[][] {{0, 7, 0, 0}, {0, 0, 6, 0}, {0, 0, 0, 8}, {9, 0, 0, 0}})
			== 6) {
			System.out.println("Test 2 passed !");
		} else System.out.println("Test 2 failed !");
	}

	public static int solution(int[] entrances, int[] exits, int[][] path) {

		int[][] new_networks = convert(entrances, exits, path);
		return fordFulkerson(new_networks);
	}

	public static int[][] convert(int[] sources, int[] sinks, int[][] networks) {

		int length = networks.length + 2;
		int[][] new_network = new int[length][length];

		for(int row = 0; row < networks.length; row++) {
			System.arraycopy(networks[row], 0, new_network[row + 1], 1, networks[row].length);
		}

		for(int source : sources)
			new_network[0][source + 1] = Integer.MAX_VALUE;

		for(int sink : sinks)
			new_network[sink + 1][length - 1] = Integer.MAX_VALUE;

		return new_network;
	}

	public static FIFOQueueInt breadthFirstSearch(int[][] residual_networks) {

		int[] parents = new int[residual_networks.length];
		Arrays.fill(parents, -1);

		FIFOQueueInt queue = new FIFOQueueInt();
		queue.enqueue(0);

		int u;
		while(!queue.isEmpty() && parents[parents.length - 1] == -1) {
			u = queue.dequeue();
			for(int v = 0; v < parents.length; v++) {
				if(residual_networks[u][v] > 0 && parents[v] == -1) {
					queue.enqueue(v);
					parents[v] = u;
				}
			}
		}

		FIFOQueueInt path = new FIFOQueueInt();
		u = parents[parents.length - 1];
		while(u != 0) {
			if(u == -1) return null;
			path.enqueue(u);
			u = parents[u];
		}

		FIFOQueueInt reversed_path = new FIFOQueueInt();
		for(int i = 0; i < path.getQueues().length; i++)
			reversed_path.enqueue(path.getQueues()[path.getQueues().length - 1 - i]);

		return reversed_path;
	}

	public static int fordFulkerson(int[][] residual_networks) {

		int maximum_flow = 0;
		FIFOQueueInt path;
		while((path = breadthFirstSearch(residual_networks)) != null) {

			int capacity = Integer.MAX_VALUE;
			int u = 0;
			for(int v : path.getQueues()) {
				capacity = Math.min(capacity, residual_networks[u][v]);
				u = v;
			}
			maximum_flow += capacity;
			u = 0;
			for(int v : path.getQueues()) {
				residual_networks[u][v] -= capacity;
				residual_networks[v][u] += capacity;
				u = v;
			}
		}

		return maximum_flow;
	}
}
