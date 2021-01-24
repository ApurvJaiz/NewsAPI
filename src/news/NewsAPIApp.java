package news;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import news.models.Articles;
import news.repository.AllArticles;
import news.service.DisplayHeadLineService;
import news.service.GetAllNewsService;
import news.service.ParseNewsService;

public class NewsAPIApp 
{
	public static void main(String[] args) throws IOException, ParseException 
	{
		GetAllNewsService getAllNewsService= new GetAllNewsService();
		String JSON_obj=getAllNewsService.MyGETRequest();
		ParseNewsService parseNewsService=new ParseNewsService();
		parseNewsService.parseJSONObject(JSON_obj);
		for(Articles a: AllArticles.allArticles)
		{
			//System.out.println(a);
		}
		DisplayHeadLineService displayHeadLineService=new DisplayHeadLineService();
		displayHeadLineService.displayHeadLineService();
		
		
	}
}
