package org.cruxframework.crossdeviceshowcase.client.controller.samples.swapviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.swapcontainer.SwapContainer;

import com.google.gwt.user.client.ui.HTML;

@Controller("swapViewContainerController")
public class SwapViewContainerController 
{	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private SwapViewContainerMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void showNextView()
	{
		View activeView = myWidgetAccessor.viewContainer().getActiveView();
		
		if (activeView != null)
		{
			String activeViewId = activeView.getId();
			
			if (activeViewId.equals("swapView1"))
			{
				myWidgetAccessor.viewContainer().showView("swapView2");
			}else
			{
				myWidgetAccessor.viewContainer().showView("swapView1");
			}
		}
	}

	@BindView("swapViewContainer")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		SwapContainer viewContainer();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(SwapViewContainerMessages messages) 
	{
		this.messages = messages;
	}
}
