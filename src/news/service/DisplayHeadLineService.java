package news.service;

import news.models.Articles;
import news.repository.AllArticles;

public class DisplayHeadLineService 
{
	public void displayHeadLineService()
	{
		System.out.println("HeadLines\n---------------");
		for(Articles a: AllArticles.allArticles)
		{
			System.out.println(a.getTitle()+"\n");
		}
	}

}
