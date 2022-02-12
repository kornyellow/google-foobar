package classes;

public class FIFOQueue {

	public FIFOQueue() {

		this.size = 0;
		this.queues = new String[this.size];
	}

	public String dequeue() {

		String queue = this.queues[0];

		String[] new_queues = new String[--this.size];
		System.arraycopy(this.queues, 1, new_queues, 0, this.size);

		this.queues = new_queues;

		return queue;
	}

	public void enqueue(String queue) {

		String[] new_queues = new String[++this.size];
		if (this.size - 1 >= 0) System.arraycopy(this.queues, 0, new_queues, 0, this.size - 1);

		new_queues[this.size - 1] = queue;
		this.queues = new_queues;
	}

	public boolean isEmpty() {

		return this.size == 0;
	}

	String[] queues;
	int size;
}
