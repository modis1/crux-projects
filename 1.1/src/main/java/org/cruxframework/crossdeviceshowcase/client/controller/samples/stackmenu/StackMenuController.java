package org.cruxframework.crossdeviceshowcase.client.controller.samples.stackmenu;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.stackmenu.StackMenu;
import org.cruxframework.crux.widgets.client.stackmenu.StackMenuItem;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.user.client.ui.HTML;

@Controller("stackMenuController")
public class StackMenuController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private StackMenuMessages messages;

	@Expose
	public void onLoad()
	{	
		// Insert the component description
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
		
		loadItems();
	}	

	//Add items programmatically.
	private void loadItems()
	{
		for (StackMenuItem listParentItems : myWidgetAccessor.menu().getItems())
		{
			if(listParentItems.getLabel().equals("DVD"))
			{
				listParentItems.add(new StackMenuItem("romance","Romance"));
				listParentItems.add(new StackMenuItem("terror","Terror"));
				for(StackMenuItem listItems : listParentItems.getSubItems())
				{
					if (listItems.getLabel().equals("Romance"))
					{
						listItems.add(new StackMenuItem("prideAndPrejudice",messages.labelPrideAndPrejudice()));
						listItems.add(new StackMenuItem("titanic","Titanic"));
					}
					else if(listItems.getLabel().equals("Terror"))
					{
						listItems.add(new StackMenuItem("constantine","Constantine"));
						listItems.add(new StackMenuItem("orphan",messages.labelOrphan()));
					}
				}
			}
		}
	}

	@Expose
	public void selectedItem(SelectionEvent<StackMenuItem> evt)
	{
		StackMenuItem item = evt.getSelectedItem();
		String nameItem = item.getLabel();

		String nameParentItem = null;

		if(item.getParentItem() != null)
		{
			nameParentItem = item.getParentItem().getLabel();
		}

		if (nameParentItem == null || nameParentItem.equals(""))
		{
			FlatMessageBox.show(messages.info()+nameItem, MessageType.INFO);
		}
		else
		{
			FlatMessageBox.show(messages.info()+nameItem+" "+messages.complementInfo()+" "+nameParentItem, MessageType.INFO);
		}	
	}

	@BindView("stackMenu")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		StackMenu menu();
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(StackMenuMessages messages) 
	{
		this.messages = messages;
	}
}
