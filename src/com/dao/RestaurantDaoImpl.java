package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.Configuration.DBConnect;
import com.Model.Restaurant;


public class RestaurantDaoImpl implements RestaurantDao {

	// Method for Add Restaurant Details
	@Override
	public boolean addRestaurant(Restaurant r) {
		try (Connection con = DBConnect.getConnection();
				PreparedStatement pst = con.prepareStatement("insert into restaurant_details values(?,?,?,?,?,?,?,?)");) {
			// precompiled query

			pst.setInt(1, r.getId());
			pst.setString(2, r.getName());
			pst.setObject(3, r.getOpentime());
			pst.setObject(4, r.getClosetime());
			pst.setLong(5, r.getPhone_no());
			pst.setString(6, r.getAddress());
			pst.setString(7, r.getCuisine());
			pst.setInt(8, 0);

			int c = pst.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	
	// Method for Update Restaurant Details
	@Override
	public boolean updateRestaurantMobileNo(int id,long mb) {
		try (Connection con = DBConnect.getConnection();
				PreparedStatement pst = con.prepareStatement("update restaurant_details set phone_no=? where id=? ");)
		{
			pst.setLong(1, mb);
			pst.setInt(2, id);
			int c=pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	

	// Method for Delete Restaurant Details
	@Override
	public boolean deleteRestaurant(int id) {
		try(Connection con=DBConnect.getConnection();
				PreparedStatement pst=con.prepareStatement("delete from restaurant_details where id=?"))
		{
			pst.setInt(1, id);
			int c=pst.executeUpdate();
			if(c>0)
			System.out.println("Record deleted successfully :"+c);
			else
			System.out.println("Invalid Id");
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	// Method for Print List of Restaurants
	@Override
	public List<Restaurant> getAllRestaurants() {
		// TODO Auto-generated method stub
		ArrayList<Restaurant> restlist=new ArrayList<>();
		try(Connection con=DBConnect.getConnection();Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from restaurant_details"))
		{
			
			while(rs.next())
			{
				Restaurant r=new Restaurant();
				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setOpentime(rs.getTime(3).toLocalTime());
				r.setClosetime(rs.getTime(4).toLocalTime());
				r.setPhone_no(rs.getLong(5));
				r.setAddress(rs.getString(6));
				r.setCuisine(rs.getString(7));
			
				System.out.println(r);
				
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return restlist;
		
	}
	
	
	// Method for Activate Restaurant 
	@Override
	public boolean activateRestaurant(int id) {
		// TODO Auto-generated method stub
		try (Connection con = DBConnect.getConnection();
				PreparedStatement pst = con.prepareStatement("update restaurant_details set is_active=? where id=? ");)
		{
			pst.setInt(1, 1);
			pst.setInt(2, id);
			int c = pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}



	// Method for Deactivate Restaurant 
	@Override
	public boolean deactivateRestaurant(int id) {
		// TODO Auto-generated method stub
		try (Connection con = DBConnect.getConnection();
				PreparedStatement pst = con.prepareStatement("update restaurant_details set is_active=? where id=? ");)
		{
			pst.setInt(1, 1);
			pst.setInt(2, id);
			int c = pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



	// Method for Update Restaurant Details
	@Override
	public boolean updateRestaurantName(int id, String nm) {
		// TODO Auto-generated method stub
		try (Connection con = DBConnect.getConnection();
				PreparedStatement pst = con.prepareStatement("update restaurant_details set name=? where id=? ");)
		{
			pst.setString(1, nm);
			pst.setInt(2, id);
			int c=pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return false;
	}



	@Override
	public Restaurant getRestaurant(int id) {
		// TODO Auto-generated method stub
		try(Connection con=DBConnect.getConnection();
				PreparedStatement pst=con.prepareStatement("select * from restaurant_details where id=?");)
		{
				
				pst.setInt(1, id);
				ResultSet rs=pst.executeQuery();
				Restaurant r=null;
				if(rs.next())
				{
					r=new Restaurant();
					r.setId(rs.getInt(1));
					r.setName(rs.getString(2));
					r.setOpentime(rs.getTime(3).toLocalTime());
					r.setClosetime(rs.getTime(4).toLocalTime());
					r.setPhone_no(rs.getLong(5));
					r.setAddress(rs.getString(6));
					r.setCuisine(rs.getString(7));
				
				}
				return r;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}




	/*
	 * @Override public List<Restaurant> getRestaurant(int id) { // TODO
	 * Auto-generated method stub
	 * 
	 * ArrayList<Restaurant> restlist1=new ArrayList<>(); try(Connection
	 * con=DBConnect.getConnection(); Statement st=con.createStatement(); ResultSet
	 * rs=st.executeQuery("select * from restaurant_details where id=?")) {
	 * st.setInt(1,id); int c=st.executeQuery(); while(rs.next()) {
	 * 
	 * 
	 * Restaurant r=new Restaurant(); r.setId(rs.getInt(1));
	 * r.setName(rs.getString(2)); r.setOpentime(rs.getTime(3).toLocalTime());
	 * r.setClosetime(rs.getTime(4).toLocalTime()); r.setPhone_no(rs.getLong(5));
	 * r.setAddress(rs.getString(6)); r.setCuisine(rs.getString(7));
	 * 
	 * System.out.println(r);
	 * 
	 * }
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return restlist1;
	 * 
	 * }
	 * 
	 * 
	 */


	/*
	 * @Override public boolean updateRestaurantOpeningTime(int id, LocalTime ot) {
	 * // TODO Auto-generated method stub try (Connection con =
	 * DBConnect.getConnection(); PreparedStatement pst = con.
	 * prepareStatement("update restaurant_details set opening_time=? where id=? ");
	 * ) { pst.setOpentime(pst.getTime(3).toLocalTime()); pst.setInt(2, id); int
	 * c=pst.executeUpdate(); return true;
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return false; }
	 * 
	 * 
	 * 
	 * @Override public boolean updateRestaurantClosingTime(int id, LocalTime cl) {
	 * // TODO Auto-generated method stub return false; }
	 */



	
	}


