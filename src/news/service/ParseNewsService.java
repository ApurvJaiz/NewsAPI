package news.service;

import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import news.models.Articles;
import news.repository.AllArticles;

public class ParseNewsService 
{
	public static void parseJSONObject(String JSON_obj) throws ParseException
	{
		
		// parsing the News
        Object obj = new JSONParser().parse(JSON_obj); 
          
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
          
        String status = jo.get("status").toString(); 
        String totalResults =jo.get("totalResults").toString(); 
          
        //System.out.println(status); 
        //System.out.println(totalResults); 
        JSONArray ja = (JSONArray) jo.get("articles"); 
        Iterator<Map.Entry> itr1;
        Iterator itr2 = ja.iterator(); 
          
        while (itr2.hasNext())  
        { 
        	Articles article=new Articles();
            itr1 = ((Map) itr2.next()).entrySet().iterator(); 
            
            while (itr1.hasNext()) 
            { 
                Map.Entry pair = itr1.next(); 
                //System.out.println(pair.getKey() + " : " + pair.getValue()); 
                if(pair.getKey().equals("author"))
                {
                	if(pair.getValue()!=null)
                	article.setAuthor(pair.getValue().toString());
                }
                else if(pair.getKey().equals("content"))
                {
                	if(pair.getValue()!=null)
                	article.setContent(pair.getValue().toString());
                }
                else if(pair.getKey().equals("description"))
                {
                	if(pair.getValue()!=null)
                	article.setDescription(pair.getValue().toString());
                }
                else if(pair.getKey().equals("publishedAt"))
                {
                	if(pair.getValue()!=null)
                	article.setPublishedAt(pair.getValue().toString());
                }
                else if(pair.getKey().equals("source"))
                {
                	if(pair.getValue()!=null)
                	article.setSource_name(pair.getValue().toString());
                }
                else if(pair.getKey().equals("title"))
                {
                	if(pair.getValue()!=null)
                	article.setTitle(pair.getValue().toString());
                }
                else if(pair.getKey().equals("url"))
                {
                	if(pair.getValue()!=null)
                	article.setURL(pair.getValue().toString());
                }
                else if(pair.getKey().equals("urlToImage"))
                {
                	if(pair.getValue()!=null)
                	article.setUrlToImage(pair.getValue().toString());
                }
            }
            AllArticles.allArticles.add(article);
            //System.out.println(article);
            //System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        }
    }
}
