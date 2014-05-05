package org.cruxframework.test.cruxtestwidgets.client;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.widgets.client.simplecontainer.SimpleViewContainer;

@Controller("mainController")
public class MainController {
   
    @Expose
    public void onLoad()
    {
        //do something
    }
    
    @Expose   
    public void viewRest()
    {
    	SimpleViewContainer views = (SimpleViewContainer) Screen.get("views");
        views.showView("rest");
    }
    
    @Expose   
    public void viewGrid()
    {
    	SimpleViewContainer views = (SimpleViewContainer) Screen.get("views");
        views.showView("grid");
    }
    
}