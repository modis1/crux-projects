package org.cruxframework.crossdeviceshowcase.client.controller.samples.tabviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.ViewLoadEvent;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;

import com.google.gwt.user.client.ui.Frame;

@Controller("tabViewInitController")
public class TabViewInitController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Expose
	public void onLoad(ViewLoadEvent event)
	{			
		myWidgetAccessor.frameContent().setUrl("http://www.cruxframework.org");
	}

	@BindView("tabViewInit")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Frame frameContent();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
