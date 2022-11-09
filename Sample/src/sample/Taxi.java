package sample;
import java.util.*;

public class Taxi {
	int id;
	static int taxiCount=0;
	char currentLocation;
	int availableTime;
	int earnings;
	
	public Taxi() {
		taxiCount=taxiCount+1;
		id=taxiCount;
		currentLocation='A';
		availableTime=6;
		earnings=0;
		
	}
	public void bookTaxi(char currentLocation,int availableTime,int earnings) {
		
		this.currentLocation=currentLocation;
		this.availableTime=availableTime;
		this.earnings+=earnings;
	}
	
}


