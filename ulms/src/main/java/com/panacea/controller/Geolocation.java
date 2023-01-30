package com.panacea.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Controller
public class Geolocation {

	@GetMapping("/GetGeoLocation")
	public String geocodeForm(address address, Model model) {
		model.addAttribute("address", address);
		return "GEO/GetGeoLocation";
	}

	@PostMapping("/GetGeoLocation")
	public String GetMap(@ModelAttribute("address") String address, Model model) {
		OkHttpClient client = new OkHttpClient();
		String url = "https://nominatim.openstreetmap.org/search?q=" + address + "&format=json&limit=1";
		Request request = new Request.Builder().url(url).build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful()) {
				throw new IOException("Unexpected code " + response);
			}
			String responseBody = response.body().string();
			JSONArray jsonArray = new JSONArray(responseBody);
			JSONObject jsonObject = jsonArray.getJSONObject(0);
			Double lat = jsonObject.getDouble("lat");
			Double lon = jsonObject.getDouble("lon");
			model.addAttribute("lat", lat);
			model.addAttribute("lon", lon);
			model.addAttribute("address", address);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "GEO/GetMapVIew";
	}

	@GetMapping("/GETGEOCODE")
	public void Location() {
		Map<String, Double> location = new HashMap<>();
		try {
			OpenStreetMapGetLocationReverse(37.7749, -122.4194);
			OpenStreetMapGetLocation("DHAKA");
			// GoogleMapAPIGetLocation();
			// Rapid API Credential Issue
			// GEOCODING();
			// ReverseGEOCODING();

		} catch (Exception e) {
		}
	}

	void OpenStreetMapGetLocation(String address) {
		OkHttpClient client = new OkHttpClient();
		String url = "https://nominatim.openstreetmap.org/search?q=" + address + "&format=json&limit=1";

		Request request = new Request.Builder().url(url).build();
		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				if (!response.isSuccessful()) {
					throw new IOException("Unexpected code " + response);
				}
				String responseBody = response.body().string();
				System.out.println(responseBody);
			}
		});

	}

	void OpenStreetMapGetLocationReverse(double lat, double lng) {

		OkHttpClient client = new OkHttpClient();
		String url = "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + lat + "&lon=" + lng
				+ "&zoom=18&addressdetails=1";

		Request request = new Request.Builder().url(url).build();
		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				if (!response.isSuccessful()) {
					throw new IOException("Unexpected code " + response);
				}
				String responseBody = response.body().string();
				System.out.println(responseBody);
			}
		});
	}

	public void GoogleMapAPIGetLocation() {
		OkHttpClient client = new OkHttpClient();
		try {
			String address = "1600 Amphitheatre Parkway, Mountain View, CA";
			String API_KEY = "";
			String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + API_KEY;
			Request request = new Request.Builder().url(url).build();
			Response response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
				throw new IOException("Unexpected code " + response);
			}
			System.out.println(response.body().string());

			// parse the JSON response and extract the lat/lng values
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void ReverseGEOCODING() {
		OkHttpClient client = new OkHttpClient();
		try {

			Request request = new Request.Builder().url(
					"https://google-maps-geocoding.p.rapidapi.com/geocode/json?latlng=40.714224%2C-73.96145&language=en")
					.get().addHeader("X-RapidAPI-Key", "3c7dbd0b24msh8d15aa98a362e91p1e1b3fjsnf478a6b2d66b")
					.addHeader("X-RapidAPI-Host", "google-maps-geocoding.p.rapidapi.com").build();

			Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void GEOCODING() {
		OkHttpClient client = new OkHttpClient();
		try {

			Request request = new Request.Builder().url(
					"https://google-maps-geocoding.p.rapidapi.com/geocode/json?address=164%20Townsend%20St.%2C%20San%20Francisco%2C%20CA&language=en")
					.get().addHeader("X-RapidAPI-Key", "3c7dbd0b24msh8d15aa98a362e91p1e1b3fjsnf478a6b2d66b")
					.addHeader("X-RapidAPI-Host", "google-maps-geocoding.p.rapidapi.com").build();

			Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
