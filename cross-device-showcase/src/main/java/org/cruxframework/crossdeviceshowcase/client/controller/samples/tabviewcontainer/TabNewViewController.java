package org.cruxframework.crossdeviceshowcase.client.controller.samples.tabviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.ViewLoadEvent;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Frame;

@Controller("tabNewViewController")
public class TabNewViewController 
{
	@Inject
	private TabViewContainerMessages messages;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Expose
	public void onLoad(ViewLoadEvent event)
	{			
		String url = event.getParameterObject();
		myWidgetAccessor.frameContent().setUrl(url);
	}

	@BindView("tabNewView")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Frame frameContent();
	}

	public void setMessages(TabViewContainerMessages messages) 
	{
		this.messages = messages;
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
//ViewLoadEvent	
//String url = event.getParameterObject();
//myWidgetAccessor.frameContent().setUrl(url);

