package org.cruxframework.crossdeviceshowcase.client.controller.samples.tabviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.tabcontainer.TabContainer;

import com.google.gwt.user.client.ui.TextBox;

@Controller("tabViewContainerController")
public class TabViewContainerController 
{
	@Inject
	public TabViewContainerView tabviewcontainerview;

	@Expose
	public void onLoad()
	{			
		//tabviewcontainerview.tabViewContainer().getIndex("tabViewInit");
		//tabviewcontainerview.viewIndex().setText(Integer.toString(tabviewcontainerview.tabViewContainer().getIndex("tabViewInit")));
	}

	@Expose
	public void add()
	{
		//tabviewcontainerview.tabViewContainer().loadView("teste", true);
		//como criar uma view?
	}
	
	@Expose
	public void remove()
	{
		//tabviewcontainerview.tabViewContainer().remove(formDisplay);
		//Não deu
	}
	
	@BindView("tabViewContainer")
	public static interface TabViewContainerView extends WidgetAccessor
	{
		TabContainer tabViewContainer();
		Button remove();
		TextBox viewIndex();
	}
}
