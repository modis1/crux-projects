package org.cruxframework.crossdeviceshowcase.client.controller.samples.tabviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.tabcontainer.TabContainer;

import com.google.gwt.user.client.ui.TextBox;

@Controller("tabViewContainerController")
public class TabViewContainerController 
{
	private int VIEW_ID = 0;

	@Inject
	private TabViewContainerMessages messages;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Expose
	public void addViewMessageBox()
	{
		myWidgetAccessor.tabView().showView("messageBox");
		myWidgetAccessor.tabView().focusView("messageBox");
	}
	
	@Expose
	public void addViewDialogBox()
	{
		myWidgetAccessor.tabView().showView("dialogBox");
		myWidgetAccessor.tabView().focusView("dialogBox");
	}
	
	@Expose
	public void addViewProgressBox()
	{
		myWidgetAccessor.tabView().showView("progressBox");
		myWidgetAccessor.tabView().focusView("progressBox");
	}
	
	@Expose
	public void add()
	{
		String url = myWidgetAccessor.textBoxUrl().getText();
		if (VIEW_ID>=0)
		{
			myWidgetAccessor.tabView().showView("tabNewView", Integer.toString(VIEW_ID), url);
			myWidgetAccessor.tabView().focusView(Integer.toString(VIEW_ID));
			VIEW_ID++;
		}
	}

	@Expose
	public void remove()
	{
		if(myWidgetAccessor.tabView().getFocusedViewIndex()>=0)
		{
			String viewRemove = myWidgetAccessor.tabView().getViewId(myWidgetAccessor.tabView().getFocusedViewIndex());
			myWidgetAccessor.tabView().remove(myWidgetAccessor.tabView().getView(viewRemove));
		} else
		{
			FlatMessageBox.show(messages.alert(), MessageType.ERROR);
		}
	}

	@BindView("tabViewContainer")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		TabContainer tabView();
		TextBox textBoxUrl();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
	
	public void setMessages(TabViewContainerMessages messages) 
	{
		this.messages = messages;
	}
}
