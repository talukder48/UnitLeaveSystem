package com.panacea.api;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkAPIClient {

	private String apilink = null;

	public OkAPIClient(String apilink) {
		this.apilink = apilink;
	}

	public String getApilink() {
		return apilink;
	}

	public void setApilink(String apilink) {
		this.apilink = apilink;
	}

	public String CallApplicationProgrammingInterface(Map<String, String> apiparameter) {

		String apiResponseData = null;
		OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
		//System.out.println(apiparameter.toString());
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, new Gson().toJson(apiparameter));
		Request request = new Request.Builder().url(getApilink()).method("POST", body).addHeader("Content-Type", "application/json").addHeader("cache-control", "no-cache").build();
		try {
				Response response = client.newCall(request).execute();
				apiResponseData = response.body().string();
				try {
					/* TODO Here */
	
				} catch (Exception e) {
					e.printStackTrace();
				}
				response.body().close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			client.dispatcher().executorService().shutdown();
		}
		return apiResponseData;
	}

}
