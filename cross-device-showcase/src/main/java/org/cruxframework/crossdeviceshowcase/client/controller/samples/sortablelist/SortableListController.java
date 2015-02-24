package org.cruxframework.crossdeviceshowcase.client.controller.samples.sortablelist;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.sortablelist.SortableList;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

@Controller("sortableListController")
public class SortableListController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private SortableListMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void addActivity()
	{
		String newActivity = myWidgetAccessor.textBoxActivity().getValue();
		if (!newActivity.equals(""))
		{
			myWidgetAccessor.sortableList().addItem(new Label(newActivity));
			myWidgetAccessor.textBoxActivity().setValue("");
		}
	}
	
	@Expose
	public void removeSelectedItem()
	{
		myWidgetAccessor.sortableList().removeSelectedItem();
	}
	
	@BindView("sortableList")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		SortableList sortableList();
		TextBox textBoxActivity();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(SortableListMessages messages) {
		this.messages = messages;
	}
}
