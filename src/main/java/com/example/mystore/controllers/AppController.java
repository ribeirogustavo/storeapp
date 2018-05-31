package com.example.mystore.controllers;

import java.math.BigInteger;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mystore.domain.DataBaseProvider;

@RestController
public class AppController {

	@RequestMapping("product/list")
	@CrossOrigin(origins = "http://http://172.245.190.232:8080")
	public String getCompleteList() {
		JSONArray jsonArray = new JSONArray();
		DataBaseProvider dataBaseProvider = new DataBaseProvider();
		try {
			jsonArray = dataBaseProvider.getAllfromProducts();
			return jsonArray.toString();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}
	}

	@RequestMapping(value = "product/by-id/", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://http://172.245.190.232:8080")
	public String getProductBytId(@RequestParam("id") BigInteger id) {
		JSONArray jsonArray = new JSONArray();
		DataBaseProvider dataBaseProvider = new DataBaseProvider();
		try {
			jsonArray = dataBaseProvider.getProductById(id);
			return jsonArray.toString();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}
	}

	@RequestMapping(value = "product/by-p_venue/", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://http://172.245.190.232:8080")
	public String getProductBypVenue(@RequestParam("p_venue") String p_venue) {
		JSONArray jsonArray = new JSONArray();
		DataBaseProvider dataBaseProvider = new DataBaseProvider();
		try {
			jsonArray = dataBaseProvider.getProductByPVenue(p_venue);
			return jsonArray.toString();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}
	}
}