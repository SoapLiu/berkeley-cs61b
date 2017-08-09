package list;

public class LockDList extends DList {
	
	protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
		return new LockDListNode(item, prev, next);
		}

	public void LockNode(LockDListNode node) {
		node.isLocked = true;
	}
	
	public void remove(LockDListNode node) {
		if(node.isLocked == true) {}
		else {
			super.remove(node);
		}
	}
	
	public static void main(String[] args) {
		LockDList l = new LockDList();
		System.out.println("\nTesting Constructor");
	    System.out.println("is empty? should be true: " + l.isEmpty());
	    System.out.println("should be zero length? : " + l.length());
	    System.out.println("should be [  ]:  " + l);
	    
	    System.out.println("\nTesting insertFront");
	    l.insertFront(1);
	    System.out.println("is empty? should be false: " + l.isEmpty());
	    System.out.println("should be 1 length? : " + l.length());
	    System.out.println("should be [  1  ]:  " + l);
	    
	    l.insertFront(2);
	    System.out.println("\nadd 2 to front of this list ");
	    System.out.println("should be [  2  1  ]:  " + l);

	    l.insertBack(3);
	    System.out.println("\nadd 3 to tail of this list ");
	    System.out.println("should be [  2  1  3  ]:  " + l);
	    
		System.out.println("\nTesting next method");
		DListNode tNode = l.next(l.front());
	    System.out.println("should be [  1  ]:  " + tNode.item);
	    tNode = l.next(tNode);
	    System.out.println("should be [  3  ]:  " + tNode.item);

		System.out.println("\nTesting prev method");
		tNode = l.prev(tNode);
	    System.out.println("should be [  1  ]:  " + tNode.item);

		System.out.println("\nTesting insertBefore method");
		l.insertBefore(5, tNode);
		System.out.println("should be [  2  5  1  3 ]: " + l);
		
		System.out.println("\nTesting insertAfter method");
		l.insertAfter(6, tNode);
		System.out.println("should be [  2  5  1  6  3 ]: " + l);
		
		System.out.println("\nTesting remove method");
		l.remove(tNode);
		System.out.println("should be [  2  5  6  3  ]: " + l);
		System.out.println("the length of this list should be 4 : " + l.length());
		
		System.out.println("\nTesting remove method while locked");
		LockDListNode t2Node = (LockDListNode) l.head.prev;
		l.LockNode(t2Node);
		l.remove(t2Node);
		System.out.println("still should be [  2  5  6  3  ]: " + l);
	}
}