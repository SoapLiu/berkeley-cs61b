package dict;

public class Test {
	  public static void main(String[] args) {
		  HashTableChained table = new HashTableChained();
		  
		  
		  System.out.println("----------------------testing prime()-----------------------");
		  int num;
		
		  num = 2;
		  if(HashTableChained.isPrime(num)) System.out.println(num + " is a prime number.");
		  else System.out.println(num + " is not a prime number.");
		  System.out.println("the nearest prime number of " + num + " is " + HashTableChained.getNearestPrime(num));
		
		  num = 3;
		  if(HashTableChained.isPrime(num)) System.out.println(num + " is a prime number.");
		  else System.out.println(num + " is not a prime number.");
		  System.out.println("the nearest prime number of " + num + " is " + HashTableChained.getNearestPrime(num));
		
		  num = 4;
		  if(HashTableChained.isPrime(num)) System.out.println(num + " is a prime number.");
		  else System.out.println(num + " is not a prime number.");
		  System.out.println("the nearest prime number of " + num + " is " + HashTableChained.getNearestPrime(num));
		
		
		  System.out.println("----------------------testing insert()----------------------");
		  System.out.println("before insert");
		  System.out.println("table's size is: " + table.size());
		  System.out.println("table is Empty: " + table.isEmpty());
		  table.insert("1", "1");
		  table.insert("2", "2");
		  table.insert("3", "3");
		  System.out.println("after insert");
		  System.out.println("table's size is: " + table.size());
		  System.out.println("table is Empty: " + table.isEmpty());

		  System.out.println("-----------------------testing find()-----------------------");
		  System.out.println("find '1'");
		  Entry e1 = table.find("1");
		  if(e1 != null){
			  System.out.println("The item is: [ " + e1.value + " ]");
			  }else {
				  System.out.println("have no this item.");
				  }
		  
		  System.out.println("----------------------testing remove()----------------------");
		  System.out.println("remove '2'");
		  Entry e2 = table.remove("2");
		  if(e1 != null){
			  System.out.println("The item was removed: [ " + e2.value + " ]");
			  }else {
				  System.out.println("have no this item.");
				  }
	  }
}


