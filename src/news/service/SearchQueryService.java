package news.service;

import news.models.Articles;
import news.repository.AllArticles;

public class SearchQueryService 
{
	public void searchQueryService(String query)
	{
		System.out.println("Query Results\n---------------");
		for(Articles a: AllArticles.allArticles)
		{
			if(containsQuery(query, a.toString()))
			{
				System.out.println(a);
			}
		}
	}

	private boolean containsQuery(String query, String string) 
	{
		
		return true;
	}

}
