package news.service;

import news.models.Articles;
import news.repository.AllArticles;

public class DisplayNewsSourcesService 
{
	public void displayNewsSourcesService()
	{
		System.out.println("News Sources\n---------------");
		for(Articles a: AllArticles.allArticles)
		{
			System.out.println(a.getSource_name());
			System.out.println(a.getDescription());
		}
	}

}
