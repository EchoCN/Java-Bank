package Echo.bank;

import java.util.ArrayList;
import java.util.List;

public class NumberManager {
	private int lastNumber = 1;
	private List<Integer> queueNumber = new ArrayList<Integer>();
	//两个不同的线程,synchronized让两个线程互相排斥
	public synchronized int generateNewManager(){
		queueNumber.add(lastNumber);
		return lastNumber++;
	}
	
	public synchronized int fetchServiceNumber(){
		Integer number =null;
		if(queueNumber.size()>0) {
			number = queueNumber.remove(0);
		}
		return number;
	}
}