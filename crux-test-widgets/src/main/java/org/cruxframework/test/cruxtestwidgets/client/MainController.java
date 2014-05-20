package org.cruxframework.test.cruxtestwidgets.client;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.widgets.client.simplecontainer.SimpleViewContainer;
import org.cruxframework.crux.widgets.client.swapcontainer.HorizontalSwapContainer;

@Controller("mainController")
public class MainController {
   
    @Expose
    public void onLoad()
    {
    	SimpleViewContainer views = (SimpleViewContainer) Screen.get("views");
		views.showView("menu");
    }
    
    @Expose   
    public void viewRest()
    {
    	SimpleViewContainer views = (SimpleViewContainer) Screen.get("views");
        views.showView("rest");
    }
    
    @Expose   
    public void viewMasketTexBox()
    {
    	SimpleViewContainer views = (SimpleViewContainer) Screen.get("views");
        views.showView("maskedTextBox");
    }
    
    
    
    
    
    
}