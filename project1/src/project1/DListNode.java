package project1;
public class DListNode {
	
	public int R;
	public int G;
	public int B;
	public int length;
	public DListNode prev;
	public DListNode next;

	DListNode() {
		R = 0;
		G = 0;
		B = 0;
		length = 0;
		prev = null;
		next = null;
	}

	DListNode(int red, int green, int blue, int length) {
		R = red;
		G = green;
		B = blue;
		this.length = length;
		prev = null;
		next = null;
	}

}