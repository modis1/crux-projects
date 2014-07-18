package org.cruxframework.crossdeviceshowcase.client.controller.samples.horizontalswapviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.swapcontainer.HorizontalSwapContainer;
import org.cruxframework.crux.widgets.client.swappanel.HorizontalSwapPanel.Direction;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;

@Controller("horizontalSwapViewContainerController")
public class HorizontalSwapViewContainerController 
{
	int numberSwap = -1;
	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private HorizontalSwapViewContainerMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void onSwap()
	{
		numberSwap++;
		
		if (numberSwap>=1)
		{
			myWidgetAccessor.labelCount().setText(Integer.toString(numberSwap));
		}
	}
	
	@Expose
	public void showView1()
	{
		if(myWidgetAccessor.rbDirectionBackward().getValue()==true)
		{
			myWidgetAccessor.viewContainer().showView("horizontalSwapView1", Direction.BACKWARDS);
		}else
		{
			myWidgetAccessor.viewContainer().showView("horizontalSwapView1", Direction.FORWARD);
		}
	}
	
	@Expose
	public void showView2()
	{
		if(myWidgetAccessor.rbDirectionBackward().getValue())
		{
			myWidgetAccessor.viewContainer().showView("horizontalSwapView2", Direction.BACKWARDS);
		} else
		{
			myWidgetAccessor.viewContainer().showView("horizontalSwapView2", Direction.FORWARD);
		}
	}
	
	@Expose
	public void showView3()
	{
		if(myWidgetAccessor.rbDirectionBackward().getValue())
		{
			myWidgetAccessor.viewContainer().showView("horizontalSwapView3", Direction.BACKWARDS);
		} else
		{
			myWidgetAccessor.viewContainer().showView("horizontalSwapView3", Direction.FORWARD);
		}
	}

	@BindView("horizontalSwapViewContainer")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		HorizontalSwapContainer viewContainer();
		Label labelCount();
		RadioButton rbDirectionBackward();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(HorizontalSwapViewContainerMessages messages) 
	{
		this.messages = messages;
	}
}
