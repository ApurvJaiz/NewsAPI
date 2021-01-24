package news.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import news.models.Articles;
import news.repository.AllArticles;

public class GetAllNewsService 
{
	public static String API_KEY="cfa1b720765d46ea91d02d16a703f23a";
	public static String MyGETRequest() throws IOException, ParseException 
	{

	    	String JSON_obj="";
		    URL urlForGetRequest = new URL("http://newsapi.org/v2/everything?q=bitcoin&from=2020-12-23&sortBy=publishedAt&apiKey="+API_KEY);
		    String readLine = null;
		    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		    conection.setRequestMethod("GET");
		    //conection.setRequestProperty("userId", "Apurv");
		    int responseCode = conection.getResponseCode();
		    if (responseCode == HttpURLConnection.HTTP_OK) 
		    {
		        BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
		        StringBuffer response = new StringBuffer();
		        while ((readLine = in .readLine()) != null) 
		        {
		            response.append(readLine);
		        } 
		        in .close();
		        //System.out.println("JSON String Result " + response.toString());
		        JSON_obj=response.toString();
		    } 
		    else 
		    {
		        System.out.println("GET FAILED");
		    }
		    
		    //System.out.println(JSON_obj);
		    //parseJSONObject(JSON_obj);
		   return JSON_obj;
	}
	
}
