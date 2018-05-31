package com.example.mystore.domain;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataBaseProvider {

	private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
	private static final String CONNECTION = "jdbc:mysql://172.245.190.232:3306/mysql_";
	private static final String DATABASE_USER = "mysql_storeap";
	private static final String DATABASE_PASSWORD = "storeap";
	private Connection connection;

	public DataBaseProvider() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			connection = DriverManager.getConnection(CONNECTION, DATABASE_USER, DATABASE_PASSWORD);
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}

	public JSONArray getAllfromProducts() throws SQLException, JSONException {
		JSONArray jsonArray = new JSONArray();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM mysql_.products");
		while (rs.next()) {
			JSONObject jsonObject = new JSONObject();
			Integer id = rs.getInt("id");
			String p_venue = rs.getString("p_venue");
			String date = rs.getString("p_date");
			jsonObject.put("id", id);
			jsonObject.put("p_venue", p_venue);
			jsonObject.put("date", date);
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}

	public JSONArray getProductById(BigInteger id) throws SQLException, JSONException {
		JSONArray jsonArray = new JSONArray();
		Statement stmt = connection.createStatement();
		String query = "SELECT * FROM mysql_.products WHERE id = " + id;
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			JSONObject jsonObject = new JSONObject();
			Integer id_search = rs.getInt("id");
			String p_venue = rs.getString("p_venue");
			String date = rs.getString("p_date");
			jsonObject.put("id", id_search);
			jsonObject.put("p_venue", p_venue);
			jsonObject.put("date", date);
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}

	public JSONArray getProductByPVenue(String p_venue_name) throws SQLException, JSONException {
		JSONArray jsonArray = new JSONArray();
		Statement stmt = connection.createStatement();
		String query = "SELECT * FROM mysql_.products WHERE p_venue like '%" + p_venue_name + "%'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			JSONObject jsonObject = new JSONObject();
			Integer id_search = rs.getInt("id");
			String p_venue = rs.getString("p_venue");
			String date = rs.getString("p_date");
			jsonObject.put("id", id_search);
			jsonObject.put("p_venue", p_venue);
			jsonObject.put("date", date);
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}

}
