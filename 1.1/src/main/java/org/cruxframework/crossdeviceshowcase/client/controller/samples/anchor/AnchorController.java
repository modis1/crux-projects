package org.cruxframework.crossdeviceshowcase.client.controller.samples.anchor;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.anchor.Anchor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;

@Controller("anchorController")
public class AnchorController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private AnchorMessages messages;

	@Expose
	public void onLoad()
	{
		 /* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void openUrl()
	{
		String url = myWidgetAccessor.textBoxUrl().getText();
		
		if (url != null)
		{
			myWidgetAccessor.anchor().setHref(url);
			myWidgetAccessor.anchor().setTarget("_self");
			myWidgetAccessor.anchor().select();
		}
	}
	
	@Expose
	public void pgEnd()
	{
		FlatMessageBox.show(messages.pgEnd(), MessageType.INFO);
	}
	
	@Expose
	public void pgHome()
	{
		FlatMessageBox.show(messages.pgHome(), MessageType.INFO);
	}

	@BindView("anchor")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		Anchor anchor();
		TextBox textBoxUrl();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(AnchorMessages messages) {
		this.messages = messages;
	}

}
