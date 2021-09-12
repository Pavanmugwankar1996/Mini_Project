package com.Controller;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.Model.Cuisine;
import com.Model.Restaurant;
import com.dao.RestaurantDao;
import com.dao.RestaurantDaoImpl;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		RestaurantDao restDao=new RestaurantDaoImpl();
		System.out.println("*****Welcome User****");
		do
		{  
			System.out.println("1--->Add Restaurant Details \n2--->Update Restaurant Details \n3--->Delete Restaurant Details \n4--->Activate/Deactivate Restaurants \n5--->Search Restaurant Details \n6--->View all Restaurants \n7--->Exit");
			System.out.println("Enter your choice");
			int choice=0;
			if(sc.hasNextInt())
			{
			 choice=sc.nextInt();
			}
			switch(choice)
			{
			// case 1 for Add Restaurant  Details in a Database
			case 1:System.out.println("ENTER RESTAURANT DETAILS");
					System.out.println("ENTER RESTAURANT ID :");
					int rid=sc.nextInt();
					System.out.println("ENTER RESTAURANT NAME :");
					String nm=sc.next();
					System.out.println("ENTER RESTAURANT OPENING TIME :");
					int openhh=sc.nextInt();
					int openmm=sc.nextInt();
					LocalTime open=LocalTime.of(openhh, openmm);
					System.out.println("ENTER RESTAURANT CLOSING TIME :");
					int closehh=sc.nextInt();
					int closemm=sc.nextInt();
					LocalTime close=LocalTime.of(closehh,closemm);
					System.out.println("ENTER RESTAURANT PHONE NUMBER :");
					long mb=sc.nextLong();
					System.out.println("ENTER RESTAURANT ADDRESS :");
					String addr=sc.next();
					System.out.println("RESTAURANT CUISINE :");
					System.out.println("CUISINE MUST BE \n A) --> INDIAN \n B) --> ITALIAN \n C) --> MEXICAN \n D) --> CHINESE ");
					char ch=sc.next().charAt(0);
					//char ch = 0;
					String cus=null;
					switch(ch)
					{
						case ('A'|'a'): cus="INDIAN";
							break;
							
						case ('B'|'b'): cus="ITALIAN";
							break;
							
						case ('C'|'c'): cus="MEXICAN";
							break;
							
						case ('D'|'d'): cus="CHINESE";
							break;
							
						default : System.out.println("Invalid CUISINE (Plaese Select Cuisine From above List)");
							break;
					}
					
					//String cus=sc.next().toUpperCase();
					
					Restaurant obj=new Restaurant();
					obj.setId(rid);
					obj.setName(nm);
					obj.setOpentime(open);
					obj.setClosetime(close);
					obj.setPhone_no(mb);
					obj.setAddress(addr);
					obj.setCuisine(cus);
					boolean isadded=restDao.addRestaurant(obj);
					
					if(isadded)
						System.out.println("Record added successfully");
					else
						System.out.println("Unsucessuful Insertion");
					break;
			
			// Case 2 for Update Restaurant by name and Id.
			case 2: System.out.println("Select from Following Options  \n1) --> Update Phone Number \n2) --> Update Name ");
					char opt = sc.next().charAt(0);
					if(opt == '1')
					{
						System.out.println("Enter Restaurant ID whose Mobile No you want to Update");
						int id=sc.nextInt();
						System.out.println("Enter new Mobile No for the above restaurant");
						long newmobile=sc.nextLong();
						boolean isupdated=restDao.updateRestaurantMobileNo(id, newmobile);
						if(isupdated)
							System.out.println("Record updated successfully");
						else
							System.out.println("Record Updation is Unsuccessful");
					}
					else if(opt == '2')
					{
						System.out.println("Enter Restaurant ID whose Name you want to Update");
						int id=sc.nextInt();
						System.out.println("Enter new Name for the above restaurant");
						String newname=sc.next();
						boolean isupdated=restDao.updateRestaurantName(id, newname);
						if(isupdated)
						System.out.println("Record updated successfully");
						else
						System.out.println("Record Updation is Unsuccessful");
					}
					else
					{
						System.out.println("Invalid Input");
					}
					break;
				
			// Case 3 for Delete the Restaurant Details
			case 3: System.out.println("Enter Restaurant ID which you want to Delete");
					int id1=sc.nextInt();
					boolean isdeleted=restDao.deleteRestaurant(id1);
					if(isdeleted)
						System.out.println("Record Deleted successfully");
					else
						System.out.println("Record Deletion is Unsuccessful");
					break;
			
			// Case 4 for Activate and Deactivate the restaurant
			case 4: System.out.println("Select from Following Options  \n1) --> Activate \n2) --> Deactivate");
					char opt1 = sc.next().charAt(0);
					if(opt1 == '1')
					{
						System.out.println("Enter Restaurant ID which you want to Activate");
						int id2=sc.nextInt();
						boolean isactivated=restDao.activateRestaurant(id2);
						if(isactivated)
							System.out.println("Restaurant Activated");
						else
							System.out.println("Restaurant Activation is Unsuccessful");
					}
					else if(opt1 == '2')
					{
						System.out.println("Enter Restaurant ID which you want to Activate");
						int id2=sc.nextInt();
						boolean isdeactivated=restDao.deactivateRestaurant(id2);
						if(isdeactivated)
							System.out.println("Restaurant Deactivated");
						else
							System.out.println("Restaurant Deactivation is Unsuccessful");
					}
					else
					{
						System.out.println("Invalid Input");
					}
					break;
					
			// case 5 for Search Restaurant	
			case 5: System.out.println("Enter Restaurant Id which you want to Search");
					int id3=sc.nextInt();
					Restaurant r = restDao.getRestaurant(id3);
					System.out.println(r);
					
					
					break;
			
			 // Case 6 for Print List of Restaurant
			case 6: List<Restaurant> restaurantlist=restDao.getAllRestaurants();
				  	 for(int i=0; i<restaurantlist.size(); i++)
				  		 {
				  		 	System.out.println(restaurantlist.get(i));
				  		 	System.out.println();
				  		 }
				  	 break;
			
			// Case 7 For Close the Application
			case 7: System.out.println("...........Thank You..........");
					break;
			
			// Default Statement
			default : System.out.println("Sorry.... Invalid Input \n Please Select Valid option from Above");
					  break;
					
			
			}
			if(choice == 7)
				break;
		}while(true);
			
	}

}
