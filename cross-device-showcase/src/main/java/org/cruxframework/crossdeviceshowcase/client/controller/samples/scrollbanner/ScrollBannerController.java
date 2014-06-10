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
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private ScrollBannerMessages messages;

	@Expose
	public void onLoad()
	{
		addMessages();
	}

	private void addMessages()
	{
		myWidgetAccessor.scrollBanner().addMessage(messages.programMessage());
	}

	@BindView("scrollBanner")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		ScrollBanner scrollBanner();
		Button next();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(ScrollBannerMessages messages) 
	{
		this.messages = messages;
	}    
}
