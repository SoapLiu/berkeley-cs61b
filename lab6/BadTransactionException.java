
public class BadTransactionException extends Exception{
	
	public int transAmount;
	
	public BadTransactionException(int badTransAmount) {
		
	    super("Invalid amount: " + badTransAmount);
		transAmount = badTransAmount;

	}
}
