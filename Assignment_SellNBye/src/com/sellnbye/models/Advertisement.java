package com.sellnbye.models;


import java.sql.Connection; 

import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;

public class Advertisement
{

	public String getAdvertisement() 
	{             
		String advertisementGrid = null;             
		Connection con = null;             
		Statement st = null;             
		ResultSet rs = null;       
		
		try {       
			con = DBConnection.createConnection();     
			st = con.createStatement();    
			rs = st.executeQuery("select * from advetisement");     
			
			if (rs.first())       
			{ 
				advertisementGrid = "<table border='1' cellspacing='1' cellpadding='1'>"
						+ "<tr>"
						+ "<th>ID</th>"
						+ "<th>Title</th>"
						+ "<th>Img_Link</th>"
						+ "<th>Description</th>"
						+ "<th>Edit</th>"
						+ "<th>Delete</th>"
						+ "</tr>"; 
				rs.beforeFirst(); 
				
				while(rs.next())  
				{   
					advertisementGrid = advertisementGrid + "<tr><td>" + rs.getString(1) + 
							"</td>"      + "<td>" + rs.getString(2) + "</td>"     
							+ "<td>" + rs.getString(3) + "</td>"   
							+ "<td>" + rs.getString(4) + "</td>"  
							+ "<td><input id=\"btnEdit\" type=\"button\" name=\"btnEdit\"  param=\"" 
							+ rs.getString(1) + "\" value=\"Edit\"</td>"      
							+ "<td>" + "<input id=\"btnRemove\" type=\"button\" name=\"btnRemove\" param=\"" 
							+ rs.getString(1) + "\" value=\"Remove\"</td></tr>";                        
				} 
				
			}                   
			else                         
				advertisementGrid = "There are no advertisements...";                   
				advertisementGrid = advertisementGrid + "</table></br>";             
			}             
		catch (SQLException e) 
		{                   
			e.printStackTrace();             
		}             
		
		return advertisementGrid;       
		
		}       
	
		public String saveAnAdvertisement(String adTitle, String adImageLink, String adDescription) 
		{
			String res = null;             
			String sql = null;            
			Connection con = null;             
			Statement st = null;             
			try 
			{                   
				con = DBConnection.createConnection();                  
				st = con.createStatement();                  
				sql = "insert into advertisements (adTitle, adImageLink, adDescription) values ('" + adTitle + "', '" + adImageLink + "', '" + adDescription + "')";                   
				st.executeUpdate(sql);                   
				res = "Successfully inserted...";             
			}             
			catch (SQLException e) 
			{                   
				e.printStackTrace();             
			}             
			
			return res;       
			
		}
			}
		
		
	


