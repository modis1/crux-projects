package org.cruxframework.test.cruxtestwidgets.client;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.widgets.client.swapcontainer.HorizontalSwapContainer;

@Controller("homeController")
public class HomeController 
{
	private static HorizontalSwapContainer views;
	
	@Expose
	public void showViewDatabase()
	{
		redirect("database");
	}
	
	@Expose
	public void showViewInputs()
	{
		redirect("inputs");
	}
	
	public static void redirect(String viewName)
	{
		if(views == null)
		{
			views = (HorizontalSwapContainer) Screen.get("views");
			views.setHeight("50%");
		}
		views.showView("inputs");
	}
}
