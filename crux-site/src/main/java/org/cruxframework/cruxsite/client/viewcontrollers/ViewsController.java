package org.cruxframework.cruxsite.client.viewcontrollers;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.plugin.google.analytics.client.GoogleAnalytics;
import org.cruxframework.crux.widgets.client.rss.RssPanel;
import org.cruxframework.crux.widgets.client.rss.feed.Error;
import org.cruxframework.crux.widgets.client.rss.feed.Feed;
import org.cruxframework.crux.widgets.client.rss.feed.FeedApi;
import org.cruxframework.crux.widgets.client.rss.feed.FeedCallback;
import org.cruxframework.cruxsite.client.MainController;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.user.client.Window;

@Controller("viewsController")
public class ViewsController 
{
	@Expose
	public void onActivate()
	{
		String viewName = View.of(this).getId();
		
		// Código de chamada do Analytics
		GoogleAnalytics.trackPageview(viewName);
		
		//Load feed API
		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() 
		{
			@Override
			public boolean execute() 
			{
				if(MainController.isFeedAPILoaded)
				{
					loadFeeds();
					return false;
				}
				return true;
			}
		}, 100);
	}

	private static void loadFeeds() 
	{
		FeedApi feedLastBlogEntries = FeedApi.create("http://feeds.feedburner.com/cruxframework");
		//this will only get feeds from cache.
		//feedLastBlogEntries.includeHistoricalEntries();
		feedLastBlogEntries.setNumEntries(3);

		feedLastBlogEntries.load(new FeedCallback()
		{
			@Override
			public void onLoad(Feed feed)
			{
				((RssPanel)View.getView("home").getWidget("lastBlogEntries")).setFeed(feed);
			}

			@Override
			public void onError(Error error) 
			{
				Window.alert(error.getMessage());
			}
		});
	}
}
