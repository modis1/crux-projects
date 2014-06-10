package org.cruxframework.crossdeviceshowcase.client.controller.samples.topmenudisposal;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.disposal.topmenudisposal.TopMenuDisposal;

@Controller("topMenuDisposalController")
public class TopMenuDisposalController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Expose
	public void onLoad()
	{			
		myWidgetAccessor.menu().addMenuEntry("Form Display", "formDisplay");
		myWidgetAccessor.menu().addMenuEntry("Masked Text Box", "maskedTextBox");
	}

	@BindView("topMenuDisposal")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		TopMenuDisposal menu();
		Button buttonShow();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
