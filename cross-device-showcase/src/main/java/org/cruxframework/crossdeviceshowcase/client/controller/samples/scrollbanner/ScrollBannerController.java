package org.cruxframework.crossdeviceshowcase.client.controller.samples.scrollbanner;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.scrollbanner.ScrollBanner;

@Controller("scrollBannerController")
public class ScrollBannerController 
{
	@Inject
	public ScrollBannerView scrollbannerview;
	
	@Expose
	public void onLoad()
	{
		addMessages();
	}
	
	private void addMessages()
	{
		scrollbannerview.scrollBanner().addMessage("This message was added from controller.");
	}
	
	@BindView("scrollBanner")
	public static interface ScrollBannerView extends WidgetAccessor
	{
		ScrollBanner scrollBanner();
		Button next();
	}    
	
	
	
	
}
