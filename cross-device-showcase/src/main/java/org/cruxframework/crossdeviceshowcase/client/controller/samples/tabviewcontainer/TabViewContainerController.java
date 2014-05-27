package org.cruxframework.crossdeviceshowcase.client.controller.samples.tabviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.tabcontainer.TabContainer;

@Controller("tabViewContainerController")
public class TabViewContainerController 
{
	
//	private String MESSAGE_INVALID_NUMBER = "Please insert a valid integer.";
//	private String MESSAGE_NEGATIVE_NUMBER = "Please insert positive value.";

	@Inject
	public TabViewContainerView tabviewcontainerview;
	private View storyBoard;

	@Expose
	public void onLoad()
	{
		tabviewcontainerview.tabViewContainer().add(storyBoard, false, true);
	}

	@BindView("tabViewContainerView")
	public static interface TabViewContainerView extends WidgetAccessor
	{
		TabContainer tabViewContainer();
	}
}
