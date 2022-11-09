package sample;
import java.util.*;
public class First {
	public static List<Taxi> newTaxi(int n){
		List<Taxi> taxis = new ArrayList<Taxi>();
		for(int i=0;i<n;i++) {
			Taxi t = new Taxi();
			taxis.add(t);
		}
		return taxis;
	}
	
	public static List<Taxi> getAvailableTaxis(List<Taxi> taxis,char st,int pt){
		List<Taxi> availableTaxis = new ArrayList<Taxi>();
		for(Taxi t:taxis) {
			if(t.availableTime<=pt && (Math.abs(t.currentLocation-'0')-(st-'0'))<=pt-t.availableTime) {
				availableTaxis.add(t);
			}
		}
		return availableTaxis;
		
	}
	
	public static Taxi getNearByTaxis(List<Taxi> taxi,char st){
		
		List<Taxi> nearByTaxis =new ArrayList<Taxi>();
		
		
		int min=27;
		
		for(int i=0;i<taxi.size();i++) {
			if(Math.abs((taxi.get(i).currentLocation-'0')-(st-'0'))<min) {
				min=Math.abs((taxi.get(i).currentLocation-'0')-(st-'0'));
			}
		}
		
		for(int i=0;i<taxi.size();i++) {
			if(Math.abs((taxi.get(i).currentLocation-'0')-(st-'0'))==min) {
				nearByTaxis.add(taxi.get(i));
			}
		}
		
		
//		for(int i=0;i<nearByTaxis.size()-1;i++) {
//			for(int j=i+1;j<nearByTaxis.size();j++) {
//				if(nearByTaxis.get(i).earnings>nearByTaxis.get(j).earnings) {
//					int t = nearByTaxis.get(i).earnings;
//					nearByTaxis.get(i).earnings=nearByTaxis.get(j).earnings;
//					nearByTaxis.get(j).earnings=t;
//				}
//			}
//		}
		Taxi  nearByTaxi=nearByTaxis.get(0);
		for(Taxi t : nearByTaxis ) {
			if(nearByTaxi.earnings>t.earnings) nearByTaxi=t;
		}
		
		
		
		return nearByTaxi;
	}

	public static void main(String[] args) {
	
		 List<Taxi> taxis = newTaxi(3);
		 Scanner sc = new Scanner(System.in);
		 while(true) {
			 System.out.println("'1' -> Book Taxi");
			 System.out.println("'2' -> Taxi details");
			 int options = sc.nextInt();
			 switch(options) {
			 case 1:{
				 System.out.println("Enter Start Location (caps)  'A-Z'");
				 char startLocation = sc.next().charAt(0);
				 System.out.println("Enter End Location (caps) 'A-Z'");
				 char endLocation = sc.next().charAt(0);
				 System.out.println("Enter pickup Time");
				 int pickupTime = sc.nextInt();
				 
				 if(startLocation < 'A' || endLocation>'Z'|| startLocation > 'Z' || endLocation<'A') {
					 System.out.println("valid Locations are ... 'A-Z'");
				 }
				 
				 List<Taxi> availableTaxis = getAvailableTaxis(taxis,startLocation,pickupTime);
				 
				 //for(Taxi t:availableTaxis) System.out.println(t.id);//check
				 
				 if(availableTaxis.size()==0) {
					 System.out.println("No taxis available...");
				 }
				 Taxi nearByTaxi = getNearByTaxis(availableTaxis,startLocation);
				 int temp=Math.abs((endLocation-'0')-(startLocation-'0'));
//				 int temp2=Math.abs((nearByTaxi.currentLocation-'0')-(startLocation-'0'));
				 nearByTaxi.bookTaxi(endLocation,pickupTime+temp,temp*100);
				 System.out.println("Taxi "+nearByTaxi.id+" booked sucsessfully...!!");
				 break;
				 
			 }
			 case 2:{
				 for(Taxi t:taxis) {
					 System.out.println("Taxi ID "+t.id+" current Location->"+t.currentLocation+"  available Time ->"+t.availableTime+" Total earnings "+t.earnings);
				 }
				 System.out.println("\n .................................................\n");
				 break;
			 }
			 default:{
				 System.out.print("Terminating....");
				 return;
			 }
				 
			 }
		 }
		
	}

}
