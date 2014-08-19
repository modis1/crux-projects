package org.cruxframework.crossdeviceshowcase.client.controller.samples.topmenudisposal;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

@Controller("viewPurchaseController")
public class ViewPurchaseController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private ViewPurchaseMessages messages;

	@Expose
	public void searchPurchase()
	{
		if(myWidgetAccessor.txtEmail().getText().isEmpty() ||
		   myWidgetAccessor.txtPassword().getText().isEmpty())
		{
			FlatMessageBox.show("Preencha todos os campos.", MessageType.ERROR);
		}else
		{
			myWidgetAccessor.labelPurchase().setText(messages.notFound());
			myWidgetAccessor.labelPurchase().setStyleName("topMenuDisposalListActive");
		}
	}

	@BindView("viewPurchase")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Label labelPurchase();
		TextBox txtEmail();
		TextBox txtPassword();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(ViewPurchaseMessages messages) {
		this.messages = messages;
	}
}
