package classes;

public class FIFOQueueInt {

	public FIFOQueueInt() {

		this.size = 0;
		this.queues = new int[this.size];
	}

	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();
		for (int queue : this.queues) output.append(queue).append(" ");
		return output.toString();
	}

	public int dequeue() {

		int queue = this.queues[0];

		int[] new_queues = new int[--this.size];
		System.arraycopy(this.queues, 1, new_queues, 0, this.size);

		this.queues = new_queues;

		return queue;
	}

	public void enqueue(int queue) {

		int[] new_queues = new int[++this.size];
		if (this.size - 1 >= 0) System.arraycopy(this.queues, 0, new_queues, 0, this.size - 1);

		new_queues[this.size - 1] = queue;
		this.queues = new_queues;
	}

	public boolean isEmpty() {

		return this.size == 0;
	}

	public int[] getQueues() {

		return this.queues;
	}

	int[] queues;
	int size;
}
