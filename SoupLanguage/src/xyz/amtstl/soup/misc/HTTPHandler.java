package xyz.amtstl.soup.misc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HTTPHandler {
	
	/**
	 * Sends a GET request over HTTP
	 * @param url the url you want to contact
	 * @return the result of the request
	 * @throws Exception necessary for an internal object
	 */
	public static String sendGet(String url) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		// con.setRequestProperty("User-Agent", "USER_AGENT");

		int responseCode = con.getResponseCode();
		/*System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);*/

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}
}