package com.panacea.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.json.XML;
import com.panacea.info.SmsInfo;

public class SmsServiceSSL {

	private static String encodeValue(String value) throws UnsupportedEncodingException {
		return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
	}

	public static Map<String, String> sendsms(String csmsid, String msisdn, String sms_string) {
		Map<String, String> ResultMap = new HashMap<String, String>();
		HttpURLConnection urlconnection = null;
		int responseCode = 101;
		try {
			Map<String, String> requestParams = new HashMap<>();
			requestParams.put("user", SmsInfo.sms_user);
			requestParams.put("pass", SmsInfo.sms_password);
			requestParams.put("sid", SmsInfo.sms_sid);
			requestParams.put("sms", sms_string);
			requestParams.put("msisdn", msisdn);
			requestParams.put("csmsid", csmsid);

			String encodedURL = requestParams.keySet().stream().map(key -> {
				try {
					return key + "=" + encodeValue(requestParams.get(key));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return key;
			}).collect(Collectors.joining("&", SmsInfo.sms_url, ""));

			URL url = new URL(encodedURL);
			urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setConnectTimeout(30000);
			urlconnection.setDoOutput(true);
			responseCode = urlconnection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				JSONObject json = XML.toJSONObject(response.toString());
				String jasonString = json.toString(4);
				ResultMap.put("Status", responseCode + "");
				ResultMap.put("StatusMessage", "SMS has been sent");
				ResultMap.put("ResponseBody", jasonString);

			}
			urlconnection.disconnect();
			return ResultMap;

		} catch (Exception ex) {
			urlconnection.disconnect();
			ResultMap.put("Status", responseCode + "");
			ResultMap.put("StatusMessage", "SMS has not been sent");
			ResultMap.put("ResponseBody", ex.getMessage());
			return ResultMap;
		}
	}
}
