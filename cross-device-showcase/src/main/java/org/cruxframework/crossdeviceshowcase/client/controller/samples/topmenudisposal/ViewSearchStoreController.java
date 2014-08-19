package org.cruxframework.crossdeviceshowcase.client.controller.samples.topmenudisposal;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.select.SingleSelect;
import org.cruxframework.crux.widgets.client.textbox.NumberTextBox;

import com.google.gwt.user.client.ui.Label;

@Controller("viewSearchStoreController")
public class ViewSearchStoreController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private ViewSearchStoreMessages messages;

	@Expose
	public void searchStore()
	{
		 myWidgetAccessor.labelSearch().setText(messages.notFound());
		 myWidgetAccessor.labelSearch().setStyleName("topMenuDisposalListActive"); 
	}

	@BindView("viewSearchStore")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Label labelSearch();
		NumberTextBox txtCode();
		SingleSelect selectCountries();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(ViewSearchStoreMessages messages) {
		this.messages = messages;
	}
}
